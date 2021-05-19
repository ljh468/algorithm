## 스택 자료 구조
# 먼저 들어온 데이터가 나중에 나가는 형식 (선입 후출)의 자료구조

# 스택 구현예제
# 삽입(5)-삽입(2)-삽입(3)-삽입(7)-삭제()-삽입(1)-삽입(4)-삭제()
stack = []
stack.append(5) # 리스트 형태
stack.append(2)
stack.append(3)
stack.append(7)
stack.pop()
stack.append(1)
stack.append(4)
stack.pop()
print(stack[::-1]) # 최상단 원소부터 출력 -> 1,3,2,5
print(stack)       # 최하단 원소부터 북력 -> 5,2,3,1

print("#######################################")
## 큐 자료구조
# 먼저 들어온 데이터가 먼저나가는 형식 (선입 선출)의 자료구조
# 큐는 입구와 출구가 모두 뚫려 있는 터널과 같은 형태로 시각화

# 큐 구현예제
# 삽입(5)-삽입(2)-삽입(3)-삽입(7)-삭제()-삽입(1)-삽입(4)-삭제()
from collections import deque
queue = deque() # 큐 구현을 위해 deque 라이브러리 사용

queue.append(5)
queue.append(2)
queue.append(3)
queue.append(7)
queue.popleft()
queue.append(1)
queue.append(4)
queue.popleft()

print(queue) # 먼저 들어온 순서대로 출력 -> deque([3,7,1,4])
queue.reverse() # 역순으로 바꾸기
print(queue) # 나중에 들어온 원소부터 출력 -> deque([4,1,7,3])
