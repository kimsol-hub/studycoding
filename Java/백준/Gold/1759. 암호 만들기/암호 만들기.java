import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int l, c;
    static String[] arr;
    static String[] condition = {"a", "e", "i", "o", "u"};

    static String answer;


    public String solution(String s) {

        answer = "";
        arr = s.split(" ");
        Arrays.sort(arr);

        DFS(0, 0, 0);

        return answer;
    }


    public void DFS(int L, int idx, int cnt) {
        if (L==l) {
            /**
             * 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성 체크.
             */
            if (cnt > 0 && l-cnt >= 2) {
                System.out.println(answer);
            }
        } else {
            for (int i=idx; i<c; i++) {
                String tmp = answer;
                char t = arr[i].charAt(0);
                answer += arr[i];
                if(Arrays.stream(condition).anyMatch(s -> s.charAt(0) == t)) {
                    DFS(L+1, i+1, cnt+1);
                } else {
                    DFS(L+1, i+1, cnt);
                }
                answer = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main main = new Main();
        l = kb.nextInt();
        c = kb.nextInt();
        arr = new String[c];
        kb.nextLine();

        String s = kb.nextLine();
        main.solution(s);
    }
}
