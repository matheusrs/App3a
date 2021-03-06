package com.example.bruno.aplicativo3a.Assistidos.InserirAlterar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;
import com.example.bruno.aplicativo3a.Mask;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroAssistidoActivity extends AppCompatActivity implements CadastroAssistidoView {

    @BindView(R.id.btnSalvarAssistido)
    Button salvar;
    @BindView(R.id.btnAtualizarAssistido)
    Button atualizar;
    @BindView(R.id.hiddenIdAssistido)
    TextView idAssistido;
    @BindView(R.id.edTxtCPFAssistido)
    EditText cpfAssistido;
    @BindView(R.id.edTxtRgAssistido)
    EditText rgAssistido;
    @BindView(R.id.edTxtNomeAssistido)
    EditText nomeAssistido;
    @BindView(R.id.edTxtDataNascimentoAssistido)
    EditText datanascimentoAssistido;
    @BindView(R.id.edTxtTamanhoCalcadoAssistido)
    EditText tamanhoCalcadoAssistido;
    @BindView(R.id.edTxtTamanhoRoupaAssistido)
    EditText tamanhoRoupaAssistido;
    @BindView(R.id.edTxtDatasPresentesAssistido)
    EditText datasPresentesAssistido;
    @BindView(R.id.edTxtMeioTransporteAssistido)
    EditText meioTransporteAssistido;
    @BindView(R.id.switchAtivo)
    Switch switchAtivo;
    CadastroAssistidoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_assistidos);
            ButterKnife.bind(this);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
            getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
            Bundle extras = getIntent().getExtras();
            boolean edit_mode = Boolean.valueOf(extras.getString("assistido_edit_mode"));
            cpfAssistido.addTextChangedListener(Mask.insert(Mask.CPF_MASK,cpfAssistido));
            rgAssistido.addTextChangedListener(Mask.insert(Mask.RG_MASK,rgAssistido));
            datanascimentoAssistido.addTextChangedListener(Mask.insert(Mask.DATA_MASK,datanascimentoAssistido));
            presenter = new CadastroAssistidoPresenter(CadastroAssistidoActivity.this, getBaseContext());

            if (edit_mode){
                idAssistido.setText(extras.getString("assistido_id"));
                AssistidoEntity assistido = presenter.carregaAssistido(idAssistido.getText().toString());
                cpfAssistido.setText(assistido.getCpf());
                rgAssistido.setText(assistido.getRg());
                nomeAssistido.setText(assistido.getNomeCompleto());
                datanascimentoAssistido.setText(assistido.getDataNascimento());
                tamanhoCalcadoAssistido.setText(assistido.getTamanhoCalcado());
                tamanhoRoupaAssistido.setText(assistido.getTamanhoRoupa());
                datasPresentesAssistido.setText(assistido.getDatasPresentes());
                meioTransporteAssistido.setText(assistido.getMeioTransporte());
                getSupportActionBar().setTitle("Atualizar Assistido");
                atualizar.setVisibility(View.VISIBLE);
                switchAtivo.setVisibility(View.VISIBLE);
                if (Boolean.valueOf(assistido.getStatusAtivo())){
                    alteraTextoSwitchAtivo(true);
                    switchAtivo.setChecked(true);
                } else {
                    alteraTextoSwitchAtivo(false);
                    switchAtivo.setChecked(false);
                }
                salvar.setVisibility(View.GONE);
            }
            else {
                switchAtivo.setVisibility(View.GONE);
                atualizar.setVisibility(View.GONE);
                getSupportActionBar().setTitle("Novo Assistido");
            }

            salvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   CadastroAssistidoPresenter presenter = new CadastroAssistidoPresenter(CadastroAssistidoActivity.this, getBaseContext());
                   presenter.salvarAssistido(cpfAssistido.getText().toString(), rgAssistido.getText().toString() , nomeAssistido.getText().toString(), datanascimentoAssistido.getText().toString(), tamanhoCalcadoAssistido.getText().toString(), tamanhoRoupaAssistido.getText().toString(), datasPresentesAssistido.getText().toString(), meioTransporteAssistido.getText().toString());
                }
            });

            atualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CadastroAssistidoPresenter presenter = new CadastroAssistidoPresenter(CadastroAssistidoActivity.this, getBaseContext());
                    presenter.atualizarAssistido(idAssistido.getText().toString(), cpfAssistido.getText().toString(), rgAssistido.getText().toString() , nomeAssistido.getText().toString(), datanascimentoAssistido.getText().toString(), tamanhoCalcadoAssistido.getText().toString(), tamanhoRoupaAssistido.getText().toString(), datasPresentesAssistido.getText().toString(), meioTransporteAssistido.getText().toString());
                }
            });

            switchAtivo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    CadastroAssistidoPresenter presenter = new CadastroAssistidoPresenter(CadastroAssistidoActivity.this, getBaseContext());
                    if (isChecked) {
                        presenter.alteraStatus(idAssistido.getText().toString(), true);
                    } else {
                        presenter.alteraStatus(idAssistido.getText().toString(), false);
                    }
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

    @Override
    public void alteraTextoSwitchAtivo(boolean status) {
        if (status)
            switchAtivo.setText("Cadastro Ativo");
        else
            switchAtivo.setText("Cadastro Inativo");
    }

    @Override
    public void exibeMensagem(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        finish();
    }
}
