# 실패율은 다음과 같이 정의한다.
# 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

def solution(N, stages):
    result = {}
    num = len(stages) # 스테이지에 도달한 플레이어 수

    for stage in range(1, N+1):
        if num != 0:
            count = stages.count(stage) # 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            result[stage] = count / num
            num -= count
        else:
            result[stage] = 0

    return sorted(result, key=lambda x : result[x], reverse=True)

N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]

print(solution(N, stages))

# 모범 풀이
def solution2(N, stages):
    answer = []
    fail = []
    info = [0] * (N + 2)
    for stage in stages:
        info[stage] += 1
    for i in range(N):
        be = sum(info[(i + 1):])
        yet = info[i + 1]
        if be == 0:
            fail.append((str(i + 1), 0))
        else:
            fail.append((str(i + 1), yet / be))
    for item in sorted(fail, key=lambda x: x[1], reverse=True):
        answer.append(int(item[0]))
    return answer
print(solution2(N, stages))

print('#######################################################')
# NUMPY로 최빈값구하기
import numpy as np
array = np.array([1, 2, 2, 3, 4, 5])
print('[1, 2, 2, 3, 4, 5]')
vals, counts = np.unique(array, return_counts=True)
index = np.argmax(counts)
print('numpy 최빈값 : ', vals[index])

# scipy로 최빈값 구하기
from scipy.stats import mode
print('scipy 최빈값 : ', mode(array)[0][0])