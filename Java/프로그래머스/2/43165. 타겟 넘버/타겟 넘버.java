class Solution {
    int answer;
    int[] numbers;
    int target;

    void dfs(int idx, int sum) {
        //1. 탈출 조건
        if (idx == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }
        //2. 수행작업
        dfs(idx+1, sum + numbers[idx]);
        dfs(idx+1, sum - numbers[idx]);
    }
    public int solution(int[] numbers, int target) {
        /**
         * 재귀로 불러야 해서 지속적으로 공유해야 하는 값 >> 멤버변수로 정의
         * 탈출조건과 수행작업 정의
         * 로직 검토 필수 (간단한 tc 로 작성해보기)
         * dfs로 시간복잡도가 최악의 경우 500만번이 넘지 않는지 확인, 넘을 경우 dfs 사용 X
         */
        answer = 0;
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);
        return answer;
    }
}