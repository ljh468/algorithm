import numpy as np

# 내 풀이
def solution(arr1, arr2):
    arr1 = np.array(arr1)
    arr2 = np.array(arr2)
    return (arr1 + arr2).tolist()

# 모범 풀이
def solution2(arr1,arr2):
    for a, b in zip(arr1, arr2):
        print('a : ', a)
        print('b : ', b)
        for c, d in zip(a, b):
            print('c : ', c)
            print('d : ', d)

    answer = [[c + d for c, d in zip(a, b)] for a, b in zip(arr1,arr2)]
    return answer

arr1 = [[1,2],[2,3]]
arr2 = [[3,4],[5,6]]
print(solution(arr1, arr2))
print(solution2(arr1, arr2))