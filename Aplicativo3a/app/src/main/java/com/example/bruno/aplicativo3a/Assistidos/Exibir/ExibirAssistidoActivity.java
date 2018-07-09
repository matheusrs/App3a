package com.example.bruno.aplicativo3a.Assistidos.Exibir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


    public ExibirAssistidoActivity() {
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
        getSupportActionBar().setTitle("Acorde Administrativo");

        idAssistido.setText(extras.getString("assistido_id"));
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
                    editarAssistido.putExtra("assistido_id", idAssistido.getText());
                    editarAssistido.putExtra("assistido_cpf", cpfAssistido.getText());
                    editarAssistido.putExtra("assistido_rg", rgAssistido.getText());
                    editarAssistido.putExtra("assistido_nome", nomeAssistido.getText());
                    editarAssistido.putExtra("assistido_datanascimento", datanascimentoAssistido.getText());
                    editarAssistido.putExtra("assistido_tamanho_calcado", tamanhoCalcadoAssistido.getText());
                    editarAssistido.putExtra("assistido_tamanho_roupa", tamanhoRoupaAssistido.getText());
                    editarAssistido.putExtra("assistido_datas_presentes", datasPresentesAssistido.getText());
                    editarAssistido.putExtra("assistido_meio_transporte", meioTransporteAssistido.getText());
                    editarAssistido.putExtra("assistido_statusativo", statusAssistido.getText());
                    startActivity(editarAssistido);
                }
            }
        );

        addResponsavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoResponsavel = new Intent(getBaseContext(), CadastroResponsavelActivity.class);
                novoResponsavel.putExtra("responsavel_edit_mode", "false");
                novoResponsavel.putExtra("responsavel_id_assistido", idAssistido.getText());
                startActivity(novoResponsavel);
            }
        });

        addMedicamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoMedicamento = new Intent(getBaseContext(), CadastroMedicamentoActivity.class);
                novoMedicamento.putExtra("medicamento_edit_mode", "false");
                novoMedicamento.putExtra("medicamento_id_assistido", idAssistido.getText());
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
            labelResponsaveis.setVisibility(View.INVISIBLE);
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
            labelMedicamentos.setVisibility(View.INVISIBLE);
        } else {
            ExibirAssistidoMedicamentosAdapter adapter = new ExibirAssistidoMedicamentosAdapter(medicamentosEntityList,this);
            adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
                @Override
                public void onClick(View v, int position) {
                    MedicamentoEntity objDoacao = medicamentosEntityList.get(position);
                    Intent exibirDoacao = new Intent(getBaseContext(), ExibirMedicamentoActivity.class);
                    exibirDoacao.putExtra("medicamento_id", objDoacao.getId());
                    exibirDoacao.putExtra("medicamento_id_assistido", objDoacao.getIdAssistido());
                    exibirDoacao.putExtra("medicamento_nome_medicamento", objDoacao.getNomeMedicamento());
                    exibirDoacao.putExtra("medicamento_observacoes", objDoacao.getObservacoes());
                    startActivity(exibirDoacao);
                }
            });
            recyclerViewMedicamentos.setAdapter(adapter);
        }
    }

}
