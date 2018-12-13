package com.cursoandroid.whatsapp.com.cursoandroid.whatsapp.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.cursoandroid.whatsapp.helper.Permissao;
import com.cursoandroid.whatsapp.helper.Preferencias;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class LoginActivity extends Activity {

    private EditText txtTelefone;
    private EditText txtCodPais;
    private EditText txtDDD;
    private EditText txtNome;
    private Button btnCadastrar;
    private ArrayList<String> permissoesNecessarias = carregaPermissoes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciar();

        Permissao.validaPermissoes(1,this, permissoesNecessarias);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gerarToken();
            }
        });

    }

    protected void iniciar(){

        txtNome = (EditText) findViewById(R.id.txtNome);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        try {

            txtDDD = (EditText) findViewById(R.id.txtDDD);
            SimpleMaskFormatter smfTxtDDD = new SimpleMaskFormatter("NN");
            MaskTextWatcher mtwtxtDDD = new MaskTextWatcher(txtDDD, smfTxtDDD);
            txtDDD.addTextChangedListener(mtwtxtDDD);

            txtCodPais = (EditText) findViewById(R.id.txtCodPais);
            SimpleMaskFormatter smfTxtCodPais = new SimpleMaskFormatter("+NN");
            MaskTextWatcher mtwTxtCodPais = new MaskTextWatcher(txtCodPais, smfTxtCodPais);
            txtCodPais.addTextChangedListener(mtwTxtCodPais);

            txtTelefone = (EditText) findViewById(R.id.txtTelefone);
            SimpleMaskFormatter smfTelefone = new SimpleMaskFormatter("NNNNN-NNNN");
            MaskTextWatcher mtwTelefone = new MaskTextWatcher(txtTelefone, smfTelefone);
            txtTelefone.addTextChangedListener(mtwTelefone);
        } catch ( Exception e){
            e.printStackTrace();
        }

    }

    protected void gerarToken(){
        String nome = txtNome.getText().toString();
        String telefoneCompleto = txtCodPais.getText().toString() + "" + txtDDD.getText().toString() + "" + txtTelefone.getText().toString();

        String telefoneSemFormatacao = telefoneCompleto.replace("+","");
        telefoneSemFormatacao = telefoneSemFormatacao.replace("-","");

        Random random = new Random();
        String token = String.valueOf(random.nextInt(9999 - 1000) + 1000);

        //Salvar Token no SharedPref
        Preferencias preferencias = new Preferencias(LoginActivity.this);
        preferencias.salvarUsuarioPreferencias(nome,telefoneSemFormatacao,token);

        //Pegar dados do usuario
        HashMap<String,String> usuario = preferencias.getDadosUsuario();

        String msg = "Whatsapp codigo de confirmação:" + token;

        //Envio do SMS
        boolean smsEnviado = enviarSMS("+" + telefoneSemFormatacao, msg);

    }

    protected Boolean enviarSMS(String telefone, String mensagem){

        try {

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(telefone,null,mensagem,null,null);


            Toast.makeText(getApplicationContext(), "Mensagem enviada.", Toast.LENGTH_SHORT).show();
            return true;

        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    protected ArrayList<String> carregaPermissoes(){
        ArrayList<String> permissoes = new ArrayList<String>();

        permissoes.add(Manifest.permission.SEND_SMS);
        permissoes.add(Manifest.permission.INTERNET);
        permissoes.add(Manifest.permission.READ_PHONE_STATE);

        return permissoes;
    }

    private void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults){

        if(Build.VERSION.SDK_INT >= 23 ){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            for(int resultado : grantResults){
                if(resultado == PackageManager.PERMISSION_DENIED){
                    alertaValidacaoPermissao();
                }
            }

        }
    }

    //Exibição do alerta
    private void alertaValidacaoPermissao(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões negadas.");
        builder.setMessage("Para utilizar esse app é necessario aceitar todas as permissões!");

        builder.setPositiveButton("ENCERRAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
