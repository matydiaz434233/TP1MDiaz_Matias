package com.matisoft.ejemplovistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.matisoft.ejemplovistas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mv; // Declaración de la instancia de ViewModel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Crear la instancia del ViewModel
        mv = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MainActivityViewModel.class);

        binding.btTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle enviaPalabra = new Bundle();
                enviaPalabra.putString("keyPalabra", binding.etPalabra.getText().toString());
                Intent intent = new Intent(MainActivity.this , PerfilActivity.class);
                intent.putExtras(enviaPalabra);
                mv.traducir(binding.etPalabra.getText().toString());
                startActivity(intent);
            }
        });
    }
}
