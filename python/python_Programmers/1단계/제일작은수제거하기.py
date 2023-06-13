# 내풀이
def solution(arr):
    if len(arr) == 0 or arr == [10]:
        return [-1]
    arr.remove(min(arr))
    return arr

# 모범 풀이
def rm_small(arr):
    return [i for i in arr if i > min(arr)]or [-1]

arr = 	[10]
# print(solution(arr))
print(rm_small(arr))