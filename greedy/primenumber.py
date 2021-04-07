import time

num = int(input())

## 소수 판별
add = []
start = time.time()
for i in range(2, num+1):
    for j in range(2, i):
        if i % j == 0:
            break
    else:
        add.append(i)

print(add)
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
start = time.time()
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
print("time :", time.time() - start)
## 에라토스테니스의 체
add3 = [True]*(num+1)
start = time.time()
m = int(num**0.5)

for i in range(2,m+1):
    if add3[i] ==True:
        for j in range(i+i, num+1,i):
            add3[j]=False
print([i for i in range(2,num+1) if add3[i]==True])

print("time :", time.time() - start)