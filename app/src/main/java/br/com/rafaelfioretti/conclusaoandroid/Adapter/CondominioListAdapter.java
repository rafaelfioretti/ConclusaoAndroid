package br.com.rafaelfioretti.conclusaoandroid.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;

import br.com.rafaelfioretti.conclusaoandroid.R;
import br.com.rafaelfioretti.conclusaoandroid.listener.OnClickListener;
import br.com.rafaelfioretti.conclusaoandroid.model.Condominio;

/**
 * Created by rafaelfioretti on 11/19/16.
 */

public class CondominioListAdapter extends RecyclerView.Adapter<CondominioListAdapter.CondominiosViewHolder>  {

    private Context context;
    private List<Condominio> condominios;
    private OnClickListener onClickListener;

    public CondominioListAdapter(Context context, List<Condominio> condominios, OnClickListener onClickListener){
        this.context = context;
        this.condominios = condominios;
        this.onClickListener = onClickListener;

    }

    public Condominio getItem(int position){
        return condominios.get(position);
    }

    public void removeAt(int position) {
        condominios.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, condominios.size());
    }

    @Override
    public CondominiosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                 .inflate(R.layout.condominio_row, parent, false);

        return new CondominiosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CondominiosViewHolder holder, final int position) {
        holder.tvCond.setText(condominios.get(position).getNome());
        holder.tvEnd.setText(condominios.get(position).getEndereco());
        holder.tvSind.setText(condominios.get(position).getSindico());
        holder.tvBlocos.setText(condominios.get(position).getBlocos()+ " Bloco(s)");

        if (onClickListener != null){
            holder.ibEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(holder.itemView, position, 1);
                }
            });
        }

        if (onClickListener != null){
            holder.ibExcluir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(holder.itemView, position, 2);
                }
            });
        }



    }




    @Override
    public int getItemCount() {
        return condominios.size();
    }


    public static class CondominiosViewHolder extends RecyclerView.ViewHolder{

        TextView tvCond;
        TextView tvEnd;
        TextView tvSind;
        TextView tvBlocos;
        ImageButton ibEditar;
        ImageButton ibExcluir;


        public CondominiosViewHolder(View itemView) {
            super(itemView);

            tvCond = (TextView) itemView.findViewById(R.id.tvcond);
            tvEnd = (TextView) itemView.findViewById(R.id.tvEnd);
            tvSind = (TextView) itemView.findViewById(R.id.tvSindico);
            tvBlocos = (TextView) itemView.findViewById(R.id.tvBlocos);
            ibEditar = (ImageButton) itemView.findViewById(R.id.ibEditar);
            ibExcluir = (ImageButton) itemView.findViewById(R.id.ibDeletar);


        }
    }
}
