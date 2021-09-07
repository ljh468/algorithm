# 내풀이
def solution(dartResult):
    stack = []
    dartResult = dartResult.replace("10", "A")
    bonus = {'S': 1, 'D': 2, 'T': 3}

    for i in dartResult:
        if i.isdigit() or i == 'A':
            stack.append(10 if i == 'A' else int(i))
        elif i in ('S', 'D', 'T'):
            num = stack.pop()
            stack.append(num ** bonus[i])
        elif i == '#':
            stack[-1] *= -1
        elif i == '*':
            num = stack.pop()
            if len(stack):
                stack[-1] *= 2
            stack.append(2 * num)
    return sum(stack)


def solution2(dartResult):
    answer = []
    # 점수리스트
    score = ['S', 'D', 'T']

    # 점수가 10점이 들어올경우 A로 바꿈
    dartResult = dartResult.replace('10', 'A')

    # 리스트컴프리헨션을 이용하여 문자열을 차례대로 탐색하여 A면 '10'으로 반환
    # 아니면 그대로 반환 (문자열을 리스트로 변환)
    dart = ['10' if i == 'A' else i for i in dartResult]

    # 이전에 얻은점수를 조회하기 위해 index로 사용
    i = -1
    print('dart : ',  dart)

    # 문자열 리스트 완전탐색
    for j in dart:
        # 점수리스트에 있는 문자인지 검사 ( 만약 SDT중 하나면 )
        if j in score:
            # 가장 최근에 얻은 점수에 S의 index는 0, D의 index는 1, T의 index는 2
            # S면 1제곱, D면 2제곱, T면 3제곱
            answer[i] = answer[i] ** (score.index(j) + 1)
        # 만약 *문자열이면
        elif j == '*':
            # 해당 점수에 2배
            answer[i] = answer[i] * 2
            # 만약 첫번째 점수가 아니라면 이전 점수에 2배
            if i != 0:
                answer[i - 1] = answer[i - 1] * 2
        # 만약 #문자열 이라면
        elif j == '#':
            # 해당 점수에 -1배
            answer[i] = answer[i] * (-1)
        else:
            # 문자열이 점수라면 리스트에 추가 (맨처음에 나오는 점수는 바로 추가)
            answer.append(int(j))
            # 다음 인덱스로 넘어가기위해 +1 (처음 점수가 들어가고 나면 index는 0부터 시작
            i += 1
    print(answer)
    return sum(answer)

import re
def solution3(d):
    # 점수와 옵션은 딕셔너리로 변환
    bonus = {'S' : 1, 'D': 2, 'T': 3}
    option = {'': 1, '*': 2, '#': -1}
    answer = []

    # (\d+) : 정수 (10이상도 찾아줌)
    # ([SDT]) : 'SDT' 인 문자
    # ([*#]?) : '*#' 문자를 찾는데, ? -> 없으면 '' 반환
    # 정규표현식을 이용하여 튜플로 묶어서 리스트로 변환
    p = re.compile('(\d+)([SDT])([*#]?)')
    dart = p.findall(d) # 입력값이 d = '1S2D*10T' 일때
    print(dart)         # [('1', 'S', ''), ('2', 'D', '*'), ('10', 'T', '')] 으로 리스트가 생성됨
    # 3개의 리스트 완전탐색
    for i in dart:
       # 2 index의 옵션이 [ * ]이고 다트를 던진횟수가 1번이상이면
        if i[2] == '*' and len(answer) > 0:
            # 이전에 얻은 점수에 2배
            answer[-1] *= 2
        # 다트점수 + 보너스점수 + 옵션 연산
        answer.append(int(i[0]) ** bonus[i[1]] * option[i[2]])
    return sum(answer)

d = '1S2D*10T'
# print(solution(d))
# print(solution2(d))
print(solution3(d))