import re

def solution(users, bans):
    bans = [b.replace("*", ".") for b in bans]
    n = len(bans)
    visit = [False]*len(users)
    answer = set()
    def combination(depth, idx, cur):
        if depth == len(bans):
            tmp = sorted(cur[:])
            answer.add(tuple(tmp))
            return 
        
        for i in range(len(users)):
            if not visit[i] and len(bans[depth]) == len(users[i]) and re.match(bans[depth], users[i]):
                visit[i] = True
                cur.append(users[i])
                combination(depth+1, i, cur)
                cur.pop()
                visit[i] = False
    combination(0, 0, [])
    return len(answer)