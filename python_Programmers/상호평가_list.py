import pandas as pd


def solution(scores):
    def grade(data):
        if data < 100 and data >= 90:
            return 'A'
        elif data >= 80:
            return 'B'
        elif data >= 70:
            return 'C'
        elif data >= 50:
            return 'D'
        else:
            return 'F'

    answer = ''

    # 데이터프레임으로 만듬
    df = pd.DataFrame(scores)

    for index, score in enumerate(scores):
        avg = df.iloc[:, index]
        avg_list = list(avg)

        cnt = avg_list.count(df.iloc[index, index])

        if cnt > 1:
            continue;
        elif score[index] == max(avg_list) or score[index] == min(avg_list):
            score[index] = 0

    df = pd.DataFrame(scores)

    for col in range(0, len(df.columns)):
        re = 0
        avg = df.iloc[:, col]
        avg = avg[avg != 0]
        answer += (grade(sum(avg) / avg.size))

    return answer
