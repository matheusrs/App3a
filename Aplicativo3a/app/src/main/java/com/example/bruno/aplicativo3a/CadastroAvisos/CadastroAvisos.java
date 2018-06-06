package com.example.bruno.aplicativo3a.CadastroAvisos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroAvisos extends AppCompatActivity {


    @BindView(R.id.btnSalvarAviso)
    Button salvar;
    @BindView(R.id.btnAtualizarAviso)
    Button atualizar;
    @BindView(R.id.hiddenIdAviso)
    TextView idAviso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_avisos);
            ButterKnife.bind(this);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
            getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
            Bundle extras = getIntent().getExtras();
            boolean edit_mode = Boolean.valueOf(extras.getString("aviso_edit_mode"));

            if (edit_mode == true){
                idAviso.setText(extras.getString("aviso_id"));
                getSupportActionBar().setTitle("Atualizar Aviso");
                atualizar.setVisibility(View.VISIBLE);
                salvar.setVisibility(View.GONE);
            }
            else {
                getSupportActionBar().setTitle("Novo Aviso");
            }

            salvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            atualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

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
