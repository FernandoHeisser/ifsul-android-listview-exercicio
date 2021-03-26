package com.example.aulalistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewSimpleActivity extends AppCompatActivity {

    //Declarar objetos para interagir com a tela
    private ListView listView;
    private EditText editText;
    private ImageButton btnAdd;
    //Declarar adaptador
    public ArrayAdapter<String> adaptadorListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_simple);

        //Vincular componentes com Views da tela
        listView = findViewById(R.id.lista);
        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.imageButton);

        //Instanciar adaptador
        adaptadorListView = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adaptadorListView);

        //Declarar evento para adicionar o que foi escrito na lista
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pega o dado
                String dado = editText.getText().toString();
                //Adiciona no adaptador
                adaptadorListView.add(dado);
                //Notifica para tela que os dados mudaram
                adaptadorListView.notifyDataSetChanged();
            }
        });

        //Implementar eventos de click no listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //retorna o item clicado
                String dado = adaptadorListView.getItem(i);
                //exibe
                Toast.makeText(getBaseContext(), "Item: "+dado, Toast.LENGTH_SHORT).show();
            }
        });

        //Implementar eventos de long click no listview
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //remove itam na posição clicada
                adaptadorListView.remove(adaptadorListView.getItem(i));
                //avisa na tela
                adaptadorListView.notifyDataSetChanged();

                return false;
            }
        });
    }
}
