# Algorithm

Tips.
웬만하면 Long Type으로 선언하자.

---
#### 구간의 합
```
   s[i] = s[i] + a[i], 연속되는 특정 Index 까지의 합을 구할 때
```
[q11660번: 구간 합 구하기2](https://www.acmicpc.net/problem/11660)
[q10986번: 나머지 합 구하기](https://www.acmicpc.net/problem/10986)

#### 투 포인트
```
   2개의 변수 startIndex, endIndex를 조건에 따라 증가시키며 특정 구간의 합을 계산할 때
```

[q2018번 : 수들의 합 5](https://www.acmicpc.net/problem/2018)

---
### 숫자 공식

**나머지 성질**: `(A+B+C)%M = (A%M + B%M + C%M) % M`

**nCm** (경우의 수, n개 중 m개를 뽑는 경우의 수): `(n) * (n - 1) / 2`
