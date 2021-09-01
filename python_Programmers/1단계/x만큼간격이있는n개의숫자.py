def solution(x, n):
    answer = []
    for i in range(1, n+1):
        answer.append(x * i)
    return answer


# 모범풀이
def solution2(x, n):
    return [x*(i+1) for i in range(n)]

x = -4
n = 2
print(solution(x, n))
print(solution2(x, n))