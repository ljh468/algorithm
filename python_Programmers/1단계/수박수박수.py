# 내 풀이
def solution(n):
    answer = ''

    for i in range(1, n+1):
        if i % 2 == 1:
            answer += '수'
        else :
            answer += '박'
    return answer

print(solution(4))

# 모범 풀이
def water_melon(n):
    return "수박"*(n//2) + "수"*(n%2)

# 실행을 위한 테스트코드입니다.
print("n이 3인 경우: " + water_melon(3));
print("n이 4인 경우: " + water_melon(4));