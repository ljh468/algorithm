# 내 풀이
def solution(lottos, win_nums):
    low = 0
    top = 0
    for lotto in lottos:
        if lotto in win_nums:
            low += 1
        elif lotto == 0:
            top += 1
    hap = (top + low)
    rank_top = 7 - (hap+1 if hap == 0 else hap)
    rank_low = 7 - (low+1 if low==0 else low)

    return [rank_top, rank_low]

# 모범 풀이
def solution2(lottos, win_nums):

    rank=[6,6,5,4,3,2,1]

    cnt_0 = lottos.count(0)
    ans = 0
    for x in win_nums:
        if x in lottos:
            ans += 1
    return rank[cnt_0 + ans],rank[ans]



lottos = [1, 2, 3, 4, 5, 6]
win_nums = [38, 19, 20, 40, 15, 25]
print(solution(lottos, win_nums))
print(solution2(lottos, win_nums))