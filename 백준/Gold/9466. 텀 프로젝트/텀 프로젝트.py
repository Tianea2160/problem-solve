import sys
sys.setrecursionlimit(111111)
input = sys.stdin.readline
t = int(input())

def dfs(cur):
    global ans
    visit[cur] = True
    cycle.append(cur)
    nxt = arr[cur]

    if visit[nxt]:
        if nxt in cycle:
            ans += cycle[cycle.index(nxt):]
    else:
        dfs(nxt)


for _ in range(t):
    n = int(input())
    arr = [0] + list(map(int, input().split()))
    ans = []
    visit = [False] * (n + 1)
    for i in range(1, n + 1):
        if not visit[i]:
            cycle = []
            dfs(i)
    print(n - len(ans))
