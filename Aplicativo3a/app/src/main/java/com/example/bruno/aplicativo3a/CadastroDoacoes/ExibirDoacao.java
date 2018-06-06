package com.example.bruno.aplicativo3a.CadastroDoacoes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.CadastroParceiros.CadastroParceiros;
import com.example.bruno.aplicativo3a.CadastroParceiros.ExibirParceiroAdapter;
import com.example.bruno.aplicativo3a.CadastroParceiros.OnRecyclerViewSelected;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.entitiy.DoacaoEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirDoacao extends AppCompatActivity {


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

    public ExibirDoacao() {
        // Required empty public constructor
    }

    @Override
    protected void onStart(){
        super.onStart();
        Bundle extras = getIntent().getExtras();
        if(extras.getString("doacao_id") != null) {
            Log.i("id", extras.getString("doacao_id"));
        }
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

        idDoacao.setText(extras.getString("doacao_id"));
        dataDoacao.setText(extras.getString("doacao_data"));;
        idParceiroDoacao.setText(extras.getString("doacao_id_parceiro"));;
        descricaoDoacao.setText(extras.getString("doacao_descricao"));

        editarDoacao.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
            Intent editarDoacao = new Intent(getBaseContext(), CadastroDoacoes.class);
            editarDoacao.putExtra("doacao_edit_mode", "true");
            editarDoacao.putExtra("doacao_id", idDoacao.getText());
            editarDoacao.putExtra("doacao_id_parceiro",idParceiroDoacao.getText());
            editarDoacao.putExtra("doacao_descricao",descricaoDoacao.getText());
            editarDoacao.putExtra("doacao_data", dataDoacao.getText());
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
