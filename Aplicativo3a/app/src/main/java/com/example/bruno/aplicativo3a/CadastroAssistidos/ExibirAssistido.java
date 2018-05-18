package com.example.bruno.aplicativo3a.CadastroAssistidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirAssistido extends AppCompatActivity {

    @BindView(R.id.btnEdit)
    Button editar;
    @BindView(R.id.hiddenId)
    TextView id;
    @BindView(R.id.valueNome)
    TextView nome;
    @BindView(R.id.valueDeficiencia)
    TextView deficiencia;
    @BindView(R.id.valueObservacoes)
    TextView observacoes;
    @BindView(R.id.valueSobrenome)
    TextView sobrenome;
    @BindView(R.id.valueTelefone)
    TextView telefone;
    @BindView(R.id.valueDataNascimento)
    TextView datanascimento;

    public ExibirAssistido() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_assistido);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Detalhes do Assistido");

        id.setText(extras.getString("assistido_id"));
        nome.setText(extras.getString("assistido_nome"));
        sobrenome.setText(extras.getString("assistido_sobrenome"));
        telefone.setText(extras.getString("assistido_telefone"));
        datanascimento.setText(extras.getString("assistido_datanascimento"));
        deficiencia.setText(extras.getString("assistido_deficiencia"));
        observacoes.setText(extras.getString("assistido_observacoes"));

        editar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editarAssistido = new Intent(getBaseContext(), CadastroAssistidos.class);
                    editarAssistido.putExtra("edit_mode", true);
                    editarAssistido.putExtra("assistido_id", id.getText());
                    editarAssistido.putExtra("assistido_nome", nome.getText());
                    editarAssistido.putExtra("assistido_sobrenome", sobrenome.getText());
                    editarAssistido.putExtra("assistido_telefone", telefone.getText());
                    editarAssistido.putExtra("assistido_datanascimento", datanascimento.getText());
                    editarAssistido.putExtra("assistido_deficiencia", deficiencia.getText());
                    editarAssistido.putExtra("assistido_observacoes", observacoes.getText());
                    startActivity(editarAssistido);
                }
            }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            //configura opção Up Action na ActionBar
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
