package cn.chunhui.hotnewsapp;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView textTitle, textSource;
    ImageView imageHeadlineNews;
    CardView cardView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        textTitle = itemView.findViewById(R.id.titleText);
        textSource = itemView.findViewById(R.id.sourceText);
        imageHeadlineNews = itemView.findViewById(R.id.headlineImageView);
        cardView = itemView.findViewById(R.id.cardView);
    }
}
