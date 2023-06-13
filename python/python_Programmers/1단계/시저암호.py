# 내 풀이
def solution(s, n):
    answer = ''
    for i in s:
        if i.isupper():
            answer += chr((ord(i) - ord('A') + n) % 26 + ord('A'))
        elif i.islower():
            answer += chr((ord(i) - ord('a') + n) % 26 + ord('a'))
        else:
            answer += ' '
    return answer

# 모범 풀이
def solution2(s, n):
    s = list(s)
    for i in range(len(s)):
        if s[i].isupper():
            s[i] = chr((ord(s[i]) - ord('A') + n) % 26 + ord('A'))
        elif s[i].islower():
            s[i] = chr((ord(s[i]) - ord('a') + n) % 26 + ord('a'))
    return "".join(s)

s = 'ZzYy'
n = 25
print(solution(s, n))
print(solution2(s, n))