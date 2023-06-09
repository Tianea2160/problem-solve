dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

direct_dict = {
    "N" : 0,
    "S" : 1,
    "W" : 2,
    "E" : 3,
}


def solution(park, routes):
    answer = []
    
    n, m = len(park), len(park[0])
    cur = (-1, -1)
    for i in range(n):
        for j in range(m):
            if park[i][j] == "S":
                cur = (i, j)
    y, x = cur
    
    for route in routes:
        direct, size_str = route.split(" ")
        size = int(size_str)

        ny, nx = y + dy[direct_dict[direct]] * size, x + dx[direct_dict[direct]] * size
        if 0 <= ny < n and 0 <= nx < m:
            # 해당 경로에 장애물이 있는지 확인이 필요
            
            if y == ny:
                can_do = True
                for i in range(min(x, nx), max(x, nx)+1):
                    if park[ny][i] == "X":
                        can_do = False
                        break
                if not can_do: continue
            else:
                can_do = True
                for i in range(min(y, ny), max(y, ny)+1):
                    if park[i][nx] == "X":
                        can_do = False
                        break
                if not can_do: continue
            y, x = ny, nx
    return (y, x)