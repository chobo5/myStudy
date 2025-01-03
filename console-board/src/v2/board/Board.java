package v2.board;

public class Board {

    private String writer;
    private String title;
    private String content;

    public Board(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }


    public void setWriter(String writer) {
        this.writer = writer;
    }

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

    @Override
    public String toString() {
        return "작성자: '" + writer + '\'' +
                ", 제목: '" + title + '\'' +
                ", 내용: '" + content + '\'';
    }
}
