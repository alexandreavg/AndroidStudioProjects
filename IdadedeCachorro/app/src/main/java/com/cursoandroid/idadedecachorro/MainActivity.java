package com.cursoandroid.idadedecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtQtdAnos;
    private TextView lblResposta;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregaObjetos();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txtQtdAnos.getText().toString().isEmpty()){
                    lblResposta.setText("DIGITE UMA IDADE!");
                } else {
                    lblResposta.setText("O animal possui " + calcular(txtQtdAnos) + " anos em idade humana");
                }
            }
        });

    }

    protected void carregaObjetos(){
        txtQtdAnos = (EditText) findViewById(R.id.txtQtdAnos);
        lblResposta = (TextView) findViewById(R.id.lblResposta);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
    }

    protected Integer calcular (EditText idade){
        Integer retorno;
        retorno = Integer.parseInt(idade.getText().toString());

        return retorno * 7;
    }
}
