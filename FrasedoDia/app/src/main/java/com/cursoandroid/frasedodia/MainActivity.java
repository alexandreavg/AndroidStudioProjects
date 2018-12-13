package com.cursoandroid.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textoNovaFrase;
    private Button btnNovaFrase;
    private List<String> frases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNovaFrase  = (TextView) findViewById(R.id.txtFrase);
        btnNovaFrase    = (Button) findViewById(R.id.btnFraseDoDia);

        frases = carregaFrases();

        btnNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            textoNovaFrase.setText(retornaFrase());
            }
        });
    }

    protected String retornaFrase(){
        String retorno = new String();
        Random random = new Random();
        Integer tamanho;

        tamanho = frases.size() - 1;

        retorno = frases.get(random.nextInt(tamanho -1));

        return retorno;
    }

    protected List<String> carregaFrases(){

        List<String> retorno = new ArrayList<String>();

        retorno.add("Nem a pau juvenal!");
        retorno.add("Agua mole e pedra dura tanto bate ate que fura.");
        retorno.add("Quem com o ferro fere com o ferro sera ferido.");
        retorno.add("Olha essa parada funcionando.");
        retorno.add("A lalalalaalalla fiquei sem ideia...");

        return retorno;
    }
}
