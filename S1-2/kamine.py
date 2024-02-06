n = int(input())
array = []
for x in range(n):
    array.append(int(input()))
count = 0

x = int(n/2)
if n % 2:
    y = x + 2
else:
    y = x + 1

ix = -1
iy = -1
while x != -1 and y != n+1: # n/2
    for i in range(n): # n
        if array[i] == x:
            ix = i
        elif array[i] == y:
            iy = i
        if ix != -1 and iy != -1:
            break
    flag = False
    if iy < ix:
        flag = True
    else:
        x1 = x+1
        for i in range(ix+1, iy):
            if array[i] == x1:
                x1 += 1
        if x1 != y:
            flag = True
    if flag:
        array.remove(x)
        array.remove(y)
        array.insert(0, x)
        array.append(y)
        count += 1
    
    x -= 1
    y += 1
    ix = -1
    iy = -1

print(count)