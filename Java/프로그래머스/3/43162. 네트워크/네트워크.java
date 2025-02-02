class Solution {
    private int[][] computers = null;
    private int n = 0;
    private boolean[] isVisited = null;
    private int answer=0;
    public int solution(int n, int[][] computers) {
        /**
         *
         * computers[][]를 전체 탐색하면서 방문한적이 없고 1인 경우, 
         * DFS() 재귀함수를 통해 계속 연결된 것을 찾기
         *
         * Solution 함수에서 전체를 탐색하면서 DFS() 함수가 한번 실행될때만 answer를 1 증가
         */
        this.n = n;
        this.computers = computers;
        isVisited = new boolean[n];

        for (int i = 0; i<n ; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                answer++;
                DFS(i);
            }
        }
        return answer;
    }

    void DFS(int computer) {
        for (int j=0 ; j < n ; j++) {
            if (computer==j) {
                continue;
            }
            if (computers[computer][j]==1 && !isVisited[j]) {
                isVisited[j] = true;
                DFS(j);
            }

        }
    }
}