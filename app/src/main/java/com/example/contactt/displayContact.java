package com.example.contactt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;

import android.widget.TextView;

public class displayContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_display_contact );

        Intent intent = getIntent();
        String name = intent.getStringExtra("Rname");
        String phone = intent.getStringExtra("Rphone");
        String email=intent.getStringExtra("Remail");


        TextView nameTextView = findViewById(R.id.lname);
        nameTextView.setText(name);



        TextView phoneTextView = findViewById(R.id.p);
        phoneTextView.setText(phone);

        TextView emailTextView = findViewById(R.id.e);
        emailTextView.setText(email);
    }

    public void ShowDialer(View view)
    {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0123456789"));
            startActivity(intent);
        }

}

