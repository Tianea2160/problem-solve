from collections import deque

f, s, g, u, d = map(int, input().split())

visit = [False] * (f + 1)
dx = [u, -1 * d]
queue = deque([[s, 0]])
visit[s] = True

ans = "use the stairs"
while queue:
    x, v = queue.popleft()
    if x == g:
        ans = v
        break
    for i in range(2):
        nx = x + dx[i]

        if 1 <= nx <= f and not visit[nx]:
            visit[nx] = True
            queue.append([nx, v + 1])
print(ans)
