def solution(s):
    return int(s)

# 모범 풀이
def solution2(str):
    result = 0

    for idx, number in enumerate(str[::-1]):
        if number == '-':
            result *= -1
        else:
            result += int(number) * (10 ** idx)

    return result

s = '-1234'
print(solution(s))
print(solution2(s))