package com.cursoandroid.whatsapp.helper;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

public class Permissao {

    public static boolean validaPermissoes(int requestCode, Activity activity, ArrayList<String> permissoes){

        if(Build.VERSION.SDK_INT >= 23 ){

            ArrayList<String> listaPermisssoes = new ArrayList<String>();

            //Percorre as permissoes e checa se estao liberadas
            for(String permissao : permissoes){
                Boolean validaPermissao = ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_GRANTED;
                if(validaPermissao == false) listaPermisssoes.add(permissao);
            }

            //Caso lista vazia nao é necessario solicitar permissao
            if(listaPermisssoes.isEmpty()){
                return true;
            }

            String[] novasPermissoes = new String[listaPermisssoes.size()];
            listaPermisssoes.toArray(novasPermissoes);

            //Solicita permissao
            ActivityCompat.requestPermissions(activity, novasPermissoes, requestCode);

        }

        return true;
    }

}
