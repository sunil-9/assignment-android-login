package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        Button button = (Button) findViewById(R.id.log_out);
        TextView userMsg = (TextView) findViewById(R.id.u_name);
        userMsg.setText("Welcome " +name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), splash.class);
                startActivity(intent);
            }
        });
    }
}
