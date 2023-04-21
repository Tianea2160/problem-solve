"""
0 1 2 3 4     5  6             7 8     9 10 11
0 0 3 0 3*3+2 0  dp[4]*dp[2]*2 0 11*11 0 

"""

def solution(n):
    dp = [0]*(5001)
    dp[2] = 3
    dp[4] = 11    
    for i in range(5,n+1):
        dp[i] = (4*dp[i-2] - dp[i-4])%1000000007
    return dp[n]