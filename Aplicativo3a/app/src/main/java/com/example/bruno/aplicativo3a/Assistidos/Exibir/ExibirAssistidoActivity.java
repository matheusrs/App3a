package com.example.bruno.aplicativo3a.Assistidos.Exibir;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.Assistidos.InserirAlterar.CadastroAssistidoActivity;
import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.AssistidosController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirAssistidoActivity extends AppCompatActivity implements ExibirAssitidoView {

    @BindView(R.id.btnEditAssistido)
    Button editarAssistido;
    @BindView(R.id.hiddenIdAssistido)
    TextView idAssistido;
    @BindView(R.id.hiddenStatusAssistido)
    TextView statusAssistido;
    @BindView(R.id.valueCPFAssistido)
    TextView cpfAssistido;
    @BindView(R.id.valueNomeAssistido)
    TextView nomeAssistido;
    @BindView(R.id.valueDeficienciaAssistido)
    TextView deficienciaAssistido;
    @BindView(R.id.valueObservacoesAssistido)
    TextView observacoesAssistido;
    @BindView(R.id.valueSobrenomeAssistido)
    TextView sobrenomeAssistido;
    @BindView(R.id.valueTelefoneAssistido)
    TextView telefoneAssistido;
    @BindView(R.id.valueDataNascimentoAssistido)
    TextView datanascimentoAssistido;
    @BindView(R.id.labelStatusAtivo)
    TextView labelStatusAssistido;

    int id;
    ExibirAssitidoPresenter presenter;

    public ExibirAssistidoActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onResume() {
        super.onResume();
        AssistidoEntity assistidoEntity = presenter.carregaAssistido(id);
        idAssistido.setText(assistidoEntity.getId());
        statusAssistido.setText(assistidoEntity.getStatusAtivo());
        cpfAssistido.setText(assistidoEntity.getCPF());
        nomeAssistido.setText(assistidoEntity.getNome());
        sobrenomeAssistido.setText(assistidoEntity.getSobrenome());
        telefoneAssistido.setText(assistidoEntity.getTelefone());
        datanascimentoAssistido.setText(assistidoEntity.getDataNascimento());
        deficienciaAssistido.setText(assistidoEntity.getDeficiencia());
        observacoesAssistido.setText(assistidoEntity.getObservacoes());
        if (Boolean.valueOf(assistidoEntity.getStatusAtivo())){
            labelStatusAssistido.setText("Cadastro Ativo");
            labelStatusAssistido.setTextColor(Color.parseColor("#00FF00"));
        }
        else{
            labelStatusAssistido.setText("Cadastro Inativo");
            labelStatusAssistido.setTextColor(Color.parseColor("#FF0000"));
        }
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

        presenter=new ExibirAssitidoPresenter(this,this);
        id = Integer.parseInt(extras.getString("assistido_id"));

        editarAssistido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editarAssistido = new Intent(getBaseContext(), CadastroAssistidoActivity.class);
                    editarAssistido.putExtra("assistido_edit_mode", "true");
                    editarAssistido.putExtra("assistido_id", idAssistido.getText());
                    startActivity(editarAssistido);
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
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
