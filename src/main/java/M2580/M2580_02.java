package main.java.M2580;

import java.io.*;
import java.util.StringTokenizer;

public class M2580_02 {

    static int[][] map = new int[9][9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
            스도쿠 판 셋팅
            빈 칸의 경우 0으로 입력
         */
        for(int i=0 ; i<9 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0 ; j<9 ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    private static void sudoku(int row, int col) throws IOException{
        /*
            한 행의 모든 열을 탐색했다면 다음 행 탐색
         */
        if(col == 9){
            sudoku(row+1, 0);
            return;
        }

        /*
            모든 행과 열을 탐색했다면 결과 출력하고 시스템 종료
         */
        if(row == 9){
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

        /*
            빈 칸인 경우 1~9까지 입력 가능한 숫자를 체크하고 입력
         */
        if(map[row][col] == 0){
            for(int i=1 ; i<=9 ; i++){
                if(check(row, col, i)){
                    map[row][col] = i;
                    sudoku(row, col+1);
                    map[row][col] = 0; //https://1-7171771.tistory.com/62
                }
            }
        }else{
            sudoku(row, col+1);
        }
    }

    private static boolean check(int row, int col, int comp){
        /*
            같은 행에 comp와 겹치는 숫자가 있는지 확인한다.
         */
        for(int i=0 ; i<9 ; i++){
            if(map[row][i] == comp){
                return false;
            }
        }

        /*
            같은 열에 comp와 겹치는 숫자가 있는지 확인한다.
         */
        for(int i=0 ; i<9 ; i++){
            if(map[i][col] == comp){
                return false;
            }
        }

        /*
            3*3 안에 comp와 겹치는 숫자가 있는지 확인한다.
            comp가 포함된 3*3 판을 검사해야한다.
         */
        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;
        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (map[i][j] == comp) {
                    return false;
                }
            }
        }

        return true;
    }
}
