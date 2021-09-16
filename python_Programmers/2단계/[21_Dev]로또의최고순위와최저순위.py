def solution(lottos, win_nums):
    cnt = 0
    for lotto in lottos:
        if lotto in win_nums:
            cnt += 1
    max_cnt = lottos.count(0) + cnt
    min_cnt = cnt
    return [6 if max_cnt == 0 else 7 - max_cnt, 6 if min_cnt == 0 else 7 - min_cnt]


# 모범 풀이
def solution2(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    cnt_0 = lottos.count(0)
    ans = 0
    for x in win_nums:
        if x in lottos:
            ans += 1
    return rank[cnt_0 + ans], rank[ans]


lottos = [1, 2, 3, 4, 5, 6]
win_nums = [38, 19, 20, 40, 15, 25]
print(solution(lottos, win_nums))
print(solution2(lottos, win_nums))
