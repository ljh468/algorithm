# 재귀함수 풀이
def solution(n):
    if (n == 0):
        return 0
    if (n == 1):
        return 1
    return (solution(n-2)%1234567 + solution(n-1)%1234567) % 1234567

# 반복문 풀이
def solution2(num):
    a, b = 0, 1
    if num < 2:
        return num

    for x in range(num-1):
        a, b = b, a + b
    return b % 1234567

n = 3
print(solution(n))
print(solution2(n))