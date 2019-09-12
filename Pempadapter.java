package com.example.adurham.testc4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.adurham.testc4.Player;
import com.example.adurham.testc4.R;

import java.util.ArrayList;

public class Pempadapter extends BaseAdapter{
    Context context;
    ArrayList<Player> al_j_adapter_listOfPlayers;


    public Pempadapter(Context context, ArrayList<Player> al_j_adapter_listOfPlayers)
    {
        this.context = context;
        this.al_j_adapter_listOfPlayers = al_j_adapter_listOfPlayers;
    }

    @Override
    public int getCount()
    {
        return al_j_adapter_listOfPlayers.size();
    }

    @Override
    public Object getItem(int position)
    {
        return al_j_adapter_listOfPlayers.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.activity_pempadapter, null);
        }





        String firstNameStr = al_j_adapter_listOfPlayers.get(position).getFirstname();


        String lastNameStr = al_j_adapter_listOfPlayers.get(position).getLastname();


        String usernameStr = al_j_adapter_listOfPlayers.get(position).getUsername();
        String pwordstr = al_j_adapter_listOfPlayers.get(position).getPassword();
        String email = al_j_adapter_listOfPlayers.get(position).getEmail();
        return convertView;
    }
}
