package com.example.bruno.aplicativo3a.Assistidos.Responsaveis.Exibir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.Assistidos.Responsaveis.InserirAlterar.CadastroResponsavelActivity;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirResponsavelActivity extends AppCompatActivity {


    @BindView(R.id.btnEditResponsavel)
    Button editarResponsavel;
    @BindView(R.id.hiddenIdResponsavel)
    TextView idResponsavel;
    @BindView(R.id.hiddenIdAssistidoResponsavel)
    TextView idAssistidoResponsavel;
    @BindView(R.id.valueNomeResponsavel)
    TextView nomeResponsavel;
    @BindView(R.id.valueCpfResponsavel)
    TextView cpfResponsavel;
    @BindView(R.id.valueRgResponsavel)
    TextView rgResponsavel;
    @BindView(R.id.valueEnderecoResponsavel)
    TextView enderecoResponsavel;
    @BindView(R.id.valueBairroResponsavel)
    TextView bairroResponsavel;
    @BindView(R.id.valueTelefoneResponsavel)
    TextView telefoneResponsavel;
    @BindView(R.id.valueGrauParentescoResponsavel)
    TextView grauParentescoResponsavel;
    @BindView(R.id.valueEmailResponsavel)
    TextView emailResponsavel;
    @BindView(R.id.valueAutorizadoRetirarResponsavel)
    TextView autorizadoRetirarResponsavel;

    public ExibirResponsavelActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onStart(){
        super.onStart();
        Bundle extras = getIntent().getExtras();
        if(extras.getString("responsavel_id") != null) {
            Log.i("id", extras.getString("responsavel_id"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_responsavel);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Detalhes da Doação:");

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
        autorizadoRetirarResponsavel.setText(extras.getString("responsavel_autorizado_retirar"));


        editarResponsavel.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
            Intent editarResponsavel = new Intent(getBaseContext(), CadastroResponsavelActivity.class);
            editarResponsavel.putExtra("responsavel_edit_mode", "true");
            editarResponsavel.putExtra("responsavel_id", idResponsavel.getText());
            editarResponsavel.putExtra("responsavel_id_assistido",idAssistidoResponsavel.getText());
            editarResponsavel.putExtra("responsavel_nome",nomeResponsavel.getText());
            editarResponsavel.putExtra("responsavel_cpf",cpfResponsavel.getText());
            editarResponsavel.putExtra("responsavel_rg",rgResponsavel.getText());
            editarResponsavel.putExtra("responsavel_endereco",enderecoResponsavel.getText());
            editarResponsavel.putExtra("responsavel_bairro",bairroResponsavel.getText());
            editarResponsavel.putExtra("responsavel_telefone",telefoneResponsavel.getText());
            editarResponsavel.putExtra("responsavel_grau_parentesco",grauParentescoResponsavel.getText());
            editarResponsavel.putExtra("responsavel_email",emailResponsavel.getText());
            editarResponsavel.putExtra("responsavel_autorizado_retirar",autorizadoRetirarResponsavel.getText());
            startActivity(editarResponsavel);
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
