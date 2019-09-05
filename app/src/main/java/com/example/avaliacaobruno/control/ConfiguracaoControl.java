package com.example.avaliacaobruno.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.avaliacaobruno.R;
import com.example.avaliacaobruno.model.Configuracao;
import com.example.avaliacaobruno.uteis.Constantes;
import com.example.avaliacaobruno.view.MainActivity;

public class ConfiguracaoControl {
    private Activity activity;
    private NumberPicker npRequisitos;
    private Configuracao configuracao;
    private Integer minino, maximo;

    public ConfiguracaoControl(Activity activity) {
        this.activity = activity;
        initComponents();
        configuracao = new Configuracao();
    }

    private void initComponents() {
        npRequisitos = activity.findViewById(R.id.npRequisitos);
    }

    public void enviarAction() {
        Intent it = new Intent(activity, MainActivity.class);
        it.putExtra(Constantes.Parametro.PARAMETRO_CONFIGURACAO, configuracao);
        activity.startActivityForResult(it, Constantes.REQUEST_CONFIGURACAO);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == activity.RESULT_OK) {
            if (requestCode == Constantes.REQUEST_CONFIGURACAO) {
                configuracao = (Configuracao) data.getSerializableExtra(Constantes.Parametro.PARAMETRO_CONFIGURACAO);
                npRequisitos.setMinValue(configuracao.getMinimo());
                npRequisitos.setMaxValue(configuracao.getMaximo());
            }
        } else if (resultCode == activity.RESULT_CANCELED) {
            Toast.makeText(activity, "Operação cancelada", Toast.LENGTH_SHORT).show();
        }

    }
}
