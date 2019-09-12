package com.example.adurham.testc4;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Regactivity extends Activity {

    MainActivity ma;
    EditText x_txt_fname;
    EditText x_txt_lname;
    EditText x_txt_uname;
    EditText x_txt_pword;
    EditText x_txt_email;
    Button  x_btn_back;
    Button x_btn_register;
    TextView x_txt;
    TextView x_txt_empty;
    Intent x_view_gethome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regactivity);


        x_txt_fname = (EditText) findViewById(R.id.r_txt_fname);
        x_txt_lname = (EditText) findViewById(R.id.r_txt_lname);
        x_txt_uname = (EditText) findViewById(R.id.r_txt_username);
        x_txt_email = (EditText) findViewById(R.id.r_txt_email);
        x_txt_pword = (EditText) findViewById(R.id.r_txt_password);
        x_btn_back = (Button) findViewById(R.id.r_btn_back);
        x_btn_register = (Button) findViewById(R.id.r_btn_register);
        x_txt_empty = (TextView)findViewById(R.id.r_txt_empty);
        x_txt = (TextView)findViewById(R.id.r_txt);
        x_view_gethome = new Intent(Regactivity.this, MainActivity.class);
        ma = new MainActivity();
       goback();
       registerfunc();


    }
    public void registerfunc()
    {

        x_btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addplayer();


            }
        });
    }
    public void goback()
    {
        x_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(x_view_gethome);
            }
        });
    }
   public static boolean AllNull(String...strings)


    {
        for (String s : strings) {
            if (s == null || s.isEmpty())
                return true;
        }

        return false;
    }
    public void addplayer()
    {
        ma.dbhelper = new DatabaseHelper(this);

        boolean ifempty = false;

            ma.j_al_players = new ArrayList<Player>();
            ma.adapter = new Pempadapter(this, ma.j_al_players);
            Player player = new Player();

            String fname = x_txt_fname.getText().toString();
            String lname = x_txt_lname.getText().toString();
            String email = x_txt_email.getText().toString();
            String pword = x_txt_pword.getText().toString();
            String username = x_txt_uname.getText().toString();
           ifempty = AllNull(username,fname,lname,pword,email);

            player.setUsername(username);
            player.setFirstname(fname);
            player.setLastname(lname);
            player.setPassword(pword);
            player.setEmail(email);

            boolean checkers =false;
            boolean usernamefilledcheck = true;

            if(username.equals(null)) {
                 usernamefilledcheck = false;
            }

            if(usernamefilledcheck==true) {
            checkers = ma.dbhelper.ucheck(player);
            if(ifempty==true)
            {
            x_txt_empty.setVisibility(View.VISIBLE);
            x_txt_empty.setText("Oops, you forgot to fill out some field(s).");
             }
            if(checkers == true) {
                ma.dbhelper.addnewuser(player);

                ma.j_al_players.add(player);

                ma.adapter.notifyDataSetChanged();
                startActivity(x_view_gethome);
            }
            if(checkers==false)
            {
                x_txt.setVisibility(View.VISIBLE);
                x_txt.setText("Oops! Someone else already has this username, please enter a new one.");
            }



    }
}}
