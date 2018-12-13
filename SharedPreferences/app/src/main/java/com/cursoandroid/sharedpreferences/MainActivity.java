package com.cursoandroid.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText txtNome;
    private TextView lblMensagem;
    private Button btnSalvar;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicio();

        recuperarDados();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }

    protected void inicio(){
        txtNome = (EditText) findViewById(R.id.txtNome);
        lblMensagem = (TextView) findViewById(R.id.lblMensagem);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
    }

    protected void salvar(){
        //Indica que o arquivo pode ser acessado apenas pela aplicaçõa.
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

        //Indica que o arquivo pode ser editado pela aplicacao
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(txtNome.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Nome não informado!",Toast.LENGTH_SHORT);
        } else{
            editor.putString("nome",txtNome.getText().toString());
            lblMensagem.setText("Seja bem vindo " + txtNome.getText().toString());
            editor.commit();
        }
    }

    protected void recuperarDados(){
        //Recuperar os Dados Salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

        if(sharedPreferences.contains("nome")){
            String nomeUsuario = sharedPreferences.getString("nome","Usuario não encontrado");

            if(nomeUsuario.equals("Usuario não encontrado")){
                lblMensagem.setText(nomeUsuario);
            } else {
                lblMensagem.setText(("Seja bem vindo " + nomeUsuario));
            }

        } else {
            lblMensagem.setText("Olá usuario não definido.");
        }
    }
}
