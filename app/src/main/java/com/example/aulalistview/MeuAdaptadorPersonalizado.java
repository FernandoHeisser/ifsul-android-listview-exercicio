package com.example.aulalistview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class MeuAdaptadorPersonalizado extends ArrayAdapter<String> {

    public MeuAdaptadorPersonalizado(Context contexto){
        super(contexto, R.layout.modelo_de_linha_listview);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //criar a linha
        View linha = LayoutInflater.from(getContext()).inflate(R.layout.modelo_de_linha_listview, parent, false);
        //pega o dado correspondente da linha
        String dado = getItem(position);
        //vincula componentes com objetos view
        TextView texto = linha.findViewById(R.id.textView);
        ImageButton btnDelete = linha.findViewById(R.id.imageButton2);
        //exibe dado
        texto.setText(dado);
        //evento do botão
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //remove
                remove(getItem(position));
                //notifica tela
                notifyDataSetChanged();
            }
        });
        // retorna linha
        return linha;
    }
}
