# this is gerald code file in python.
card = int(input("请输入四位会员卡号: "))
bit = card % 10
ten = card / 10 % 10
hundred = card / 100 % 10
thousand = card / 1000
total = (int)(bit + ten + hundred + thousand)
print("会员卡号: " + str(card) + " 各位总和为: " + str(total))
if(total >= 20):
    print("恭喜您！您是幸运用户！")
else:
    print("很遗憾！您不是幸运用户")