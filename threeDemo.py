n=input()
if n[-1] in{"i"}:
    n=eval(n[:-1])*2.54
    print("{:.2f}cm".format(n))
elif "inch" in n:
    n = eval(n[0:len(n)-4]) * 2.54
    print("{:.2f}cm".format(n))
elif n[-1] in{"c"}:
    n = eval(n[:-1]) / 2.54
    print("{:.2f}inch".format(n))
elif "cm" in n:
    n = eval(n[0:len(n)-2]) / 2.54
    print("{:.2f}inch".format(n))
else:
    print("输入错误。")