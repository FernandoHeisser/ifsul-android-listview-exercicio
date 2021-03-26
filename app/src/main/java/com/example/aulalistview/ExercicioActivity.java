package com.example.aulalistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

public class ExercicioActivity extends AppCompatActivity {

        private Spinner spinner;
        private EditText editText;
        private ImageButton btnAdd;
        private ListView listView;
        public ArrayAdapter<String> adaptadorListView;
        public ArrayAdapter<String> adaptadorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.lista2);
        editText = findViewById(R.id.editText2);
        btnAdd = findViewById(R.id.imageButton3);

        adaptadorSpinner = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1);
        spinner.setAdapter(adaptadorSpinner);

        adaptadorSpinner.add("Solteiro");
        adaptadorSpinner.add("Casado");
        adaptadorSpinner.add("Namorando");

        adaptadorListView = new MeuAdaptadorPersonalizado(getBaseContext());
        listView.setAdapter(adaptadorListView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editText.getText().toString();
                adaptadorListView.add(nome);
                adaptadorListView.notifyDataSetChanged();
                editText.setText("");
            }
        });
    }
}
