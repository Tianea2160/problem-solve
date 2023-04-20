def solution(r1, r2):
    answer = 0
    min_y, max_y = r1, r2
    
    for x in range(0, r2):
        while r2**2 < max_y**2 + x**2: # 현재 위치의 최대 y 값을 구해야함.
            max_y -= 1
        while min_y-1 and r1**2 <= x**2 + (min_y-1)**2:
            min_y -= 1
        answer += (max_y - min_y) + 1
    return answer*4