package restassured.config;

public class PostsEndpoint {

    private String title;

    private String body;

    private String userId;

    private String id;

    private String postId;

    private String name;

    private String email;


    public PostsEndpoint() {

    }

    public PostsEndpoint(String title, String body, String userId, String id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getBody()
    {
        return body;
    }
    public void setBody(String body)
    {
        this.body=body;
    }
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId=userId;
    }
    public String getId()
    {
        return id;
    }
    public void SetId(String id)
    {
        this.id=id;
    }
    public String getPostId() {
        return postId;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", body = "+body+", userId = "+userId+", id = "+id+"]";
    }

}
