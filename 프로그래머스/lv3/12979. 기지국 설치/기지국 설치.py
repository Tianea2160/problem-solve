from collections import deque
from math import ceil

def solution(n, stations, w):
    answer = 0
    distance = []
    
    distance.append(max(0,stations[0] - w-1))
    distance.append(min(n,n - (stations[-1] + w)))
    for i in range(1, len(stations)):
        distance.append((stations[i] - w) - (stations[i-1] + w+1))
        
    for i in distance:
        if i < 0: continue
        answer += ceil(i/(w*2+1))
    
    return answer