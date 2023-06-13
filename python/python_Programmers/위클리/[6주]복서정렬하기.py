def solution(weights, head2head):
    lis = []
    dic = {}
    num = 1
    # wights와 head2head를 리스트로 묶어줌
    heads = list(map(list, zip(weights, head2head)))
    print(heads)
    for head in heads:
        # 승률 구하기
        win_cnt = head[1].count('W') # 이긴횟수
        loss_cnt = head[1].count('L') # 진횟수
        fight_total = win_cnt + loss_cnt # 싸운 경기수
        if win_cnt != 0 or loss_cnt !=0: # 경기를 치루지 않았을경우 (예외처리)
            rate = win_cnt / fight_total # 이긴횟수 / 진횟수 = 승률
        else:
            rate = 0 # 경기를 치루지 않았으면 승률은 0
        print('rate : ', rate)
        # rate_per = '%.2f%%' % (rate * 100.0)
        lis.append(rate)

        # 자기보다 무거운 복서를 이긴횟수
        win_weight = [i for i, els in enumerate(head[1]) if els =='W'] # 자기가 이긴선수의 인덱스 여러개 반환
        cnt = 0
        for i in win_weight:
            if head[0] < heads[i][0]: # 자신이 이긴선수의 몸무게가 더크다면
                cnt += 1 # 1추가
        lis.append(cnt)

        # 몸무게
        lis.append(head[0])

        # 딕셔너리에 선수번호, 승률, 무거운복서이긴횟수, 몸무게가 담긴 리스트 추가
        dic[num] = lis
        num += 1 # 다음 딕셔너리로 이동

        # 딕셔너리에 담은 리스트 초기화
        lis = []
    # dic = {1: ['33.33%', 1, 50], 2: ['33.33%', 0, 82], 3: ['66.67%', 2, 75], 4: ['66.67%', 0, 120]}
    print(dic.items())
    # 딕셔너리의 items로 승률->오름차순 , 무거운복서이긴횟수->오름차순, 몸무게->오름차순 정렬
    sor = sorted(dic.items(), key=lambda item: [-item[1][0], -item[1][1], -item[1][2]])
    print(sor)
    return [i[0] for i in sor]

print('###########################################################################')
weights = [50,82,75,120]
head2head = ["NLLL","WNLL","LWNW","WWLN"]
print(solution(weights, head2head))