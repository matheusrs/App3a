package com.example.bruno.aplicativo3a.CadastroAssistidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.Main.MainActivity;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.BancoController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroAssistidos extends AppCompatActivity {


    @BindView(R.id.btnSalvarAssistido)
    Button salvar;
    @BindView(R.id.btnAtualizarAssistido)
    Button atualizar;
    @BindView(R.id.hiddenIdAssistido)
    TextView idAssistido;
    @BindView(R.id.edTxtCPFAssistido)
    EditText cpfAssistido;
    @BindView(R.id.edTxtNomeAssistido)
    EditText nomeAssistido;
    @BindView(R.id.edTxtDeficienciaAssistido)
    EditText deficienciaAssistido;
    @BindView(R.id.edTxtObservacoesAssistido)
    EditText observacoesAssistido;
    @BindView(R.id.edTxtSobrenomeAssistido)
    EditText sobrenomeAssistido;
    @BindView(R.id.edTxtTelefoneAssistido)
    EditText telefoneAssistido;
    @BindView(R.id.edTxtDataNascimentoAssistido)
    EditText datanascimentoAssistido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_assistidos);
            ButterKnife.bind(this);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
            getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
            Bundle extras = getIntent().getExtras();
            boolean edit_mode = Boolean.valueOf(extras.getString("assistido_edit_mode"));

            if (edit_mode == true){
                idAssistido.setText(extras.getString("assistido_id"));
                cpfAssistido.setText(extras.getString("assistido_cpf"));
                nomeAssistido.setText(extras.getString("assistido_nome"));
                sobrenomeAssistido.setText(extras.getString("assistido_sobrenome"));
                telefoneAssistido.setText(extras.getString("assistido_telefone"));
                datanascimentoAssistido.setText(extras.getString("assistido_datanascimento"));
                deficienciaAssistido.setText(extras.getString("assistido_deficiencia"));
                observacoesAssistido.setText(extras.getString("assistido_observacoes"));
                getSupportActionBar().setTitle("Atualizar Assistido");
                atualizar.setVisibility(View.VISIBLE);
                salvar.setVisibility(View.GONE);
            }
            else {
                getSupportActionBar().setTitle("Novo Assistido");
            }

            salvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String message;
                    BancoController banco = new BancoController(getBaseContext());
                    if (banco.insereAssistido(cpfAssistido.getText().toString() , nomeAssistido.getText().toString(), sobrenomeAssistido.getText().toString(), telefoneAssistido.getText().toString(), datanascimentoAssistido.getText().toString(), deficienciaAssistido.getText().toString(), observacoesAssistido.getText().toString()))
                        message = "Assistido cadastrado!";
                    else
                        message = "Erro ao gravar assistido";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    finish();
                    //Intent i = new Intent(CadastroAssistidos.this, MainActivity.class);
                    //startActivity(i);
                }
            });

            atualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String message;
                    BancoController banco = new BancoController(getBaseContext());
                    if (banco.atualizaAssistido(idAssistido.getText().toString(),cpfAssistido.getText().toString(), nomeAssistido.getText().toString(), sobrenomeAssistido.getText().toString(), telefoneAssistido.getText().toString(), datanascimentoAssistido.getText().toString(), deficienciaAssistido.getText().toString(), observacoesAssistido.getText().toString()))
                        message = "Assistido atualizado!";
                    else
                        message = "Erro ao atualizar assistido";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    finish();
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
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
