package com.example.bruno.aplicativo3a.Eventos.ListagemEventos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.Entity.EventoEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListarEventosAdapter extends RecyclerView.Adapter<ListarEventosAdapter.ViewHolder> {
    private List<EventoEntity> eventoList;
    OnRecyclerViewSelected onRecyclerViewSelected;
    private Context context;

    ListarEventosAdapter(List<EventoEntity> list, Context context){
        this.eventoList=list;
        this.context = context;
    }

    //infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventos_item_list, parent, false);
        return new ViewHolder(v);
    }

    //seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EventoEntity eventoEntity = eventoList.get(position);
        holder.txTituloEvento.setText(eventoEntity.getTitulo());
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return eventoList.size();
    }

    //mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titulo_evento)
        TextView txTituloEvento;

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
