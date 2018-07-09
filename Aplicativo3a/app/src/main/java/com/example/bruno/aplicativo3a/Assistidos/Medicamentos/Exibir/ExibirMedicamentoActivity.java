package com.example.bruno.aplicativo3a.Assistidos.Medicamentos.Exibir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.Assistidos.Medicamentos.InserirAlterar.CadastroMedicamentoActivity;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirMedicamentoActivity extends AppCompatActivity {


    @BindView(R.id.btnEditMedicamento)
    Button editarMedicamento;
    @BindView(R.id.hiddenIdMedicamento)
    TextView idMedicamento;
    @BindView(R.id.hiddenIdAssistidoMedicamento)
    TextView idAssistidoMedicamento;
    @BindView(R.id.valueNomeMedicamento)
    TextView nomeMedicamento;
    @BindView(R.id.valueObservacoesMedicamento)
    TextView observacoesMedicamento;

    public ExibirMedicamentoActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onStart(){
        super.onStart();
        Bundle extras = getIntent().getExtras();
        if(extras.getString("medicamento_id") != null) {
            Log.i("id", extras.getString("medicamento_id"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_medicamento);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Detalhes do Medicamento:");

        idMedicamento.setText(extras.getString("medicamento_id"));
        idAssistidoMedicamento.setText(extras.getString("medicamento_id_assistido"));
        nomeMedicamento.setText(extras.getString("medicamento_nome"));;
        observacoesMedicamento.setText(extras.getString("medicamento_observacoes"));

        editarMedicamento.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
            Intent editarMedicamento = new Intent(getBaseContext(), CadastroMedicamentoActivity.class);
            editarMedicamento.putExtra("medicamento_edit_mode", "true");
            editarMedicamento.putExtra("medicamento_id", idMedicamento.getText());
            editarMedicamento.putExtra("medicamento_id_assistido",idAssistidoMedicamento.getText());
            editarMedicamento.putExtra("medicamento_nome",nomeMedicamento.getText());
            editarMedicamento.putExtra("medicamento_observacoes", observacoesMedicamento.getText());
            startActivity(editarMedicamento);
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
