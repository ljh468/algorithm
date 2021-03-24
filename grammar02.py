print("#######################################")
# 6. 조건문과 반복문
print("#######################################")
# 6-1. 조건문
# 프로그램의 흐름을 제어하는 문법
x = 15
if x >= 10:
    print("x>=10")
if x >= 0:
    print("x>=0")
if x >= 30:
    print("x>=30")
# -> x는 "x>=10", "x>=30" 두조건에 부합

# 조건문 형식
# if 조건문1 :
#     조건문1이 True일때 실행되는 코드
# elif 조건문2 :
#     조건문1에 해당하지않고 조건문2가 True일때 실행되는 코드
# else :
#     위의 모든 조건문이 모두 True값이 아닐때 실행되는코드

# 비교연산자 x==y, x!=y, x>y, x<y, x>=y, x<=y
# 논리연산자 x and y, x or y, not x (x가 거짓이면 True)
a = 15
if a <= 20 and a >=0:
    print("yes") # -> Yes출력

# in, not in 연산자
#   x in 리스트  -- 리스트안에 x가 들어있을때 True
#   x not in 문자열 -- 문자열안에 x가 들어가 있지 않을때 True
# pass는 아무것도 처리하고 싶지않을때 pass사용
# 디버깅 과정에서 일단 조건문 형태만 만들고 처리부분은 비워놓고 싶은경우 사용
score = 85
if score >= 80:
    pass # 나중에 작성할 코드
else:
    print("성적이 80점 미만입니다.")
print("프로그램 종료")

# 조건문의 간소화1
score = 85
if score >= 80: result = "success"
else: result = "fail"
print(result)

# 조건문의 간소화2
score = 85
result = "success" if score>=80 else "fail"
print(result)

# 조건문내의 부등식 (python은 수학의 부등식 사용가능)
# ex) x>0 and x<20과 0<x<20은 같은결과를 반환
x = 15
if x > 0 and x < 20:
    print("x는 0이상 20미만의 수입니다.")

x = 15
if 0 < x < 20:
    print("x는 0이상 20미만의 수입니다.")

print("#######################################")
# 6-2 반복문 (for문이 더 간결)
print("#######################################")
# while 문
#### 1부터 9까지 정수의 합 (while 문) ####
i = 1
result = 0
# i가 9보다 작거나 같을때 아래코드를 반복적으로 실행
while i <= 9:
    result += i
    i +=1
print(result)

#### 1부터 9까지 홀수의 합 (while문) ####
i = 1
result = 0
# i가 9보다 작거나 같을때 아래코드를 반복적으로 실행
while i <= 9 :
    if i % 2 == 1: # i를 2로 나눈나머지가 1일경우
        result += i # 홀수면 result에 추가
    i += 1
print(result)

# 반복문에서의 무한루프
# x = 10
# while x > 5:
#    print(x)

print("#######################################")
# for 문
# for문의 형식
# for 변수 in 리스트 :
#       실행할 소스코드

# 연속적인 값을 차례대로 순회할때는 range()사용
# range(시작값, 끝값+1) 형태

# 예제1
result = 0
for i in range(1, 10): # i는 1부터 9까지 모든값을 순회
    result += i
print(result)

# 예제2
array = [9,8,7,6,5]
for i in range(1,10):
    if i % 2 == 0:
        continue
    result += i

# Continue
# 반복문에서 남은코드의 실행을 건너뛰고, 다음반복을 진행하고자 할때 continue사용

## 1부터 9까지 홀수의합
result = 0
for i in range(1,10):
    if i % 2 == 0: # i가 2로 나누어떨어지면 건너뛰기
        continue
    result += i
print(result)

## 반복문을 탈출하고자 할대 break문 사용
i = 1
while True:
    print("현재 i의 값 : ", i)
    if i == 5:
        break # i가 5와 같으면 반복문 탈출
    i += 1

## 학생 합격여부 판단문제
# 1) 점수가 80점만 넘으면 합격
score = [90, 85, 77, 65, 97]
for i in range(5):
    if score[i] >= 80:
        print(i+1, "번 학생은 합격입니다.")
        # -> 1,2,5 번 학생은 합격입니다.

