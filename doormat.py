n=11
dash = '---'
design = '.|.'
hlf = int((n*3-7)/2)

for i in range(int(n/2)):
    print((int(n/2)+1-(i+1))*dash+ (int(i*2)+1)*design+(int(n/2)-i)*dash)

print(hlf*'-' + 'WELCOME' + hlf*'-')

for i in range (int(n/2)):
    print(((i+1)*dash)+(int((n//2-i))*2-1)*design+(i+1)*dash)



# n, m = map(int,input().split())
# pattern = [('.|.'*(2*i + 1)).center(m, '-') for i in range(n//2)]
# print('\n'.join(pattern + ['WELCOME'.center(m, '-')] + pattern[::-1]))
