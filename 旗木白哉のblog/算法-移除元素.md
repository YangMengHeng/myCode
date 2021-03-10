
@[TOC](算法-移除元素)
# 问题概述
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

> <font size=4>题目：27.移除元素(LeetCode)<br />
> 问题描述：
	给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，
	并返回移除后数组的新长度。不要使用额外的数组空间，
	你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
	元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
</font>

<font size=4>

> 
> 输入：
> 给定一个原始数组，一个指定要删除的数字。
	
> 输出：
> 删除指定数字后的新数组。
		
> 样例输入： 	
> 4
	3 2 2 3
	3
> 样例输出： 
> 2 2
</font>
<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

# 1. 问题分析

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

## 1.1 算法核心
这是一道简单的算法题，关键是理解引用与局部变量的用法，引用类似于指针的用法，就是将引用的变量的地址传过去用，也就是相当于给原变量取了一个别名，实质上还是原变量，局部变量是把原变量复制了一个，是全新的一个变量，只是内容与原变量相同，所以在这个算法题目中，我们移除元素的函数方法中参数是引用参数，所以我们在函数中修改参数变量nums（引用原变量），一样会影响到主函数的nums，这两个是同一个，若是局部变量那么我们在移除元素的函数方法中针对局部变量nums做的一切操作都是影响不到原变量的，也就是主函数的nums；

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

## 1.2 算法分析
共有三行输入，第一行是数组个数，第二行是数组元素，第三行需要删除的数字。只有一行输出，输出最终删除数字以后的数组。
移除元素的函数方法，先声明一个长度len初始化0，接着遍历整个数组，若当前元素不等于要删除的数字，则len当前位置赋值为当前元素，然后len加一。否则一直循环，直到整个数组循环完毕，最后返回len值。

<hr style=" border:solid; width:100%; height:2px;" color=#000000 size=1">

# 2. 解决方案

```cpp
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>
using namespace std;

/*
算法题目：27.移除元素(LeetCode)
问题描述：
	给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，
	并返回移除后数组的新长度。不要使用额外的数组空间，
	你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
	元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
输入：
	给定一个原始数组，一个指定要删除的数字。
输出：
	删除指定数字后的新数组。
样例输入：
	4
	3 2 2 3
	3
样例输出：
	2 2
*/
int removeElement(vector<int>& nums, int val);

int main(void)
{
	int num, tmp;
	vector<int> t;

	cin >> num;
	for (int i = 0; i < num; i++)
	{
		cin >> tmp;
		t.push_back(tmp);
	}
	cin >> num;
	int len = removeElement(t, num);
	for (int i = 0; i < len; i++)
		cout << t[i] << ' ';
	cout << endl;

	return 0;
}

int removeElement(vector<int>& nums, int val)
{
	int len = 0;

	for (int i = 0; i < nums.size(); i++)
		if (val != nums[i])
			nums[len++] = nums[i];

	return len;
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