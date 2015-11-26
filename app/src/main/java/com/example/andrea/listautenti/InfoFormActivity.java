package com.example.andrea.listautenti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InfoFormActivity extends AppCompatActivity {

    private Button button_salva;
    private Button button_cancella;
    private Button button_esci;

    private EditText textEdit_nome;
    private EditText textEdit_indirizzo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_form);

        textEdit_nome = (EditText) findViewById(R.id.edit_nome);
        textEdit_indirizzo = (EditText) findViewById(R.id.edit_indirizzo);

        /* Button cancella */
        button_cancella = (Button) findViewById(R.id.button_cancella);
        button_cancella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textEdit_nome.setText("");
                textEdit_indirizzo.setText("");
            }
        });

        /* Button esci */
        button_esci = (Button) findViewById(R.id.button_esci);
        button_esci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("new element", "no");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        /* Button salva */
        button_salva = (Button) findViewById(R.id.button_salva);
        button_salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // alert if empty
                if(TextUtils.isEmpty(textEdit_nome.getText().toString())) {
                    textEdit_nome.setError("Il campo non può essere vuoto");
                }
                if(TextUtils.isEmpty(textEdit_indirizzo.getText().toString())) {
                    textEdit_indirizzo.setError("Il campo non può essere vuoto");
                }

                //scrivi se compilati
                if (!TextUtils.isEmpty(textEdit_nome.getText().toString()) &&
                        !TextUtils.isEmpty(textEdit_indirizzo.getText().toString())) {
                    Intent intent = new Intent();
                    intent.putExtra("nome", textEdit_nome.getText().toString());
                    intent.putExtra("indirizzo", textEdit_indirizzo.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });
    }
}
