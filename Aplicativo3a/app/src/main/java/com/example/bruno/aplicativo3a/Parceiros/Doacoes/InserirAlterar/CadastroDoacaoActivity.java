package com.example.bruno.aplicativo3a.Parceiros.Doacoes.InserirAlterar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.Entity.DoacaoEntity;
import com.example.bruno.aplicativo3a.Mask;
import com.example.bruno.aplicativo3a.Parceiros.Exibir.ExibirParceiroActivity;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroDoacaoActivity extends AppCompatActivity implements CadastroDoacaoView {

    @BindView(R.id.btnSalvarDoacao)
    Button salvar;
    @BindView(R.id.btnAtualizarDoacao)
    Button atualizar;
    @BindView(R.id.hiddenIdDoacao)
    TextView idDoacao;
    @BindView(R.id.hiddenIdParceiroDoacao)
    TextView idParceiroDoacao;
    @BindView(R.id.edTxtDescricaoDoacao)
    EditText descricaoDoacao;
    @BindView(R.id.edTxtDataDoacao)
    EditText dataDoacao;

    CadastroDoacaoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_doacoes);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        Bundle extras = getIntent().getExtras();
        boolean insert_edit_mode = Boolean.valueOf(extras.getString("doacao_edit_mode")) ||
                Boolean.valueOf(extras.getString("doacao_insert_mode"));
        presenter = new CadastroDoacaoPresenter(this, this);
        idParceiroDoacao.setText(extras.getString("doacao_id_parceiro"));

        dataDoacao.addTextChangedListener(Mask.insert(Mask.DATA_MASK,dataDoacao));

        if (insert_edit_mode){
            DoacaoEntity doacao = presenter.carregaDoacao(extras.getString("doacao_id"));
            idDoacao.setText(doacao.getId());
            dataDoacao.setText(doacao.getDataDoacao());
            descricaoDoacao.setText(doacao.getDescricao());
            idParceiroDoacao.setText(doacao.getIdParceiro());
            salvar.setVisibility(View.GONE);
            getSupportActionBar().setTitle("Atualizar Doação");
        } else {
            atualizar.setVisibility(View.GONE);
            getSupportActionBar().setTitle("Nova Doação");
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastroDoacaoPresenter presenter = new CadastroDoacaoPresenter(CadastroDoacaoActivity.this, getBaseContext());
                presenter.salvarDoacao(idParceiroDoacao.getText().toString(), dataDoacao.getText().toString(), descricaoDoacao.getText().toString());
            }
        });

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastroDoacaoPresenter presenter = new CadastroDoacaoPresenter(CadastroDoacaoActivity.this, getBaseContext());
                presenter.atualizarDoacao(idDoacao.getText().toString(), idParceiroDoacao.getText().toString(), dataDoacao.getText().toString(), descricaoDoacao.getText().toString());
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
    public void exibeMensagem(String idParceiroDoacao, String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        finish();
    }
}
