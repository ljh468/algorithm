def solution(arr, divisor):
    answer = []
    answer = sorted([i for i in arr if i % divisor == 0])
    # if len(answer) == 0:
    #     return [-1]
    if answer is []:
        return [-1]
    return answer


# 모범 풀이
def solution2(arr, divisor):
    return sorted([n for n in arr if n%divisor == 0]) or [-1]

arr = [3,2,6]
divisor = 10
print(solution(arr, divisor))