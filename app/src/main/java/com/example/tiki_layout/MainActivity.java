package com.example.tiki_layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  SendingData{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
    }


    @Override
    public void sendingData(String data) {
        TextView tvThanhTien = findViewById(R.id.tvThanhTien);
        tvThanhTien.setText(data);
    }
}