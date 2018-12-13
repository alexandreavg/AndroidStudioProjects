package com.cursoandroid.tudolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cursoandroid.tudolist.domain.Tarefa;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private EditText txtTarefa;
    private Button btnSalvar;
    private ListView listView;
    private SQLiteDatabase bancoDados;
    private ArrayAdapter<Tarefa> arrayAdapter;
    private ArrayList<Tarefa> tarefas;
    private Tarefa tarefa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
        listar();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txtTarefa.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Digite a tarefa antes de salvar.",Toast.LENGTH_SHORT);
                    return;
                } else {
                    salvar();
                    txtTarefa.setText("");
                    listar();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                excluir(tarefas.get(i));
                listar();
            }
        });

    }

    protected void iniciar(){

        txtTarefa = (EditText) findViewById(R.id.txtTarefa);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        listView = (ListView) findViewById(R.id.listView);
        tarefa = new Tarefa();
        tarefas = new ArrayList<Tarefa>();
        criarBD();

    }

    protected void criarBD(){

        try {
            //Cria BD
            bancoDados = openOrCreateDatabase("apptarefas",MODE_PRIVATE, null);

            //Cria tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas (id  INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),"Erro ao criar/conectar ao BD",Toast.LENGTH_SHORT).show();
            System.out.println("Erro ao inicializar ao criar BANCO");
            e.printStackTrace();
        }

    }

    protected void salvar(){

        String textoDigitado = txtTarefa.getText().toString();

        try{
            bancoDados.execSQL("INSERT INTO tarefas (tarefa) VALUES('" + textoDigitado + "')");
            Toast.makeText(getApplicationContext(), "Salvo com sucesso.", Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro ao inserir", Toast.LENGTH_SHORT).show();
            System.out.println("Erro ao insirir no BANCO");
            e.printStackTrace();
        }
    }

    protected void listar(){

        try {

            Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC",null);
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");
            tarefas = new ArrayList<Tarefa>();

            arrayAdapter = new ArrayAdapter<Tarefa>(getApplicationContext(),
                                                    android.R.layout.simple_list_item_1,
                                                    android.R.id.text1,
                                                    tarefas);

            listView.setAdapter(arrayAdapter);

            //Move o cursor para o primeiro registro retornado da query
            cursor.moveToFirst();

            Integer i = 0;


            while(i < cursor.getCount()){

                Log.i("Resultado - ", "Tarefa: " + cursor.getString(indiceColunaTarefa));

                tarefa = new Tarefa();

                tarefa.setId(cursor.getInt(indiceColunaId));
                tarefa.setTarefa(cursor.getString(indiceColunaTarefa));

                tarefas.add(tarefa);
                cursor.moveToNext();
                i++;

            }

        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "Erro ao listar", Toast.LENGTH_SHORT).show();
            System.out.println("Erro ao listar");
            e.printStackTrace();
        }

    }

    private void excluir(Tarefa tarefa){

        try {

            bancoDados.execSQL("DELETE FROM tarefas WHERE id = " + tarefa.getId());
            Toast.makeText(getApplicationContext(), "Excluido com sucesso.", Toast.LENGTH_SHORT).show();

        } catch (Exception e){

            Toast.makeText(getApplicationContext(), "Erro ao excluir", Toast.LENGTH_SHORT).show();
            System.out.println("Erro ao listar");
            e.printStackTrace();
        }

    }
}
