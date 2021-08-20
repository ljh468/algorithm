# 내풀이
def solution(left, right):
    arr = []
    answer = 0
    for num in range(left, right+1):

        for i in range(1, num+1):
            if num % i == 0:
                arr.append(i)
        if len(arr) % 2 == 0:
            answer += num
        else:
            answer -= num
        arr = []
    return answer
print(solution(24, 27))

# 모범 풀이 ( 제곱수의 약수의 갯수는 항상 홀수이다.)
def solution2(left, right):
    answer = 0
    for i in range(left,right+1):
        if int(i**0.5)==i**0.5:
            answer -= i
        else:
            answer += i
    return answer

import math

def solution3(left, right):
    answer = 0
    for i in range(left, right + 1, 1):
        sqrt = math.sqrt(i)
        if int(sqrt) == sqrt:
            answer -= i
        else:
            answer += i

    return answer