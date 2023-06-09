def solution(players, callings):
    answer = []
    ranks = dict()
    # 탐색의 시간복잡도를 줄이기위해서 딕셔너리를 사용
    for idx, player in enumerate(players):
        ranks[player] = idx
    
    for player in callings:
        # 호명된 플레이어의 위치
        rank = ranks[player]
        # 앞 등수 사람 이름
        prev_player = players[rank-1]
        
        # 다음 탐색을 위한 등수 변경
        ranks[player] = rank-1
        ranks[prev_player] = rank
        # 플레이어 이름 변경
        players[rank], players[rank-1] = players[rank-1], players[rank]
    return players