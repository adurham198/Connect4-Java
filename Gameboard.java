package com.example.adurham.testc4;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class Gameboard extends Activity {

    //public static char[][] cells = new char[NUM_COLS][NUM_ROWS];
    public static char[][] cells = new char[7][6];
    DatabaseHelper dbhelper;
    private View boardView;
    static int counter= 0;
    private Board board;
    private static int NUM_ROWS = 6;
    private static int NUM_COLS = 7;
    static int row0 = 5, row1=5,row2=5,row3=5,row4=5,row5=5,row6=5;
    MediaPlayer chips;
    Button a_btn_reset;
    Button a_btn_col1;
    Button a_btn_col2;
    Button a_btn_col3;
    Button a_btn_col4;
    Button a_btn_col5;
    Button a_btn_col6;
    Button a_btn_col7;
    ImageView a_col1r1;
    ImageView a_col1r2;
    ImageView a_col1r3;
    ImageView a_col1r4;
    ImageView a_col1r5;
    ImageView a_col1r6;
    ImageView a_col2r1;
    ImageView a_col2r2;
    ImageView a_col2r3;
    ImageView a_col2r4;
    ImageView a_col2r5;
    ImageView a_col2r6;
    ImageView a_col3r1;
    ImageView a_col3r2;
    ImageView a_col3r3;
    ImageView a_col3r4;
    ImageView a_col3r5;
    ImageView a_col3r6;
    ImageView a_col4r1;
    ImageView a_col4r2;
    ImageView a_col4r3;
    ImageView a_col4r4;
    ImageView a_col4r5;
    ImageView a_col4r6;
    ImageView a_col5r1;
    ImageView a_col5r2;
    ImageView a_col5r3;
    ImageView a_col5r4;
    ImageView a_col5r5;
    ImageView a_col5r6;
    ImageView a_col6r1;
    ImageView a_col6r2;
    ImageView a_col6r3;
    ImageView a_col6r4;
    ImageView a_col6r5;
    ImageView a_col6r6;
    ImageView a_col7r1;
    ImageView a_col7r2;
    ImageView a_col7r3;
    ImageView a_col7r4;
    ImageView a_col7r5;
    ImageView a_col7r6;

    Intent r;
    TextView a_txt_wintext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameboard);
        board = new Board();
        a_btn_reset = (Button) findViewById(R.id.g_btn_reset);
        a_txt_wintext = (TextView) findViewById(R.id.g_txt_winscreen);
        a_btn_col1 = (Button) findViewById(R.id.g_col1);
        a_btn_col2 = (Button) findViewById(R.id.g_col2);
        a_btn_col3 = (Button) findViewById(R.id.g_col3);
        a_btn_col4 = (Button) findViewById(R.id.g_col4);
        a_btn_col5 = (Button) findViewById(R.id.g_col5);
        a_btn_col6 = (Button) findViewById(R.id.g_col6);
        a_btn_col7 = (Button) findViewById(R.id.g_col7);

        a_col1r1=(ImageView)findViewById(R.id.g_c1r1);
        a_col1r2 = (ImageView) findViewById(R.id.g_c1r1);
        a_col1r3 = (ImageView) findViewById(R.id.g_c1r2);
        a_col1r4 = (ImageView) findViewById(R.id.g_c1r3);
        a_col1r5 = (ImageView) findViewById(R.id.g_c1r4);
        a_col1r6 = (ImageView) findViewById(R.id.g_c1r5);
        a_col2r1 = (ImageView) findViewById(R.id.g_c1r6);
        a_col2r2 = (ImageView) findViewById(R.id.g_c2r1);
        a_col2r3 = (ImageView) findViewById(R.id.g_c2r2);
        a_col2r4 = (ImageView) findViewById(R.id.g_c2r3);
        a_col2r4 = (ImageView) findViewById(R.id.g_c2r4);
        a_col2r5 = (ImageView) findViewById(R.id.g_c2r5);
        a_col2r6 = (ImageView) findViewById(R.id.g_c2r6);
        a_col3r1 = (ImageView) findViewById(R.id.g_c3r1);
        a_col3r2 = (ImageView) findViewById(R.id.g_c3r2);
        a_col3r3 = (ImageView) findViewById(R.id.g_c3r3);
        a_col3r4 = (ImageView) findViewById(R.id.g_c3r4);
        a_col3r5 = (ImageView) findViewById(R.id.g_c3r5);
        a_col3r6 = (ImageView) findViewById(R.id.g_c3r6);
        a_col4r1 = (ImageView) findViewById(R.id.g_c4r1);
        a_col4r2 = (ImageView) findViewById(R.id.g_c4r2);
        a_col4r3 = (ImageView) findViewById(R.id.g_c4r3);
        a_col4r4 = (ImageView) findViewById(R.id.g_c4r4);
        a_col4r5 = (ImageView) findViewById(R.id.g_c4r5);
        a_col4r6 = (ImageView) findViewById(R.id.g_c4r6);
        a_col5r1 = (ImageView) findViewById(R.id.g_c5r1);
        a_col5r2 = (ImageView) findViewById(R.id.g_c5r2);
        a_col5r3 = (ImageView) findViewById(R.id.g_c5r3);
        a_col5r4 = (ImageView) findViewById(R.id.g_c5r4);
        a_col5r5 = (ImageView) findViewById(R.id.g_c5r5);
        a_col5r6 = (ImageView) findViewById(R.id.g_c5r6);
        a_col6r1 = (ImageView) findViewById(R.id.g_c6r1);
        a_col6r2 = (ImageView) findViewById(R.id.g_c6r2);
        a_col6r3 = (ImageView) findViewById(R.id.g_c6r3);
        a_col6r4 = (ImageView) findViewById(R.id.g_c6r4);
        a_col6r5 = (ImageView) findViewById(R.id.g_c6r5);
        a_col6r6 = (ImageView) findViewById(R.id.g_c6r6);
        a_col7r1 = (ImageView) findViewById(R.id.g_c7r1);
        a_col7r2 = (ImageView) findViewById(R.id.g_c7r2);
        a_col7r3 = (ImageView) findViewById(R.id.g_c7r3);
        a_col7r4 = (ImageView) findViewById(R.id.g_c7r4);
        a_col7r5 = (ImageView) findViewById(R.id.g_c7r5);
        a_col7r6 = (ImageView) findViewById(R.id.g_c7r6);
        r = new Intent(Gameboard.this, Gameboard.class);

        chips = new MediaPlayer();
        dbhelper=new DatabaseHelper(this);
        chips = MediaPlayer.create(this, R.raw.chip);


        buildboard();
        colpressed();

        gameover();
        resetfunc();
    }



