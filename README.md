# Algorithm

Tips.
- 정수형 범위를 의식해서 Long Type을 고려하자.
- 입력값이 크다면 Buffered를 고려하자.

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

---
#### 숫자 공식

**나머지 성질**: `(A+B+C)%M = (A%M + B%M + C%M) % M`

**nC2** (조합, n개 중 2개를 뽑는 경우의 수): `(n) * (n - 1) / 2` 

참고- https://whitehairhan.tistory.com/367
