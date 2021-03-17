# 问题概述
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

> <font size=4>题目：28.实现strStr()(LeetCode)<br />
> 问题描述：
	给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
</font>

<font size=4>

> 
> 输入：
> 给定两个字符串，一个haystack字符串一个needle字符串。
	
> 输出：
> 在 haystack 字符串中找出 needle 字符串出现的第一个位置。
		
> 样例输入： 	
> "hello"
	"ll"
	"mississipi"
	"issip"
> 样例输出： 
> 2
	4
</font>
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

# 1. 问题分析

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

## 1.1 算法核心
C++字符串string类型的应用问题，面向对象给我们提供了很多便利，其中比较重要的就是封装这一特性，熟悉我们的数据对象是很重要的部分，本题解题关键就是利用好string类型内置的方法，这样解题思路清晰，速度也快。

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

## 1.2 算法分析
首先读入haystack和needle字符串，然后调用strStr()函数，最后输出strStr的返回值也就是，needle字符串在haystack中的第一个字符位置。
针对strStr函数呢，我们要注意利用string类型内置函数find，以及其他有关的函数，比如本题中用到的find_first_of，这些函数可以帮我们快速找到我们需要找的字符。
变量名释义：
pos：位置变量，标记needle[0]元素在haystack中的位置
len：长度变量，记录当前needle[0]元素在haystack中的位置
num1：标记needle字符串的长度
num2：标记s字符串的长度
s：临时变量字符串，初始先复制haystack，然后后续会进行字符串剪取，所以需要定义这么一个临时字符串；
strStr函数逻辑释义：
（1）若needle字符串是空字符串返回-1；
（2）标记s字符串的长度，赋值给num2；
（3）若num2长度小于num1，返回-1；
（4）在s字符串中找needle[0]的位置，赋值给pos；
（5）若pos等于string::npos（表示找不到这个元素），返回-1；
（6）若pos不等于string::npos，则进行第七步；
（7）循环变量 j 赋值为1，len加上pos位置，标记在haystack中的位置；
（8）开始内层循环，因为我们已经找到了第一个元素的位置（needle[0]），所以这个时候让j为1，然后接着开始比较s[len + j]的元素与needle[j]是否相同，若不相同，那么截取s字符串，截取到pos之前的所有元素，也就是pos + 1，最大长度为num2，然后len长度加一，跳出内层循环；
（9）若 j 的值等于num1，那么说明内层循环完全遍历了，就是说明找到了needle字符串在haystack字符串中的位置，那么直接返回len长度；

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

# 2. 解决方案

```cpp
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <string>
using namespace std;

/*
算法题目：28.实现strStr()(LeetCode)
问题描述：
	给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
输入：
	给定两个字符串，一个haystack字符串一个needle字符串。
输出：
	在 haystack 字符串中找出 needle 字符串出现的第一个位置。
样例输入：
	"hello"
	"ll"
	"mississipi"
	"issip"
样例输出：
	2
	4
*/

int strStr(string haystack, string needle);

int main(void)
{
	string s1, s2;

	cin >> s1 >> s2;
	int len = strStr(s1, s2);
	cout << len;
	cout << endl;

	return 0;
}

int strStr(string haystack, string needle)
{
	int pos = 0, num1 = needle.size(), num2, len = 0;
	string s = haystack;

	if (!needle.size())
		return 0;
	while (1)
	{
		num2 = s.size();
		if (num2 < num1)
			return -1;
		pos = s.find_first_of(needle[0]);
		if (pos != string::npos)
		{
			int j = 1;
			len += pos;

			for (; j < num1; j++)
			{
				char c = s[pos + j];
				if (c != needle[j])
				{
					s = s.substr(pos + 1, num2);
					len++;
					break;
				}
			}
			if (j == num1)
				return len;
		}
		else
			return -1;
	}
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