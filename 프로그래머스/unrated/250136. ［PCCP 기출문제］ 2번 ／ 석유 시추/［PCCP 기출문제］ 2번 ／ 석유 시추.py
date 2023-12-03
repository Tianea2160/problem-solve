def solution(land):
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    answer = 0
    n, m = len(land), len(land[0])
    columns = [0 for i in range(m)]
    visit = [[False for i in range(m)] for j in range(n)]
    
    # pre processing
    for i in range(n):
        for j in range(m):
            if land[i][j] == 0:
                continue
        
            if not visit[i][j]:
                visit[i][j] = True
                queue, pos = [(i, j)], [(i, j)]
                count = 1
                cols = set([j])
                
                # search oil count
                while queue:
                    y, x = queue.pop()

                    for k in range(4):
                        ny, nx = dy[k] + y, dx[k] + x

                        if 0 <= ny < n and 0 <= nx < m:
                            if land[ny][nx] == 0:
                                continue

                            if not visit[ny][nx]:
                                visit[ny][nx] = True    
                                count += 1
                                queue.append((ny, nx))
                                pos.append((ny, nx))
                                cols.add(nx)
                
                # add oil count where oil colum index
                for idx in cols:
                    columns[idx] += count
    
    return max(columns)
