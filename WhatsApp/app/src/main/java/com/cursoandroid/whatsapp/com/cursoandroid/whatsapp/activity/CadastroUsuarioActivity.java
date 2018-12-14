package com.cursoandroid.whatsapp.com.cursoandroid.whatsapp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cursoandroid.whatsapp.R;
import com.cursoandroid.whatsapp.config.ConfiguracaoFirebase;
import com.cursoandroid.whatsapp.domain.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtSenha;
    private Button btnCadastrar;
    private Usuario usuario;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        iniciar();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario();

                usuario.setNome(txtNome.getText().toString());
                usuario.setEmail(txtEmail.getText().toString());
                usuario.setSenha(txtSenha.getText().toString());

                try {
                    cadastrarUsuario(usuario);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    private void iniciar(){

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

    }

    private void cadastrarUsuario(Usuario usuario) throws Exception{
        firebaseAuth = ConfiguracaoFirebase.getFirebaseAuth();
        firebaseAuth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(CadastroUsuarioActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Usuario cadastrado com sucesso.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Ocorreu um erro no cadastro.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
