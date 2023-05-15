def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x : x[2]) # 비용을 기준으로 오름차순 정렬
    # 연결되어 있는지 확인하기 위한 코드
    link = set([costs[0][0]])
    
    # 크루스칼
    while len(link) != n:
        for v in costs:
            # 이미 탐색한 간선인지 확인
            if v[0] in link and v[1] in link: continue
            # 탐색할 수 있는 간선인지 확인
            if v[0] in link or v[1] in link:
                link.update([v[0], v[1]])
                answer += v[2]
                break
    return answer