def solution(s):
    s = s.lower()
    arr = s.split(' ')
    cnt = 0
    for i in arr:
        arr[cnt] = arr[cnt].capitalize()
        cnt += 1
    return ' '.join(arr)

# 모범 풀이
def solution2(s):
    # 함수를 완성하세요
    s = ' '.join(((word[0].upper()) + word[1:].lower()) for word in s.split())
    return s

s = "3people unFollowed me"
print(solution(s))
print(solution2(s))