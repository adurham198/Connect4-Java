package com.example.adurham.testc4;
//Name: Anton Durham
//Date:11/19/2018
//Desc: This program is designed to be the initial user setup for my game,
//Connect 4. Players are able to register into my local database, login as a user,
//view their information, delete their profile, or update their information.
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import static android.graphics.Color.YELLOW;

public class MainActivity extends AppCompatActivity {

    EditText j_txt_username;
    EditText j_txt_password;
    Button j_btn_login;
    Button j_btn_register;
    Intent j_view_registerplayer;
    Intent j_view_loginplayer;
    Intent j_view_updateplayer;
    Intent j_view_accinfo;
    TextView j_txt_error;
    ListView j_list;

    Pempadapter adapter;
    ArrayList<Player> j_al_players;
    DatabaseHelper dbhelper;
    static boolean registerpress = false;
    boolean pcheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        j_txt_username = (EditText) findViewById(R.id.v_txt_username);
        j_txt_password = (EditText) findViewById(R.id.v_txt_password);
        j_txt_password.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        j_btn_login = (Button) findViewById(R.id.v_btn_login);
        j_btn_register = (Button) findViewById(R.id.v_btn_register);
        j_txt_error = (TextView)findViewById(R.id.v_txt_error);
        j_view_registerplayer = new Intent(MainActivity.this, Regactivity.class);
        j_view_loginplayer = new Intent(MainActivity.this, Playactivity.class);
        j_view_updateplayer = new Intent(MainActivity.this, Updateactivity.class);
        j_view_accinfo = new Intent(MainActivity.this, Accinfoactivity.class);
        j_btn_register.setBackgroundColor(YELLOW);
        j_btn_login.setBackgroundColor(YELLOW);
        gotologin();
        gotoregister();

        dbhelper = new DatabaseHelper(this);
        dbhelper.initializedb();

        if (registerpress == false) {

            j_al_players = new ArrayList<Player>();

            registerpress = true;
        }
        j_al_players = dbhelper.getallRows();
        //adapter = new ArrayAdapter<Player>(this, android.R.layout.activity_list_item,j_al_players);
        adapter = new Pempadapter(this, j_al_players);


        for (int i = 0; i < j_al_players.size(); i++) {
            Log.d("======+", j_al_players.get(i).getFirstname());
        }




    }

    private class PasswordCharSequence implements CharSequence {
        private CharSequence mSource;

        public PasswordCharSequence(CharSequence source) {
            mSource = source; // Store char sequence
        }

        public char charAt(int index) {
            //return '*'; // This is the important part
            return '\u2022';
            //use this unicode to get the period instead of an asterisk as their password.
        }

        public int length() {
            return mSource.length(); // Return default
        }

        public CharSequence subSequence(int start, int end) {
            return mSource.subSequence(start, end); // Return default
        }
    }

    public void gotologin() {

        j_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Player pl = new Player();
                String uniqueuser = j_txt_username.getText().toString();
                String password = j_txt_password.getText().toString();
                boolean dotheyexist;
               dotheyexist= dbhelper.checkifexists(uniqueuser);
                if(dotheyexist==false)
                {
                    j_txt_error.setVisibility(View.VISIBLE);
                    j_txt_error.setText("That username is not valid");
                }

               if(dotheyexist==true) {
                   dbhelper.getallRows();


                   pl = dbhelper.gettheplayer(uniqueuser);
                   String newemail = pl.getEmail();
                   String newlname = pl.getLastname();
                   String newfname = pl.getFirstname();
                   String newuname = pl.getUsername();


                   Log.d("Testing1", uniqueuser);
                   Log.d("THEPASS", pl.getPassword());
                   Log.d("THEENTERPASS", password);

                   boolean checkresult = passcheck(pl, password);
                   boolean empcheck = AllNull(uniqueuser, password);
                   if (checkresult == true && empcheck == true) {
                       Intent b_list = j_view_loginplayer.putExtra("b list", uniqueuser);
                       startActivity(j_view_loginplayer);
                   } else {
                       j_txt_error.setVisibility(View.VISIBLE);
                       j_txt_error.setText("Please enter the correct credentials");
                   }
               }

            }
        });
    }
    public static boolean AllNull(String...strings)
    //this ...line selects all the strings that I sent it

    {
        for (String s : strings) {
            if (s == null || s.isEmpty())
                return false;
        }

        return true;
    }
    public boolean passcheck(Player guy, String pword)
    {
        pcheck = false;
        Log.d("THEPASS1", guy.getPassword());
        String word = guy.getPassword();
        Log.d("THEENTERPASS1", pword);
        if (pword.equals(word))
        {

            pcheck=true;

            Log.d("IMADE IT", "LOG");

        }

        return pcheck;
    }

    public void gotoregister() {
        j_btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(j_view_registerplayer);
            }
        });
    }


    public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }
    }
}
