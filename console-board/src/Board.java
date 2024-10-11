public class Board {

    private Member writer;
    private String title;
    private String content;

    public Board(Member writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Member getWriter() {
        return writer;
    }

    public void setWriter(Member writer) {
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
        return "작성자: '" + writer.getName() + '\'' +
                ", 제목: '" + title + '\'' +
                ", 내용: '" + content + '\'';
    }
}
