import sys
from collections import deque

input = sys.stdin.readline

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

N, M, K = map(int, input().split())

maps = [list(map(int, input().strip())) for _ in range(N)]

MAX = float('inf')
visit = [[[MAX] * (K + 1) for _ in range(M)] for _ in range(N)]
visit[0][0][K] = 0

queue = deque([[0, 0, K, 1]])
ans = MAX

while queue:
    y, x, k, v = queue.popleft()

    if (y, x) == (N - 1, M - 1):
        ans = min(v, ans)
        break

    day = v % 2
    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]

        if 0 <= ny < N and 0 <= nx < M:
            if maps[ny][nx] == 0 and visit[ny][nx][k] > v:
                visit[ny][nx][k] = v
                queue.append([ny, nx, k, v + 1])
            elif maps[ny][nx] == 1 and k > 0 and visit[ny][nx][k - 1] > v: # 장애물이 있고 벽을 격파할 수 있는 기회가 있는 경우
                if not day:  # 밤
                    queue.append([y, x, k, v + 1])
                else:  # 낮
                    visit[ny][nx][k - 1] = v
                    queue.append([ny, nx, k - 1, v + 1])

print(ans if ans != MAX else -1)
