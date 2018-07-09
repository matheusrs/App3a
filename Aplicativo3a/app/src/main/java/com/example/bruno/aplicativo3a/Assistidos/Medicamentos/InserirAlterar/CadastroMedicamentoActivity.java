package com.example.bruno.aplicativo3a.Assistidos.Medicamentos.InserirAlterar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.Mask;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroMedicamentoActivity extends AppCompatActivity implements CadastroMedicamentoView {

    @BindView(R.id.btnAdicionarMedicamento)
    Button salvar;
    @BindView(R.id.btnAtualizarMedicamento)
    Button atualizar;
    @BindView(R.id.hiddenIdMedicamento)
    TextView idMedicamento;
    @BindView(R.id.hiddenIdAssistidoMedicamento)
    TextView idAssistidoMedicamento;
    @BindView(R.id.edTxtNomeMedicamento)
    EditText nomeMedicamento;
    @BindView(R.id.edTxtObservacoesMedicamento)
    EditText observacoesMedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_medicamentos);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        Bundle extras = getIntent().getExtras();
        boolean insert_edit_mode = Boolean.valueOf(extras.getString("medicamento_edit_mode")) ||
                Boolean.valueOf(extras.getString("medicamento_insert_mode"));
        idAssistidoMedicamento.setText(extras.getString("medicamento_id_assistido"));

        if (insert_edit_mode){
            idMedicamento.setText(extras.getString("medicamento_id"));
            idAssistidoMedicamento.setText(extras.getString("medicamento_id_assistido"));
            nomeMedicamento.setText(extras.getString("medicamento_nome"));
            observacoesMedicamento.setText(extras.getString("medicamento_observacoes"));
            atualizar.setVisibility(View.VISIBLE);
            salvar.setVisibility(View.GONE);
            getSupportActionBar().setTitle("Atualizar Medicamento");
        }
        else {
            getSupportActionBar().setTitle("Novo Medicamento");
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastroMedicamentoPresenter presenter = new CadastroMedicamentoPresenter(CadastroMedicamentoActivity.this, getBaseContext());
                presenter.salvarMedicamento(idAssistidoMedicamento.getText().toString(), nomeMedicamento.getText().toString(), observacoesMedicamento.getText().toString());
            }
        });

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastroMedicamentoPresenter presenter = new CadastroMedicamentoPresenter(CadastroMedicamentoActivity.this, getBaseContext());
                presenter.atualizarMedicamento(idMedicamento.getText().toString(), idAssistidoMedicamento.getText().toString(), nomeMedicamento.getText().toString(), observacoesMedicamento.getText().toString());
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
            //configura opção Up Action na ActionBar
            case android.R.id.home:
                finish();
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
