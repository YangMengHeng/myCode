#include <iostream>
#include <algorithm>
using namespace std;

#define term 532

/*
算法题目：数学问题-算法模拟
问题描述：
	设a、b、c均是0到9之间的数字
    abc、bcc是两个三位数，
    且有：abc+bcc=532.
    求满足条件的所有a、b、c的值.
输入：
	无输入
输出：
	请输出所有满足题目条件的a、b、c的值.
    a、b、c之间用空格隔开.
    每个输出占一行
样例输入：
	无
样例输出：
	无
*/

int main(){
    int a, b, c, t1, t2;

    for(a = 0; a < 10; a++)
    {
        for(b = 0; b < 10; b++)
        {
            for(c = 0; c < 10; c++)
            {
                t1 = a * 100 + b * 10 + c;
                t2 = b * 100 + c * 10 + c;
                if((t1 + t2) == term) printf("%d %d %d\n", a, b, c);
            }
        }
    }
}