package com.example.pibicproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pibicproject.R;
import com.example.pibicproject.model.Movimentacao;

import java.util.List;

public class AdapterMovimentacao extends RecyclerView.Adapter<AdapterMovimentacao.MyViewHolder>
{
    List<Movimentacao> movimentacoes;
    Context context;


    public AdapterMovimentacao(List<Movimentacao> movimentacoes, Context context)
    {
        this.movimentacoes = movimentacoes;
        this.context = context;


    }

    //para inflar o layout

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType)
    {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_movimentacao, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Movimentacao movimentacao = movimentacoes.get(position);
      //  holder.problema.setText(movimentacao.getTipoProblemaEnum());
     //   holder.prioridade.setText(movimentacao.getValor());
        holder.prioridade.setText("alguma coisa");


    }

    @Override
    public int getItemCount() {
        return movimentacoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView problema;
        public TextView prioridade;


        public MyViewHolder (View itemView)
        {
            super(itemView);
            problema = itemView.findViewById(R.id.textAdapterProblemas);

            prioridade = itemView.findViewById(R.id.textAdapterPrioridade);


        }



    }



}
