def solution(enter, leave):
    answer = [[] for _ in range(len(enter)+1)]

    room = []
    ei, li = 0, 0
    while ei<len(enter) or li<len(leave):
        if leave[li] not in room:
            answer[enter[ei]]=room[:]
            room.append(enter[ei])
            ei += 1
        else:
            room.remove(leave[li])
            li += 1

    print('answer : ', answer)
    for p, person in enumerate(answer):
        print('p : ', p, ' person : ', person)
        for met in person:
            answer[met].append(p)
    print(answer)
    return [len(set(i)) for i in answer][1:]

# 모범 풀이
def solution2(enter, leave):
    answer = [0] * len(enter)

    room = []
    e_idx = 0
    for l in leave:
        while l not in room:
            room.append(enter[e_idx])
            e_idx += 1
        room.remove(l)
        for p in room:
            answer[p - 1] += 1
        answer[l - 1] += len(room)

    return answer


enter = [1,4,2,3]
leave = [2,1,3,4]
# print(solution(enter, leave))
print(solution2(enter, leave))
