def solution(numbers):
    answer = []

    for i in range(len(numbers)):
        for j in range(len(numbers)):
            if i == j:
                continue
            result = numbers[i] + numbers[j]
            answer.append(result)
    answer = list(set(answer))
    answer.sort()
    return answer


# 모범 풀이
def solution2(numbers):
    answer = []
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            answer.append(numbers[i] + numbers[j])
    return sorted(list(set(answer)))

numbers = [5,0,2,7]
print(solution(numbers))