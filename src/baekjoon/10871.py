N, X = input().split()
A = list(map(int, input().split()))
B = []

for i in range(0, int(N)) :
    if(A[i] < int(X)) :
        print(A[i], end=" ")