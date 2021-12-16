# 제한사항
# 새롭게 생성되는 집합은 첫번째 유저의 티어 점수 +-2까지의 유저들만 허용하는 집합으로 생성됩니다.
# 새로운 유저를 받지 못하게된 집합들은 매번 +-2* 만큼의 허용 티어 점수가 가중됩니다.
# 가중되어진 허용 티어 점수는 25점을 넘을 수 없습니다.*
# 집한간 가중된 티어 점수가 겹치게된다면 허용 티어 점수가 높은 집합을 우선적으로 유저가 할당되어집니다.
# 이미 집한 안에 들어간 유저에 대해서는 다른 집합의 허용 티어 점수에 영향을 받지 않습니다.

def solution(users, n):
    matchCnt = 0  # 매칭이 성사된 수
    tears = []  # users의 유저를 담을 리스트
    tears.append([users[0]])  # users의 첫번째 유저를 추가 (이중배열로 구성)
    cnt = [2]  # 집합이 새롭게 생성될때 허용 티어점수를 담을 리스트
    # 첫번째 유저를 추가 하였기때문에 허용티어 2 만큼 추가
    users = users[1:]  # 첫번째 유저를 제외한 users 리스트

    for user in users:  # 새로운 유저를 추가
        appand = 0  # 새로운 유저가 기존의 집합에 들어갔는지 판별할 변수
        matchcntidx = 0  # 매칭이 됐을때 제거해줄 cnt의 인덱스를 찾기 위한 변수
        print('tears 확인 : ', tears)
        print('cnt 확인 : ', cnt)
        for c in range(0, len(tears)):  # 매칭될 집합이 있는지 탐색
            # 매칭 집합의 +-허용티어 점수에 포함되면
            if appand == 0 and user <= int(tears[c][0]) + int(cnt[c]) and user >= int(tears[c][0]) - int(cnt[c]):
                tears[c].append(user)  # 매칭 집합에 유저를 추가
                if len(tears[c]) == n:  # 집합안 유저의 수가 N명이 되면
                    matchCnt += 1  # 매칭 수 1추가
                    tears.pop(c)  # 매칭 집합 제거
                    matchcntidx = c  # 매칭집합의 허용티어점수가 들어있는 cnt의 인덱스를 추가
                    appand = 1  # 매칭 완료
            else:
                if int(cnt[c]) >= 25:  # 가중되어진 허용 티어 점수는 25점을 넘을 수 없음
                    break
                else:  # 새로운 유저를 받지 못하게된 집합들은 매번 +-2* 만큼의 허용 티어 점수가 가중
                    cnt[c] += 2

        if appand == 0:  # 새로운 유저가 매칭이 되지않았다면
            tears.append([user])  # 새롭게 생성되는 집합은 첫번째 유저의 티어 점수 +-2까지의 유저들만 허용하는 집합으로 생성
            cnt.append(2)  # 집합이 새롭게 생성될때 허용 티어점수 +-2를 리스트에 추가

        elif appand == 1:  # 새로운 유저가 매칭이 되었다면
            cnt.pop(matchcntidx)  # 매칭집합의 허용티어점수가 들어있는 cnt 제거


    return matchCnt  # 결과값 : 매칭이 완료된 집합의 갯수

users = [0, 5, 11, 7, 13, 22, 14, 19, 25, 22]
n = 2
print(solution(users, n))