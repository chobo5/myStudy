package io;

import java.io.*;

public class Ex1 {
  public static void main(String[] args) throws Exception {
//    File file = new File("temp");
//    file.mkdir();

    FileOutputStream out = new FileOutputStream("temp/test.txt");
    byte a = 12;
    byte b = 13;
    byte c = 14;
    byte d = 15;
    byte e = 16;

    byte[] bytes = {20, 30, 40, 50, 60, 70};

    out.write(a);
    out.write(b);
    out.write(c);
    out.write(d);
    out.write(e);

    out.write(bytes);
//    out.write(bytes, 0, 3);



    out.close();
    FileInputStream in = new FileInputStream("temp/test.txt");
    int i;
    while ((i = in.read()) != -1) {
      System.out.println(i);
    }
//    byte[] buf = new byte[3];
//    int count = in.read(buf);
//    for (int i = 0; i < count; i++) {
//      System.out.println(buf[i]);
//    }


    in.close();

  }
}
