# 파이썬 이진탐색 라이브러리
import bisect

# a = 1, 2, 4, 4, 8
# bisect_left(a, 4) = 2 (인덱스)
# bisect_right(a, 4) = 4 (인덱스)

from bisect import bisect_left, bisect_right

a = [1, 2, 4, 4, 8]
x = 4
print(bisect_left(a, x))  # -> 2
print(bisect_right(a, x))  # -> 4
print('############################################')

# 값이 특정범위에 속하는 데이터 개수 구하기
from bisect import bisect_left, bisect_right

# 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
def count_by_range(a, left_value, right_value):
    right_value = bisect_right(a, right_value)
    left_value = bisect_left(a, left_value)
    return right_value - left_value

# 배열선언
a = [1, 2, 3, 3, 3, 3, 4, 4, 8, 9]
# 값이 4인 데이터의 갯수 출력
print(count_by_range(a, 4, 4))  # -> 2
# 값이 -1, 3 범위에 있는 데이터 갯수 출력
print(count_by_range(a, -1, 3))  # -> 6