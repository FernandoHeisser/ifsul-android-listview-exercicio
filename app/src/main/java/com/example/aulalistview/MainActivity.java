package com.example.aulalistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirTelaSimples(View t){
        Intent it = new Intent(getBaseContext(), ListViewSimpleActivity.class);
        startActivity(it);
    }

    public void abrirTelaPersonalizada(View t){
        Intent it = new Intent(getBaseContext(), ListViewPersonalizadaActivity.class);
        startActivity(it);
    }

    public void abrirTelaExercicio(View t){
        Intent it = new Intent(getBaseContext(), ExercicioActivity.class);
        startActivity(it);
    }
}
