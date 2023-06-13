# 내 풀이
def solution(s):
    answer = ''
    index = len(s)//2
    if len(s) % 2 == 0 : # 짝수
        answer += s[index-1]
        answer += s[index]
    else:
        answer += s[index]

    return answer

print(solution("abcde"))
print(solution("qwer"))

# 모범 풀이
def string_middle(str):
    a = len(str)
    if a % 2 == 0 :
        a = (a-2) / 2
    else :
        a = (a-1) / 2
    return str[int(a) : -int(a)]
# 아래는 테스트로 출력해 보기 위한 코드입니다.
print(string_middle("power"))