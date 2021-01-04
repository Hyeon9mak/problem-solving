def solution(num) :
    return (num//1000%10) + (num//100%10) + (num//10%10) + (num%10) + num

set1 = set(range(1, 10001))
set2 = set()
cnt = 1

while True :
    num = solution(cnt)
    if num > 10000 : break
    set2.add(num)
    cnt += 1

result = [x for x in set1 if x not in set2]
for r in result :
    print(r)