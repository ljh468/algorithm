# 리스트에서 최대값인 인덱스 여러개 뽑기
def max_wh(n):
    res_list = [i for i, value in enumerate(n) if value == max(n)]
    return res_list

# 내 풀이
def solution(sizes):
    answer = 0
    w = []
    h = []
    for s1, s2 in sizes:
        if s1 >= s2:
            w.append(s1)
            h.append(s2)
        else:
            w.append(s2)
            h.append(s1)
    return max(w) * max(h)


# 모범 풀이
def solution2(sizes):
    row = 0
    col = 0
    for a, b in sizes:
        if a < b:
            a, b = b, a
        row = max(row, a)
        col = max(col, b)
    return row * col


sizes = [[60, 50], [30, 70], [60, 30], [80, 40]]
print(solution(sizes))
print(solution2(sizes))
