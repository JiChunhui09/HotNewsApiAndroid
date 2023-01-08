package cn.chunhui.hotnewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cn.chunhui.hotnewsapp.click.SelectListener;
import cn.chunhui.hotnewsapp.model.HeadlineArticle;
import cn.chunhui.hotnewsapp.model.NewsApiResponse;

public class ItemControllerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private ArrayList<HeadlineArticle>headlineArticles;
    private SelectListener listener;

    public ItemControllerAdapter(Context context, ArrayList<HeadlineArticle> headlineArticles,
                                 SelectListener listener) {
        this.context = context;
        this.headlineArticles = headlineArticles;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_controller,
                parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.textTitle.setText(headlineArticles.get(position).getTitle());
        holder.textSource.setText(headlineArticles.get(position).getSource().getName());
        if(headlineArticles.get(position).getUrlToImage() != null){
            Picasso.get().load(headlineArticles.get(position).getUrlToImage()).into(
                    holder.imageHeadlineNews
            );
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNewsClicked(headlineArticles.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlineArticles.size();
    }
}
