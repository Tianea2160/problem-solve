dx = [1,-1,0,0]
dy = [0,0,1,-1]

def solution(land):
    answer = 0
    n, m = len(land), len(land[0])
    columns = [0 for i in range(m)]
    visit = [[False for i in range(m)] for j in range(n)]
    
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and not visit[i][j]:
                # find count
                visit[i][j] = True
                queue = [(i, j)]
                pos = [(i, j)]
                count = 1

                while queue:
                    y, x = queue.pop()

                    for idx in range(4):
                        ny, nx = dy[idx] + y, dx[idx] + x

                        if 0 <= ny < n and 0 <= nx < m:
                            if land[ny][nx] == 1 and not visit[ny][nx]:
                                visit[ny][nx] = True    
                                count += 1  
                                queue.append((ny, nx))
                                pos.append((ny, nx))
                
                cols = set([b for a, b in pos])
                
                # add
                for idx in cols:
                    columns[idx] += count

    return max(columns)
