package com.example.bruno.aplicativo3a.Assistidos.Responsaveis.InserirAlterar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.Mask;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroResponsavelActivity extends AppCompatActivity implements CadastroResponsavelView {

    @BindView(R.id.btnAdicionarResponsavel)
    Button salvar;
    @BindView(R.id.btnAtualizarResponsavel)
    Button atualizar;
    @BindView(R.id.hiddenIdResponsavel)
    TextView idResponsavel;
    @BindView(R.id.hiddenIdAssistidoResponsavel)
    TextView idAssistidoResponsavel;
    @BindView(R.id.edTxtNomeResponsavel)
    EditText nomeResponsavel;
    @BindView(R.id.edTxtCpfResponsavel)
    EditText cpfResponsavel;
    @BindView(R.id.edTxtRgResponsavel)
    EditText rgResponsavel;
    @BindView(R.id.edTxtEnderecoResponsavel)
    EditText enderecoResponsavel;
    @BindView(R.id.edTxtBairroResponsavel)
    EditText bairroResponsavel;
    @BindView(R.id.edTxtTelefoneResponsavel)
    EditText telefoneResponsavel;
    @BindView(R.id.edTxtGrauParentescoResponsavel)
    EditText grauParentescoResponsavel;
    @BindView(R.id.edTxtEmailResponsavel)
    EditText emailResponsavel;
    @BindView(R.id.switchAutorizadoRetirar)
    Switch autorizadoRetirarResponsavel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_responsaveis);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        Bundle extras = getIntent().getExtras();
        boolean insert_edit_mode = Boolean.valueOf(extras.getString("responsavel_edit_mode")) ||
                Boolean.valueOf(extras.getString("responsavel_insert_mode"));
        idAssistidoResponsavel.setText(extras.getString("responsavel_id_assistido"));
        rgResponsavel.addTextChangedListener(Mask.insert(Mask.RG_MASK,cpfResponsavel));
        cpfResponsavel.addTextChangedListener(Mask.insert(Mask.CPF_MASK,cpfResponsavel));
        telefoneResponsavel.addTextChangedListener(Mask.insert(Mask.TELEFONE_MASK,telefoneResponsavel));

        if (insert_edit_mode){
            idResponsavel.setText(extras.getString("responsavel_id"));
            idAssistidoResponsavel.setText(extras.getString("responsavel_id_assistido"));
            nomeResponsavel.setText(extras.getString("responsavel_nome"));
            cpfResponsavel.setText(extras.getString("responsavel_cpf"));
            rgResponsavel.setText(extras.getString("responsavel_rg"));
            enderecoResponsavel.setText(extras.getString("responsavel_endereco"));
            bairroResponsavel.setText(extras.getString("responsavel_bairro"));
            telefoneResponsavel.setText(extras.getString("responsavel_telefone"));
            grauParentescoResponsavel.setText(extras.getString("responsavel_grau_parentesco"));
            emailResponsavel.setText(extras.getString("responsavel_email"));
            autorizadoRetirarResponsavel.setVisibility(View.VISIBLE);
            if (Boolean.valueOf(extras.getString("assistido_statusativo"))) {
                alteraTextoSwitchAutorizadoRetirar(true);
                autorizadoRetirarResponsavel.setChecked(true);
            } else {
                alteraTextoSwitchAutorizadoRetirar(false);
                autorizadoRetirarResponsavel.setChecked(false);
            }
            atualizar.setVisibility(View.VISIBLE);
            salvar.setVisibility(View.GONE);
            getSupportActionBar().setTitle("Atualizar Responsável");
        }
        else {
            getSupportActionBar().setTitle("Novo(a) Responsável");
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastroResponsavelPresenter presenter = new CadastroResponsavelPresenter(CadastroResponsavelActivity.this, getBaseContext());
                presenter.salvarResponsavel(idAssistidoResponsavel.getText().toString(), nomeResponsavel.getText().toString(), cpfResponsavel.getText().toString(),rgResponsavel.getText().toString(),enderecoResponsavel.getText().toString(),bairroResponsavel.getText().toString(),telefoneResponsavel.getText().toString(),grauParentescoResponsavel.getText().toString(),emailResponsavel.getText().toString(),autorizadoRetirarResponsavel.getText().toString());
            }
        });

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastroResponsavelPresenter presenter = new CadastroResponsavelPresenter(CadastroResponsavelActivity.this, getBaseContext());
                presenter.atualizarResponsavel(idResponsavel.getText().toString(), idAssistidoResponsavel.getText().toString(), nomeResponsavel.getText().toString(), cpfResponsavel.getText().toString(),rgResponsavel.getText().toString(),enderecoResponsavel.getText().toString(),bairroResponsavel.getText().toString(),telefoneResponsavel.getText().toString(),grauParentescoResponsavel.getText().toString(),emailResponsavel.getText().toString(),autorizadoRetirarResponsavel.getText().toString());
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
    public void alteraTextoSwitchAutorizadoRetirar(boolean status) {
        if (status)
            autorizadoRetirarResponsavel.setText("Sim");
        else
            autorizadoRetirarResponsavel.setText("Não");
    }

    @Override
    public void exibeMensagem(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        finish();
    }
}
