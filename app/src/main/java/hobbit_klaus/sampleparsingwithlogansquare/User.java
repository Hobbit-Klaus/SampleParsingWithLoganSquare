package hobbit_klaus.sampleparsingwithlogansquare;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject public class User {
  @JsonField private String name;
  @JsonField private String blog;
  @JsonField private String avatar_url;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBlog() {
    return blog;
  }

  public void setBlog(String blog) {
    this.blog = blog;
  }

  public String getAvatar_url() {
    return avatar_url;
  }

  public void setAvatar_url(String avatar_url) {
    this.avatar_url = avatar_url;
  }
}
