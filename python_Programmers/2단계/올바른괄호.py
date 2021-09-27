# 내 풀이
def solution(s):
    if s[0] != '(' or s[-1] != ')' or len(s) % 2 != 0:
        return False
    stack = []
    for i in s:
        if i == '(':
            stack.append(i)
        else:
            if len(stack) == 0:
                return False
            stack.pop()
    if len(stack) != 0:
        return False
    return True

# 모범 풀이
def solution2(s):
    st = 0
    for c in s:
        if c == '(':
            st += 1
        elif c == ')':
            if st == 0:
                return False
            st -= 1
    return st == 0

s = "())(()"
print(solution(s))
print(solution2(s))