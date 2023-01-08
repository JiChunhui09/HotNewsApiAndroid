package cn.chunhui.hotnewsapp.data;

import cn.chunhui.hotnewsapp.model.NewsApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CallNewsApi {
    @GET("top-headlines")
    Call<NewsApiResponse> callHeadlineArticles(
            @Query("country") String country,
            @Query("category") String category,
            @Query("q") String query,
            @Query("apiKey") String api_key
    );
}
