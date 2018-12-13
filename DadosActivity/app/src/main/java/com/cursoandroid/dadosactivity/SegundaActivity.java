package com.cursoandroid.dadosactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.cursoandroid.domain.Usuario;

public class SegundaActivity extends Activity {

    private TextView txtNome;
    private TextView txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Usuario usuario = new Usuario();

        txtNome = (TextView) findViewById(R.id.txtNome);
        txtSenha = (TextView) findViewById(R.id.txtSenha);

        Bundle extra = getIntent().getExtras();

        usuario = (Usuario) extra.get("Usuario");

        txtNome.setText(usuario.getNome());
        txtSenha.setText(usuario.getSenha());
    }
}
