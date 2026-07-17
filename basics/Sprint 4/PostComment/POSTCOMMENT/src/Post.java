import java.util.ArrayList;

public class Post {
    private String title;
    private String content;
    private String[] tags;
    private ArrayList<PostComment> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public ArrayList<PostComment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<PostComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        String str = "Post{title=\'" + getTitle() + "\', content.length=\'" + getContent().length() + "\', tags=[";
        for (int i = 0; i < tags.length; i++) {
            str += tags[i];
            if (i != tags.length - 1) {
                str += ", ";
            }
        }
        str += "], comments=[";
        for (int i = 0; i < comments.size(); i++) {
            str += comments.get(i).toString();
            if (i != comments.size() - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str + "}";
    }
}