### 분류

DFS

### 문제 설명

<p>
!https://cote.inflearn.com/public/upload/8f99ebbe8d.jpg

로 계산합니다.

하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.

!https://cote.inflearn.com/public/upload/b4a8e9f795.jpg
</p>


### 입력

 <p>첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.</p>

### 출력

 <p>첫째 줄에 조합수를 출력합니다.</p>

### 풀이 

<p>

메모이제이션 사용해서 시간 비용을 줄였다.

dis[n+1][r+1]로 크기 해둔 이유 → 예를 들어 5C3이라고하면 n과 r은 각각 5와 3보다 계속 작아짐

(n-1, r-1)
</p>
