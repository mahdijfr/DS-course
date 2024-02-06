class Range:
    def __init__(self, first, last, sf, sl):
        self.first = first
        self.last = last
        self.sf = sf
        self.sl = sl

def partition(array, low, high):
    i = low - 1
    for j in range(low, high):
        if array[j].first + int(array[j] == '[') < array[high].first or\
        (array[j].first == array[high].first and array[high].sf != '['):
            i = i + 1
            (array[i], array[j]) = (array[j], array[i])
    (array[i + 1], array[high]) = (array[high], array[i + 1])

    return i + 1
 
def quickSort(array, low, high):
    if low < high:
        pi = partition(array, low, high)
        quickSort(array, low, pi - 1)
        quickSort(array, pi + 1, high)

def toInt(x):
    return str(x).split(".")[0]
    

n = int(input())
ranges = []
for _ in range(n):
    line = input()
    sf = line[0]
    sl = line[-1]
    line = line[1:-1]
    first, last = line.split(", ")
    first = float(first)
    last = float(last)
    ranges.append(Range(first, last, sf, sl))


quickSort(ranges, 0, n-1)
# ranges.sort(key=lambda x: (x.first, x.sf == '('))

main_range = ranges[0]
for i in range(1, n):
    current = ranges[i]
    if main_range.last > current.first or (main_range.last == current.first and (main_range.sl == ']' or current.sf == '[')):
        if main_range.last < current.last:
            main_range.last = current.last
            main_range.sl = current.sl
        if main_range.last == current.last and current.sl == ']':
            main_range.sl = ']'
    else:
        print(f"{main_range.sf}{toInt(main_range.first)}, {toInt(main_range.last)}{main_range.sl}", "U", end=" ")
        main_range = current

print(f"{main_range.sf}{toInt(main_range.first)}, {toInt(main_range.last)}{main_range.sl}")







