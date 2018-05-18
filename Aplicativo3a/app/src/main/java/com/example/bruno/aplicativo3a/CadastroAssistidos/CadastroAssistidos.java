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


    @BindView(R.id.btnSalvar)
    Button salvar;
    @BindView(R.id.btnAtualizar)
    Button atualizar;
    @BindView(R.id.hiddenId)
    TextView id;
    @BindView(R.id.edTxtNome)
    EditText nome;
    @BindView(R.id.edTxtDeficiencia)
    EditText deficiencia;
    @BindView(R.id.edTxtObservacoes)
    EditText observacoes;
    @BindView(R.id.edTxtSobrenome)
    EditText sobrenome;
    @BindView(R.id.edTxtTelefone)
    EditText telefone;
    @BindView(R.id.edTxtDataNascimento)
    EditText datanascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_assistidos);
            ButterKnife.bind(this);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
            getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
            final Bundle extras = getIntent().getExtras();
            boolean edit_mode = (Boolean.valueOf(extras.getString("edit_mode")) != null ? true : false);

            if (edit_mode == true){
                id.setText(extras.getString("assistido_id"));
                nome.setText(extras.getString("assistido_nome"));
                sobrenome.setText(extras.getString("assistido_sobrenome"));
                telefone.setText(extras.getString("assistido_telefone"));
                datanascimento.setText(extras.getString("assistido_datanascimento"));
                deficiencia.setText(extras.getString("assistido_deficiencia"));
                observacoes.setText(extras.getString("assistido_observacoes"));
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
                    if (banco.insereAssistido(nome.getText().toString(), sobrenome.getText().toString(), telefone.getText().toString(), datanascimento.getText().toString(), deficiencia.getText().toString(), observacoes.getText().toString()))
                        message = "Assistido cadastrado!";
                    else
                        message = "Erro ao gravar assistido";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(CadastroAssistidos.this, MainActivity.class);
                    startActivity(i);
                }
            });

            atualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String message;
                    BancoController banco = new BancoController(getBaseContext());
                    if (banco.atualizaAssistido(id.getText().toString(), nome.getText().toString(), sobrenome.getText().toString(), telefone.getText().toString(), datanascimento.getText().toString(), deficiencia.getText().toString(), observacoes.getText().toString()))
                        message = "Assistido atualizado!";
                    else
                        message = "Erro ao atualizar assistido";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(CadastroAssistidos.this, MainActivity.class);
                    startActivity(i);
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
