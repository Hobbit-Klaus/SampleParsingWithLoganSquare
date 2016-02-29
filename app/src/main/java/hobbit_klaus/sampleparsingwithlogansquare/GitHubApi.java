package hobbit_klaus.sampleparsingwithlogansquare;

import com.github.aurae.retrofit2.LoganSquareConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public class GitHubApi {
  private static final GitHubService API_SERVICE =
      new Retrofit.Builder().baseUrl("https://api.github.com")
          .addConverterFactory(LoganSquareConverterFactory.create())
          .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
          .build()
          .create(GitHubService.class);

  public static GitHubService getApiService() {
    return API_SERVICE;
  }

  interface GitHubService {
    @GET("/users/{id}") Observable<User> getUser(@Path("id") String id);
  }
}
