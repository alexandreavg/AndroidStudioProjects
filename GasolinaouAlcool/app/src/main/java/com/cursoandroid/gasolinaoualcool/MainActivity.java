package com.cursoandroid.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtAlcool;
    private EditText txtGasolina;
    private Button btnVerificar;
    private TextView lblResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarObjetos();
    }

    protected void carregarObjetos(){

        txtAlcool = (EditText) findViewById(R.id.txtAlcool);
        txtGasolina = (EditText) findViewById(R.id.txtGasolina);
        btnVerificar = (Button) findViewById(R.id.btnVerificar);
        lblResposta = (TextView) findViewById(R.id.lblResposta);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txtAlcool.getText().toString().isEmpty() || txtGasolina.getText().toString().isEmpty()){
                    lblResposta.setText("Alcool ou gasolina sem valores informados!");
                } else {
                    lblResposta.setText(calcular(Double.parseDouble(txtAlcool.getText().toString()),
                            Double.parseDouble(txtGasolina.getText().toString())));
                }
            }
        });

    }

    protected String calcular(Double alcool, Double gasolina){
        Double resultado = 0.00;
        List<String> combustiveis = new ArrayList<String>();
        Integer i;

        combustiveis.add("ALCOOL");
        combustiveis.add("GASOLINA");

        resultado = alcool / gasolina;

        if(resultado > 0.7){
            i = 1;
        } else i = 0;

        return "Ecolha por: " + combustiveis.get(i);
    }
}
