# 내 풀이
def zinsu(x):
    binary = ''
    while x > 0:
        mo = x % 2
        x = x // 2
        binary += str(mo)
    return binary[::-1]

def solution(n):
    z1 = zinsu(n).count('1')
    while True:
        n += 1
        z2 = zinsu(n).count('1')
        if z1 == z2:
            return n
    return answer

# 모범 풀이
def solution2(n):
    num1 = bin(n).count('1')
    while True:
        n = n + 1
        if num1 == bin(n).count('1'):
            break
    return n
n = 78
print(solution(n))
print(solution2(n))