# 이스트소프트 코딩테슽 21-05-25

from collections import deque

queue = deque()
queue2 = deque()
lis = []
lis = list(map(int, input()))
print(lis)
for li in lis:
    queue.append(li)

print(queue)

lists = list(map(int,input()))
print(lists)
queuesize = len(lis)
listssize = len(lists)
result = 0
index = 0
resultcnt = 0

for list in lists:
    print(queue2)
    if len(queue) != 0:
        if queue[index] == list:
            queue2.append(list)
            index += 1

    if len(queue2) == queuesize:
        queue.clear()
        queue2.clear()
        for li in lis:
            queue.append(li)
        index = 0
        resultcnt += 1
        result = result + 3

if resultcnt == 0:
    print(-1)
else:
    print(len(lists) - result)