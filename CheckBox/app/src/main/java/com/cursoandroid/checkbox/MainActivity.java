package com.cursoandroid.checkbox;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button btnConfirmar;
    private TextView txtExibicao;

    private CheckBox chkCachorro;
    private CheckBox chkGato;
    private CheckBox chkPapagaio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicia();

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(itensSelecionados() == null){
                    Toast.makeText(getApplicationContext(), "Nenhum animal selecionado.", Toast.LENGTH_SHORT).show();
                } else {
                    txtExibicao.setText(itensSelecionados());
                }
            }
        });

    }

    protected void inicia(){

        btnConfirmar    = (Button) findViewById(R.id.btnConfirmar);
        txtExibicao     = (TextView) findViewById(R.id.txtExibicao);

        chkCachorro     = (CheckBox) findViewById(R.id.chkCachorro);
        chkGato         = (CheckBox) findViewById(R.id.chkGato);
        chkPapagaio     = (CheckBox) findViewById(R.id.chkPapagaio);

    }

    protected String itensSelecionados(){
        String retorno = new String();

        if(chkCachorro.isChecked())
            retorno = retorno + chkCachorro.getText().toString() + "\n";

        if(chkGato.isChecked())
            retorno = retorno + chkGato.getText().toString() + "\n";

        if(chkPapagaio.isChecked())
            retorno = retorno + chkPapagaio.getText().toString() + "\n";

        if(retorno.length() < 1) {
            return null;
        }
        return retorno;
    }
}
