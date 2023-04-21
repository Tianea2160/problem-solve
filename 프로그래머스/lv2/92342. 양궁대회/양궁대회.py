from itertools import combinations_with_replacement

def solution(n, info):
    max_board = [-1]
    max_gap = -1
    for score_list in list(combinations_with_replacement([i for i in range(11)], n)):
        lion, apeach = 0, 0
        score_board = [0 for _ in range(11)]
        for score in score_list:
            score_board[10-score] += 1
        for i in range(11):
            if score_board[i] == 0 and info[i] == 0:
                continue
            if score_board[i] > info[i]:
                lion += (10-i)
            else:
                apeach += (10-i)
        if lion > apeach:
            gap = lion - apeach
            if max_gap < gap:
                max_gap = gap
                max_board = score_board
    return max_board