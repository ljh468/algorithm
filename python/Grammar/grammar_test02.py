# 파일을 쓰기 모드로 열게 되면 해당 파일이 이미 존재할 경우 원래 있던 내용이 모두 사라지고, 해당 파일이 존재하지 않으면 새로운 파일이 생성
# r 읽기모드, w 쓰기모드, a 마지막에 새로운내용 추가

# 파일을 쓰기 모드로 열어 출력값 적기
f = open("new01.txt", 'w', encoding='utf-8')
for i in range(1, 11):
    data = "%d번째 줄입니다. \n" % i
    f.write(data)
f.close()

# 파일의 첫번째 줄 읽기, 전체 줄 읽기
f = open("new01.txt", 'r', encoding='utf-8')
line = f.readline()
print(line)
lines = f.read()
print(lines)
f.close()

# 파일에 새로운 내용 추가하기
f = open("new01.txt", 'a', encoding='utf-8')
for i in range(11,21):
    data = "%d번째 줄입니다. \n" % i
    f.write(data)

# with as문을 이용하여 파일 자동 열고 닫기
with open("new02.txt", "w") as f :
    f.write("Life is too short, you need python")

