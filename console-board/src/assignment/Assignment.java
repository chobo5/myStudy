package assignment;

public class Assignment {

    private String title;
    private String content;
    private String deadline;

    public Assignment(String title, String content, String deadline) {
        this.title = title;
        this.content = content;
        this.deadline = deadline;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "assignment.Assignment{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
