# 선택 정렬
# 처리되지 않은 데이터 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸는것을 반복

# step 0 : 7, 5, 9, 0, 3, 1
# step 1 : 0, 5, 9, 7, 3, 1
# step 2 : 0, 1, 9, 7, 3, 5
# step 3 : 0, 1, 3, 7, 9, 5
# step n : 0, 1, 3, 5, 7, 9

print('####################################################')
# 예제 01) 선택 정렬 소스코드 예제
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_index = i  # 가장 작은 원소의 인덱스
    for j in range(i + 1, len(array)):
        if array[j] < array[min_index]:
            min_index = j  # 가장 작은 원소의 인덱스를 구함
    array[i], array[min_index] = array[min_index], array[i]  # swap
print(array)

# 반복1 :  i = 0부터 n-1까지
# 반복2 :  j = i+1 부터 n-1까지
# 선택정렬은 N번 만큼 가장 작은 수를 찾아서 맨앞으로 보내야 함
# (N^2+N-2)/2이므로 O(N^2)의 시간복잡도를 가짐
