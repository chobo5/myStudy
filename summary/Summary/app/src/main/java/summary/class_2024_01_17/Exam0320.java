// 디렉토리 생성
package class_2024_01_17;

import java.io.File;

public class Exam0320 {

  public static void main(String[] args) throws Exception {

    File dir = new File("./Summary/temp");

    // 하위 디렉토리 생성하기
    //
    if (dir.mkdir()) {
      System.out.println("temp/a 디렉토리를 생성하였습니다.");
    } else {
      System.out.println("temp/a 디렉토리를 생성할 수 없습니다.");
    }
  }

}