# 2) 구구단 예제 < 중첩된 반복문 >
for i in range(2,10):
    for j in range(1,10):
        print(f"{i}*{j} = {i*j}")

# 3) 특정번호의 학생은 제외하기
score = [90,85,77,65,97]
cheating_student_list = {2,4}
for i in range(5): # (0,1,2,3,4)
    if i+1 in cheating_student_list:
      # (1,2,3,4,5)
        continue
    if score[i] >= 80:
        print(i+1, "번 학생은 합격입니다.") # -> 1,5번 학생은 합격

print("#######################################")
# 7. 함수와 람다표현식
# 7-1. 함수(Function)는 프로그램 안에서 반복사용되는 특정한작업을 하나로 묶어 놓은것
# 불필요한 소스코드의 반복을 줄일 수 있음

# 내장함수 : 파이썬에서 기본적으로 제공하는 함수
# 사용자함수 : 직접 정의하여 사용할 수 있는 함수

# 함수의 형태
# def 함수명(매개변수):
#   실행할 소스코드
#   return 반환값 (결과는 존재하지 않을수도 있음)

# 더하기 함수(1)
def add(a,b):
    return a+b
print(add(3,7)) # -> 10

# 더하기 함수(2)
def add(a,b):
    print("함수의 결과는 : ", a+b)
add(3,7) # -> "함수의 결과는 : 10"

# 파라미터의 변수를 직접지정 할수있음
def add(a,b):
    print("함수의 결과 : ", a+b)
add( a=7, b=3 )

# 함수 밖에 선언된 변수를 참조, Global
a = 0
def func():
    global a # 전역변수 a 사용
    a += 1
for i in range(10):
    func()
print(a) # 전역변수의 a의 값이 변함

# 리스트 변수는 자동으로 global적용
array = [1,2,3,4,5]
def func():
    array.append(6) # 자동으로 global 선언됨
func() # 6을 리스트에 추가
print(array)

# 여러개의 반환값
def operator(a,b):
    add_var = a+b
    subtract_var = a-b
    multiply_var = a*b
    divide_var = a/b
    rest_var = a%b
    share_var = a//b
    return add_var, subtract_var, multiply_var, divide_var, rest_var, share_var

a,b,c,d,e,f = operator(9,3)
print(a,b,c,d,e,f)
# 6가지 연산자 결과산출

print("#######################################")
## 7-2. 람다표현식
def add(a,b):
    return a + b
# 일반적인 add() 메서드 사용
print(add(3,7))

# 람다표현식으로 구현한 add()메서드
print((lambda a,b : a+b)(3,7))

# 재사용이 가능한 람다표현식 예제
add = lambda x,y : x+y
print(add(3,4)) # -> 7

# 리스트에 담아서 사용하는 람다표현식
lambdas = [lambda x : x+10, lambda x : x+100]
print(lambdas[0](5)) # -> 15
print(lambdas[1](5)) # -> 105

# 예시 1) 내장함수에서 자주사용되는 람다함수
array = [('홍길동', 50), ('이순신', 32), ('아무개', 74)]
def my_key(x):
    return x[1]

print(sorted(array, key = my_key))
print(sorted(array, key= lambda x : x[1]))
# -> [('이순신',32), ('홍길동',50), ('아무개',74)]

# sort와 sorted의 차이
# sort는 원본내용이 바뀜
# sorted는 정렬된 내용을 반환 (기준을 key를 통해 설정)

# 예시 2) 여러개의 리스트를 합쳐서 적용
list1 = [1,2,3,4,5]
list2 = [6,7,8,9,10]
# map은 각각의 원소에 어떠한 함수를 적용하고자 할때 사용가능
result = map(lambda a,b : a+b, list1, list2)
print(list(result))
# -> [7,9,11,13,15]

