# [문제 01] 정렬된 배열에서 특정 수의 개수 구하기 : 문제설명
# N개의 원소를 포함하는 수열이 오름차순으로 정렬되어 있음
# 이때 수열X가 등장하는 횟수를 계산하시오. 예를들어 수열 {1, 1, 2, 2, 2, 2, 3}이 있을때
# X = 2라면, 현재 수열에서 값이 2인 원소가 4개 이므로 4를 출력함
# 단 이문제도 시간복잡도( O(logn) )으로 알고리즘을 설계하지 않으면 시간초과 판정.

# 입력예시 : n, x = 7, 2
#           array = [1, 1, 2, 2, 2, 2, 3]
#           수열의 원소 중에서 x인 원소의 개수를 출력, 원소가 1개도 없다면 -1을 출력

# 문제해결 아이디어
# 시간복잡도 O(logN)으로 동작하는 알고리즘을 요구
# 일반적인 선형탐색은 시간초과 판정을 받을 수 있음 O(n)
# 하지만 데이터가 정렬되어 있기 때문에 이진탐색을 수행 할 수 있음
# 특정값이 등장하는 첫번째 위치와 마지막 위치를 찾아 위치 차이를 계산해 문재를 해결할 수 있음
# 1, 1, [2], 2, 2, [2], 3

from bisect import bisect_left, bisect_right

n, x = 7, 2  # 데이터의 개수 N, 찾고자 하는 값 x 입력 받기
array = [1, 1, 2, 2, 2, 2, 3]


# 값이 다른 [left_value, right_value]인 데이터의 개수를 반환하는 함수
def count_by_range(array, left_value, right_value):
    right_index = bisect_right(array, right_value)
    left_index = bisect_left(array, left_value)
    return right_index - left_index


# 값이 [x, x]범위에 있는 데이터의 개수 계산
count = count_by_range(array, x, x)
# 값이 x인 원소가 존재하지 않는다면
if count == 0:
    print('-1')
# 값이 x인 원소가 존재한다면
else:
    print(count)
