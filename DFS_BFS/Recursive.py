# 재귀함수
# 재귀함수(Recursive Function)란 자기자신을 다시 호출하는 함수

def recursive_function0():
    print('재귀 함수를 호출합니다.')
    recursive_function0()


# recursive_function()
# 파이썬은 1000번의 재귀가 돌면 maximum recursion depth 오류뜸


# 재귀함수 종료조건
# 문제풀이시 재귀함수의 종료 조건을 반드시 명시해야함
# < 종료 조건을 포함한 재귀함수 예제>

def recursive_function1(i):
    # 100번째 호출시 종료
    if i == 100:
        return
    print(i, '번째 재귀함수에서', i + 1, '번째 재귀함수를 호출')
    recursive_function1(i + 1)
    print(i, '번째 재귀함수를 종료합니다.')


# recursive_function1(1)
# 재귀함수의 호출은 stack 의 원리(LIFO), 마지막에 호출된 함수가 먼저 종료된다

print("#######################################")
#  예제00)
# 팩토리얼 구현
# n! = 1*2*3...*(n-1)*n
# 수학적으로 0!, 1!의 값은 1임

# 반복적으로 구현한 n!(팩토리얼)
def factorial_iterative(n):
    result = 1
    # 1부터 n까지의 수를 차례대로 곱하기
    for i in range(1, n + 1):
        result *= i
    return result

print('반복적으로 구현 : ', factorial_iterative(5))

# 재귀적으로 구현한 n!(팩토리얼)
i = 0
def factorial_recursive(n):
    if n <= 1:
        return 1
    # n! = n * (n-1)!
    return n * factorial_recursive(n-1)
    # ex) 5 * 4! = 120
    #     4 * 3! = 24
    #     3 * 2! = 6
    #     2 * 1  = 2

print('재귀적으로 구현 : ', factorial_recursive(5))

print("#######################################")
#  예제01)
# 최대공약수 계산 (유클리드 호제법) 예제
# 2개의 자연수에 대한 최대공약수를 구하는 대표적인 알고리즘으로는 유클리드 호제법이 있음

# 유클리드 호제법
# 두 자연수 A, B에 대하여 (A > B) A를 B로 나눈 나머지를 R 이라고 함
# 이때 A와 B의 최대공약수는 B와 R의 최대공약수와 같음
# 유클리드 호제법의 아이디어를 그대로 재귀 함수로 작성
# 예시 : GCD(192, 162)
# a : 192, b : 162
# a : 162, b : 30
# a : 30, b : 12
# a : 12, b : 6

def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a % b)
print("192와 162의 최대공약수 : ", gcd(192, 162))

# 재귀 함수 사용의 유의사항
# 재귀함수를 잘 활용하면 복잡한 알고리즘을 간결하게 작성할 수 있습니다.
# 단, 오히려 다른 사람이 이해하기 어려운 형태의 코드가 될 수도 있으므로 신중하게 사용해야함
# 모든 재귀 함수는 반복문을 이용하여 동일한 기능을 구현할 수 있음
# 재귀함수가 반복문보다 유리한 경우도 있고 불리한 경우도 있음
# 컴퓨터가 함수를 연속적으로 호출하면 컴퓨터 메모리 내부의 스택 프레임에 쌓임
# 그래서 스택을 사용해야 할 때 구현상 스택 라이브러리 대신에 재귀 함수를 이용하는 경우가 많음
