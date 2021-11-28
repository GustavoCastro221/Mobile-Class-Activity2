package com.example.appatividade2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static int REQUEST_ADD = 0;
    public static int REQUEST_EDIT = 1;
    ArrayList<String> players;
    ArrayAdapter adapter;
    ListView listViewPlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        players = new ArrayList<String>();
        adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, players);

        listViewPlayers = (ListView) findViewById(R.id.playerListView);
        listViewPlayers.setAdapter(adapter);

    }

    public void addPlayer(View view){
        Intent intent = new Intent(this, FormActivity.class);
        //int playerID = players.length + 1;
        intent.putExtra("request_code", REQUEST_ADD);
        //intent.putExtra("id", playerID);
        startActivityForResult(intent, REQUEST_ADD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String result =  " Resultado: " + requestCode + " - " + resultCode;

        if(resultCode == FormActivity.RESULT_ADD){

            if(data.getExtras() != null && requestCode == REQUEST_ADD){
                Player addedPlayer = new Player();
                addedPlayer.name = data.getStringExtra("name");
                addedPlayer.team = data.getStringExtra("team");
                players.add((String) addedPlayer.toString());
                Toast.makeText(this, "Player Added", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(this, "Empty name and team", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
        }
    }

}