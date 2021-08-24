# 내 풀이
from collections import Counter
def solution(nums):
    n = int(len(nums)/2) # 가져갈 폰켓몬 수
    cnt = Counter(nums) # 폰켓몬의 종류 튜플 리스트
    cnts =cnt.most_common(n) # 폰켓몬 종류의 상위 가져갈 폰켓몬 수
    return len(cnts)

nums = [1,1,1,2,2,2]
print(solution(nums))

# 모범 풀이
def solution2(ls):
    print(int(len(ls)/2)) # 가져갈 폰켓몬 수
    print(len(set(ls))) # 폰켓몬의 종류 수
    return int(min(len(ls)/2, len(set(ls))))

print(solution2(nums))