import java.util.Stack;

class Solution {
    
    class Stock {
        int index;
        int price;
        
        public Stock(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }

    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] result = new int[len];

        Stack<Stock> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && stack.peek().price > prices[i]) {
                Stock stock = stack.pop();
                result[stock.index] = i - stock.index;
            }
            stack.push(new Stock(i, prices[i]));
        }
        
        while(!stack.isEmpty()) {
            Stock stock = stack.pop();
            result[stock.index] = len - (stock.index + 1);
        }
        return result;
    }
}