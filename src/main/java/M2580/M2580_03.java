package main.java.M2580;

import java.io.*;
import java.util.StringTokenizer;

public class M2580_03 {

    static int[][] map = new int[9][9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0 ; i<9 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0 ; j<9 ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
        br.close();
    }

    private static void sudoku(int row, int col) throws IOException{

        //한 행의 끝 열까지 다 탐색했다.
        if(col == 9){
            sudoku(row+1, 0);
            return;
        }

        //전체 판을 다 탐색했다.
        if(row == 9){
            //출력하고 시스템 종료
            for(int i=0 ; i<9 ; i++){
                for(int j=0 ; j<9 ; j++){
                    bw.append(String.valueOf(map[i][j])).append(" ");
                }
                bw.append("\n");
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }

        if(map[row][col] == 0){
            for(int i=1 ; i<=9 ; i++){
                if(check(row, col, i)){
                    map[row][col] = i;
                    sudoku(row, col+1);
                    map[row][col] = 0;
                }
            }
        }else{
            sudoku(row, col+1);
        }
    }

    private static boolean check(int row, int col, int comp){
        //같은 행에 겹치는 수가 있는지 확인
        for(int i=0 ; i<9 ; i++){
            if(map[row][i] == comp){
                return false;
            }
        }

        //같은 열에 겹치는 수가 있는지 확인
        for(int i=0 ; i<9 ; i++){
            if(map[i][col] == comp){
                return false;
            }
        }

        //3*3범위에 겹치는 수가 있는지 확인
        int set_row = (row/3) * 3;
        int set_col = (col/3) * 3;
        for(int i=set_row ; i<set_row+3 ; i++){
            for(int j=set_col ; j<set_col+3 ; j++){
                if(map[i][j] == comp){
                    return false;
                }
            }
        }

        return true;

    }
}
