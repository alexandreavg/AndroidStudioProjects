package com.cursoandroid.radiobutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioEscolhido;

    private TextView lblEscolha;
    private Button btnVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicio();

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();

                if(idRadioButtonEscolhido > 0){
                    radioEscolhido = (RadioButton) findViewById(idRadioButtonEscolhido);
                    lblEscolha.setText("Comida escolhida: " + radioEscolhido.getText());
                } else {
                    Toast.makeText(getApplicationContext(),"Nenhuma comida escolhida",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void inicio(){
        lblEscolha = (TextView) findViewById(R.id.lblEscolha);
        btnVerificar = (Button) findViewById(R.id.btnVerificar);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

    }
}
