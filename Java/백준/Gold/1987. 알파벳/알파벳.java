import java.util.*;


public class Main {
    
    static int r, c;
    static String[][] arr;
    static int[][] ch;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Set<String> used;

    static int answer;


    public int solution() {
        /*
          상하좌우 중 한 칸
        * 첫째 줄에 말이 지날 수 있는 최대의 칸 수
        * */
        answer = 0;

        used.add(arr[0][0]);
        DFS(0, 0, 1);

        return answer;
    }


    public void DFS(int x, int y, int L) {
        boolean flag = true;
        for (int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y + dy[i];

            if (nx>=0&& nx<r&& ny>=0&& ny<c&& ch[nx][ny]==0&& !used.contains(arr[nx][ny])) {
                used.add(arr[nx][ny]);
                ch[nx][ny] = 1;
                flag = false;
                DFS(nx, ny, L+1);
                used.remove(arr[nx][ny]);
                ch[nx][ny] = 0;
            }
        }
        if (flag) answer = Math.max(answer, L);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main main = new Main();
        r = kb.nextInt();
        c = kb.nextInt();
        arr = new String[r][c];
        ch = new int[r][c];
        used = new HashSet<>();
        kb.nextLine();
        for (int i=0; i<r; i++) {
            String s = kb.nextLine().replace(" ", "");
            arr[i] = s.split("");
        }

        System.out.println(main.solution());
    }
}
