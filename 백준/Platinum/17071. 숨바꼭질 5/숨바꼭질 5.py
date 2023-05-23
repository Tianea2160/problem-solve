from collections import deque

N, K = map(int, input().split())

visit = [[-1 for i in range(500001)] for _ in range(2)]

queue = deque([(N, 0)])
visit[0][N] = 0

while queue:
    x, v = queue.popleft()
    flag = v % 2

    for nx in [x - 1, x + 1, x * 2]:
        if 0 <= nx <= 500000 and visit[1 - flag][nx] == -1:
            visit[1 - flag][nx] = v + 1
            queue.append((nx, v + 1))

t = 0
flag = 0
res = -1

while K <= 500000:
    if visit[flag][K] != -1:
        if visit[flag][K] <= t:
            res = t
            break
        flag = 1 - flag
        t += 1
        K += t
print(res)