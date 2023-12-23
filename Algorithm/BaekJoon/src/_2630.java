import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(in.readLine());
//        int[][] square = new int[n][n];
//        StringTokenizer st;
//        for (int i = 0; i < n; i++) {
//            String line = in.readLine();
//            st = new StringTokenizer(line, " ");
//            for (int j = 0; j < n; j++) {
//                square[i][j] = Integer.parseInt(st.nextToken());
//
//            }
//
//
//        }
//    }

    public static int white = 0;
    public static int blue = 0;
    public static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int row,int col,int size) {
        if(checkColor(row,col,size)){
            if(paper[row][col]==0){
                white++;
            }else{
                blue++;
            }
            return;
        }
        int newSize = size/2;
        divide(row,col,newSize);
        divide(row,col+newSize,newSize);
        divide(row+newSize,col,newSize);
        divide(row+newSize,col+newSize,newSize);
    }
    public static boolean checkColor(int row, int col, int size){
        int color = paper[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(paper[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    }

}
