def solution(x):
    hap = 0
    x = str(x)
    for i in range(len(x)):
        hap += int(x[i])

    if int(x) % hap == 0:
        return True
    return False

# 모범 풀이
def solution2(n):
    # n은 하샤드 수 인가요?
    return n % sum([int(c) for c in str(n)]) == 0


arr = 13
print(solution(arr))
print(solution2(arr))