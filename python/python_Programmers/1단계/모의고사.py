# 내풀이
def solution(answers):
    answer = []

    list1 = [1, 2, 3, 4, 5]
    list2 = [2, 1, 2, 3, 2, 4, 2, 5]
    list3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    solve = [0, 0, 0]
    for i in range(0, len(answers)):
        if list1[i % len(list1)] == answers[i]:
            solve[0] += 1
        if list2[i % len(list2)] == answers[i]:
            solve[1] += 1
        if list3[i % len(list3)] == answers[i]:
            solve[2] += 1
    max_value = max(solve)

    for j in range(0, len(solve)):
        if solve[j] == max_value:
            answer.append(j+1)
    return answer

print(solution([1,3,2,4,2]))

# 모범 풀이
from itertools import cycle

def solution2(answers):
    giveups = [
        cycle([1,2,3,4,5]),
        cycle([2,1,2,3,2,4,2,5]),
        cycle([3,3,1,1,2,2,4,4,5,5]),
    ]
    scores = [0, 0, 0]
    for num in answers:
        for i in range(3):
            if next(giveups[i]) == num:
                scores[i] += 1
    highest = max(scores)

    return [i + 1 for i, v in enumerate(scores) if v == highest]
print(solution2([1,3,2,4,2]))

# cycle 활용법
A = [1,2,3]
B = ['A','B','C','D']
C = [10,20,30,40,50]
R_Z = zip(A, B, C)
print(next(R_Z))
print(next(R_Z))
print(next(R_Z))

R_L = zip(cycle(A),cycle(B),cycle(C))
for i in range(0, len(C)):
    print('r_l : ', next(R_L))