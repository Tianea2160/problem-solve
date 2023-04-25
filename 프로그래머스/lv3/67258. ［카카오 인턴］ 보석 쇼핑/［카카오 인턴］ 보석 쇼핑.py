from collections import defaultdict

def solution(gems):
    answer = []
    n = len(set(gems))
    l, r = 0, 0
    cur = defaultdict(int)
    cur[gems[0]] += 1
    
    while True:
        if len(cur) == n:
            answer.append([l, r])
            
        if l == r and l == len(gems)-1:
            break
        if r < len(gems)-1 and len(cur) < n:
            r+=1
            j = gems[r]
            cur[j] += 1
            continue
        j = gems[l]
        cur[j] -= 1
        if cur[j] == 0:
            del cur[j]
        l += 1
    # print(answer)
    answer.sort(key=lambda x : (x[1] - x[0],x[0]))
    return [ a + 1 for a in answer[0]]