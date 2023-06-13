import math
# 내 풀이
def solution(n):
    answer = 0
    if math.sqrt(n) == int(math.sqrt(n)):
        return int(math.sqrt(n) + 1) **2
    else:
        return -1

# 모범 풀이
def solution2(n):
    sqrt = n ** (1/2)

    if sqrt % 1 == 0:
        return (sqrt + 1) ** 2
    return -1

n = 3
print(solution(n))
print(solution2(n))