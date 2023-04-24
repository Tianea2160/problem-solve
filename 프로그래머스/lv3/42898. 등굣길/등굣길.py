def solution(m, n, puddles):
    answer = 0
    dp = [[0]*(m+1) for _ in range(n+1)]
    valid = [[False]*(m+1) for _ in range(n+1)]
    
    for x, y in puddles:
        valid[y][x] = True
    
    for i in range(1, m+1):
        if valid[1][i]: break
        dp[1][i] = 1
        
    for j in range(1, n+1):
        if valid[j][1]: break
        dp[j][1] = 1
    
    for i in range(2, n+1):
        for j in range(2, m+1):
            if not valid[i-1][j] and valid[i][j-1]:
                dp[i][j] = dp[i-1][j]
            elif not valid[i][j-1] and valid[i-1][j]:
                dp[i][j] = dp[i][j-1]
            elif not valid[i-1][j] and not valid[i][j-1]:
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007
    for a in dp: print(a)
    return dp[n][m]