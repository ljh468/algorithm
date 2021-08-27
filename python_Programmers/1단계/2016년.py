from datetime import date

a = 5
b = 24

def solution(a, b):
    week = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    preday = date(2016, 1, 1)
    nowday = date(2016, a, b)

    cha = nowday - preday
    cha = cha.days % 7

    return week[cha]
print(solution(a, b))

# 다른 사람 풀이 2
# 축약 버전입니다
def solution2(a, b):
    date = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    return date[(sum(month[:a-1])+b-1)%7]
print(solution2(a, b))

# 다른 사람 풀이 2
# datetime 라이브러리를 사용한 경우입니다.
# datetime.datetime(YEAR, MONTH, DAY)
# weekday() : 정수로 요일을 반환합니다. 월요일은 0 ~ 일요일은 6입니다.

def solution3(a, b):
    date = 'MON TUE WED THU FRI SAT SUN'.split()
    return date[datetime.datetime(2016, a, b).weekday()]

print(solution3(a, b))