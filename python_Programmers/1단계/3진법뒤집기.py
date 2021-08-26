# 내 풀이
def solution(n):
    answer = 0
    sam = ''

    # n이 3보다 크거나 같을때
    while n:
        sam += str(n%3)
        n = n//3
    s = sam[::-1] # 3진법

    for j in range(len(s)): # 뒤에서부터 제곱을 쌓아나가기위해 반전되지않은 3진법 사용
        answer += int(s[j]) * (3 ** j)
    return answer

print(solution(45))

# 모범 풀이
def solution2(n):
    tmp = ''
    while n:
        tmp += str(n % 3)
        n = n // 3

    answer = int(tmp, 3) # int에 매개변수는 진법 변환 (3진법으로 변환)
    return answer

print(solution2(125))