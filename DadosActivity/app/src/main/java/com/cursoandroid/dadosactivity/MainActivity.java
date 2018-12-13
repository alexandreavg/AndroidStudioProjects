package com.cursoandroid.dadosactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cursoandroid.domain.Usuario;

import java.io.Serializable;

public class MainActivity extends Activity {

    private EditText txtNome;
    private EditText txtSenha;
    private Button btnPassar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Usuario usuario = new Usuario();

        capturar();

        usuario.setNome(txtNome.getText().toString());
        usuario.setSenha(txtSenha.getText().toString());

        btnPassar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("Usuario", (Serializable) usuario);

                startActivity(intent);
            }
        });

    }

    protected void capturar(){
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        btnPassar = (Button) findViewById(R.id.btnPassar);
    }
}
