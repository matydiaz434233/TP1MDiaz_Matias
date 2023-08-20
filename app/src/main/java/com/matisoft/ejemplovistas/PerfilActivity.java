package com.matisoft.ejemplovistas;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.matisoft.ejemplovistas.databinding.ActivityMainBinding;
import com.matisoft.ejemplovistas.databinding.ActivityPerfilBinding;
import com.matisoft.ejemplovistas.modelo.Palabra;

public class PerfilActivity extends AppCompatActivity {
    private PerfilActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPerfilBinding binding=ActivityPerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle reciboPalabra = getIntent().getExtras();
        String palabrita = reciboPalabra.getString("keyPalabra");
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(PerfilActivityViewModel.class);
        mv.getPalabraM().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
                binding.tvPalabra.setText(palabra.getPalabra());
                binding.tvTraduccion.setText(palabra.getTraduccion());
                binding.imageView.setImageResource(palabra.getFoto());
            }
        });

        /*aca tengo que traer la palabra a la funcion , que esta en mi activity_main.xml
          el id es etPalabra y me andaria genial !!!
         hice prueba utilizando un Bundle , y pude
         hacer que me funcionara pero estoy seguro que hay maneras mas sencillas*/
        mv.traducirePalabra(palabrita);


    }
}


