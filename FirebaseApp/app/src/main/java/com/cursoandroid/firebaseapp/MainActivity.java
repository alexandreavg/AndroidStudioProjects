package com.cursoandroid.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cursoandroid.firebaseapp.com.cursoandroid.firebaseapp.domain.Endereco;
import com.cursoandroid.firebaseapp.com.cursoandroid.firebaseapp.domain.Pessoa;
import com.cursoandroid.firebaseapp.com.cursoandroid.firebaseapp.domain.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = databaseDatabase.child("usuarios");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gravarUsuario();

        //Listener das alterações no nó
        usuarioReferencia.addValueEventListener(new ValueEventListener() {
            //Dispara esse metodo sempre que algum dado do nó em escuta é alterado.
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    protected void gravarUsuario(){
        Usuario usuario = new Usuario();
        Endereco endereco = new Endereco();

        endereco.setRua("Rua Lalala da Silva de Lara");
        endereco.setNro("3220");

        usuario.setNome("Francine");
        usuario.setSobreNome("Lins");
        usuario.setSexo("F");
        usuario.setIdade(18);

        usuarioReferencia.child("003").setValue(usuario);
    }
}
