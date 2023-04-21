"""
	==========
0 1
0 2
2 1
==========
1 0
2 1
==========
1 1
0 2
==========
1 2
1 0
==========
2 1
0 2
1 0
==========
0 0
2 1
2 1
==========
0 2
1 0
2 1
==========
2 0
2 1
1 0
==========
2 2
1 0
1 0
"""


def is_win(board, y, x):
    left_x, right_x = (x-1)%3, (x+1)%3
    up_y, down_y = (y-1)%3, (y+1)%3
    # print("=")
    # print(y, x)
    # print(left_x,right_x)
    # print(up_y, down_y)
    
    if board[y][x] == board[y][left_x] == board[y][right_x]:
        return True
    if board[y][x] == board[up_y][x] == board[down_y][x]:
        return True
    if (board[y][x] == board[up_y][left_x] == board[down_y][right_x]) or (board[y][x] == board[up_y][right_x] == board[down_y][left_x]):
        return True
    return False

def solution(board):
    o_pos = []
    x_pos = []
    for i in range(3):
        for j in range(3):
            if board[i][j] in "O": o_pos.append((i, j))
            if board[i][j] in "X": x_pos.append((i, j))
    if len(o_pos) < len(x_pos) or len(o_pos) - len(x_pos) > 1:
        return 0
    for y, x in o_pos:
        if is_win(board, y, x) and (len(o_pos) != len(x_pos)+1):
            return 0
    for y, x in x_pos:
        if is_win(board, y, x) and (len(o_pos) != len(x_pos)):
            return 0
    return 1