# 내 풀이
def solution(s):
    s = s.lower()
    p = s.count('p')
    y = s.count('y')
    if p == y:
        return True
    return False
s = "pPoooyY"
print(solution(s))

# 모범 풀이
def numPY(s):
    return s.lower().count('p') == s.lower().count('y')
print( numPY("pPoooyY") )