print("#######################################")
## 8. 표준라이브러리
## 8-1. 표준라이브러리 설명
# 1. 내장함수 : 입출력부터 정렬함수까지 기본적인 함수제공
# 2. itertools : 반복되는 형태의 데이터를 처리하기 위한 유용한 기능제공 (순열, 조합 lib)(완전탐색)
# 3. heapq : 힙 자료구조를 제공 (우선순위큐 기능을 구현하기 위해 사용)
# 4. bisect : 이진탐색 (Binary Search)
# 5. collections : 덱(deque), 카운터(counter) 등의 유용한 자료구조를 포함
# 6. math : 필수적인 수학적 기능을 제공(팩토리얼, 제곱근, 최대공약수(GCD), 삼각함수관련, pi와 같은 상수를 포함

## 자주 사용되는 내장함수
# sum()
result = sum([1,2,3,4,5])
print(result)

# eval()
result = eval("(3+5)*7")
print(result)

# min(), max()
min_result = min(7,3,5,2)
max_result = max(7,3,5,2)
print(min_result, max_result)

# sorted() <정렬된 내용을 반환>
# 오름차순
result = sorted([9,1,8,5,4])
# 내림차순
reverse_result = sorted([9,1,8,5,4], reverse=True)
print(result) # -> [1,4,5,8,9]
print(reverse_result) # -> [9,8,5,4,1]

# Sorted() with key
array = [('홍길동', 35), ('이순신', 75), ('아무개', 50)]

result = sorted(array, key=lambda x: x[1], reverse=True)
                                    # 두번째 index인 수를 기준으로 내림차순
print(result)
# -> [('이순신', 75), ('아무개', 50), ('홍길동', 35)]

print("#######################################")
## 8-2. 순열과 조합
# 모든 경우의 수를 고려해야 할때 어떤 라이브러리를 효과적으로 사용 할수있을까?

# 순열 (Permutation)
# 서로다른 n개에서 서로다른 r개를 선택하여 일렬로 나열하는것 (중복 X, 순서구분O)
# {'A','B','C'}에서 3개를 선택하여 나열하는경우 : 'ABC', 'ACB', 'BAC', 'BCA', 'BCA', 'CAB', 'CBA'
# 순열의 수 : nPr = n * (n-1)*(n-2)*...(n-r+1)

# 조합 (Combination)
# 서로다른 n개에서 순서에 상관없이 서로다른 r개를 선택하는것 (중복 X, 순서구분 O)
# {'A','B','C'}에서 순서를 고려하지않고 2개를 뽑는경우 : 'AB', 'AC', 'BC'
# 조합의 수 : nCr = n * (n-1)*(n-2)*...(n-r+1) / r!

# 순열사용 예제
from itertools import permutations
data = ['A','B','C'] # 데이터 준비
result = list(permutations(data, 3)) # 모든 순열구하기
print(result)

# 조합사용 예제
from itertools import combinations
data = ['A','B','C'] # 데이터 준비
result = list(combinations(data,2)) # 2개를 뽑는 모든 조합구하기
print(result)

# 중복순열 사용
from itertools import product
data = ['A','B','C'] # 데이터 준비
result = list(product(data, repeat=2)) # 2개를 뽑는 모든 순열구하기(중복허용)
print(result)

# 중복조합 사용
from itertools import combinations_with_replacement
data = ['A','B','C'] # 데이터 준비
result = list(combinations_with_replacement(data, 2)) # 2개를 뽑는 모든 조합구하기(중복허용)
print(result)

## Counter
# 등장횟수를 세는 파이썬 collections 라이브러리
from collections import Counter
counter = Counter(['red', 'blue', 'red', 'green', 'blue', 'blue'])
# blue 등장한 횟수 출력
print(counter['blue'])
# green 등장한 횟수 출력
print(counter['green'])
# 사전 자료형으로 반환
print(dict(counter))

## 최대공약수와 최소공배수
import math

def lcm(a,b):
    return a*b // math.gcd(a,b)

a,b = 21,14
print(math.gcd(21,14)) # 최대공약수(GCD)계산 -- 공통된 약수중 가장 큰값 -> 7
print(lcm(21,14)) # 최소공배수(LCM)계산 -- 공통된 배수중에서 가장 작은값 -> 42


#### 문법 끝



