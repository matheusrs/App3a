package com.example.bruno.aplicativo3a.Parceiros.InserirAlterar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.Mask;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CadastroParceiroActivity extends AppCompatActivity implements CadastroParceiroView {

    @BindView(R.id.btnSalvarParceiro)
    Button salvar;
    @BindView(R.id.btnAtualizarParceiro)
    Button atualizar;
    @BindView(R.id.hiddenIdParceiro)
    TextView idParceiro;
    @BindView(R.id.edTxtCnpjCpfParceiro)
    EditText cnpjCpfParceiro;
    @BindView(R.id.edTxtNomeParceiro)
    EditText nomeParceiro;
    @BindView(R.id.edTxtTelefoneParceiro)
    EditText telefoneParceiro;
    @BindView(R.id.edTxtDataVinculoParceiro)
    EditText datavinculoParceiro;
    @BindView(R.id.edTxtObservacoesParceiro)
    EditText observacoesParceiro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_parceiros);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        Bundle extras = getIntent().getExtras();
        boolean edit_mode = Boolean.valueOf(extras.getString("parceiro_edit_mode"));



        telefoneParceiro.addTextChangedListener(Mask.insert(Mask.CELULAR_MASK,telefoneParceiro));
        datavinculoParceiro.addTextChangedListener(Mask.insert(Mask.DATA_MASK,datavinculoParceiro));
        if (edit_mode){
            idParceiro.setText(extras.getString("parceiro_id"));
            cnpjCpfParceiro.setText(extras.getString("parceiro_cnpjcpf"));
            nomeParceiro.setText(extras.getString("parceiro_nome"));
            telefoneParceiro.setText(extras.getString("parceiro_telefone"));
            datavinculoParceiro.setText(extras.getString("parceiro_datavinculo"));
            observacoesParceiro.setText(extras.getString("parceiro_observacoes"));
            getSupportActionBar().setTitle("Atualizar Parceiro");
            salvar.setVisibility(View.GONE);
        }
        else {
            atualizar.setVisibility(View.GONE);
            getSupportActionBar().setTitle("Novo Parceiro");
        }
    /* Implementação do DatePicker
        datavinculoParceiro.setOnClickListener(new View.OnClickListener() {
            Calendar myCalendar = Calendar.getInstance();
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();
                }

                private void updateLabel() {
                    String myFormat = "dd/MM/yyyy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("pt","BR"));
                    datavinculoParceiro.setText(sdf.format(myCalendar.getTime()));
                }
            };

            @Override
            public void onClick(View v) {
                new DatePickerDialog(CadastroParceiroActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        }); */

        salvar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)  {
               CadastroParceiroPresenter presenter = new CadastroParceiroPresenter(CadastroParceiroActivity.this, getBaseContext());
               presenter.salvarParceiro(cnpjCpfParceiro.getText().toString() , nomeParceiro.getText().toString(), telefoneParceiro.getText().toString(), datavinculoParceiro.getText().toString(), observacoesParceiro.getText().toString());
            }
        });

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastroParceiroPresenter presenter = new CadastroParceiroPresenter(CadastroParceiroActivity.this, getBaseContext());
                presenter.atualizarParceiro(idParceiro.getText().toString(), cnpjCpfParceiro.getText().toString() , nomeParceiro.getText().toString(), telefoneParceiro.getText().toString(), datavinculoParceiro.getText().toString(), observacoesParceiro.getText().toString());
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
    public void exibeMensagem(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        finish();
    }
}
