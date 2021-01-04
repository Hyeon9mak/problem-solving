num = []
for i in range(0, 5) :
    num.append(int(input()))
    if(num[i] < 40) :
        num[i] = 40

print(sum(num)//len(num))