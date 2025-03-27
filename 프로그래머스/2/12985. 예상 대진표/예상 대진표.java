class Solution
{
    public int solution(int n, int a, int b)
    {
        // 1 2 3 4 5 6 7 8
        
        int answer = 0;
        while(true) {
            answer++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            if(a == b) {
                return answer;
            }
        }
    }
}