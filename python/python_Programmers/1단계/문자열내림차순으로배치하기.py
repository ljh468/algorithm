def solution(s):
    answer = ''
    low = ''
    upp = ''
    for i in s:
        if i == i.upper():
            upp += i
        else:
            low += i
    upp = "".join(sorted(upp, reverse=True))
    low = "".join(sorted(low, reverse=True))
    return low+upp

# 모범 풀이
# 대문자는 소문자보다 작은 것으로 간주함
def solution2(s):
    return ''.join(sorted(s, reverse=True))
s = "Zbcdefg"
print(solution(s))