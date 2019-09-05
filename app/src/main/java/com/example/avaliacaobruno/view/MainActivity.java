package com.example.avaliacaobruno.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.avaliacaobruno.R;
import com.example.avaliacaobruno.control.MainControl;

public class MainActivity extends Activity {
    private MainControl control;

    public void enviar(View view) {
        control.enviarAction();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

}
