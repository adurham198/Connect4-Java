package com.example.adurham.testc4;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "players.db";
    public static final String PLAYER_TABLE = "players";





    public DatabaseHelper(Context context)
    {
        //creating database
        super(context, DATABASE_NAME, null, 7);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {


        //creating table in database
        db.execSQL("CREATE TABLE players (username TEXT PRIMARY KEY NOT NULL, fname TEXT, lname TEXT, password TEXT, email TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + PLAYER_TABLE);
        onCreate(db);
    }

    public boolean initializedb()
    {
        if(numberofrowsinDB() == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + PLAYER_TABLE + " VALUES('adurham89' , 'anton', 'durham', 'password1', 'adurh@gmail.com');");
            db.execSQL("INSERT INTO " + PLAYER_TABLE + " VALUES('dbrown556' , 'dave', 'brown', 'password2', 'dbk@gmail.com');");
            db.execSQL("INSERT INTO " + PLAYER_TABLE + " VALUES('kboi22' , 'kevin', 'reiter', 'password3', 'kevlar@gmail.com');");
            //insert in the order you need the values
            //Alter this statement to not let users insert without fields filled out
            db.close();
            return true;
        }
        else
        {
            return false;
        }
    }
    //only do this the first time you load the database

    public int numberofrowsinDB()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        int numRows = (int) DatabaseUtils.queryNumEntries(db, PLAYER_TABLE);
        db.close();

        return numRows;
    }
    public boolean checkifexists(String key)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM " + PLAYER_TABLE + " WHERE Username = ? ", new String[]{ key } );

// If name doesn't exist -> add
        if (res.getCount() == 0) {
            return false;
        }

        // else -> return false and give error
        return true;

    }
    public ArrayList<Player> getallRows()

    {
        ArrayList<Player> playerslist = new ArrayList<Player>();
        Player player;

        //Then add this player to the database
        String selectquery = "SELECT * FROM " + PLAYER_TABLE + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectquery, null);


        if(cursor.moveToFirst())
        {

            do
            {
                player = new Player();
                String username = cursor.getString(cursor.getColumnIndex("username"));
                String firstname = cursor.getString(cursor.getColumnIndex("fname"));
                String lastname = cursor.getString(cursor.getColumnIndex("lname"));
                String password = cursor.getString(cursor.getColumnIndex("password"));
                String email = cursor.getString(cursor.getColumnIndex("email"));

                player.setUsername(username);
                player.setFirstname(firstname);
                player.setLastname(lastname);
                player.setPassword(password);
                player.setEmail(email);
                playerslist.add(player);


            }

            while(cursor.moveToNext());

        }
        db.close();
        return playerslist;
    }



    public void addnewuser(Player player)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String d = player.getUsername();
        String e = player.getEmail();
        Log.d("EMAILS", e);
        Log.d("USERNAME", d);

        boolean thecheck = ucheck(player);
        if (thecheck==true) {
            db.execSQL("INSERT INTO " + PLAYER_TABLE + " VALUES('" + player.username + "', '" + player.firstname + "', '" + player.lastname + "', '" + player.password + "', '" + player.email + "');");
        }
        db.close();
    }

    public boolean ucheck(Player p)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String uniquek = p.getUsername();
        Cursor res =  db.rawQuery( "SELECT * FROM " + PLAYER_TABLE + " WHERE Username = ? ", new String[]{ uniquek } );

// If name doesn't exist -> add
        if (res.getCount() == 0) {
            return true;
        }

        // else -> return false and give error
        return false;
    }
    //This will get passed the primary key
    //You delete using the primary key because you want to make sure you delete the right player


    public void deleteplayer(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + PLAYER_TABLE + " WHERE username = '" + username + "';");

        db.close();
        //important line that is often forgotten
    }

    public Player gettheplayer(String uname)
    {
        Player p = new Player();
        SQLiteDatabase db = this.getWritableDatabase();
        String select = ("SELECT * FROM " + PLAYER_TABLE + " WHERE username = '" + uname + "';");

        Cursor cursor = db.rawQuery(select, null);
        cursor.moveToFirst();
        Log.d("TESTING04", uname);
        if(cursor != null && cursor.moveToFirst()) {
            String newusername = cursor.getString(cursor.getColumnIndex("username"));
            String fname = cursor.getString(cursor.getColumnIndex("fname"));
            String lname = cursor.getString(cursor.getColumnIndex("lname"));
            String pword = cursor.getString(cursor.getColumnIndex("password"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            p.setUsername(newusername);
            p.setFirstname(fname);
            p.setLastname(lname);
            p.setEmail(email);
            p.setPassword(pword);
            cursor.close();
            Log.d("TESTING03", newusername);
        }
        db.close();
        return p;
    }
    public void updatetheplayer(String uname, String firstname, String lastname, String pword, String e_mail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("MSN1",firstname);
        Log.d("MSN2", lastname);
        Log.d("MSN3",pword);
        Log.d("MSN4",e_mail);
        db.execSQL(" UPDATE " + PLAYER_TABLE + " SET fname = '" + firstname + "' WHERE username = '" + uname + "';");
        db.execSQL(" UPDATE " + PLAYER_TABLE + " SET lname = '" + lastname + "' WHERE username = '" + uname + "';");
        db.execSQL(" UPDATE " + PLAYER_TABLE + " SET password = '" + pword + "' WHERE username = '" + uname + "';");
        db.execSQL(" UPDATE " + PLAYER_TABLE + " SET email = '" + e_mail + "' WHERE username = '" + uname + "';");
        db.close();
    }
}