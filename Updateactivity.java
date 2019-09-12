package com.example.adurham.testc4;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Updateactivity extends Activity {

    EditText u_txt_firstname;
    EditText u_txt_lastname;
    EditText u_txt_email;
    EditText u_txt_password;
    TextView u_txt_username;
    Button  u_btn_back;
    Button u_btn_update;
    Intent u_view_pleaseletmegohome;
    Intent u_view_goback;
    DatabaseHelper dbhelper;
    MainActivity u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateactivity);

        u_txt_firstname = (EditText)findViewById(R.id.t_txt_firstname);
        u_txt_lastname = (EditText)findViewById(R.id.t_txt_lastname);
        u_txt_email = (EditText)findViewById(R.id.t_txt_email);
        u_txt_password = (EditText)findViewById(R.id.t_txt_password);
        u_txt_username = (TextView)findViewById(R.id.t_txt_username);
        u_btn_back = (Button)findViewById(R.id.t_btn_back);
        u_btn_update = (Button)findViewById(R.id.t_btn_update);
        u_view_pleaseletmegohome = new Intent(Updateactivity.this, MainActivity.class);
        u_view_goback = new Intent(Updateactivity.this, Accinfoactivity.class);
        u = new MainActivity();

        dbhelper = new DatabaseHelper(this);
        Intent intent = getIntent();
        Bundle infopassed = intent.getExtras();
        String uniquekey = infopassed.getString("b list");
        u_txt_username.setText(uniquekey);


        populateplayer();
        updateplayer();
        backtoaccinfo();



    }



    public void backtoaccinfo()
    {
        Intent intent = getIntent();
        Bundle infopassed = intent.getExtras();
        String uniquekey = infopassed.getString("d list");
        Intent clist = u_view_goback.putExtra("c list", uniquekey);
        u_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(u_view_goback);
            }
        });
    }
    public void populateplayer()
    {
        Intent intent = getIntent();
        Bundle infopassed = intent.getExtras();
        String uniquekey = infopassed.getString("d list");
        Log.d("Username", uniquekey);

        String passedpword = infopassed.getString("passlist");
        String passedusername = infopassed.getString("ulist");
        String passedemail = infopassed.getString("elist");
        String passedlname = infopassed.getString("llist");
        String passedfname = infopassed.getString("flist");

        u_txt_firstname.setText(passedfname);
        u_txt_lastname.setText(passedlname);
        u_txt_email.setText(passedemail);
        u_txt_username.setText(passedusername);
        u_txt_password.setText(passedpword);
        //Calling these strings that got passed from accinfo gives me the old information
        //Player pla = new Player();
//        pla = u.dbhelper.gettheplayer(uniquekey);


  //      u_txt_lastname.setText(pla.getLastname().toString());
    //    u_txt_firstname.setText(pla.getFirstname().toString());
      //  u_txt_email.setText(pla.getEmail().toString());
    }
    public void updateplayer()
    {
        u_btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle infopassed = intent.getExtras();
                String uniquekey = infopassed.getString("d list");
                u_txt_username.setText(uniquekey);
                String fname = u_txt_firstname.getText().toString();
                String lname = u_txt_lastname.getText().toString();
                String email = u_txt_email.getText().toString();
                String pass = u_txt_password.getText().toString();


                dbhelper.updatetheplayer(uniquekey,fname,lname,pass,email);
                startActivity(u_view_pleaseletmegohome);
            }
        });




    }

}
