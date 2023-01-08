package cn.chunhui.hotnewsapp;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import cn.chunhui.hotnewsapp.click.SelectListener;
import cn.chunhui.hotnewsapp.data.OnFetchDataListener;
import cn.chunhui.hotnewsapp.data.RequestManager;
import cn.chunhui.hotnewsapp.model.HeadlineArticle;
import cn.chunhui.hotnewsapp.model.NewsApiResponse;

public class MainActivity extends AppCompatActivity implements
        SelectListener,
        View.OnClickListener{

    RecyclerView recyclerView;
    ItemControllerAdapter adapter;
    ProgressDialog dialog;
    Button businessBtn,entertainmentBtn,generalBtn,healthBtn,scienceBtn,sportsBtn,technologyBtn;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,"general",null);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading news articles...");
        dialog.show();
        initializeButton();
        initializeSearch();
    }

    private final OnFetchDataListener<NewsApiResponse>listener
            = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(ArrayList<HeadlineArticle> list, String message) {
            if(list.isEmpty()){
                Toast.makeText(MainActivity.this,
                        "No data match.", Toast.LENGTH_SHORT).show();
            }
            showNews(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this,
                    "There is an Error.", Toast.LENGTH_SHORT).show();
        }
    };

    private void initializeButton(){
        businessBtn = findViewById(R.id.businessButton);
        businessBtn.setOnClickListener(this);
        entertainmentBtn = findViewById(R.id.entertainmentButton);
        entertainmentBtn.setOnClickListener(this);
        generalBtn = findViewById(R.id.generalButton);
        generalBtn.setOnClickListener(this);
        healthBtn = findViewById(R.id.healthButton);
        healthBtn.setOnClickListener(this);
        scienceBtn = findViewById(R.id.scienceButton);
        scienceBtn.setOnClickListener(this);
        sportsBtn = findViewById(R.id.sportsButton);
        sportsBtn.setOnClickListener(this);
        technologyBtn = findViewById(R.id.technologyButton);
        technologyBtn.setOnClickListener(this);
    }

    private void initializeSearch(){
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Loading news articles of "+query +"....");
                dialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getNewsHeadlines(listener,"general",query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void showNews(ArrayList<HeadlineArticle> list) {
        recyclerView = findViewById(R.id.recycleMainView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(
                new GridLayoutManager(this,1));
        adapter = new ItemControllerAdapter(this,list,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onNewsClicked(HeadlineArticle headlineArticle) {
        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
        intent.putExtra("data",headlineArticle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String category = button.getText().toString();
        dialog.setTitle("Loading news articles of " + category + "....");
        dialog.show();
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,category,null);
    }
}