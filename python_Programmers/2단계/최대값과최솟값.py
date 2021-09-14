def solution(s):
    arr = list(map(int, s.split(' ')))
    answer = (str(min(arr))+' '+str(max(arr)))
    return answer


def solution2(s):
    s = list(map(int,s.split()))
    return f'{min(s)} {max(s)}'



s = "1 2 3 4"
print(solution(s))
print(solution2(s))