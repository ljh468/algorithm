# 내 풀이
def solution(d, budget):
    cnt = 0
    d.sort()
    for i in d:
        if budget >= i:
            budget -=i
            cnt +=1
        else:
            break
    return cnt

# 모범 풀이
def solution2(d, budget):
    answer = 0
    d = sorted(d)
    for needs in d :
        budget -= needs
        if budget < 0 :
            break
        answer = answer + 1

    return answer

d = [2,2,3,3]
budget = 10
print(solution(d, budget))
print(solution2(d, budget))