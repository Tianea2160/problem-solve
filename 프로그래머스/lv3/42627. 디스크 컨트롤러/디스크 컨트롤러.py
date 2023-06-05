from collections import deque
from heapq import heappop, heappush

def solution(jobs):
    answer = 0
    jobs.sort(key=lambda x : (x[0], x[1]))
    jobs = deque(jobs)
    wait = []
    n = len(jobs)
    cur = 0
    while jobs or wait:
        # 현재 시작할 작업을 찾기
        if wait:
            d, s = heappop(wait)
        elif jobs and cur >= jobs[0][0]:
            s, d = jobs.popleft()
        else:
            cur += 1
            continue
        cur += d
        answer += (cur - s)
        # 현재 시간을 기준으로 시작할 수 있는 작업을 대기 힙에 저장
        while jobs and jobs[0][0] < cur:
            ns, nd = jobs.popleft()
            heappush(wait, (nd, ns))
    
    return answer // n