class Solution {
    public int solution(int chicken) {
        
        int coupon = 0;
        int serviceCount = 0;
        while(chicken > 0) {
            coupon += chicken;
            serviceCount += coupon / 10;
            chicken = coupon / 10;
            coupon %= 10;
        }
        
        return serviceCount;
    }
}
