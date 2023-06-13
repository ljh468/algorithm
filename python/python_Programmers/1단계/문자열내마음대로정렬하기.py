def solution(strings, n):
    strings.sort()
    return sorted(strings, key=lambda x: x[n])

strings = ["sun", "bed", "car"]
n = 1
print(solution(strings ,n))