class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0, sum2 = 0;
        long[] arr = new long[n * 2];

        for (int i = 0; i < n; i++) {
            arr[i] = queue1[i];
            arr[i + n] = queue2[i];
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        long target = sum1 + sum2;
        if (target % 2 != 0) return -1;
        target /= 2;

        int left = 0, right = n;
        long curSum = sum1;
        int ops = 0;
        int maxOps = n * 3;

        while (left < arr.length && right < arr.length && ops <= maxOps) {
            if (curSum == target) return ops;

            if (curSum < target) {
                curSum += arr[right++];
            } else {
                curSum -= arr[left++];
            }
            ops++;
        }

        return -1;
    }
}
