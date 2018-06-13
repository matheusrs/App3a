package com.example.bruno.aplicativo3a.Parceiros.Exibir;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.Entity.DoacaoEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExibirParceiroAdapter extends RecyclerView.Adapter<ExibirParceiroAdapter.ViewHolder> {
    private List<DoacaoEntity> doacaoList;
    OnRecyclerViewSelected onRecyclerViewSelected;
    private Context context;

    ExibirParceiroAdapter(List<DoacaoEntity> list, Context context){
        this.doacaoList=list;
        this.context = context;
    }

    //infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.doacoes_item_list, parent, false);

        return new ViewHolder(v);
    }

    //seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DoacaoEntity doacaoEntity = doacaoList.get(position);
        holder.txDataDoacao.setText(doacaoEntity.getDataDoacao());
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return doacaoList.size();
    }

    //mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.data_doacao)
        TextView txDataDoacao;


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
