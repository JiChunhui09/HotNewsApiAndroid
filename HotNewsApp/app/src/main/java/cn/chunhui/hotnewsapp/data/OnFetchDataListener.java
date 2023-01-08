package cn.chunhui.hotnewsapp.data;

import java.util.ArrayList;

import cn.chunhui.hotnewsapp.model.HeadlineArticle;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(ArrayList<HeadlineArticle>list, String message);
    void onError(String message);
}
