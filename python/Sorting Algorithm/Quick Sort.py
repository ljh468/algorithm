# 퀵 정렬
# 기준데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
# 일반적인 상황에서 가장 많이 사용되는 정렬 알고리즘 중 하나이다. (표준 정렬 라이브러리의 아이디어)
# 가장 기본적인 퀵 정렬은 1번째 데이터를 기준 데이터(Pivot)로 설정 함.

# step 0 : 5, 7, 9, 0, 3, 1, 6, 2, 4, 8
# 현재 피벗의 값은 '5'입니다. 왼쪽에서부터 '5'보다 큰 데이터를 선택하므로 '7'이 선택되고
# 오른쪽에서부터 '5'보다 작은 데이터를 선택하므로 '4'가 선택됩니다. 이제 이 두 데이터의 위치를 서로 변경합니다.

# 1. 기준값이 '5'라면 왼쪽에서부터 5보다 큰값(7) 선택, 오른쪽에서부터 5보다 작은값(4) 선택
#    -> 두 데이터 위치 서로 변경 (7, 4)
#   5, 4, 9, 0, 3, 1, 6, 2, 7, 8    # (7, 4)위치변경 <반복>
#   5, 4, 2, 0, 3, 1, 6, 9, 7, 8    # (9, 2)위치변경

# 2. 위치가 엇갈리는 경우 (left > right)
#    -> 피벗값과 작은 데이터의 위치를 서로 변경
#   5, 4, 2, 0, 3, 1, 6, 9, 7, 8  # (6, 1)이 엇갈림
#   1, 4, 2, 0, 3, |5| 6, 9, 7, 8  # 피벗값(5)와 작은값 위치변경

# 3. 피벗을 기준으로 데이터 묶음을 나누는 분할 작업 수행
#   1, 4, 2, 0, 3 ||||5|||| 6, 9, 7, 8

# 4. 왼쪽 데이터 묶음, 오른쪽 데이터 묶음을 다시 퀵 정렬 해줌 (재귀)

print('####################################################')
# 예제 01) 퀵 정렬 소스코드 예제
array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    if start >= end:  # 원소가 1개인 경우 종료
        return
    pivot = start  # 피벗값은 첫번째 원소의 인덱스
    left = start + 1  # 왼쪽 원소의 인덱스
    right = end  # 오른쪾 원소의 인덱스
    while left <= right:  # 엇길릴때 까지 반복 (left의 인덱스 보다 right의 인덱스가 크면 반복)
        # 피벗보다 큰 데이터를 찾을때까지 반복
        while left <= end and array[left] <= array[pivot]:
            left += 1
        # 피벗보다 작은 데이터를 찾을때까지 반복
        while right > start and array[right] >= array[pivot]:
            right -= 1

        if left > right:  # 엇갈렷다면 작은 데이터와 피벗을 교체
            array[right], array[pivot] = array[pivot], array[right]
        else:  # 엇갈리지 않았다면 작은 데이터와 큰 데이터 교체체
           array[left], array[right] = array[right], array[left]

    # 분할 이후 왼쪽부분과 오른쪽부분에서 각각 정렬 수행
    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)


quick_sort(array, 0, len(array) - 1)
print(array)
print('####################################################')

# 퀵 정렬 소스코드 : 파이썬의 장점을 살린 방식
array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort2(array):
    # 리스트가 하나 이하의 원소만을 담고 있다면 종료
    if len(array) <= 1:
        return array
    pivot = array[0]  # 피벗은 첫 번째 원소
    tail = array[1:]  # 피벗을 제외한 리스트

    left_side = [x for x in tail if x <= pivot]  # 분할된 왼쪽 부분
    right_side = [x for x in tail if x > pivot]  # 분할된 오른쪽 부분
    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행하고, 전체 리스트 반환
    return quick_sort2(left_side) + [pivot] + quick_sort2(right_side)
print(quick_sort2(array))


# 퀵 정렬이 빠른이유 : 직관적인 이해
# 이상적인 경우 분할이 절반씩 일어난다면 전체 연산횟수로 O(NlogN)를 기대할 수 있습니다.
# 너비 X 높이 = N * logN = NlogN

# 퀵 정렬은 평균의 경우 O(NlogN)의 시간복잡도를 가집니다.
# 한쪽 방향으로 편향된 분할이 발생하는 경우 O(N^2)의 시간복잡도를 가짐
# 예시 0 || 1, 2, 3, 4, 5, 6, 7, 8, 9 분할
#     1 || 2, 3, 4, 5, 6, 7, 8, 9 분할
#     2 || 3, 4, 5, 6, 7, 8, 9 분할
# 표준 정렬 라이브러리는 O(NlogN)을 보장함