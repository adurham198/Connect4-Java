package com.example.adurham.testc4;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Accinfoactivity extends Activity {

    MainActivity pa;
    Button p_btn_del;
    Button p_btn_back;
    Button p_btn_update;
    TextView p_txt_fname;
    TextView p_txt_lname;
    TextView p_txt_uname;
    TextView p_txt_pword;
    TextView p_txt_email;
    TextView p_txt_delmsg;
    Intent p_view_backuptomain;
    Intent p_view_backup;
    Intent p_view_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accinfoactivity);
        p_btn_back = (Button)findViewById(R.id.w_btn_back);
        p_btn_del = (Button)findViewById(R.id.w_btn_delete);
        p_btn_update = (Button)findViewById(R.id.w_btn_update);
        p_txt_fname = (TextView)findViewById(R.id.w_txt_fname);
        p_txt_lname = (TextView)findViewById(R.id.w_txt_lname);
        p_txt_uname = (TextView)findViewById(R.id.w_txt_uname);
        p_txt_email = (TextView)findViewById(R.id.w_txt_email);
        p_txt_delmsg = (TextView)findViewById(R.id.w_txt_delmessage);
        p_view_backuptomain = new Intent(Accinfoactivity.this, MainActivity.class);
        p_view_backup = new Intent(Accinfoactivity.this, Playactivity.class);
        p_view_update = new Intent(Accinfoactivity.this, Updateactivity.class);
        pa = new MainActivity();
        pa.dbhelper = new DatabaseHelper(this);

        displayinfo();
        delplayer();
        updateplayer();
        goback();
    }


    public void displayinfo()
    {
        String userNAme = "" ;


        Intent intent = getIntent();
        Bundle infopassed = intent.getExtras();
        String uniquek = infopassed.getString("c list");
        Intent c_list = p_view_update.putExtra("d list", uniquek);


       Player player = new Player();
       player = pa.dbhelper.gettheplayer(uniquek);
       Log.d("username:", player.getUsername());

        p_txt_uname.setText(player.getUsername().toString());
        p_txt_lname.setText(player.getLastname().toString());
        p_txt_fname.setText(player.getFirstname().toString());
        p_txt_email.setText(player.getEmail().toString());


        String unametopass = player.getUsername();
        String fnametopass = player.getFirstname();
        String lnametopass = player.getLastname();
        String emailtopass = player.getEmail();
        String pwordtopass = player.getPassword();

        Intent ulist = p_view_update.putExtra("ulist", unametopass);
        Intent flist = p_view_update.putExtra("flist", fnametopass);
        Intent llist = p_view_update.putExtra("llist", lnametopass);
        Intent passlist = p_view_update.putExtra("passlist", pwordtopass);
        Intent elist = p_view_update.putExtra("elist", emailtopass);


    }
    public void goback()
    {
        Intent intent = getIntent();
        Bundle infopassed = intent.getExtras();
        String uniquek = infopassed.getString("c list");
        Intent c_list = p_view_backup.putExtra("b list", uniquek);

        p_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(p_view_backup);
            }
        });
    }
    public void delplayer()
    {

        p_btn_del.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String userNAme = "" ;
                Intent intent = getIntent();
                Bundle infopassed = intent.getExtras();
                String uniquek = infopassed.getString("c list");

                Player player;
                player = pa.dbhelper.gettheplayer(uniquek);

                pa.dbhelper.deleteplayer(uniquek);
                startActivity(p_view_backuptomain);
                return false;
            }
        });


    }

    public void updateplayer()
    {
        p_btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(p_view_update);
            }
        });
    }
}
