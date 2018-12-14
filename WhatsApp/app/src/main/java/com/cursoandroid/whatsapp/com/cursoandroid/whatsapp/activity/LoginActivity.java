package com.cursoandroid.whatsapp.com.cursoandroid.whatsapp.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cursoandroid.whatsapp.R;
import com.cursoandroid.whatsapp.config.ConfiguracaoFirebase;
import com.cursoandroid.whatsapp.helper.Permissao;
import com.cursoandroid.whatsapp.helper.Preferencias;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class LoginActivity extends Activity {

    private EditText txtEmail;
    private EditText txtSenha;
    private Button btnEntrar;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseReference = ConfiguracaoFirebase.getFirebase();
        databaseReference.child("PONTOS").setValue("800");

        iniciar();

    }

    protected void iniciar(){
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
    }

    public void abrirCadastroUsuario(View view){
        Intent intent = new Intent( LoginActivity.this , CadastroUsuarioActivity.class);
        startActivity(intent);
    }


}
