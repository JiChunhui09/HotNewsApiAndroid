package cn.chunhui.hotnewsapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class NewsApiResponse implements Serializable {
    String status;
    int totalResults;
    ArrayList<HeadlineArticle>articles;

    public NewsApiResponse() {
    }

    public NewsApiResponse(String status, int totalResults, ArrayList<HeadlineArticle> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<HeadlineArticle> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<HeadlineArticle> articles) {
        this.articles = articles;
    }
}
