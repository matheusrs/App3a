package com.example.bruno.aplicativo3a.Assistidos.Exibir;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.Assistidos.InserirAlterar.CadastroAssistidoActivity;
import com.example.bruno.aplicativo3a.Assistidos.Medicamentos.Exibir.ExibirMedicamentoActivity;
import com.example.bruno.aplicativo3a.Assistidos.Medicamentos.InserirAlterar.CadastroMedicamentoActivity;
import com.example.bruno.aplicativo3a.Assistidos.Responsaveis.Exibir.ExibirResponsavelActivity;
import com.example.bruno.aplicativo3a.Assistidos.Responsaveis.InserirAlterar.CadastroResponsavelActivity;
import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;
import com.example.bruno.aplicativo3a.Entity.MedicamentoEntity;
import com.example.bruno.aplicativo3a.Entity.ResponsavelEntity;
import com.example.bruno.aplicativo3a.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirAssistidoActivity extends AppCompatActivity implements ExibirAssistidoView {

    @BindView(R.id.btnEditAssistido)
    Button editarAssistido;
    @BindView(R.id.btnAddResponsavel)
    Button addResponsavel;
    @BindView(R.id.btnAddMedicamento)
    Button addMedicamento;

    @BindView(R.id.hiddenIdAssistido)
    TextView idAssistido;
    @BindView(R.id.hiddenStatusAssistido)
    TextView statusAssistido;
    @BindView(R.id.valueCPFAssistido)
    TextView cpfAssistido;
    @BindView(R.id.valueRgAssistido)
    TextView rgAssistido;
    @BindView(R.id.valueNomeAssistido)
    TextView nomeAssistido;
    @BindView(R.id.valueDataNascimentoAssistido)
    TextView datanascimentoAssistido;
    @BindView(R.id.valueTamanhoCalcadoAssistido)
    TextView tamanhoCalcadoAssistido;
    @BindView(R.id.valueTamanhoRoupaAssistido)
    TextView tamanhoRoupaAssistido;
    @BindView(R.id.valueDatasPresentesAssistido)
    TextView datasPresentesAssistido;
    @BindView(R.id.valueMeioTransporteAssistido)
    TextView meioTransporteAssistido;

    @BindView(R.id.labelStatusAtivo)
    TextView labelStatusAssistido;
    @BindView(R.id.labelResponsaveis)
    TextView labelResponsaveis;
    @BindView(R.id.labelMedicamentos)
    TextView labelMedicamentos;
    @BindView(R.id.recycler_view_medicamentos)
    RecyclerView recyclerViewMedicamentos;
    @BindView(R.id.recycler_view_responsaveis)
    RecyclerView recyclerViewResponsaveis;
    @BindView(R.id.card_view_responsaveis)
    CardView cardResponsaveis;
    @BindView(R.id.card_view_medicamentos)
    CardView cardMedicamentos;

    ExibirAssistidoPresenter presenter;

    public ExibirAssistidoActivity() {
        // Required empty public constructor
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        presenter = new ExibirAssistidoPresenter(this, getBaseContext());
        AssistidoEntity assistidoEntity = presenter.carregaAssistido(idAssistido.getText().toString());
        idAssistido.setText(assistidoEntity.getId());
        statusAssistido.setText(assistidoEntity.getStatusAtivo());
        cpfAssistido.setText(assistidoEntity.getCpf());
        rgAssistido.setText(assistidoEntity.getRg());
        nomeAssistido.setText(assistidoEntity.getNomeCompleto());
        datanascimentoAssistido.setText(assistidoEntity.getDataNascimento());
        tamanhoCalcadoAssistido.setText(assistidoEntity.getTamanhoCalcado());
        tamanhoRoupaAssistido.setText(assistidoEntity.getTamanhoRoupa());
        datasPresentesAssistido.setText(assistidoEntity.getDatasPresentes());
        meioTransporteAssistido.setText(assistidoEntity.getMeioTransporte());

        if (Boolean.valueOf(assistidoEntity.getStatusAtivo())){
            labelStatusAssistido.setText("Cadastro Ativo");
            labelStatusAssistido.setTextColor(Color.parseColor("#00FF00"));
        }
        else{
            labelStatusAssistido.setText("Cadastro Inativo");
            labelStatusAssistido.setTextColor(Color.parseColor("#FF0000"));
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_assistido);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Detalhes do Assistido");

        presenter = new ExibirAssistidoPresenter(this, this);
        presenter.listarResponsaveis(Integer.valueOf(extras.get("assistido_id").toString()));
        presenter.listarMedicamentos(Integer.valueOf(extras.get("assistido_id").toString()));

        recyclerViewMedicamentos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewResponsaveis.setLayoutManager(new LinearLayoutManager(this));

        idAssistido.setText(String.valueOf(extras.get("assistido_id")));
        statusAssistido.setText(extras.getString("assistido_statusativo"));
        cpfAssistido.setText(extras.getString("assistido_cpf"));
        rgAssistido.setText(extras.getString("assistido_rg"));
        nomeAssistido.setText(extras.getString("assistido_nome"));
        datanascimentoAssistido.setText(extras.getString("assistido_datanascimento"));
        tamanhoCalcadoAssistido.setText(extras.getString("assistido_tamanho_calcado"));
        tamanhoRoupaAssistido.setText(extras.getString("assistido_tamanho_roupa"));
        datasPresentesAssistido.setText(extras.getString("assistido_datas_presentes"));
        meioTransporteAssistido.setText(extras.getString("assistido_meio_transporte"));
        if (Boolean.valueOf(extras.getString("assistido_statusativo")))
            labelStatusAssistido.setText("Cadastro Ativo");
        else
            labelStatusAssistido.setText("Cadastro Inativo");


        editarAssistido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editarAssistido = new Intent(getBaseContext(), CadastroAssistidoActivity.class);
                    editarAssistido.putExtra("assistido_edit_mode", "true");
                    editarAssistido.putExtra("assistido_id", idAssistido.getText().toString());
                    editarAssistido.putExtra("assistido_cpf", cpfAssistido.getText().toString());
                    editarAssistido.putExtra("assistido_rg", rgAssistido.getText().toString());
                    editarAssistido.putExtra("assistido_nome", nomeAssistido.getText().toString());
                    editarAssistido.putExtra("assistido_datanascimento", datanascimentoAssistido.getText().toString());
                    editarAssistido.putExtra("assistido_tamanho_calcado", tamanhoCalcadoAssistido.getText().toString());
                    editarAssistido.putExtra("assistido_tamanho_roupa", tamanhoRoupaAssistido.getText().toString());
                    editarAssistido.putExtra("assistido_datas_presentes", datasPresentesAssistido.getText().toString());
                    editarAssistido.putExtra("assistido_meio_transporte", meioTransporteAssistido.getText().toString());
                    editarAssistido.putExtra("assistido_statusativo", statusAssistido.getText().toString());
                    startActivity(editarAssistido);
                }
            }
        );

        addResponsavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoResponsavel = new Intent(getBaseContext(), CadastroResponsavelActivity.class);
                novoResponsavel.putExtra("responsavel_edit_mode", "false");
                novoResponsavel.putExtra("responsavel_id_assistido", idAssistido.getText().toString());
                startActivity(novoResponsavel);
    }
        });

        addMedicamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoMedicamento = new Intent(getBaseContext(), CadastroMedicamentoActivity.class);
                novoMedicamento.putExtra("medicamento_edit_mode", "false");
                novoMedicamento.putExtra("medicamento_id_assistido", idAssistido.getText().toString());
                startActivity(novoMedicamento);
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
    public void updateListResponsaveis(final List<ResponsavelEntity> responsaveisEntityList){
        if (responsaveisEntityList.isEmpty()) {
            cardResponsaveis.setVisibility(View.GONE);
        } else {
            ExibirAssistidoResponsavelAdapter adapter = new ExibirAssistidoResponsavelAdapter(responsaveisEntityList,this);
            adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
                @Override
                public void onClick(View v, int position) {
                    ResponsavelEntity objResponsavel = responsaveisEntityList.get(position);
                    Intent exibirResponsavel = new Intent(getBaseContext(), ExibirResponsavelActivity.class);
                    exibirResponsavel.putExtra("responsavel_id",objResponsavel.getId());
                    exibirResponsavel.putExtra("responsavel_id_assistido",objResponsavel.getIdAssistido());
                    exibirResponsavel.putExtra("responsavel_nome_completo",objResponsavel.getNomeCompleto());
                    exibirResponsavel.putExtra("responsavel_cpf",objResponsavel.getCpf());
                    exibirResponsavel.putExtra("responsavel_rg",objResponsavel.getRg());
                    exibirResponsavel.putExtra("responsavel_endereco",objResponsavel.getEndereco());
                    exibirResponsavel.putExtra("responsavel_bairro",objResponsavel.getBairro());
                    exibirResponsavel.putExtra("responsavel_telefone",objResponsavel.getTelefone());
                    exibirResponsavel.putExtra("responsavel_grau_parentesco",objResponsavel.getGrauParentesco());
                    exibirResponsavel.putExtra("responsavel_email",objResponsavel.getEmail());
                    exibirResponsavel.putExtra("responsavel_autorizado_retirar",objResponsavel.getAutorizadoRetirar());
                    startActivity(exibirResponsavel);
                }
            });
            recyclerViewResponsaveis.setAdapter(adapter);
        }
    }

    @Override
    public void updateListMedicamentos(final List<MedicamentoEntity> medicamentosEntityList){
        if (medicamentosEntityList.isEmpty()) {
            cardMedicamentos.setVisibility(View.GONE);
        } else {
            ExibirAssistidoMedicamentosAdapter adapter = new ExibirAssistidoMedicamentosAdapter(medicamentosEntityList,this);
            adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
                @Override
                public void onClick(View v, int position) {
                    MedicamentoEntity objDoacao = medicamentosEntityList.get(position);
                    Intent exibirMedicamento = new Intent(getBaseContext(), ExibirMedicamentoActivity.class);
                    exibirMedicamento.putExtra("medicamento_id", objDoacao.getId());
                    exibirMedicamento.putExtra("medicamento_id_assistido", objDoacao.getIdAssistido());
                    exibirMedicamento.putExtra("medicamento_nome_medicamento", objDoacao.getNomeMedicamento());
                    exibirMedicamento.putExtra("medicamento_observacoes", objDoacao.getObservacoes());
                    startActivity(exibirMedicamento);
                }
            });
            recyclerViewMedicamentos.setAdapter(adapter);
        }
    }

}
