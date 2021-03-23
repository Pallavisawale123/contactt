package com.example.contactt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
private Button b11;
private Button b22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        b11 = findViewById ( R.id.b2 );
        b22 = findViewById ( R.id.b1 );
        b11.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i=new Intent (MainActivity.this,fetchdata.class);
                startActivity ( i );
            }
        } );
        b22.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent j=new Intent (MainActivity.this,SaveC.class);
                startActivity ( j );
            }
        } );
    }
}
