import sys
from collections import deque

input = sys.stdin.readline

n, m, p = map(int, input().split())

s = [0] + list(map(int, input().split()))

maps = [[c for c in input().rstrip()] for _ in range(n)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
queues = [deque() for _ in range(p + 1)]
cnts = [0] * (p + 1)

for i in range(n):
    for j in range(m):
        if maps[i][j] != "#" and maps[i][j] != ".":
            cnts[int(maps[i][j])] += 1
            queues[int(maps[i][j])].append([i, j])

is_moved = True
while is_moved:
    is_moved = False

    for i in range(1, p + 1):
        if not queues[i]:
            continue
        queue = queues[i]
        for _ in range(s[i]):
            if not queue:
                break
            for _ in range(len(queue)):
                y, x = queue.popleft()

                for idx in range(4):
                    ny, nx = y + dy[idx], x + dx[idx]

                    if 0 <= ny < n and 0 <= nx < m and maps[ny][nx] == ".":
                        maps[ny][nx] = str(i)
                        queue.append([ny, nx])
                        cnts[i] += 1
                        is_moved = True

print(" ".join(map(str, cnts[1:])))
