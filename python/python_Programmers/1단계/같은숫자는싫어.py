# 내 풀이
def solution(arr):
    answer = [arr[0]]
    for i in range(1, len(arr)):
        if arr[i-1] == arr[i]:
            continue
        answer.append(arr[i])

    return answer

# 모범 풀이
def no_continuous(s):
    return [a for b, a in enumerate(s) if a != s[b-1]]


arr = [4,4,4,3,3]
print(solution(arr))
print(no_continuous(arr))