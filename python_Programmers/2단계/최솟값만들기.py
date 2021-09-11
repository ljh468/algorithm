def solution(A,B):
    A.sort()
    B.sort(reverse=True)

    result = [x * y for x, y in zip(A, B)]

    return sum(result)

A = [1, 4, 2]
B = [5, 4, 4]
print(solution(A, B))