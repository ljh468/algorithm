import numpy as np
def solution(arr1, arr2):
    answer = [[]]
    arr1 = np.array(arr1)
    arr2 = np.array(arr2)

    answer = arr1.dot(arr2).tolist()
    return answer

# 모범 풀이
def solution2(arr1, arr2):
    return [[sum(a*b for a, b in zip(A_row,B_col)) for B_col in zip(*arr2)] for A_row in arr1]

print('###########################################################################')

arr1 = [[2, 3, 2],
        [4, 2, 4],
        [3, 1, 4]]
arr2 = [[5, 4, 3],
        [2, 4, 1],
        [3, 1, 1]]
print(solution(arr1, arr2))
print(solution2(arr1, arr2))