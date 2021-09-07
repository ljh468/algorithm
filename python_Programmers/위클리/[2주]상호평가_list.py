
def solution(scores):
    import statistics
    def scoring(x):
        if x >= 90:
            return 'A'
        elif 80 <= x < 90:
            return 'B'
        elif 70 <= x < 80:
            return 'C'
        elif 50 <= x < 70:
            return 'D'
        else:
            return 'F'
    # 같은열끼리 리스트로 묶어주는 작업
    scores = list(map(list, zip(*scores)))
    students = len(scores)
    answer = ''

    for i in range(students):
        maximum = max(scores[i])
        minimum = min(scores[i])
        if scores[i].count(maximum) == 1 and scores[i][i] == maximum:
            answer += scoring((sum(scores[i])-scores[i][i])/(students-1))
        elif scores[i].count(minimum) == 1 and scores[i][i] == minimum:
            answer += scoring((sum(scores[i])-scores[i][i])/(students-1))
        else:
            answer += scoring(statistics.mean(scores[i]))

    return answer

scores = [[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]
print(solution(scores))