public void makechipnoise()
{
    chips.start();
}
    public void resetfunc()
    {

        a_btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row0 = 5;
                row1 = 5;
                row2=5;
                row3=5;
                row4=5;
                row5=5;
                row6=5;
                a_txt_wintext.setText("");
                startActivity(r);
            }
        });
    }
    public void gameover()
    {

    }
    public void buildboard() {


        for (int i = 0; i < cells.length; i++) {

            for (int j = 0; j < cells[i].length; j++) {


                cells[i][j] = 'E';




            }
        }
        Log.d("Thisarr", Arrays.deepToString(cells));
        //this line prints my array
    }

    public void colpressed() {
        if(row0>0&&row1>0&&row2>0&&row3>0&&row4>0&&row5>0&&row6>0) {
            a_btn_col1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    adjustgui(0);
                    cells = dropchip(0);
                    whowon(cells);
                    makeAImove();

                    whowon(cells);
                    makechipnoise();
                }
            });

            a_btn_col2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adjustgui(1);
                    dropchip(1);
                    whowon(cells);
                    makeAImove();

                    whowon(cells);
                    makechipnoise();
                }
            });
            a_btn_col3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adjustgui(2);
                    dropchip(2);
                    whowon(cells);
                    makeAImove();
                    whowon(cells);
                    makechipnoise();
                }
            });

            a_btn_col4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adjustgui(3);
                    dropchip(3);
                    whowon(cells);
                    makeAImove();

                    makechipnoise();
                    whowon(cells);

                }
            });
            a_btn_col5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adjustgui(4);
                    dropchip(4);
                    whowon(cells);
                    makeAImove();
                    makechipnoise();
                    whowon(cells);
                }
            });
            a_btn_col6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adjustgui(5);
                    dropchip(5);
                    whowon(cells);
                    makeAImove();
                    makechipnoise();
                    whowon(cells);
                }
            });
            a_btn_col7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adjustgui(6);
                    dropchip(6);
                    whowon(cells);
                    makechipnoise();
                    makeAImove();
                    whowon(cells);
                }
            });
        }
    }

    public char[][] dropchip(int columnclicked) {
        int col0=0, col1=1, col2=2, col3=3, col4=4, col5=5, col6 = 6;
        {

            if (row0 > 0 && row1 > 0 && row2 > 0 && row3 > 0 && row4 > 0 && row5 > 0 && row6>0) {
                if (col0 == columnclicked) {

                    for (int r = 6; r >= 0; r--) {
                        for (int c = 0; c <= 0; c++) {

                            cells[columnclicked][row0] = 'C';

                        }
                    }  row0--;


                }
                if (col1 == columnclicked) {

                    for (int r = 6; r >= 0; r--) {
                        for (int c = 0; c <= 0; c++) {
                            cells[columnclicked][row1] = 'C';

                        }
                    } row1--;


                }
                if (col2 == columnclicked) {

                    for (int r = 6; r >= 0; r--) {
                        for (int c = 0; c <= 0; c++) {
                            cells[columnclicked][row2] = 'C';
                        }
                    }row2--;


                }
                if (col3 == columnclicked) {

                    for (int r = 6; r >= 0; r--) {
                        for (int c = 0; c <= 0; c++) {
                            cells[columnclicked][row3] = 'C';

                        }
                    }row3--;

                }
                if (col4 == columnclicked) {

                    for (int r = 6; r >= 0; r--) {
                        for (int c = 0; c <= 0; c++) {
                            cells[columnclicked][row4] = 'C';

                        }
                    }  row4--;

                }
                if (col5 == columnclicked) {
                    for (int r = 6; r >= 0; r--) {
                        for (int c = 0; c <= 0; c++) {
                            cells[columnclicked][row5] = 'C';

                        }
                    }
                    row5--;
                }

                if (col6 == columnclicked) {

                    for (int r = 6; r >= 0; r--) {
                        for (int c = 0; c <= 0; c++) {
                            cells[columnclicked][row6] = 'C';

                        }
                    }row6--;

                }
            }
        }
        gameover();
        return cells;
    }

    public void makeAImove() {
        if(row0>=0&&row1>=0&&row2>=0&&row3>=0&&row4>=0&&row5>=0&&row6>=0) {
            int pickedcol = wheretomoveAI();
            boolean move = shouldimovetothatcell(pickedcol);
            if (move == true) {
                if (pickedcol == 0) {
                    cells[pickedcol][row0] = 'A';
                    adjustgui(pickedcol);
                    row0--;
                }
                if (pickedcol == 1) {
                    cells[pickedcol][row1] = 'A';
                    adjustgui(pickedcol);
                    row1--;
                }
                if (pickedcol == 2) {
                    cells[pickedcol][row2] = 'A';
                    adjustgui(pickedcol);
                    row2--;
                }
                if (pickedcol == 3) {
                    cells[pickedcol][row3] = 'A';
                    adjustgui(pickedcol);
                    row3--;
                }
                if (pickedcol == 4) {
                    cells[pickedcol][row4] = 'A';
                    adjustgui(pickedcol);
                    row4--;
                }
                if (pickedcol == 5) {
                    cells[pickedcol][row5] = 'A';
                    adjustgui(pickedcol);
                    row5--;
                }
                if (pickedcol == 6) {
                    cells[pickedcol][row6] = 'A';
                    adjustgui(pickedcol);
                    row6--;
                }
            }
            Log.d("A new, hopeful array", Arrays.deepToString(cells));
        }

    }

    public int wheretomoveAI() {

        for (int c = 6; c >= 3; c--) {
            for ( int r = 5; r >=0; r--) {
                if (cells[c][r] == 'A' && cells[c - 1][r] == 'A' && cells[c - 2][r] == 'A') {

                   // adjustgui(c-3);
                    return (c-3);
                }
            }
        }

        for(int c= 6; c>=0;c--)
        {
            for(int r =5; r>=3;r--)
            {
                if (cells[c][r] == 'A' && cells[c][r-1] == 'A' && cells[c][r-2] == 'A') {

                  //  adjustgui(c);
                    return c;
                }
            }
        }
        for(int c= 6; c>=3;c--)
        {
            for(int r =5; r>=3;r--)
            {
                if (cells[c][r] == 'A' && cells[c-1][r-1] == 'A' && cells[c-2][r-2] == 'A') {

                   // adjustgui(c-3);
                    return (c-3);

                }
            }
        }


        ///////These 3 loops check for a winning(best) move

        for (int c = 6; c >= 3; c--) {
            for ( int r = 5; r >=0; r--) {
                if (cells[c][r] == 'C' && cells[c - 1][r] == 'C' && cells[c - 2][r] == 'C') {

                    //adjustgui(c-3);
                    return (c-3);
                }
            }
        }

        for(int c= 6; c>=0;c--)
        {
            for(int r =5; r>=3;r--)
            {
                if (cells[c][r] == 'C' && cells[c][r-1] == 'C' && cells[c][r-2] == 'C') {

                    //adjustgui(c);
                    return c;
                }
            }
        }
        for(int c= 6; c>=3;c--)
        {
            for(int r =5; r>=3;r--)
            {
                if (cells[c][r] == 'C' && cells[c-1][r-1] == 'C' && cells[c-2][r-2] == 'C') {

                    //adjustgui(c-3);
                    return (c-3);
                }
            }
        }
        //these loops check if the opposing player has a winning move we should block


        int random = (int)(Math.random() * 6 + 1);
        Log.d("RANDOM", String.valueOf(random));
       // adjustgui(random);
        return random;

        //This random statement is to return a random column to be placed in if there isn't a winning spot
    }

    public boolean shouldimovetothatcell(int c) {

        if (c == 0&& row0>=0) {
            if (cells[c][row0] != 'C') {
                return true;
            }
        }
        if (c == 1&& row1>=0) {
            if (cells[c][row1] != 'C') {
                return true;
            }
        }
        if (c == 2&& row2>=0) {
            if (cells[c][row2] != 'C') {
                return true;
            }
        }
        if (c == 3&& row3>=0) {
            if (cells[c][row3] != 'C') {

                return true;
            }
        }
        if (c == 4&& row4>=0) {
            if (cells[c][row4] != 'C') {
                return true;
            }
        }
        if (c == 5&& row5>=0) {
            if (cells[c][row5] != 'C') {
                return true;
            }
        }
        if(c == 6 && row6>=0)
        {
            if (cells[c][row6] != 'C') {
                return true;
            }
        }
        return false;

    }
    public boolean winfunctionforAI(char[][] cells)
    {
        for(int c = 0; c<=6;c++)
        {
            for(int r = 0;r<=2;r++)
            {
                if(cells[c][r]=='A' && cells[c][r+1]=='A'&&cells[c][r+2] == 'A'&& cells[c][r+3]=='A')
                {
                    return true;
                }
            }
        }


        for(int col = 0; col<=3;col++)
        {
            for(int r = 0; r<=5;r++)
            {
                if(Gameboard.cells[col][r]=='A'&& Gameboard.cells[col+1][r]=='A' && Gameboard.cells[col+2][r]=='A'&& Gameboard.cells[col+3][r]=='A')
                {
                    return true;
                }

            }
        }
        for(int c= 6; c>=3;c--)
        {
            for(int r =5; r>=3;r--)
            {
                if (cells[c][r] == 'A' && cells[c-1][r-1] == 'A' && cells[c-2][r-2] == 'A' && cells[c-3][r-3]=='A') {


                    return true;

                }
            }
        }
        return false;
    }
    public boolean winfunctionforplayer(char[][] cells)
    {

        for(int c = 0; c<=6;c++)
        {
            for(int r = 0;r<=2;r++)
            {
                if(cells[c][r]=='C' && cells[c][r+1]=='C'&&cells[c][r+2] == 'C'&& cells[c][r+3]=='C')
                {
                    return true;
                }
            }
        }


        for(int col = 0; col<=3;col++)
        {
            for(int r = 0; r<=5;r++)
            {
                if(Gameboard.cells[col][r]=='C'&& Gameboard.cells[col+1][r]=='C' && Gameboard.cells[col+2][r]=='C'&& Gameboard.cells[col+3][r]=='C')
                {
                    return true;
                }

            }
        }


        for(int col =0; col<=3;col++)
        {
            for(int r = 5; r>=3;r--)
            {
                if(Gameboard.cells[r][col]=='C'&& Gameboard.cells[r-1][col+1]=='C' && Gameboard.cells[r-2][col+2]=='C'&& Gameboard.cells[r-3][col+3]=='C')
                {
                    return true;
                }

            }
        }
        for(int col =6; col>=3;col--)
        {
            for(int r = 5;r>=3;r--)
            {

                if(cells[col][r]=='C' && cells[col-1][r-1] == 'C' && cells[col-2][r-2] =='C' && cells[col-3][r-3] =='C') {
                    {
                        return true;
                    }
                }
            }
        }


      return false;


    }
    public void whowon(char[][] cells)
    {

        boolean pcheck = winfunctionforplayer(cells);
        boolean acheck = winfunctionforAI(cells);
        if(pcheck==true)
        {
            Log.d("Thiswinningarr", Arrays.deepToString(cells));
           Log.d("WINMSG", "THE PLAYER WON");
           a_txt_wintext.setText("CONGRATS Player 1");

        }
        if(pcheck == false)
        {

        }
        if(acheck==true)
        {
            Log.d("Thiswinningarr", Arrays.deepToString(Gameboard.cells));
            Log.d("WINMSG", "AI WON");
            a_txt_wintext.setText("TRY HARDER NEXT TIME");
        }
        if (acheck ==false)
        {

        }

    }
    public void adjustgui(int column)
    {

        if(counter%2 !=0)
        {
            Context context = findViewById(R.id.g_c1r1).getContext();
            String pictureName = "red";
            int resIDred = context.getResources().getIdentifier(pictureName, "drawable", context.getPackageName());
            Log.d("ENTER", "PLAYER");
            if (column == 0) {
            if (row0 == 0)
            {

                a_col1r1.setVisibility(View.VISIBLE);
                a_col1r1.setImageResource(resIDred);
            }
                if(row0==1)
                {
                    Log.d("LINE", "TOBEFOUJD");
                    a_col1r2.setVisibility(View.VISIBLE);
                    a_col1r2.setImageResource(resIDred);
                }
                if(row0==2)
                {
                    a_col1r3.setVisibility(View.VISIBLE);
                    a_col1r3.setImageResource(resIDred);
                }
                if(row0==3)
                {
                    a_col1r4.setVisibility(View.VISIBLE);
                    a_col1r4.setImageResource(resIDred);
                }
                if(row0==4)
                {
                    a_col1r5.setVisibility(View.VISIBLE);
                    a_col1r5.setImageResource(resIDred);
                }
            if(row0==5)
            {
                Log.d("THE", "BLITZ");
                a_col1r6.setVisibility(View.VISIBLE);
                a_col1r6.setImageResource(resIDred);
            }
         }

            if(column == 1)
            {
                if (row1 == 0) {

                    a_col2r1.setVisibility(View.VISIBLE);
                    a_col2r1.setImageResource(resIDred);

                }
                if(row1==1)
                {
                    a_col2r2.setVisibility(View.VISIBLE);
                    a_col2r2.setImageResource(resIDred);
                }
                if(row1==2)
                {
                    a_col2r3.setVisibility(View.VISIBLE);
                    a_col2r3.setImageResource(resIDred);
                }
                if(row1==3)
                {
                    a_col2r4.setVisibility(View.VISIBLE);
                    a_col2r4.setImageResource(resIDred);
                }
                if(row1==4)
                {
                    a_col2r5.setVisibility(View.VISIBLE);
                    a_col2r5.setImageResource(resIDred);
                }
                if(row1==5)
                {
                    a_col2r6.setVisibility(View.VISIBLE);
                    a_col2r6.setImageResource(resIDred);
                }
            }

        }

        if(counter%2==0) {
            Context context = findViewById(R.id.g_c1r1).getContext();
            String pictureName = "yellow";
            int resID = context.getResources().getIdentifier(pictureName, "drawable", context.getPackageName());
            Log.d("ENTER", "AI");
            if(column==0)
            {
                if (row0 == 0) {

                    Log.d("COL1 AI", "ROW 0 AI");
                    a_col1r1.setVisibility(View.VISIBLE);
                    a_col1r1.setImageResource(resID);

                }
                if(row0==1)
                {
                    a_col1r2.setVisibility(View.VISIBLE);
                    a_col1r2.setImageResource(resID);
                }
                if(row0==2)
                {
                    a_col1r3.setVisibility(View.VISIBLE);
                    a_col1r3.setImageResource(resID);
                }
                if(row0==3)
                {
                    a_col1r4.setVisibility(View.VISIBLE);
                    a_col1r4.setImageResource(resID);
                }
                if(row0==4)
                {
                    a_col1r5.setVisibility(View.VISIBLE);
                    a_col1r5.setImageResource(resID);
                }
                if(row0==5)
                {
                    a_col1r6.setVisibility(View.VISIBLE);
                    a_col1r6.setImageResource(resID);
                }
            }
            if (column == 1) {
                if (row1 == 0) {

                    a_col2r1.setVisibility(View.VISIBLE);
                    a_col2r1.setImageResource(resID);

                }
                if(row1==1)
                {
                    a_col2r2.setVisibility(View.VISIBLE);
                    a_col2r2.setImageResource(resID);
                }
                if(row1==2)
                {
                    a_col2r3.setVisibility(View.VISIBLE);
                    a_col2r3.setImageResource(resID);
                }
                if(row1==3)
                {
                    a_col2r4.setVisibility(View.VISIBLE);
                    a_col2r4.setImageResource(resID);
                }
                if(row1==4)
                {
                    a_col2r5.setVisibility(View.VISIBLE);
                    a_col2r5.setImageResource(resID);
                }
                if(row1==5)
                {
                    a_col2r6.setVisibility(View.VISIBLE);
                    a_col2r6.setImageResource(resID);
                }
            }

            if (column == 2) {

            }

            if (column == 3) {

            }

            if (column == 4) {

            }

            if (column == 5) {

            }

            if (column == 6) {

            }

        }

        counter++;
    }
}
