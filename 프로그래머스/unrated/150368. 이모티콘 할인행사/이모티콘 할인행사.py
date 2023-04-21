from itertools import product

def solution(users, emoticons):
    answer = []
    
    sales = [10, 20, 30, 40]
    # 중복 순열로 풀 수 있을 것 같음
    max_money = 0
    max_person = 0
    
    for sale_list in product(sales, repeat=len(emoticons)):
        total_money, person = 0, 0
        
        for per, limit in users:
            money = 0
            flag = False
            for sale, price in zip(sale_list, emoticons):
                if sale >= per:
                    money += price*(100-sale)//100
                if money >= limit:
                    person += 1
                    flag = True
                    break
            if flag: continue
            total_money += money
        
        if max_person < person:
            max_person = person
            max_money = total_money
        elif max_person == person and max_money < total_money:
            max_money = total_money
    return [max_person, max_money]