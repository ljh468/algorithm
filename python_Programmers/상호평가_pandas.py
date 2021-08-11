import numpy as np
import pandas as pd

def solution(scores):
    answer = ''

    def grade(data):
        if data < 100 and data >= 90 :
            return 'A'
        elif data >= 80:
            return 'B'
        elif data >= 70:
            return 'C'
        elif data >= 50:
            return 'D'
        elif data >= 0:
            return 'F'
    # 데이터 프레임
    df = pd.DataFrame(scores)
    
    # 행번호와, 행의 요소를 이동하면서 조회
    for index, score in enumerate(scores):
        # 열을 하나씩 조회
        avg = df.iloc[:, index]
        avg_list = list(avg)
        # 유일한 값인지 조회
        cnt = avg_list.count(score[index])

        if cnt > 1:
            continue;
        # 유일한 최대값이거나, 유일한 최소값이면, None으로 채움
        elif score[index] == max(avg_list) or score[index] == min(avg_list):
            score[index] = None
    
    # 0으로 채워진 scores 리스트를 다시 데이터프레임으로 변환
    df = pd.DataFrame(scores)
    # 데이터프레임의 컬럼을 하나씩 조회해서 0이면 없애버림
    for col in range(0 ,len(df.columns)):
        # 컬럼 1개씩 확인
        avg = df.iloc[:, col]
        # 마스킹으로 None 제거
        avg = avg.dropna()

        print(avg)
        # 평균을 구하고 함수판별식으로 학점 확인
        answer += (grade(sum(avg)/avg.size))
    return answer


scores = [[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]
print(solution(scores))