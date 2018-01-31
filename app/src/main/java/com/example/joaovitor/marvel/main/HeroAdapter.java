package com.example.joaovitor.marvel.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joaovitor.marvel.R;
import com.example.joaovitor.shared.HeroModel;
import com.example.joaovitor.shared.model.APICharacter;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by joaovitor on 30/08/17.
 */

public class HeroAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<APICharacter> list;

    public HeroAdapter(List<APICharacter> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Cria a célula
        return new ViewHolderHero(LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_hero, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //preenche cada celula com imagem e texto
        ViewHolderHero viewHolderHero = (ViewHolderHero) holder;
        APICharacter apiCharacter = list.get(position);
        viewHolderHero.profileName.setText(apiCharacter.getName());
        Picasso.with(viewHolderHero.profileImage.getContext())
                .load(apiCharacter.getThumbnail().getUrl())
                .into(viewHolderHero.profileImage);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolderHero extends RecyclerView.ViewHolder {

        @Bind(R.id.profile_image)
        ImageView profileImage;

        @Bind(R.id.profile_name)
        TextView profileName;

        public ViewHolderHero(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
