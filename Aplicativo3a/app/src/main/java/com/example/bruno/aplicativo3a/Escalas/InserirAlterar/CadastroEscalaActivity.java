package com.example.bruno.aplicativo3a.Escalas.InserirAlterar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroEscalaActivity extends AppCompatActivity implements CadastroEscalaView {

    @BindView(R.id.spinnerDia)
    Spinner dia;
    @BindView(R.id.spinnerTurno)
    Spinner turno;
    @BindView(R.id.btnSalvarEscala)
    Button btnAdd;
    @BindView(R.id.edTxtNomeFuncionario)
    EditText nomeFunc;
    @BindView(R.id.edTxtEspecialidade)
    EditText espec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_escala);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Adicionar na escala");

        ArrayAdapter<String> adapterDia = new ArrayAdapter<String>(CadastroEscalaActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.dias));
        adapterDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dia.setAdapter(adapterDia);
        ArrayAdapter<String> adapterTurno = new ArrayAdapter<>(CadastroEscalaActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.turnos));
        adapterTurno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        turno.setAdapter(adapterTurno);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CadastroEscalaPresenter presenter = new CadastroEscalaPresenter(CadastroEscalaActivity.this,getBaseContext());
                presenter.insereFuncionario(dia.getSelectedItem().toString(),turno.getSelectedItem().toString(),nomeFunc.getText().toString(),espec.getText().toString());

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void exibeMensagem(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        finish();
    }
}
