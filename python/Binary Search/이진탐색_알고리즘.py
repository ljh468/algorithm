# 이진탐색 알고리즘
# 순차탐색 : 리스트 안에 있는 특정한 데이터를 찾기위해 앞에서부터 데이터를 하나씩 확인 하는방법
# 이진탐색 : 정렬되어 있는 리스트에서 탐색범위를 절반씩 좁혀가며 데이터를 탐색하는 방법
#           - 이진 탐색은 시작점, 끝점, 중간점을 이용하여 탐색범위를 설정함

# 이진탐색 동작예시
# EX : 이미 정렬된 10개의 데이터 중에서 4를 찾는 예시
#       0(시작 0), 2, 4, 6, 8(중간 4), 10, 12, 14, 16, 18(끝 9)
# Step 1 : 시작점 0, 중간 4, 끝점 9 -> 찾고자하는 값과 중간점 비교
#          4 < 8 --> 0, 2, 4, 6 (왼쪽 부분)
#
# Step 2 : 시작점 0, 중간 1, 끝점 3 -> 찾고자하는 값과 중간점 비교
#          4 > 2 --> 4 (오른쪽 부분)
# 이진탐색의 시간복잡도
# - 단계마다 탐색범위를 2로 나누는것과 동일하므로 연산횟수는 Log2n에 비례
# - 예를들어 초기 데이터의 수가 32일때  16 -> 8 -> 4
# - 이진탐색은 탐색범위를 절반씩 줄이며, 시간복잡도는 O(logN)을 보장함
print('############################################')

# 이진탐색 소스코드 : 재귀적 구현(python)
def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    # 찾는 경우 중간점 인덱스 반환
    if array[mid] == target:
        return mid
    # 중간점의 값 보다 찾고자하는 값이 작은 경우 왼쪽 확인
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    # 중간점의 값 보다 찾고자하는 값이 큰 경우 오른쪽 확인
    elif array[mid] < target:
        return binary_search(array, target, mid + 1, end)


# n(원소의 개수)과 target(찾고자 하는값)을 입력받기
# n, target = list(map(int, input().split()))
n, target = 10, 7
# 전체 원소 입력받기
# array = list(map(int, input().split()))
array = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
# 이진탐색 수행 결과 출력
result = binary_search(array, target, 0, n - 1)
if result == None:
    print('원소를 포함하지 않습니다.')
else:
    print('target의 인덱스는 : ', result+1)

print('############################################')

# 이진탐색 소스코드 : 반복문 구현(python)
def binary_search2(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return None

# n, target = list(map(int, input().split()))
n, target = 10, 7
# array = list(map(int, input().split()))
array = [1, 3, 5, 6, 9, 11, 13, 15, 17, 19]
# 이진 탐색 수행 결과 출력
result = binary_search2(array, target, 0, n-1)
if result == None:
    print('원소를 포함하지 않습니다.')
else:
    print('target의 인덱스는 : ', result+1)
