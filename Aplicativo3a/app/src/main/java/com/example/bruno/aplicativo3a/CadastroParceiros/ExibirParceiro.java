package com.example.bruno.aplicativo3a.CadastroParceiros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirParceiro extends AppCompatActivity {


    @BindView(R.id.btnEditParceiro)
    Button editarParceiro;
    @BindView(R.id.hiddenIdParceiro)
    TextView idParceiro;
    @BindView(R.id.valueNomeParceiro)
    TextView nomeParceiro;
    @BindView(R.id.valueCnpjCpfParceiro)
    TextView cnpjCpfParceiro;
    @BindView(R.id.valueObservacoesParceiro)
    TextView observacoesParceiro;
    @BindView(R.id.valueDataVinculoParceiro)
    TextView dataVinculoParceiro;
    @BindView(R.id.valueTelefoneParceiro)
    TextView telefoneParceiro;

    public ExibirParceiro() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_parceiro);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Detalhes do Parceiro");

        idParceiro.setText(extras.getString("parceiro_id"));
        cnpjCpfParceiro.setText(extras.getString("parceiro_cnpjcpf"));
        nomeParceiro.setText(extras.getString("parceiro_nome"));
        telefoneParceiro.setText(extras.getString("parceiro_telefone"));
        dataVinculoParceiro.setText(extras.getString("parceiro_datavinculo"));
        observacoesParceiro.setText(extras.getString("parceiro_observacoes"));

        editarParceiro.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent editarParceiro = new Intent(getBaseContext(), CadastroParceiros.class);
                      editarParceiro.putExtra("parceiro_edit_mode", "true");
                      editarParceiro.putExtra("parceiro_id", idParceiro.getText());
                      editarParceiro.putExtra("parceiro_cnpjcpf", cnpjCpfParceiro.getText());
                      editarParceiro.putExtra("parceiro_nome", nomeParceiro.getText());
                      editarParceiro.putExtra("parceiro_telefone", telefoneParceiro.getText());
                      editarParceiro.putExtra("parceiro_datavinculo", dataVinculoParceiro.getText());
                      editarParceiro.putExtra("parceiro_observacoes", observacoesParceiro.getText());
                      startActivity(editarParceiro);
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
