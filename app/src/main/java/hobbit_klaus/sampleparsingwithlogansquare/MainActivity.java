package hobbit_klaus.sampleparsingwithlogansquare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.imageView) ImageView imageView;
  @Bind(R.id.tvName) TextView tvName;
  @Bind(R.id.tvBlog) TextView tvBlog;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    GitHubApi.GitHubService service = GitHubApi.getApiService();
    service.getUser("octocat").subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(
        user -> {
          Glide.with(MainActivity.this).load(user.getAvatar_url()).into(imageView);
          tvName.setText(user.getName());
          tvBlog.setText(user.getBlog());
        },
        error -> Log.v("error", "error ::: " + error.getMessage()),
        () -> Log.v("complete", "Complete")
    );
  }

  @OnClick(R.id.tvBlog) public void onClick() {
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(this.tvBlog.getText().toString())));
  }
}
