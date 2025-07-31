package stackoverflow;

import java.util.UUID;

public class Comment {

    private final String id;
    private final User author;
    private final String content;


    public Comment(User author, String content) {
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.content = content;
    }


    public String getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
