

@[TOC](算法-)
# 问题概述
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

> <font size=4>题目：50.Pow(x, n)(LeetCode)<br />
> 问题描述：
	实现 pow(x, n) ，即计算 x 的 n 次幂函数（即x^n^）。
</font>

<font size=4>

> 
> 输入：
	给定底数x和指数n。
	-100.0 < x < 100.0
	-2^31 <= n <= 2^(31-1)
	-10^4 <= xn <= 10^4 
	
> 输出：
pow函数计算后的最终结果值

> 样例输入： 	
> 2.0 10	
> 2.1 3	
> 2.0 -2
> 样例输出： 
> 1024.0	
> 9.261	
> 0.25
</font>
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

# 1. 问题分析

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

## 1.1 算法核心
理解快速幂计算方法，理解递归和迭代的思想方法。

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

## 1.2 算法分析
本题可以采用递归和迭代两种方式进行代码设计，首先介绍快速幂思想。快速幂的本质是分治算法，比如我们计算2^64^，那么我们应当按照x→x^2^ →x^4^→x^8^→x^16^→x^32^→x^64^的顺序来计算，从 x开始，每次直接把上一次的结果进行平方，计算 6 次就可以得到 x^64^的值，而不需要对 x乘 63 次 x。现在我们知道了快速幂的方法，接下来若我们采用递归的方法来设计本题解法，可以注意到递归边界为指数n为0的时候（任何数的0次方都是1）直接返回1.0，若不是递归边界，那么当前一个暂存的y值应当等于x^(n/2)^，然后根据当前指数是奇数还是偶遇判定返回值，若当前指数为偶数，那么返回的y值平方即可返回，当前指数为奇数，那么返回的y值还需要再多乘以一个底数x值。

迭代：从下往上算，如何判定当前是否需要多乘以一个底数值是很难的，但是我们仔细观察可以发现一个规律，以x^29^为例：x→+x^3^→+x^7^→x^14^→+x^29^
把需要额外多乘一个 x 的步骤打上了 +标记。可以发现：

- x^14^→+x^29^中额外乘的x在x^29^中贡献了x^1^;
- x^3^→+x^7^中额外乘的x在x^29^中贡献了x^4^
- x→+x^3^中额外乘的x在x^29^中贡献了x^8^
- 最初的单个x在之后被平方了4次，贡献了x^16^。
- 这些贡献的指数部分又是什么呢？它们都是 2 的幂次，这是因为每个额外乘的 x在之后都会被平方若干次。**而这些指数 1，4，8 和 16，恰好就对应了 29 的二进制表示 (0001 1101)~2~中的每个1！**

因此借助整数的二进制拆分，我们快速幂迭代的时候就可以不断的将指数拆分，若当前指数值对2求余得1那么说明当前最低位为1，也就是需要额外加入最终结果的值（在x已经平方的情况下，再额外乘一个x）。
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

# 2. 解决方案

```cpp
#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

/*
算法题目：50.Pow(x, n)(LeetCode)
问题描述：
	实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
输入：
	给定底数x和指数n。
	-100.0 < x < 100.0
	-2^31 <= n <= 2^(31-1)
	-10^4 <= xn <= 10^4
输出：
	pow函数计算后的最终结果值
样例输入：
	2.0 10
	2.1 3
	2.0 -2
样例输出：
	
*/

double myPow(double x, int n);
double quickMul(double x, long long int N);


int main(void)
{
	int n;
	double x, s;

	cin >> x >> n;
	s = myPow(x, n);
	cout << s << endl;

	return 0;
}

double myPow(double x, int n)
{
	long long int N = n;

	if (x == 0.0)
		return 0.0;
	if (n == 0 || x == 1.0)
		return 1;
	if (x == -1.0)
		return (n % 2) ? -1.0 : 1.0;

	return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
}

double quickMul(double x, long long int N)
{
	// 迭代
	/*double ans = 1.0;

	while (N > 0)
	{
		if (N % 2)
			ans *= x;
		x *= x;
		N /= 2;
	}

	return ans;*/
	// 迭代结束

	// 递归
	if (N == 0)
		return 1.0;
	double y = quickMul(x, N / 2);

	return (N % 2) ? y * y * x : y * y;
	// 递归结束
}
```

# 3. 资源分享
> ==旗木白哉のGitHub：==
> https://github.com/YangMengHeng
> ==GitHub/Gitee源代码下载地址：==
> **GitHub**
> https://github.com/YangMengHeng/myCode/tree/master/VSCode
> https://github.com/YangMengHeng/myCode/tree/master/Java
> **Gitee**
> https://gitee.com/QMBZ/myCode/tree/master/VSCode
> https://gitee.com/QMBZ/myCode/tree/master/Java
> ==旗木白哉のblog源代码下载地址：==
>https://github.com/YangMengHeng/myCode/tree/master/%E6%97%97%E6%9C%A8%E7%99%BD%E5%93%89%E3%81%AEblog
>https://gitee.com/QMBZ/myCode/tree/master/%E6%97%97%E6%9C%A8%E7%99%BD%E5%93%89%E3%81%AEblog

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">