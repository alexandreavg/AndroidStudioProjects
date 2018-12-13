package com.cursoandroid.atmempresaconsultoria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView imgMenuEmpresa;
    private ImageView imgMenuServico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgMenuEmpresa = (ImageView) findViewById(R.id.imgMenuEmpresa);
        imgMenuServico = (ImageView) findViewById(R.id.imgMenuServico);

        imgMenuEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EmpresaActivity.class));
            }
        });

        imgMenuServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ServicoActivity.class));
            }
        });
    }
}
