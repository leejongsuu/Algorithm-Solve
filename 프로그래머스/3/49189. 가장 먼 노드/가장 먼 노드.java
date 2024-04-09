import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 인접 리스트 생성
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // 그래프 정보를 인접 리스트에 저장
        for(int i = 0; i < edge.length; i++) {
            int s = edge[i][0];
            int e = edge[i][1];
            adjList.get(s).add(e);
            adjList.get(e).add(s);
        }
        
        // BFS를 통해 1번 노드부터 탐색하여 가장 멀리 떨어진 노드의 개수 구하기
        answer = BFS(n, adjList);
        
        return answer;
    }
    
    // BFS 구현
    public int BFS(int n, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[n + 1]; // 방문 여부 체크
        visited[1] = true; // 1번 노드 방문 처리
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 시작 노드인 1을 큐에 삽입
        
        int count = 0; // 가장 멀리 떨어진 노드의 개수를 저장할 변수
        while(!queue.isEmpty()) {
            int size = queue.size(); // 현재 큐에 있는 노드의 개수
            count = size; // 현재 레벨의 노드 개수를 count에 저장
            for(int i = 0; i < size; i++) {
                int current = queue.poll(); // 큐에서 하나의 노드를 꺼냄
                for(int next : adjList.get(current)) { // 인접한 노드들에 대해서
                    if(!visited[next]) { // 방문하지 않았다면
                        visited[next] = true; // 방문 처리
                        queue.offer(next); // 큐에 삽입
                    }
                }
            }
        }
        return count; // 가장 멀리 떨어진 노드의 개수 반환
    }
}