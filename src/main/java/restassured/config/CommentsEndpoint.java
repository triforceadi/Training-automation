package restassured.config;

public class CommentsEndpoint {

    private String body;

    private String id;

    private String postId;

    private String name;

    private String email;

    public CommentsEndpoint() {

    }

    public CommentsEndpoint(String postId, String id, String name, String email, String body) {
        this.body = body;
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
        return "ClassPojo [id = "+id+", body = "+body+", postId = "+postId+", name = "+name+", email = "+email+"]";
    }
}
