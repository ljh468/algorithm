import math


# 기본적인 소수 판별 방법(2부터 n-1까지 돌려보기)
def prime_number(x):
    for i in range(2, x):
        if x % i == 0:
            return False
    return True


data = list(map(int, input().split()))
print(len(data))
result = 0
if len(data) < 3:
    print("x")
for i in data[0:len(data)]:
    print("i : ", i)
    for j in data[1:len(data)]:
        print("j : ",j)
        if j == i:
            break
        for k in data[2:len(data)]:
            print("k : ", k)
            if k == i:
                break
            elif k == j:
                break
            hap = i + j + k
            if prime_number(hap):
                print(hap)
                result = result + 1
                print(result)
print("result : " ,result)


