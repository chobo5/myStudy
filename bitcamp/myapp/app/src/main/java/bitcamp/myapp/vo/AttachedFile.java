package bitcamp.myapp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder //이 객체는 빌더를 통해서 만들어라
@Data
public class AttachedFile {

  private int no;
  private String filePath;
  private int boardNo;

}
