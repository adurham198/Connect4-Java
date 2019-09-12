package com.example.adurham.testc4;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Playactivity extends Activity {

    Button y_btn_play;
    Button y_btn_logout;
    Button y_btn_accinfo;
    Intent y_view_gotoaccinfo;
    Intent y_view_gologout;
    Intent y_view_goplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playactivity);

        y_btn_accinfo = (Button)findViewById(R.id.d_btn_accinfo);
        y_btn_logout = (Button)findViewById(R.id.d_btn_logout);
        y_btn_play = (Button)findViewById(R.id.d_btn_playgame);
        y_view_gotoaccinfo = new Intent(Playactivity.this, Accinfoactivity.class);
        y_view_gologout = new Intent(Playactivity.this, MainActivity.class);
        y_view_goplay = new Intent(Playactivity.this, Gameboard.class);
        readname();
        getaccinfo();
        getloggedout();
        gotogame();
    }


    public void getloggedout()
    {
        y_btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(y_view_gologout);
            }
        });
    }

    public void getaccinfo()
    {
        y_btn_accinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(y_view_gotoaccinfo);
            }
        });
    }
    public void gotogame()
    {
        y_btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(y_view_goplay);
            }
        });
    }
    public void readname()
    {
        Intent intent = getIntent();
        Bundle infopassed = intent.getExtras();
        String uniquek = infopassed.getString("b list");
        //This gets the unique username that the user entered in the main login page

        Intent c_list = y_view_gotoaccinfo.putExtra("c list", uniquek);
        //This sends the unique username to the account information page
        //so that it can be accessed in the activity
        //I had issues sending accinfo this information from main.
    }
}
