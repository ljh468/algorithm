# BFS(Bread-First Seach)
# BFS는 너비 우선 탐색이라고도 부르며, 그래프에서 가까운 노드부터 우선적으로 탐색하는 알고리즘
# BFS는 큐 구조를 이용하며, 구체적인 동작과정은 다음과같음
# 1. 탐색 시작노드를 큐에 삽입하고 방문처리 함
# 2. 큐에서 노드를 꺼낸뒤에 해당 노드의 인접 노드중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문처리함 (모두 저장)
# 3. 더이상 2번의 과정을 수행할 수 없을때 까지 반복

# 시작노드 : 1, 방문기준 : 번호가 낮는 인접노드 부터
# 탐색순서 : 1 -> 2 -> 3 -> 8 -> 7 -> 4 -> 5 -> 6
# BFS 소스 코드 예제

from collections import deque
# BFS 메서드 정싀
def bfs(graph, start, visited):
    # 큐(queue) 구현을 위해 deque 라이브러리 사용 ( 선입, 선출 )
    queue = deque([start])
    # 현재 노드를 방문처리
    visited[start] = True
    # 큐가 빌때까지 반복
    while queue:
        # 큐에서 하나의 원소를 뽑아서 출력
        v = queue.popleft()
        print(v, end=" ")
        # 아직 방문하지 않은 인접한 원소들을 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

# 각 노드가 연결된 정보를 표현 ( 2차원 리스트 )
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]
# 각 노드가 방문된 정보를 표현
visited = [False] * 9 # 0인덱스 부터 9인덱스 까지 모두 False로 채움 ( 1개 더 큰 크기의 노드를 초기화 )
# 정의된 BFS 함수 호출
bfs(graph, 1, visited) # -> 1,2,3,8,7,4,5,6