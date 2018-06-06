package com.example.bruno.aplicativo3a.CadastroDoacoes;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.CadastroParceiros.ExibirParceiro;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.DoacoesController;
import com.example.bruno.aplicativo3a.banco.ParceirosController;
import com.example.bruno.aplicativo3a.entitiy.ParceiroEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroDoacoes extends AppCompatActivity {

    @BindView(R.id.btnAdicionarDoacao)
    Button salvar;
    @BindView(R.id.btnAtualizarDoacao)
    Button atualizar;
    @BindView(R.id.hiddenIdDoacao)
    TextView idDoacao;
    @BindView(R.id.hiddenIdParceiroDoacao)
    TextView idParceiroDoacao;
    @BindView(R.id.edTxtDescricaoDoacao)
    TextView descricaoDoacao;
    @BindView(R.id.edTxtDataDoacao)
    TextView dataDoacao;

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
        idParceiroDoacao.setText(extras.getString("doacao_id_parceiro"));
        if (insert_edit_mode){
            idDoacao.setText(extras.getString("doacao_id"));
            dataDoacao.setText(extras.getString("doacao_data"));
            descricaoDoacao.setText(extras.getString("doacao_descricao"));

            atualizar.setVisibility(View.VISIBLE);
            salvar.setVisibility(View.GONE);
            getSupportActionBar().setTitle("Atualizar Doação");
        }
        else {
            getSupportActionBar().setTitle("Nova Doação");
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;
                DoacoesController banco = new DoacoesController(getBaseContext());
                if (banco.insereDoacao(idParceiroDoacao.getText().toString(), dataDoacao.getText().toString(), descricaoDoacao.getText().toString()))
                    message = "Doação adicionada!";
                else
                    message = "Erro ao gravar doação";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                finish();
            }
        });

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;
                DoacoesController banco = new DoacoesController(getBaseContext());
                if (banco.atualizaDoacao(idDoacao.getText().toString(), idParceiroDoacao.getText().toString(), dataDoacao.getText().toString(), descricaoDoacao.getText().toString()))
                    message = "Doação atualizada!";
                else
                    message = "Erro ao atualizar doação";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                Intent exibirParceiro = new Intent(getBaseContext(), ExibirParceiro.class);
                exibirParceiro.putExtra("parceiro_id", idParceiroDoacao.getText().toString());
                startActivity(exibirParceiro);
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
}
