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
    print(lang_list)
    lang_list.sort()
    for i in lang_list:
        if answer.index(max(answer)) == i[1]:
            print(i[0])
            return i[0]
    return 0


table = ["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
         "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
         "GAME C++ C# JAVASCRIPT C JAVA"]
language = ["JAVA", "JAVASCRIPT"]
preference = [7, 5]
print(solution(table, language, preference))
