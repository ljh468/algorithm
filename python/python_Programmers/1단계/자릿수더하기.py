# 내 풀이
def solution(n):
    answer = 0
    for i in str(n):
        answer += int(i)
    return answer

# map을 이용한 풀이
def solution2(number):
    return sum(map(int,str(number)))

# 재귀를 이용한 풀이
def solution3(number):
    if number < 10:
        return number;
    return (number % 10) + solution3(number // 10)
    # number % 10은 1의자리를 구함
    # number // 10은 1의자리를 제거한 수를 다시 재귀로 1의자리구함
    # 1의자리만 남으면 그대로 리턴

n = 987
# print(solution(n))
print(solution2(n))