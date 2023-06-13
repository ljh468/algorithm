# 쉬운 풀이
def solution(absolutes, signs):
    answer = 0
    for i in range(0, len(absolutes)):
        if signs[i]:
            answer += abs(absolutes[i])
        else:
            answer -= abs(absolutes[i])
    return answer

# 삼항연산자 풀이
def solution2(absolutes, signs):
    return sum(absolutes if sign else -absolutes for absolutes, sign in zip(absolutes, signs))


print(solution([1,2,3], [False, False, True]))
print(solution2([1,2,3], [False, False, True]))