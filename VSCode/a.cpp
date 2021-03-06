
@[TOC](算法-有效的括号)
# 问题概述
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

> <font size=4>题目：算法-有效的括号<br />
> 问题描述：
	给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
	有效字符串需满足：
	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
</font>

<font size=4>

> 
> 输入：
	给定一个字符串；
> 输出：
	true或者false；
> 样例输入： 	
> "()"
	"()[]{}"
	")["
	"([)]"
> 样例输出： 
> true
	true
	false
	false

</font>
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

# 1. 问题分析

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

## 1.1 算法核心
处理这类某种符号匹配的问题，重要的是有栈的处理思想。

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

## 1.2 算法分析
从字符串的首端开始依次读入字符，每读入一个字符就进行一次匹配过程，若是第一个匹配的元素（比如左括号之类的）则压入栈中跳过匹配，若不是则利用键值对的特性，用这个字符去匹配栈顶的元素，若匹配成功则说明括号对成立弹出栈顶元素，继续遍历下一个元素，若匹配失败则说明这个字符串不是有效的括号，输出false，这样循环直到所有的字符都遍历一遍，同时栈为空则说明所有字符都匹配上了，是有效的括号字符串，输出true。

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

# 2. 解决方案

```cpp
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <string>
#include <unordered_map>
#include <stack>
using namespace std;

/*
算法题目：有效的括号
问题描述：
	给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
	有效字符串需满足：
	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
输入：
	给定一个字符串；
输出：
	true或者false；
样例输入：
	"()"
	"()[]{}"
	")["
	"([)]"
样例输出：
	true
	true
	false
	false
*/

int main(void)
{
	string s;
	unordered_map<char, char> pairs = {
			{')', '('},
			{']', '['},
			{'}', '{'}
	};

	getline(cin, s);
	int len = s.size();

	if (len % 2 != 0)
		cout << "false" << endl;

	stack<char> stk;
	for (char ch : s) {
		if (pairs.count(ch)) {
			if (stk.empty() || stk.top() != pairs[ch]) {
				return false;
			}
			stk.pop();
		}
		else {
			stk.push(ch);
		}
	}

	return stk.empty();
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