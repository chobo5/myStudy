import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3003 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    StringTokenizer st = new StringTokenizer(line, " ");
    int king = Integer.parseInt(st.nextToken()); // 1
    int queen = Integer.parseInt(st.nextToken()); //1
    int rook = Integer.parseInt(st.nextToken()); //2
    int bishop = Integer.parseInt(st.nextToken()); //2
    int knight = Integer.parseInt(st.nextToken()); //2
    int pone = Integer.parseInt(st.nextToken()); //8
    
    System.out.print(1 - king);
    System.out.print(" ");
    System.out.print(1- queen);
    System.out.print(" ");
    System.out.print(2 - rook);
    System.out.print(" ");
    System.out.print(2 - bishop);
    System.out.print(" ");
    System.out.print(2 - knight);
    System.out.print(" ");
    System.out.print(8 - pone);


  }
}
