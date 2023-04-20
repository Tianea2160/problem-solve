from collections import deque

dy = [0,0,-1,1]
dx = [1,-1,0,0]

def bfs(board, start, size):
    row, col = size
    y, x = start
    visit = [[False]*col for _ in range(row)]
    queue = deque([(y, x, 1)])
    visit[y][x] = True    
    
    while queue:
        y, x, v = queue.popleft()

        for i in range(4):
            ny, nx = y, x
            while 0 <= ny + dy[i] < row and 0 <= nx + dx[i] < col and board[ny + dy[i]][nx + dx[i]] in ".RG":
                ny += dy[i]
                nx += dx[i]
                
            if ny == y and nx == x: continue
            if visit[ny][nx]: continue
            if board[ny][nx] == "G": return v
            visit[ny][nx] = True
            queue.append((ny, nx, v+1))
    return -1


def solution(board):
    answer = 0
    
    row, col = len(board), len(board[0])
    
    start = (-1, -1)
    for i in range(row):
        for j in range(col):
            if board[i][j] == "R":
                start = (i, j) 
    
    return bfs(board, start, (row, col))