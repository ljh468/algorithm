def solution(land):
    n = len(land) - 1  # n == 2 # N은 행의 개수가 된다.
    for i in range(n):  # 0, 1
        # i+1번째 행에 0번째 열에는 i번째 행에 1,2,3 열 중 최대값을 더해준다. 이런식으로 계속 더해나가면
        # N-1번째에 열들을 각 선택지에서 가질 수 있는 최대값이 된다.
        land[i + 1][0] += max(land[i][1], land[i][2], land[i][3])
        land[i + 1][1] += max(land[i][0], land[i][2], land[i][3])
        land[i + 1][2] += max(land[i][0], land[i][1], land[i][3])
        land[i + 1][3] += max(land[i][0], land[i][1], land[i][2])
    return max(land[-1])


# 모범풀이
def solution2(land):
    for i in range(1, len(land)):
        for j in range(len(land[0])):
            land[i][j] = max(land[i -1][: j] + land[i - 1][j + 1:]) + land[i][j]

    return max(land[-1])

land = [[1, 2, 3, 5], [5, 6, 7, 8], [4, 3, 2, 1]]
print(solution(land))
land = [[1, 2, 3, 5], [5, 6, 7, 8], [4, 3, 2, 1]]
print(solution2(land))