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

    @BindView(R.id.btnEditAssistido)
    Button editarAssistido;
    @BindView(R.id.hiddenIdAssistido)
    TextView idAssistido;
    @BindView(R.id.hiddenStatusAssistido)
    TextView statusAssistido;
    @BindView(R.id.valueCPFAssistido)
    TextView cpfAssistido;
    @BindView(R.id.valueNomeAssistido)
    TextView nomeAssistido;
    @BindView(R.id.valueDeficienciaAssistido)
    TextView deficienciaAssistido;
    @BindView(R.id.valueObservacoesAssistido)
    TextView observacoesAssistido;
    @BindView(R.id.valueSobrenomeAssistido)
    TextView sobrenomeAssistido;
    @BindView(R.id.valueTelefoneAssistido)
    TextView telefoneAssistido;
    @BindView(R.id.valueDataNascimentoAssistido)
    TextView datanascimentoAssistido;
    @BindView(R.id.labelStatusAtivo)
    TextView labelStatusAssistido;


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

        idAssistido.setText(extras.getString("assistido_id"));
        statusAssistido.setText(extras.getString("assistido_statusativo"));
        cpfAssistido.setText(extras.getString("assistido_cpf"));
        nomeAssistido.setText(extras.getString("assistido_nome"));
        sobrenomeAssistido.setText(extras.getString("assistido_sobrenome"));
        telefoneAssistido.setText(extras.getString("assistido_telefone"));
        datanascimentoAssistido.setText(extras.getString("assistido_datanascimento"));
        deficienciaAssistido.setText(extras.getString("assistido_deficiencia"));
        observacoesAssistido.setText(extras.getString("assistido_observacoes"));
        if (Boolean.valueOf(extras.getString("assistido_statusativo")))
            labelStatusAssistido.setText("Cadastro Ativo");
        else
            labelStatusAssistido.setText("CAdastro Inativo");

        editarAssistido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editarAssistido = new Intent(getBaseContext(), CadastroAssistidos.class);
                    editarAssistido.putExtra("assistido_edit_mode", "true");
                    editarAssistido.putExtra("assistido_id", idAssistido.getText());
                    editarAssistido.putExtra("assistido_cpf", cpfAssistido.getText());
                    editarAssistido.putExtra("assistido_nome", nomeAssistido.getText());
                    editarAssistido.putExtra("assistido_sobrenome", sobrenomeAssistido.getText());
                    editarAssistido.putExtra("assistido_telefone", telefoneAssistido.getText());
                    editarAssistido.putExtra("assistido_datanascimento", datanascimentoAssistido.getText());
                    editarAssistido.putExtra("assistido_deficiencia", deficienciaAssistido.getText());
                    editarAssistido.putExtra("assistido_observacoes", observacoesAssistido.getText());
                    editarAssistido.putExtra("assistido_statusativo", statusAssistido.getText());
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
