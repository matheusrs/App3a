package com.example.bruno.aplicativo3a.Parceiros.Exibir;

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

import com.example.bruno.aplicativo3a.Parceiros.Doacoes.Exibir.ExibirDoacaoActivity;
import com.example.bruno.aplicativo3a.Parceiros.Doacoes.InserirAlterar.CadastroDoacaoActivity;
import com.example.bruno.aplicativo3a.Parceiros.InserirAlterar.CadastroParceiroActivity;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.Entity.DoacaoEntity;
import com.example.bruno.aplicativo3a.Entity.ParceiroEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirParceiroActivity extends AppCompatActivity implements ExibirParceiroView {


    @BindView(R.id.btnEditParceiro)
    Button editarParceiro;
    @BindView(R.id.btnAddDoacao)
    Button registrarDoacao;
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

    @BindView(R.id.recycler_view_doacoes)
    RecyclerView recyclerView;

    ExibirParceiroPresenter presenter;


    public ExibirParceiroActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onStart(){
        super.onStart();
        Bundle extras = getIntent().getExtras();
        if(extras.getString("parceiro_id") != null) {
            Log.i("id", extras.getString("parceiro_id"));
        }
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
        boolean edit_mode = Boolean.valueOf(extras.getString("parceiro_edit_mode"));

        // Inflate the layout for this fragment
        presenter = new ExibirParceiroPresenter(this, getBaseContext());

        idParceiro.setText(extras.getString("parceiro_id"));
        if (edit_mode){
            ParceiroEntity parceiro = presenter.carregaParceiro(extras.getString("parceiro_id"));
            cnpjCpfParceiro.setText(parceiro.getCnpjCpf());
            nomeParceiro.setText(parceiro.getNome());
            telefoneParceiro.setText(parceiro.getTelefone());
            dataVinculoParceiro.setText(parceiro.getDatavinculo());
            observacoesParceiro.setText(parceiro.getObservacoes());
        } else {
            cnpjCpfParceiro.setText(extras.getString("parceiro_cnpjcpf"));
            nomeParceiro.setText(extras.getString("parceiro_nome"));
            telefoneParceiro.setText(extras.getString("parceiro_telefone"));
            dataVinculoParceiro.setText(extras.getString("parceiro_datavinculo"));
            observacoesParceiro.setText(extras.getString("parceiro_observacoes"));
        }
        presenter.listarDoacoes(extras.getString("parceiro_id"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        editarParceiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editarParceiro = new Intent(getBaseContext(), CadastroParceiroActivity.class);
                editarParceiro.putExtra("parceiro_edit_mode", "true");
                editarParceiro.putExtra("parceiro_id", idParceiro.getText());
                editarParceiro.putExtra("parceiro_cnpjcpf", cnpjCpfParceiro.getText());
                editarParceiro.putExtra("parceiro_nome", nomeParceiro.getText());
                editarParceiro.putExtra("parceiro_telefone", telefoneParceiro.getText());
                editarParceiro.putExtra("parceiro_datavinculo", dataVinculoParceiro.getText());
                editarParceiro.putExtra("parceiro_observacoes", observacoesParceiro.getText());
                startActivity(editarParceiro);
            }
        });

        registrarDoacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novaDoacao = new Intent(getBaseContext(), CadastroDoacaoActivity.class);
                novaDoacao.putExtra("doacao_edit_mode", "false");
                novaDoacao.putExtra("doacao_id_parceiro", idParceiro.getText());
                startActivity(novaDoacao);
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

    public void updateListDoacoes(final List<DoacaoEntity> doacoesEntityList){
        ExibirParceiroAdapter adapter = new ExibirParceiroAdapter(doacoesEntityList,this);
        adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View v, int position) {
                DoacaoEntity objDoacao = doacoesEntityList.get(position);
                Intent exibirDoacao = new Intent(getBaseContext(), ExibirDoacaoActivity.class);
                exibirDoacao.putExtra("doacao_id", objDoacao.getId());
                exibirDoacao.putExtra("doacao_data", objDoacao.getDataDoacao());
                exibirDoacao.putExtra("doacao_descricao", objDoacao.getDescricao());
                startActivity(exibirDoacao);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
