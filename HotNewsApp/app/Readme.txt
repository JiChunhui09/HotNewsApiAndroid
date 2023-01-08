Step for building an App with NewsApi
-by Chunhui

First Step: Choosing API
  01 - NewsApi: https://newsapi.org/v2/

  02 - Register for openweathermap API Key: 78d7d38543cb4cdaa7e0fe02a54ce294

  03 - Go to Documentation to get the Endpoints, to limit our loading data, can choose Headlines.

  04 - Test your end point: https://newsapi.org/v2/top-headlines?country=us&apiKey=78d7d38543cb4cdaa7e0fe02a54ce294
  
  05 - GET request parameters.

  06 - Postman to get the json format. 
     - download Postman: https://www.postman.com/downloads/
     - or just use online verson.

Manifest:
  01 - Add permission of INTERNET: <uses-permission android:name="android.permission.INTERNET" />

Layout:
  01 - MainActivity and NewsActivity

  02 - Single item layout for Recycle_view

Java:
  01 - Build models (Objects) according to the json format of End point.
     - Those models will be the whole response to receive the data objects from API.
     - The data should be an ArrayList of object(news articles).

  02 - Build View_Holder for each item.

  03 - Create Item_Adapter which extends RecycleView.Adapter with View_Holder.
     - In Adapter, there will be the ArrayList of data (Objects), where the MainActivity can get data.

  04 - For reading url of image and loading in view_holder, we can use the library called "Picasso".
     - Add dependency in Build_gradle: implementation 'com.squareup.picasso:picasso:2.71828'

  05 - In order to manage our requests, can use Retrofit library(or OkHttp, but not simply as Retrofit)
     - Add dependency in Build_gradle: implementation 'com.squareup.retrofit2:retrofit:2.9.0'
                                       implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

  06 - Create Request_Manager and an object for the Retrofit and make our api calls here.
     
  07 - Create interface to pass some queries that we want to make.

  08 - Create a listener class (interface) so we can handle the responses from MainActivity.
  
  09 - In MainActivity, call Request_Manager to call the Api.
     - Make sure all queries we pass are the same as api request.

  10 - Click item_cell to go to detailed page of news.
  








