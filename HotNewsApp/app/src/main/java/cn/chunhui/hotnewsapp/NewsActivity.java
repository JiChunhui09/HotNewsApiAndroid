package cn.chunhui.hotnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cn.chunhui.hotnewsapp.model.HeadlineArticle;

public class NewsActivity extends AppCompatActivity implements View.OnClickListener{
    HeadlineArticle headlineArticle;
    TextView newsTitle, author, postTime, newsDetail, newsContent;
    ImageView imageView;
    Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initialize();
    }

    private void initialize(){
        headlineArticle = (HeadlineArticle) getIntent().getSerializableExtra("data");
        newsTitle = findViewById(R.id.newsTitleDetail);
        author = findViewById(R.id.newsAuthorDetail);
        postTime = findViewById(R.id.newsPostTimeDetail);
        newsDetail = findViewById(R.id.newsDetailDetail);
        newsContent = findViewById(R.id.newsDetailContent);
        imageView = findViewById(R.id.newsImageDetail);

        returnBtn = findViewById(R.id.returnButton);
        returnBtn.setOnClickListener(this);

        newsTitle.setText(headlineArticle.getTitle());
        author.setText(headlineArticle.getAuthor());
        postTime.setText(headlineArticle.getPublishedAt());
        newsDetail.setText(headlineArticle.getDescription());
        newsContent.setText(headlineArticle.getContent());
        Picasso.get().load(headlineArticle.getUrlToImage()).into(imageView);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.returnButton){
            finish();
        }
    }
}