package com.devheverton.ciclodevida;



import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.devheverton.ciclodevida.databinding.ActivitySegundaTelaBinding;


public class SegundaTela extends AppCompatActivity {
    private ActivitySegundaTelaBinding binding;
    private  final String TAG = "lifecycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundaTelaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.i(TAG, getLocalClassName() + ".onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getLocalClassName() + ".onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getLocalClassName() + ".onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, getLocalClassName() + ".onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getLocalClassName() + ".onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, getLocalClassName() + ".onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, getLocalClassName() + ".onDestroy");
    }
}
}