package com.example.andrea.listautenti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class ListViewActivity extends AppCompatActivity {

    static  final int ADD_NEW_ELEMENT_REQUEST = 1;

    ArrayList<User> utenti = new ArrayList<>();



    /*
     * On create
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);



        //creo e popolo Arraylist
        User user1 = new User(1, "Andrea Girò", "6702 Claro");
        User user2 = new User(2, "Carina Dionisio", "6900 Lugano");

        utenti.add(user1);
        utenti.add(user2);

        faiRefresh();

        /* Longclick listener */
        ListView listView = (ListView) findViewById(R.id.users_list);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Rimosso utente " + position,
                        Toast.LENGTH_SHORT).show();
                utenti.remove(position);
                faiRefresh();

                return false;
            }
        });

    }

    /*
     * Creo il refresh
     */
    public void faiRefresh() {
        ListView listView = (ListView) findViewById(R.id.users_list);
        TextView textView_vuoto = (TextView) findViewById(R.id.label_lista_vuota);
        String[] users_names_list = new String[utenti.size()];
        String[] users_names_adresses = new String[utenti.size()];

        if (utenti.size() == 0) {
            textView_vuoto.setText("La lista è vuota.");
        } else {
            textView_vuoto.setText("");
            for (int i = 0; i < utenti.size(); i++) {
                users_names_list[i] = utenti.get(i).getNome();
                users_names_adresses[i] = utenti.get(i).getIndirizzo();
            }
        }

        /* Collego adapter */
        UsersListarrayAdapter adapter = new UsersListarrayAdapter(this, users_names_list, users_names_adresses);
        listView.setAdapter(adapter);
    }


    /*
     * Creo menu opzioni
     */
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuItem add = menu.add(Menu.NONE, 1, Menu.NONE, "Add");
        MenuItem refresh = menu.add(Menu.NONE, 2, Menu.NONE, "Refresh");
        MenuItem Undo = menu.add(Menu.NONE, 3, Menu.NONE, "Undo");

        return true;
    }

    /*
     * Handler menu opzioni
     */
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent().setClass(this, InfoFormActivity.class);
                startActivityForResult(intent, ADD_NEW_ELEMENT_REQUEST);
                return true;
            case 2:
                Toast.makeText(getApplicationContext(),
                        "Refresh: non implementato",
                        Toast.LENGTH_LONG).show();
                return true;
            case 3:
                Toast.makeText(getApplicationContext(),
                        "Undo: non implementato",
                        Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
     * Metodo con activity fired
     */



    protected void onActivityResult (int requestCode, int resultCode, Intent data) {

        if(requestCode == ADD_NEW_ELEMENT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String new_element = data.getStringExtra("new_element");
                String nome = data.getStringExtra("nome");
                String indirizzo = data.getStringExtra("indirizzo");
                if(!TextUtils.isEmpty(nome) && !TextUtils.isEmpty(indirizzo)) {
                    utenti.add(new User(utenti.size() + 1, nome, indirizzo));
                    Toast.makeText(getApplicationContext(),
                            nome + " aggiunto.",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        faiRefresh();

    }
}
