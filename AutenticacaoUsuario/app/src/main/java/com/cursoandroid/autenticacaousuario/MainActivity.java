package com.cursoandroid.autenticacaousuario;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cadastrarUsuario();
        //logarUsuario();
        verificaUsuario();
        //logout();

    }

    //Cadastrar usuario novo
    protected void cadastrarUsuario(){
        firebaseAuth = FirebaseAuth.getInstance();
        //Criar usuario
        firebaseAuth.createUserWithEmailAndPassword("outroemail@bol.com","minhasenha").addOnCompleteListener(MainActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){//Sucesso ao cadastrar
                            Log.i("createUser","Sucesso no cadastro");
                        } else{//Falha ao cadastrar
                            Log.i("createUser","Falha no cadastro");
                        }
                    }
                });
    }

    //Login do usuario
    protected void logarUsuario(){
        firebaseAuth = FirebaseAuth.getInstance();

        //logar
        firebaseAuth.signInWithEmailAndPassword("outroemail@bol.com","minhasenha").addOnCompleteListener(MainActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Log.i("Login","Sucesso no login");
                        } else{
                            Log.i("Login","Falha no login " + task.getException().toString());
                        }

                    }
                });
    }

    //checar se esta logado
    protected void verificaUsuario(){
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            Log.i("verificaUsuario","Usuario esta logado.");
        } else {
            Log.i("verificaUsuario","Nenhum usuario logado.");
        }
    }

    //Metodo para deslogar
    protected void logout(){
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signOut();
    }
}
