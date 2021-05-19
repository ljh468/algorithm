### 리스트 자료형 ###

a = "Hello Python abcdefghijk"
print(a[6:12])
print(a[13:-7])

a = [1, 'a', 'b', 'c', 4]
a[1:3] = []
print(a)
del a[1]
print(a)

a = []
for i in range(0,11):
    a.append(i)
a.append([11,12])
print(a)

a = [1,2,3]
a.insert(3,4)
print(a)

a = [1,2,3,4,1,2,3]
a.remove(4)
print(a)

a = [1,2,3]
a.extend([4,5])
print(a)

### 튜플 자료형 ###

t1 = (1,2,'a','b')
t1[0:]
print(t1)
t2 = (3,4)
print(t1 + t2)
print(t2* 3)

### 딕셔너리 자료형 ###

dic = {'name':'pey'}
dic['phone'] = "011"
dic[3] = [1,2,3]
print(dic)
del dic['name']
print(dic)

dic.clear()
a = {'name':'pey', 'phone':'0119993323', 'birth': '1118'}
print(a.get('name'))
print(a['name'])
print(a.get('foo', 'defult'))

### 집합 자료형 ###

s1 = set([1,2,3])
t1 = tuple(s1)
print(t1)

s1 = set([1,2,3,4,5,6])
s2 = set([4,5,6,7,8,9])
print(s1 & s2) # 교집합
print(s1 | s2) # 합집합
print(s1 - s2) # 차집합

s1 = set([1,2,3])
s1.add(4)
print(s1)
s1.update([5,6])
print(s1)
s1.remove(6)
print(s1)

### 변수 ###

a = [1,2,4]
b = a
a[2] = 3
print(a, b)

a = [1,2,4]
b = a[:]
a[2] = 3
print(a, b)
from copy import copy
b = copy(a)
print(a, b)
print(b is a)

# “돈이 3000원 이상 있거나 카드가 있으면 택시를 타고 그렇지 않으면 걸어 가라”
# 현재 돈 2000원 있음, card 있음
money = 2000
card = 1
if money >=3000 or card:
    print("택시를 타고가라")
else:
    print("걸어가라")

# “주머니에 돈이 있으면 택시를 타고, 주머니에 돈이 없지만 카드가 있으면 택시를 타고, 돈도 없고 카드도 없으면 걸어가라”
pocket = ['paper', 'cellphone', 'money']
if 'money' in pocket:
    print("택시를 타고가라")
elif 'card' in pocket:
    print("택시를 타고가라")
else:
    print("걸어가라")

# money를 입력해서 커피 뽑기
coffee = 10
while True:
    # money = int(input("돈을 넣어주세요 : "))
    if money == 300:
        print("커피를 줍니다.")
        coffee = coffee-1
    elif money > 300:
        print("거스름돈 %d를 주고 커피를 줍니다." %(money-300))
        coffee = coffee - 1
    else:
        print("돈을 다시 돌려주고 커피를 주지 않습니다.")
        print("남은 커피의 양은 %d개입니다." %coffee)

    if not coffee:
        print("커피가 다 떨어졌습니다. 판매를 중지합니다.")
        break

# a를 2로 나누었을 때 나머지가 0이면 맨 처음으로 돌아감 (홀수만 출력하시오)
a = 0
while a < 10:
    a = a + 1
    if a % 2 == 0:continue
    print(a)

# “총 5명의 학생이 시험을 보았는데 시험 점수가 60점이 넘으면 합격이고  그렇지 않으면 불합격이다. 합격인지 불합격인지 결과를 보여주시오.”
marks = [90, 25, 67, 45, 80]
number = 0
for mark in marks:
    number = number + 1
    if mark >= 60:
        print("%d번 학생은 합격입니다." %number)
    else:
        print("%d번 학생은 불합격입니다." %number)

# 60점 이상인 사람에게는 축하 메시지를 보내고 나머지 사람에게는 아무런 메시지도 전하지 않는 프로그램
marks = [90, 25, 67, 45, 80]
number = 0
for mark in marks:
    number = number + 1
    if mark >=60:
        print("%d번 학생 축하합니다." %number)
    else:
        continue

# 1부터 10까지의 합계 (range 함수)
sum = 0
for i in range(1,11):
    sum = sum + i
print(sum)

# 구구단
for i in range(2, 10):
    for j in range(1, 10):
        print(i, " * ", j, i*j)
    print("")

# 리스트 각 항목에 3을 곱한결과를 담아라 (리스트 내포)
a = [1,2,3,4]
result = [num * 3 for num in a]
print(result)

# 리스트의 짝수에만 3을 곱하여 담기 (리스트 내포)
result = [num * 3 for num in a if num%2==0]
print(result)

# 구구단 (리스트 내포)
result = [x * y for x in range(2,10) for y in range(1,10)]
print(result)

# 여러개의 입력값을 받는 함수 만들기
def sum_many(*args):
    sum = 0
    for i in args:
        sum = sum + i
    return sum
print(sum_many(1,2,3,4,5))

# 함수의 인수로 *args(*입력변수)만 사용할 수 있는 것은 아님
def sum_mul(choice, *args):
    if choice == "sum":
        result = 0
        for i in args:
            result = result + 1
    elif choice == "mul":
        result = 1
        for i in args:
            result = result * i
        return result
print(sum_mul("mul", 2,3,4))

result = [i * j for i in range(2,10) for j in range(1,10)]