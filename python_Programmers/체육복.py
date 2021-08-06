# 풀이
def solution(n, lost, reserve):
    answer = 0
    set_reserve = set(reserve) - set(lost)
    set_lost = set(lost) - set(reserve)

    for i in list(set_reserve):
        for j in list(set_lost):
            if i == (j+1):
                set_reserve.remove(i)
                set_lost.remove(j)
                break
            elif i == (j-1):
                set_reserve.remove(i)
                set_lost.remove(j)
                break
    answer = n - len(set_lost)
    return answer

print(solution(3, [1, 2, 4], [1, 3, 5]))

# 모범 풀이
def solution2(n, lost, reserve):
    _reserve = [r for r in reserve if r not in lost]
    _lost = [l for l in lost if l not in reserve]
    for r in _reserve:
        f = r - 1
        b = r + 1
        if f in _lost:
            _lost.remove(f)
        elif b in _lost:
            _lost.remove(b)
    return n - len(_lost)
print(solution2(3, [1, 2, 4], [1, 3, 5]))