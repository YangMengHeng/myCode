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