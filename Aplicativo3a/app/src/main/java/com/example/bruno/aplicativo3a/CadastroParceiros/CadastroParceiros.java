package com.example.bruno.aplicativo3a.CadastroParceiros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.Main.MainActivity;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.ParceirosController;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;


public class CadastroParceiros extends AppCompatActivity {

    @BindView(R.id.btnSalvarParceiro)
    Button salvarParceiro;
    @BindView(R.id.btnAtualizarParceiro)
    Button atualizarParceiro;
    @BindView(R.id.hiddenIdParceiro)
    TextView idParceiro;
    @BindView(R.id.edTxtCnpjCpfParceiro)
    EditText cnpjCpfParceiro;
    @BindView(R.id.edTxtNomeParceiro)
    EditText nomeParceiro;
    @BindView(R.id.edTxtTelefoneParceiro)
    EditText telefoneParceiro;
    @BindView(R.id.edTxtDataVinculoParceiro)
    EditText datavinculoParceiro;
    @BindView(R.id.edTxtObservacoesParceiro)
    EditText observacoesParceiro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_parceiros);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        Bundle extras = getIntent().getExtras();
        boolean edit_mode = Boolean.valueOf(extras.getString("parceiro_edit_mode"));

        if (edit_mode){
            idParceiro.setText(extras.getString("parceiro_id"));
            cnpjCpfParceiro.setText(extras.getString("parceiro_cnpjcpf"));
            nomeParceiro.setText(extras.getString("parceiro_nome"));
            telefoneParceiro.setText(extras.getString("parceiro_telefone"));
            datavinculoParceiro.setText(extras.getString("parceiro_datavinculo"));
            observacoesParceiro.setText(extras.getString("parceiro_observacoes"));
            getSupportActionBar().setTitle("Atualizar Parceiro");
            atualizarParceiro.setVisibility(View.VISIBLE);
            salvarParceiro.setVisibility(View.GONE);
        }
        else {
            getSupportActionBar().setTitle("Novo Parceiro");
        }

        salvarParceiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;
                ParceirosController banco = new ParceirosController(getBaseContext());
                if (banco.insereParceiro(cnpjCpfParceiro.getText().toString() , nomeParceiro.getText().toString(), telefoneParceiro.getText().toString(), datavinculoParceiro.getText().toString(), observacoesParceiro.getText().toString()))
                    message = "Parceiro cadastrado!";
                else
                    message = "Erro ao gravar parceiro";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                finish();
            }
        });

        atualizarParceiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;
                ParceirosController banco = new ParceirosController(getBaseContext());
                if (banco.atualizaParceiro(idParceiro.getText().toString(),cnpjCpfParceiro.getText().toString() , nomeParceiro.getText().toString(), telefoneParceiro.getText().toString(), datavinculoParceiro.getText().toString(), observacoesParceiro.getText().toString()))
                    message = "Parceiro atualizado!";
                else
                    message = "Erro ao atualizar parceiro";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                finish();
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
}
