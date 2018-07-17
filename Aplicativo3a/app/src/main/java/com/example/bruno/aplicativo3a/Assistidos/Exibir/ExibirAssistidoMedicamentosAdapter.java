package com.example.bruno.aplicativo3a.Assistidos.Exibir;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.Entity.DoacaoEntity;
import com.example.bruno.aplicativo3a.Entity.MedicamentoEntity;
import com.example.bruno.aplicativo3a.Entity.MedicamentoEntity;
import com.example.bruno.aplicativo3a.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExibirAssistidoMedicamentosAdapter extends RecyclerView.Adapter<ExibirAssistidoMedicamentosAdapter.ViewHolder> {
    private List<MedicamentoEntity> medicamentoList;

    OnRecyclerViewSelected onRecyclerViewSelected;
    private Context context;

    ExibirAssistidoMedicamentosAdapter(List<MedicamentoEntity> listMedicamento, Context context){
        this.medicamentoList=listMedicamento;

        this.context = context;
    }

    //infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicamento_item_list, parent, false);

        return new ViewHolder(v);
    }

    //seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MedicamentoEntity medicamentoEntity = medicamentoList.get(position);
        holder.txNomeMedicamento.setText(medicamentoEntity.getNomeMedicamento());
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return medicamentoList.size();
    }

    //mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nome_medicamento)
        TextView txNomeMedicamento;


       public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.container)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());
        }

    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }
}
