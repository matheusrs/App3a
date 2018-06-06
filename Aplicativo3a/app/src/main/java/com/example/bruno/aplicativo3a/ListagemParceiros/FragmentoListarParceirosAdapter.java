package com.example.bruno.aplicativo3a.ListagemParceiros;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.entitiy.ParceiroEntity;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentoListarParceirosAdapter extends RecyclerView.Adapter<FragmentoListarParceirosAdapter.ViewHolder> {
    private List<ParceiroEntity> parceiroList;
    OnRecyclerViewSelected onRecyclerViewSelected;
    private Context context;

    FragmentoListarParceirosAdapter(List<ParceiroEntity> list, Context context){
        this.parceiroList=list;
        this.context = context;
    }

    //infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.parceiros_item_list, parent, false);
        return new ViewHolder(v);
    }

    //seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ParceiroEntity parceiroEntity = parceiroList.get(position);
        holder.txNomeParceiro.setText(parceiroEntity.getNome());
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return parceiroList.size();
    }

    //mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nome_parceiro)
        TextView txNomeParceiro;

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
