def solution(n, m):

    def gcdd(list):
        mx = max(list)
        mn = min(list)
        while mn != 0:
            tmp = mx % mn
            mx = mn
            mn = tmp
            print('mx : ', mx, 'mn : ', mn)
        return mx

    list = [n, m]
    gcd_result = gcdd(list)
    lcm_result = int((n*m) / gcd_result)
    answer = [gcd_result, lcm_result]
    return answer

print(solution(3, 12))

# 모범 풀이
def gcdlcm(a, b):
    c, d = max(a, b), min(a, b)
    t = 1
    while t > 0:
        t = c % d
        c, d = d, t
    answer = [c, int(a*b/c)]

    return answer

# 아래는 테스트로 출력해 보기 위한 코드입니다.
print(gcdlcm(3,12))