# 내 풀이
def binary(num, n):
    bin = ''
    for i in range(n):
        a = int(num // 2)
        b = int(num % 2)
        bin += str(b)
        num = a
    return bin[::-1]

def solution(n, arr1, arr2):
    arr3 = []
    arr1 = [binary(b, n) for b in arr1]
    arr2 = [binary(bb, n) for bb in arr2]
    bbb = ''
    for i in range(n):
        for j in range(n):
            if arr1[i][j] == '1' or arr2[i][j] == '1':
                bbb += '1'
            else:
                bbb += '0'
        bbb = bbb.replace('1', '#')
        bbb = bbb.replace('0', ' ')
        arr3.append(bbb)
        bbb = ''
    return arr3

# 모범 풀이
def solution2(n, arr1, arr2):
    answer = []
    for i, j in zip(arr1, arr2):
        # 비트연산자 or( | )는 둘중하나라도 1이 있으면 1, 둘 다 0 이면 0
        a12 = str(bin(i | j)[2:]) # 맨앞2자리 제외하고 저장

        # 문자열.rjust(전체 자리 숫자, 비어있을 경우 공백을 채울 텍스트)
        a12 = a12.rjust(n, '0')
        a12 = a12.replace('1', '#')
        a12 = a12.replace('0', ' ')
        answer.append(a12)
    return answer



print('###########################################################################')

n = 6
arr1 = [46, 33, 33, 22, 31, 50]
arr2 = [27, 56, 19, 14, 14, 10]
print(solution(n, arr1, arr2))
print(solution2(n, arr1, arr2))