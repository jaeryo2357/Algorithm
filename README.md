# Algorithm

Tips.
- 정수형 범위를 의식해서 Long Type을 고려하자.
- Buffer
   - 장점: 많은 데이터를 빠르 속도에 출력 가능. 따라서 시간이 민감하 문제에서 사용하면 좋다.
   - 단점: 중간에 버퍼가 가득 차게 되면 부분 출력을 시도하므로, 중간 계산에 따라서 결과 형식이 달라져야 하는 경우 실패할 가능성이 있음

---
### 구간의 합
```
   s[i] = s[i] + a[i], 연속되는 특정 Index 까지의 합을 구할 때
```
[q11660번: 구간 합 구하기2](https://www.acmicpc.net/problem/11660)
</br>
[q10986번: 나머지 합 구하기](https://www.acmicpc.net/problem/10986)

### 투 포인트
```
   2개의 변수 startIndex, endIndex를 조건에 따라 증가시키며 특정 구간의 합을 계산할 때,
    
   조건: 배열의 연속되는 수는 **정렬되어 있어야 함** (시간 복잡도 주의)
```

[q2018번 : 수들의 합 5](https://www.acmicpc.net/problem/2018)
</br>
[q1940번: 주몽](https://www.acmicpc.net/problem/1940)

### 슬라이드 윈도우
```
 투 포인트와 유사한 기법으로 특징은 고정된 구간에서 계산을 하는 것이 특징.
```
[q11003번: 최솟값 찾기](https://www.acmicpc.net/problem/11003)

> 슬라이드 윈도우를 이용해 정렬 구현하기 (Deque)

### 이진 탐색
```
 탐색 범위르 1/2로 줄여나가면서 원하는 요소를 찾는 방법. nlong

조건: 정렬이 되어 있어야 함
```
[q1920번: 원하는 정수 찾기](https://www.acmicpc.net/problem/1920)

### DFS / BFS
```
dfs: 깊이 우선 탐색
스택, 혹은 재귀를 이용하여 구현


bfs: 너비 우서 탐색
큐를 이용하여 구현

주의:
  무한 반복으로 하지 않도로 방문한 노드를 체크해야함
```
[q11724번: 연결 요소의 개수 구하기](https://www.acmicpc.net/problem/11724)


### Greedy
```
필요한 계산만 빠르게 하는 기법
```
[q1541번: 최솟값을 만드는 괄호 배치 찾기](https://www.acmicpc.net/problem/1541)

---
#### 숫자 공식

**나머지 성질**: `(A+B+C)%M = (A%M + B%M + C%M) % M`

**nC2** (조합, n개 중 2개를 뽑는 경우의 수): `(n) * (n - 1) / 2` 

참고- https://whitehairhan.tistory.com/367
