package com.cursoandroid.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button btnAbrir;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbrir = (Button) findViewById(R.id.btnAbrir);

        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Criacao do dialogo
                dialog = new AlertDialog.Builder(MainActivity.this);

                //Titulo do dialogo
                dialog.setTitle("CONFIRMAÇÃO");

                //Menssagem
                dialog.setMessage("Voçê tem certeza disso?");

                //O dialogo so pode ser fechado pelos botçoes disponiveis.
                dialog.setCancelable(false);

                //Icone
                dialog.setIcon(android.R.drawable.ic_delete);

                //Botao negativo
                dialog.setNegativeButton("Nah!, Não queria mesmo.",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"Quase fez cagada ein...", Toast.LENGTH_SHORT).show();
                            }
                        });

                //Botao positivo
                dialog.setPositiveButton("Manda vê!.",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"Todos os registros deletados com sucesso.", Toast.LENGTH_SHORT).show();
                            }
                        });

                dialog.create();

                dialog.show();

            }
        });
    }
}
