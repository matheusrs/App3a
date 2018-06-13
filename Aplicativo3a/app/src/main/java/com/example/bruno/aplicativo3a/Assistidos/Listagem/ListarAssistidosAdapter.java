package com.example.bruno.aplicativo3a.Assistidos.Listagem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListarAssistidosAdapter extends RecyclerView.Adapter<ListarAssistidosAdapter.ViewHolder> {
    private List<AssistidoEntity> assistidoList;
    OnRecyclerViewSelected onRecyclerViewSelected;
    private Context context;

    ListarAssistidosAdapter(List<AssistidoEntity> list, Context context){
        this.assistidoList=list;
        this.context = context;
    }

    //infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.assistidos_item_list, parent, false);
        return new ViewHolder(v);
    }

    //seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AssistidoEntity assistidoEntity = assistidoList.get(position);
        holder.txNomeAssistido.setText(assistidoEntity.getNome());
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return assistidoList.size();
    }

    //mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nome_assistido)
        TextView txNomeAssistido;


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
