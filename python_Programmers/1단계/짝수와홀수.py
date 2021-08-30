def solution(num):
    if num % 2 ==0:
        return 'Even'
    return 'Odd'

def solution2(num):
    answer = ["Even", "Odd"][num & 1]
    print(num & 1)
    return answer
num = 5
print(solution(num))
print(solution2(num))
