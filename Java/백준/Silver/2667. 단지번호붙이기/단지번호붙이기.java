import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     문제
     <그림 1>과 같이 정사각형 모양의 지도가 있다.
     1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
     철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
     여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
     대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
     지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

     입력
     첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

     출력
     첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

     예제 입력 1
     7
     0110100
     0110101
     1110101
     0000111
     0100000
     0111110
     0111000

     예제 출력 1
     3
     7
     8
     9
     */

    static int n, cnt;
    static int[][] grid, ch;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public List<Integer> solution() {
        /*1이 집, 0은 집없, 단지 수 세기*/
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j]==1 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    cnt =1;
                    DFS(i, j);
                    answer.add(cnt);
                }
            }
        }


        return answer;
    }


    public void DFS(int x, int y) {
        if (grid[x][y]==0) return;
        else {
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx>=0 && nx < n &&ny>=0 && ny < n && grid[nx][ny]==1 && ch[nx][ny]==0) {
                    ch[nx][ny] = 1;
                    cnt++;
                    DFS(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main main = new Main();
        n = kb.nextInt();
        kb.nextLine();
        grid = new int[n][n];
        ch = new int[n][n];
        for (int i=0; i<n; i++) {
            String str = kb.nextLine().replaceAll(" ", "");
            String[] arr = str.split("");
            for (int j=0; j<n; j++) {
                grid[i][j] = Integer.valueOf(arr[j]) ;
            }
        }

        List<Integer> result = main.solution();
        System.out.println(result.size());
        Collections.sort(result);
        for (int x: result) {
            System.out.println(x);
        }
    }
}
