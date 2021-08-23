import numpy as np

a = [1,2,3,4]
b = [-3,-1,0,2]

# zip함수 활용
def solution(a, b):
    answer = [x*y for x,y in zip(a, b)]
    return sum(answer)


print(solution(a, b))

# NUMPY 활용
def solution2(a, b):
    answer = list(map(int,np.multiply(a, b)))
    return sum(answer)

print(solution2(a, b))