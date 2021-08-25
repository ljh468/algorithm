# 내 풀이
def solution(s):
    answer = ''
    cnt = 0
    for word in s:
        if word == ' ':
            answer += ' '
            cnt = 0
        elif cnt % 2 == 0:
            answer += word.upper()
            cnt += 1
        else:
            answer += word.lower()
            cnt += 1
    return answer

# 모범풀이
def solution2(s):
    liste = []
    for i in s.split():
        result = ''
        for n, v in enumerate(i):
            if n % 2 == 0:
                result += v.upper()
            else:
                result += v.lower()
        liste.append(result)
    return ' '.join(liste)

s = "try hello world"
print(solution(s))
print(solution2(s))