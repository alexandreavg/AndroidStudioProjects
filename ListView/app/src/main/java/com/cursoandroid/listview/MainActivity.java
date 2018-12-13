package com.cursoandroid.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;
    private List<String> itens = new ArrayList<String>();
    private String[] listagem;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);

        itens = carregar();
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Item selecionado. " + itens.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected List<String> carregar(){
        itens.add("Abacaxi");
        itens.add("Hortela");
        itens.add("Acerola");
        itens.add("Limao");
        itens.add("Morango");
        itens.add("Banana");
        itens.add("Mamao");

        return itens;

    }
}
