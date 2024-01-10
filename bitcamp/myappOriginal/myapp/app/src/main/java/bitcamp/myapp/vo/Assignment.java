package bitcamp.myapp.vo;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

public class Assignment implements Serializable {

  @Serial
  private static final long serialVersionUID = 100L;
  private String title;
  private String content;
  private Date deadline;

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

  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }


  //펙토리 메서드
  public static Assignment createFromCsv(String csv) {
    String[] values = csv.split(",");
    Assignment obj = new Assignment();
    obj.setTitle(values[0]);
    obj.setContent(values[1]);
    obj.setDeadline(Date.valueOf(values[2]));
    return obj;
  }

  @Override
  public String toString() {
    return "Assignment{" +
            "title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", deadline=" + deadline +
            '}';
  }
}
