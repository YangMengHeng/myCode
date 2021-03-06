
@[TOC](算法-最后一个单词的长度)
# 问题概述
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

> <font size=4>题目：58.最后一个单词的长度(LeetCode)<br />
> 问题描述：
	给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0。
	单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
</font>

<font size=4>

> 
> 输入：
> 给定一个仅有空格和字母的字符串。
	1 <= s.length <= 10^4
	s 仅由英文字母和空格 ' ' 组成

> 输出：
> 最后一个单词的长度值

> 样例输入： 	
> "hello world"
	"a "
> 样例输出： 
> 5
> 1
</font>
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

# 1. 问题分析

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

## 1.1 算法核心
本题较为容易，遍历一遍字符串即可得到答案。需要注意的是给定的字符串可能末尾不只含有一个空格！

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

## 1.2 算法分析
因为给定的字符串末尾可能不只有一个空格，所以我们先针对末尾空格处理，第一个循环判断当前末尾元素是否是空格，循环一直往前找第一个不是空格的元素，这样就能把末尾空格全部跳过，然后第二个循环开始计数；
若末尾不是空格，那我们直接第二个循环开始从末尾开始计数，最后返回计数值。

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

# 2. 解决方案

```cpp
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <string>
#include <istream>
using namespace std;

/*
算法题目：58.最后一个单词的长度(LeetCode)
问题描述：
	给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0。
	单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
输入：
	给定一个仅有空格和字母的字符串。
	1 <= s.length <= 10^4
	s 仅由英文字母和空格 ' ' 组成
输出：
	最后一个单词的长度值
样例输入：
	"hello world"
	"a "
样例输出：
	5
	1
*/

int lengthOfLastWord(string s);


int main(void)
{
	int t;
	string s;

	getline(cin, s);
	t = lengthOfLastWord(s);
	cout << t << endl;

	return 0;
}

int lengthOfLastWord(string s)
{
	/* 执行用例用时较慢的方法，但内存消耗更小 */
	int num = 0, i;

	for (i = s.size() - 1; i >= 0 && s[i] == ' '; i--);
	for (; i >= 0 && s[i] != ' '; i--)
		num++;

	return num;

	/* 执行用例用时更快的方法，但内存消耗更大
	int len = s.size(), num = 0;

		if (s[len - 1] == ' ')
			if (len == 1)
				return 0;
			else
			{
				int j, n = 0;
				for (j = len - 1; j >= 0 && s[j] == ' '; j--)
					n++;
				len = len - n;
			}

		for (int i = len - 1; i >= 0 && s[i] != ' '; i--)
			num++;

		return num;
	*/
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