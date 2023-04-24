n = int(input())
dp = [0] * 1500000
dp[1] = 1
for i in range(2, (n + 1) % 1_500_000):
    dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000
print(dp[n % 1500000])
