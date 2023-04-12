package com.example.tiktokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.tiktokapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<Model> arrayList=new ArrayList<>();
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.a,R.drawable.profile,"Rupam Mukherjee"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.b,R.drawable.profile,"Rina Mukherjee"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.c,R.drawable.profile,"Sohag Chakrabarty"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.d,R.drawable.profile,"Ranajit Mukherjee"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.e,R.drawable.profile,"Jay Shree Ram"));

        adapter=new Adapter(MainActivity.this,arrayList);
        binding.vpg2.setAdapter(adapter);
    }
}