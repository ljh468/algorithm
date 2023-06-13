# 내 풀이
def solution(a, b):
    answer = 0
    return sum([answer+i for i in range(min(a, b), max(a, b)+1)])

# 내 풀이2
def solution2(a, b):
    return sum(range(min(a, b), max(a, b)+1))

# 모범 풀이
def solution3(a, b):
    if a > b: a, b = b, a
    return sum(range(a,b+1))

# 등차수열 풀이
def solution4(a, b):
    return (abs(a-b)+1)*(a+b)//2
           # 항의 개수 * 첫항,끝항의 합 / 2
a = 5
b = 3
print(solution4(a, b))

