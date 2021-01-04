buger = juice = 2001
for i in range(0, 5) :
    if(i < 3) :
        new_buger = int(input())
        if new_buger < buger :
            buger = new_buger
    else :
        new_juice = int(input())
        if new_juice < juice :
            juice = new_juice

print(buger + juice - 50)