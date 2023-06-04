from collections import defaultdict

def solution(tickets):
    graph = defaultdict(list)
    
    for start, end in tickets:
        graph[start].append(end)
    
    for value in graph.values():
        value.sort(reverse=True)
    
    stack = ["ICN"]
    path = []
    while stack:
        top = stack.pop()
        
        if top not in graph or not graph[top]:
            path.append(top)
        else:
            stack.append(top)
            stack.append(graph[top].pop())
            
    return path[::-1]