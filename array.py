n=input()
if n[-1] in ['i','I']:
    n=2.54*eval(n[:-1])
    print("{:.2f}cm".format(n))
elif n[-1] in ['c','C']:
    n=eval(n[:-1])/2.54
    print("{:.2f}inch".format(n))
else:
    print("输入错误。")


