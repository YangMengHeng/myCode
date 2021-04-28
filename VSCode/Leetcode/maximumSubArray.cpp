#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>
using namespace std;

/*
算法题目：53.最大子序和(LeetCode)
问题描述：
	给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
输入：
	给定数组元素个数n，以及n个元素值nums[i]；
	1 <= n <= 3 * 10^4
	-10^5 <= nums[i] <= 10^5
输出：
	最大子序和值
样例输入：
	9
	-2 1 -3 4 -1 2 1 -5 4
样例输出：
	6
*/

int maxSubArray(vector<int>& nums);


int main(void)
{
	int n, t;
	vector<int> nums;

	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> t;
		nums.push_back(t);
	}
	t = maxSubArray(nums);
	cout << t << endl;

	return 0;
}

int maxSubArray(vector<int>& nums)
{
	int pre = 0, maxAns = nums[0];

	for (const auto &x : nums)
	{
		pre = max(pre + x, x);
		maxAns = max(maxAns, pre);
	}

	return maxAns;
}