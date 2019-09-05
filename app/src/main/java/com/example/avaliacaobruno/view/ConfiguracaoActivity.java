package com.example.avaliacaobruno.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.avaliacaobruno.R;
import com.example.avaliacaobruno.control.ConfiguracaoControl;
import com.example.avaliacaobruno.model.Configuracao;

public class ConfiguracaoActivity extends Activity {
    private ConfiguracaoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);
        control = new ConfiguracaoControl(this);
    }

    public void requisitar(View view) {
        control.enviarAction();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}
