package com.matisoft.ejemplovistas;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.matisoft.ejemplovistas.modelo.Palabra;

public class MainActivityViewModel extends AndroidViewModel {
private Context context;

    public MainActivityViewModel(@NonNull Application application){
        super(application);
        context= getApplication().getApplicationContext();
    }

    //compruebo si la palabra ingresada esta en el diccionario
        public void traducir(String palabra) {
            Intent intent = new Intent(context, PerfilActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            boolean palabraValida = false;

            switch (palabra) {
                case "gato":
                case "perro":
                case "mesa":
                case "azul":
                case "rojo":
                case "casa":
                    palabraValida = true;
                    break;
            }

            if (palabraValida) {
                context.startActivity(intent);
            } else {
                Toast.makeText(context, "Palabra no encontrada o incorrecta", Toast.LENGTH_LONG).show();
            }
        }


}
