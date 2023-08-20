package com.matisoft.ejemplovistas;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

import com.matisoft.ejemplovistas.modelo.Palabra;

public class PerfilActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Palabra> palabraM;

    public PerfilActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<Palabra> getPalabraM() {
        if (palabraM == null) {
            palabraM = new MutableLiveData<>();
        }
        return palabraM;
    }

    public void traducirePalabra(String palabra) {
        Map<String, TraduccionInfo> traduccionesMap = new HashMap<>();
        traduccionesMap.put("gato", new TraduccionInfo("cat", R.drawable.gato));
        traduccionesMap.put("perro", new TraduccionInfo("dog", R.drawable.perro));
        traduccionesMap.put("rojo", new TraduccionInfo("red", R.drawable.rojo));
        traduccionesMap.put("azul", new TraduccionInfo("blue", R.drawable.azul));
        traduccionesMap.put("mesa", new TraduccionInfo("table", R.drawable.mesa));
        traduccionesMap.put("casa", new TraduccionInfo("house", R.drawable.casa));



        TraduccionInfo traduccionInfo = traduccionesMap.get(palabra);

        if (traduccionInfo != null) {
            Palabra palabraFinal = new Palabra(palabra, traduccionInfo.getPalabraTraducida(), traduccionInfo.getImagenId());
            palabraM.setValue(palabraFinal);
        } else {
            Toast.makeText(context, "Palabra no encontrada o incorrecta", Toast.LENGTH_LONG).show();
        }
    }

    private static class TraduccionInfo {
        private String palabraTraducida;
        private int imagenId;

        public TraduccionInfo(String palabraTraducida, int imagenId) {
            this.palabraTraducida = palabraTraducida;
            this.imagenId = imagenId;
        }

        public String getPalabraTraducida() {
            return palabraTraducida;
        }

        public int getImagenId() {
            return imagenId;
        }
    }
}

