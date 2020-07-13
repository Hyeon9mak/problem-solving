N = M = int(input())
result = 0

while True:
    M = (M%10*10) + ((M//10 + M%10)%10)
    result += 1
    if M == N :
        break

print(result)