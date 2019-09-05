package com.example.avaliacaobruno.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avaliacaobruno.R;
import com.example.avaliacaobruno.model.Configuracao;
import com.example.avaliacaobruno.model.ConfiguracaoBO;
import com.example.avaliacaobruno.uteis.Constantes;
import com.example.avaliacaobruno.view.ConfiguracaoActivity;

public class MainControl {
    private Activity activity;
    private TextView editMinimo;
    private TextView editMaximo;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        editMinimo = activity.findViewById(R.id.editMinimo);
        editMaximo = activity.findViewById(R.id.editMaximo);
        carregarForm();
    }

    private void carregarForm(){
        try {
            Configuracao configuracao = (Configuracao) activity.getIntent().getSerializableExtra(Constantes.Parametro.PARAMETRO_CONFIGURACAO);
            if (configuracao.getMinimo() != null)
            editMinimo.setText(String.valueOf(configuracao.getMinimo()));
            if (configuracao.getMaximo() != null)
            editMaximo.setText(String.valueOf(configuracao.getMaximo()));
        } catch (Exception e){

        }
    }

    private Configuracao getDadosForm() {
        try {
            Configuracao configuracao = new Configuracao();
            configuracao.setMinimo(Integer.parseInt(editMinimo.getText().toString()));
            configuracao.setMaximo(Integer.parseInt(editMaximo.getText().toString()));
            return configuracao;
        } catch (Exception e){
            return null;
        }
    }

    private boolean valida(Configuracao c) {
        if (!ConfiguracaoBO.valida(c)){
            editMinimo.setError("O valor mínimo não pode ser igual ou superior ao valor máximo");
            editMinimo.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void enviarAction() {
        Configuracao configuracao = getDadosForm();
        if (valida(configuracao)){
            Intent it = new Intent(activity, ConfiguracaoActivity.class);
            it.putExtra(Constantes.Parametro.PARAMETRO_CONFIGURACAO, configuracao);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }
    }

}
