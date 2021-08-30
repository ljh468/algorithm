a, b = map(int, input().strip().split(' '))

for i in range(b):
    for j in range(a):
        print('*' , end='')
    print()

# 모범 풀이
# 문자열을 곱하는 방식
a, b = map(int, input().strip().split(' '))
answer = ('*'*a +'\n')*b
print(answer)
