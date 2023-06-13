# 내 풀이
def solution(table, languages, preference):
    answer = []
    lang = []
    score = 0
    # table 리스트 생성
    t_lists = [x.split(' ') for x in table]

    # {'PYTHON': 7, 'C++': 5, 'SQL': 5}형태의 딕셔너리로 만듬
    l_dic = dict(zip(languages, preference))

    # l_list = python, c++ 이런거
    # t_list = 테이블
    for t_list in t_lists:
        t_list.reverse()
        for l_list in l_dic: # languages의 키값
            if l_list in t_list:
                score += l_dic[l_list] * (t_list.index(l_list) + 1)
        lang.append(t_list[-1])
        answer.append(score)
        lang_list = list(zip(lang, answer))
        score = 0
    lang_list.sort()

    for i, k in lang_list:
        if k == max(answer):
            return i

# 모범 풀이
def solution2(table, languages, preference):
    score = {}
    for t in table:
        for lang, pref in zip(languages, preference):
            if lang in t.split():
                score[t.split()[0]] = score.get(t.split()[0], 0) + (6 - t.split().index(lang)) * pref
    print(score)
    return sorted(score.items(), key=lambda item : [-item[1], item[0]])[0][0]
                                                    # 두번째 인자 기준으로 내림차순, 첫번째 인자 기준으로 오름차순
                                                    # 큰점수부터 내림차순 -> 사전순으로 오름차순

print('###########################################################################')
table = ["SI JAVA JAVASCRIPT SQL PYTHON C#",
         "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
         "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
         "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
         "GAME C++ C# JAVASCRIPT C JAVA"]
language = ["JAVA", "JAVASCRIPT"]
preference = [7, 5]
print(solution2(table, language, preference))
