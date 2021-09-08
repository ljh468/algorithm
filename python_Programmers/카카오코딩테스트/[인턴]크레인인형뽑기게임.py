# 내 풀이
def solution(board, moves):
    count = 0
    temp = []
    for move in moves: # 이동포인트로 탐색
        for c in range(len(board)): # 보드의 맨윗칸부터 조회하면서 값이 있는지 탐색
            if board[c][move-1] > 0: # 이동포인트에 값이 있다면

                # 창고에 값이 없거나, 바로이전에 창고에 들어간 인형과 이동포인트의 인형이 같지 않다면
                if len(temp) == 0 or temp[-1] != board[c][move-1]:
                    temp.append(board[c][move-1]) # 창고에 인형추가
                    board[c][move - 1] = 0 # 보드에 있는 인형 지우기
                    break
                else: # 바로이전에 창고에 들어간 인형과 이동포인트의 인형이 같다면
                    board[c][move - 1] = 0 # 보드에 있는 인형 지우기
                    del temp[-1] # 창고에 있는인형 지우기
                    count += 2 # 사라진 인형의 개수 더하기
                    break
    return count

# 모범 풀이
def solution2(board, moves):
    stacklist = []
    answer = 0

    for i in moves:
        for j in range(len(board)):
            if board[j][i-1] != 0:
                stacklist.append(board[j][i-1])
                board[j][i-1] = 0

                if len(stacklist) > 1:
                    if stacklist[-1] == stacklist[-2]: # 금방넣은 인형과 바로 이전에 넣은 인형이 같다면,
                        stacklist.pop(-1) # 지정한 위치(맨 오른쪽) 값을 취득한 후 삭제
                        stacklist.pop(-1)
                        answer += 2 # 사라진 인형 갯수 올려줌
                break

    return answer
print('###########################################################################')

board = [[0, 0, 0, 0, 0],
         [0, 0, 1, 0, 3],
         [0, 2, 5, 0, 1],
         [4, 2, 4, 4, 2],
         [3, 5, 1, 3, 1]]
moves = [1, 5, 3, 5, 1, 2, 1, 4]
print(solution(board, moves))
