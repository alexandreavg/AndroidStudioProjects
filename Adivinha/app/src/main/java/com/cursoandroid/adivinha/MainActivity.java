package com.cursoandroid.adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnJogar;
    private TextView lblResultado;
    private TextView txtNumeroEscolhido;
    private TextView lblResposta;

    //Metodo MAIN, primeira coisa executada no APP
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Chama a tela principal.

        btnJogar        = (Button)      findViewById(R.id.btnJogar);
        lblResultado    = (TextView)    findViewById(R.id.lblResultado);
        txtNumeroEscolhido = (TextView) findViewById(R.id.txtNumero);
        lblResposta = (TextView)         findViewById(R.id.lblResposta);

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alteraMensagem();
            }
        });
    }


    protected void alteraMensagem(){
        Random numero = new Random();
        int numeroAleatorio = numero.nextInt(10);

        lblResultado.setText("NUMERO = " + numeroAleatorio);

        if(txtNumeroEscolhido.getText().equals(lblResultado)){
            lblResposta.setText("Acertou!");
        } else {
            lblResposta.setText("Errou!");
        }

        limpar();
    }

    protected void limpar(){
        txtNumeroEscolhido.setText(new String());
    }


}
