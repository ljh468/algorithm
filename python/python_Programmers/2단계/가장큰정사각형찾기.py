def solution(board):
    n = len(board)
    m = len(board[0])

    # dp 준비
    dp = [[0] * m for _ in range(n)]
    dp[0] = board[0]
    for i in range(1, n):
        dp[i][0] = board[i][0]

    # 2중 포문으로 연산
    for i in range(1, n):
        for j in range(1, m):
            if board[i][j] == 1:
                dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1

    # 최대 넓이 구하기
    answer = 0
    for i in range(n):
        temp = max(dp[i])
        answer = max(answer, temp)

    return answer ** 2

def solution2(board):
    width = len(board[0])
    height = len(board)
    for x in range(1,height):
        for y in range(1,width):
            if board[x][y] == 1:
                board[x][y] = min(board[x-1][y-1], min(board[x-1][y], board[x][y-1])) + 1
    return max([item for row in board for item in row])**2

board = [[0,1,1,1],
         [1,1,1,1],
         [1,1,1,1],
         [0,0,1,0]]
print(solution(board))
print(solution2(board))

