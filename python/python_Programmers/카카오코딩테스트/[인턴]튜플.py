# 내 풀이
import re
from collections import Counter
def solution(s):
    result = []
    p = re.compile('\d+')
    num = list(map(int, p.findall(s)))
    dic = sorted(Counter(num).items(), key=lambda x: x[1], reverse=True)
    for i in dic:
        result.append(i[0])
    return result

# 모범 풀이
def solution2(s):
    # {{, }}를 제거 후 },{ 으로 나누기
    data = s[2:-2].split("},{")
    # 길이 별로 오름차순 정렬
    data = sorted(data, key=lambda x: len(x))
    print(data)
    answer = []
    for item in data:
        # 각각의 원소로 분류 후
        item = list(map(int, item.split(",")))
        print('item : ', item)
        for value in item:
            # 포함되어 있지 않으면 input
            if value not in answer:
                answer.append(value)
    return answer


print('###########################################################################')

s = "{{1,2,3},{2,1},{1,2,4,3},{2}}"
print(solution(s))
print(solution2(s))
