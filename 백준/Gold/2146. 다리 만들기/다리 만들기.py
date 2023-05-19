import sys
from collections import deque

input = sys.stdin.readline
n = int(input())

maps = [list(map(int, input().split())) for _ in range(n)]

dy = [0, 0, -1, 1]
dx = [1, -1, 0, 0]
cnt = 0
visit = [[False] * n for _ in range(n)]
answer = 987654321


def bfs(start):
    y, x = start
    queue = deque([start])
    visit[y][x] = True

    while queue:
        y, x = queue.popleft()
        maps[y][x] = cnt
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]

            if 0 <= ny < n and 0 <= nx < n:
                if maps[ny][nx] > 0 and not visit[ny][nx]:
                    visit[ny][nx] = True
                    queue.append([ny, nx])


def bfs2(cur):
    global answer
    queue = deque([])

    # 현재 섬을 기준으로 다른 섬까지의 최단 거리를 구해보자
    dist = [[-1] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if cur == maps[i][j]:
                dist[i][j] = 0
                queue.append([i, j])

    while queue:
        y, x = queue.popleft()

        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]

            if 0 <= ny < n and 0 <= nx < n:
                if maps[ny][nx] > 0 and maps[ny][nx] != cur:
                    answer = min(answer, dist[y][x])
                if maps[ny][nx] == 0 and dist[ny][nx] == -1:
                    dist[ny][nx] = dist[y][x] + 1
                    queue.append([ny, nx])


for i in range(n):
    for j in range(n):
        if not visit[i][j] and maps[i][j] != 0:
            cnt += 1
            bfs([i, j])

for i in range(1, cnt):
    bfs2(i)

print(answer)