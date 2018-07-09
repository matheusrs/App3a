package com.example.bruno.aplicativo3a.Parceiros.Doacoes.Exibir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.Entity.DoacaoEntity;
import com.example.bruno.aplicativo3a.Parceiros.Doacoes.InserirAlterar.CadastroDoacaoActivity;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.DoacoesController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirDoacaoActivity extends AppCompatActivity {


    @BindView(R.id.btnEditDoacao)
    Button editarDoacao;
    @BindView(R.id.hiddenIdDoacao)
    TextView idDoacao;
    @BindView(R.id.hiddenIdParceiroDoacao)
    TextView idParceiroDoacao;
    @BindView(R.id.valueDescricaoDoacao)
    TextView descricaoDoacao;
    @BindView(R.id.valueDataDoacao)
    TextView dataDoacao;

    int idDoacaoVal;

    public ExibirDoacaoActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onResume() {
        super.onResume();
        DoacoesController banco = new DoacoesController(this);
        DoacaoEntity doacao = banco.carregaDoacao(String.valueOf(idDoacaoVal));
        idDoacao.setText(doacao.getId());
        dataDoacao.setText(doacao.getDataDoacao());
        idParceiroDoacao.setText(doacao.getIdParceiro());
        descricaoDoacao.setText(doacao.getDescricao());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_doacao);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Detalhes da Doação:");

        idDoacaoVal = Integer.parseInt(extras.getString("doacao_id"));

        editarDoacao.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
            Intent editarDoacao = new Intent(getBaseContext(), CadastroDoacaoActivity.class);
            editarDoacao.putExtra("doacao_edit_mode", "true");
            editarDoacao.putExtra("doacao_id", idDoacao.getText());
            startActivity(editarDoacao);
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
