import time
import math
num = int(input())
#
## 소수 판별
add = []
start = time.time()
for i in range(2, num+1):
    for j in range(2, i):
        if i % j == 0:
            break
    else:
        add.append(i)

print(len(add))
print("time :", time.time() - start)

## 소수 판별
add1 = []
start = time.time()
for i in range(2, num+1):
    if i <= 2:
        add1.append(i)
    else:
        for j in range(2,i+1):
            if i % j == 0 and i != j: # 자기자신의 수를 제외하고 나누어떨어지면 소수아님
                break;
            else:
                if i == j:
                    add1.append(i)

print(add1)
print("time :", time.time() - start)

## 소수 판별 (함수 이용 코드)
# num = int(input())
add2 = []
def sosu(n):
    if n <= 2:
        return add2.append(n)
    else:
        # 자기자신의 수를 제외하고 나누어떨어지면 소수아님
        for i in range(2,n):
            if n % i == 0:
                return
        return add2.append(n)

for i in range(2, num+1):
    sosu(i)

print(add2)

# 에라토스테니스의 체
add3 = [True]*(num+1) # 특정 수가 지워졌는지 아닌지 확인하기 위한 배열
m = int(num**0.5)

for i in range(2,m+1):
    if add3[i] == True:  # 특정 수가 지워지지 않았다면 (소수여서)
        for j in range(i+i, num+1, i):
            add3[j]=False
print([i for i in range(2,num+1) if add3[i]==True])



# 에라토스테니스의 체 2
# 소수 판별 함수(에라토스테네스의 체)
def is_prime_number(n):
    # 2부터 n까지의 모든 수에 대하여 소수 판별
    array = [True for i in range(n+1)] # 처음엔 모든 수가 소수(True)인 것으로 초기화(0과 1은 제외)

    # 에라토스테네스의 체
    for i in range(2, int(math.sqrt(n)) + 1): #2부터 n의 제곱근까지의 모든 수를 확인하며
        if array[i] == True: # i가 소수인 경우(남은 수인 경우)
            # i를 제외한 i의 모든 배수를 지우기
            j = 2
            while i * j <= n:
                array[i * j] = False
                j += 1

    return [ i for i in range(2, n+1) if array[i] ]

# N이 1,000,000 이내로 주어지는 경우 활용할 것 => 이론상 400만번 정도 연산이고 메모리도 충분함

print(is_prime_number(26))