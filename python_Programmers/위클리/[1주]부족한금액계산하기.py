# 내 풀이
def solution(price, money, count):
    answer = 0
    num = 0
    while count != 0:
        num += 1
        count = count - 1
        money = money - (price * num)
        answer = abs(money)
        if money > 0:
            answer = 0
    return answer

# 모범 풀이
def solution2(price, money, count):
    answer = 0
    while count > 0:
        answer += price*count
        count -=1
    return answer-money if answer-money >0 else 0

# 수학 풀이
def solution3(price, money, count):
    total = (price * (1+count) * count / 2)
    return total - money if total > money else 0

print(solution2(3, 20, ))

