# 내 풀이
def solution(n):
    answer = 0
    for i in range(1, n + 1):
        s = 0
        for j in range(i, n + 1):
            s += j
            if s == n:
                answer += 1
                break
            if s > n:
                break
    return answer


# 모범 풀이
def solution2(num):
    return len([i for i in range(1, num + 1, 2) if num % i is 0])


n = 15
print(solution(n))
print(solution2(n))
