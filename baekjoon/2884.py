H, M= input().split()
H = int(H)
M = int(M)

if(M < 45) :
    H = H - 1
    M = 60 - (45-M)
else :
    M = M - 45

if(H < 0) :
    H = 24 + H

print(H, M)