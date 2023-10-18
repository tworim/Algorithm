package Bstudy.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class b2920 {
    static int[] dx = {0,1,1};
    static int[] dy = {1,1,0};
    static String[][] arr;
    static boolean[][] ch;

    public static void Block(int x, int y,int m,int n){
        String str = arr[x][y];

        for(int i=0;i<3;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<1 || ny<1 || nx>m || ny>n || arr[nx][ny] == null || !arr[nx][ny].equals(str)){
                return;
            }
        }
        //네개 다 일치해야만 for 문을 다돌고 나올수있기때문에
        ch[x][y] = true;
        for(int i=0;i<3;i++){
            ch[x + dx[i]][y + dy[i]] = true;
        }

    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        arr = new String[m+1][n+1];
        boolean flag = false;


        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                arr[i][j] = String.valueOf(board[i-1].charAt(j-1)); // 고침
            }
        }


        while(true){
            ch = new boolean[m+1][n+1];
            int tmp = answer;
            for(int i=1;i<=m-1;i++){
                for(int j=1;j<=n-1;j++){
                    if(arr[i][j] != null ){
                        Block(i,j,m,n);
                    }

                }
            }

            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(ch[i][j] == true) answer++;
                }
            } //ch에서 true 인거 개수세기
            if(answer == tmp) break;

            Stack<String> s = new Stack<>();
            // s.push(" ");

            for(int j=1;j<=n;j++){
                for(int i=1;i<=m;i++){
                    if(arr[i][j] != null && ch[i][j]==false){
                        s.push(arr[i][j]);
                    }
                } // 위에서 아래 순으로 stack 에 넣ㅎ음
                s.push(" ");
            }
            s.pop(); // 마지막 맨위는 무조건 ""일테니까 우선 빼두기

            arr = new String[m+1][n+1];



            for(int j=n;j>=1;j--){
                int cnt = 0;
                for(int i=m;i>=1;i--){
                    if(!s.isEmpty()){
                        String str2 = s.pop();
                        if (cnt<m && str2.equals(" ")){
                            break;
                        }else if(!str2.equals(" ")){
                            arr[i][j] = str2;
                            cnt++;
                            if(i == 1) s.pop();
                        }
                    }

                }
            }

            //여기서 ch배열에서 true인 개수가 그 당시 지워지는 ........ 개수임 answer
            //answer의 개수가 이전과 동일하면 더해지는게없으면 더이상 끝나는거니까 flag = true로변경

            //지워지면이제 그걸 없애고 위에있는 내용들이 내려와야함 이거는 아직 생각해야함



        }



        return answer;
    }

    public static void main(String[] args) throws IOException {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4,5,board));

    }

}
