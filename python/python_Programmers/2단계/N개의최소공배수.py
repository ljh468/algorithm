# 최대공약수
def gcd(a, b):
    if a >= b:
        pass
    else:
        a, b = b, a
    while b != 0:
        a, b = b, a % b
    return a


# 최소공배수
def lcm(a, b):
    return a * b // gcd(a, b)


def solution(arr):
    l = lcm(arr[0], arr[1])
    for i in range(len(arr) - 1):
        if i == (len(arr) - 2):
            return l
        l = lcm(l, arr[i + 2])


# 모범 풀이
def gcd2(a, b):
    if b == 0:
        return a
    return gcd2(b, a % b)

def solution2(arr):
    answer = arr[0]
    for n in arr:
        answer = n * answer / gcd2(n, answer)
    return int(answer)


print('##########################################################')
arr = [2, 6, 8, 14]
print(solution(arr))
print(solution2(arr))
