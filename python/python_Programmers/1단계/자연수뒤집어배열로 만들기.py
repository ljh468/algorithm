# 내풀이
def solution(n):
    answer = list(map(int,str(n)))
    answer.reverse()
    return answer

# 모범 풀이 [::-1]은 거꾸로 인덱싱
def digit_reverse(n):
    return [int(i) for i in str(n)][::-1]

n = 12345
print(solution(n))
print(digit_reverse(n))