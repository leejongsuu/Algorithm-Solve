
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        int A = Math.min(a, b) - 1;
        int B = Math.max(a, b) - 1;
        
        while(A != B) {
            A/=2;
            B/=2;
            answer++;
        }
            
        return answer;
    }
}