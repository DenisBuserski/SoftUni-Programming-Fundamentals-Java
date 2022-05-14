package Articles_20_04;

public class Articles20 {
    private String title;
    private String content;
    private String author;

    public Articles20 (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " - " + content + ": " + author;
    }
    
}
