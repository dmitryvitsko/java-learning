public class PostComment {
    private String text;
    private String[] whoLiked;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getWhoLiked() {
        return whoLiked;
    }

    public void setWhoLiked(String[] whoLiked) {
        this.whoLiked = whoLiked;
    }

    @Override
    public String toString() {
        String str = "";
            str = "PostComment{text=\'" + getText() + "\', whoLiked=";
            if (getWhoLiked() != null) {
                for (int i = 0; i < whoLiked.length; i++) {
                    if (i == 0) str += "[" + whoLiked[i];
                    else str += whoLiked[i];
                    if (i != whoLiked.length - 1) {
                        str += ", ";
                    }
                }
                str += "]";
            }
            else {
                    str += "null";
                }
                str += "}";
        return str;
    }
}