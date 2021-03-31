from turtle import *
def curvemove():            #这个函数是为了绘制爱心上方的曲线
    for i in range(200):
        right(1)
        fd(1)

title('My Friend - Happy Spring Festival To You by 旗木白哉') #设置边框标题
getscreen().bgcolor('light blue')
pensize(4)                  #调整画笔粗细
speed(100)                   #调节画笔速度
color('red','red')          #画笔颜色及填充颜色
begin_fill()                #开始填充
left(140)
fd(111.65)
curvemove()                 #调用函数
left(120)
curvemove()                 #调用函数
fd(111.65)
end_fill()                  #结束填充
hideturtle()                #隐藏画笔
up()
goto(0, 80)
down()
write("Dear Libby",font=(u"楷体",36,"normal"),align="center")
up()
goto(0, 0)
down()
write("Happy Birthday",font=(u"楷体",36,"normal"),align="center")
up()
goto(100, -210)
down()
write("亲爱的大妖怪生日快乐！",font=(u"楷体",26,"bold"),align="right")
up()
goto(160, -190)
resizemode('user')
shapesize(4, 4, 10)
color('red', 'red')
showturtle()
done()