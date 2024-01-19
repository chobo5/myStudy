package io;

import java.io.*;

public class Ex2 {
  public static void main(String[] args) throws IOException {
    Writer writer = new BufferedWriter(new FileWriter("temp/test2.txt"));
    char c1 = '이';
    char c2 = 'j';

    char[] cs = {'그', '러', '나', 'b', 'u', 't'};
    writer.write(c1);
    writer.write(c2);
    writer.write(cs);
    writer.flush();
    writer.close();


    Reader reader = new BufferedReader(new FileReader("temp/test2.txt"));
    int i;
    while ((i = reader.read()) != -1) {
      System.out.println((char) i);
    }
    reader.close();

//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String str;
//    while (!(str = br.readLine()).equals("-1")) {
//      System.out.println(str);
//    }
//    br.close();

    DataOutputStream out = new DataOutputStream(new FileOutputStream("./temp/test3.txt"));
    out.writeUTF("안녕하세요");
    out.writeUTF("하지만");
    out.writeUTF("however");
    out.writeUTF("nevertheless");
    out.flush();
    out.close();

    DataInputStream in = new DataInputStream(new FileInputStream("./temp/test3.txt"));
    for (int j = 0; j < 4 ; j++) {
      System.out.println(in.readUTF());
    }



  }
}
