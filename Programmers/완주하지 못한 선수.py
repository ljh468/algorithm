# 완주하지 못한 선수
participant = list(input().split(","))
completion = list(input().split(","))

print(participant)
print(completion)

# 리스트를 정렬해줌
participant.sort()
completion.sort()
# zip 내장함수로 서로 짝지어줌
for p, c in zip(participant, completion):
    print("p : ",p)
    print("c : ",c)
    # 짝이 서로 맞지않으면 완주하지 못한 선수임
    if p != c:
        print(p)
# 짝이 모두 맞게 나온다면 participant에서 마지막 남은것이 완주하지 못한 선수
print(participant[-1])