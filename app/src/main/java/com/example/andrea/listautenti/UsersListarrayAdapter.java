package com.example.andrea.listautenti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by andrea on 25.11.15.
 */
public class UsersListarrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final String[] adresses;

    public UsersListarrayAdapter(Context context,  String[] values, String[] adresses) {
        super(context,R.layout.list_element, values);
        this.context = context;
        this.values = values;
        this.adresses = adresses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_element, parent, false);

        TextView textview_nome = (TextView) rowView.findViewById(R.id.textView_nome);
        TextView textview_indirizzo = (TextView) rowView.findViewById(R.id.textView_indirizzo);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);

        textview_nome.setText(values[position]);
        textview_indirizzo.setText(adresses[position]);
        imageView.setImageResource(R.mipmap.ic_launcher);

        return rowView;
    }
}
