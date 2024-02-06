def calculate(countries, x):
    for y in countries[x]:
        countries[y].remove(x)

    neighbors = list(countries[x])
    countries[x].clear()

    currPower = powers[x]
    neededPower = 0
    while neighbors:
        xx = neighbors[0]
        minim = powers[xx]
        minindex = 0
        i = 0
        for mi in neighbors:
            power = powers[mi]
            if power < minim:
                minim = power
                xx = mi
                minindex = i
            if (currPower+neededPower) > power:
                minim = power
                xx = mi
                minindex = i
                break
            i += 1
            
        if (currPower+neededPower) <= minim:
            neededPower += (minim - (currPower+neededPower) + 1)


        currPower += minim
        neighbors.pop(minindex)
        
        for y in countries[xx]:
            if y not in neighbors:
                neighbors.append(y)
            countries[y].remove(xx)


    print(neededPower, end= " ")

n, m = map(int, input().split())
powers = list(map(int, input().split()))
powers.insert(0, 0)
_countries = [set() for _ in range(n+1)]
for _ in range(m):
    v, u = map(int, input().split())
    _countries[v].add(u)
    _countries[u].add(v)



for x in range(1, n+1):
    
    calculate([list(x) for x in _countries], x)
    
    
print()
