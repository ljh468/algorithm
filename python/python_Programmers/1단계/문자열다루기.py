def solution(s):
    try:
        int(s)
    except:
        return False
    return len(s) == 4 or len(s) == 6

#  모범 풀이
def solution2(s):
    return s.isdigit() and len(s) in (4, 6)

s = 'a234'
print(solution(s))
print(solution2(s))