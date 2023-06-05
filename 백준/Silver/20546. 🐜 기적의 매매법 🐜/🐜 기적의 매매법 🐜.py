init_cost = int(input())

prices = list(map(int, input().split()))

a, b = init_cost, init_cost

a_cnt = 0
for price in prices:
    cnt = a // price
    a_cnt += cnt
    a -= cnt * price

a = a + prices[-1] * a_cnt

b_cnt = 0
prev = 987654321
down, up = 0, 0
for price in prices:
    if prev > price:
        down += 1
        up = 0
    if prev < price:
        up += 1
        down = 0
    if down >= 3:
        cnt = b // price
        b_cnt += cnt
        b -= cnt * price
    if up >= 3:
        b += b_cnt * price
        b_cnt = 0
    prev = price
b = b + b_cnt * prices[-1]

if a == b:
    print("SAMESAME")
elif a > b:
    print("BNP")
else:
    print("TIMING")
