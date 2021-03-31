#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>
using namespace std;

/*
算法题目：26.删除有序数组中的重复项()(LeetCode)
问题描述：
	给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
	不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
输入：
	给定一个有序数组nums。
	0 <= nums.length <= 3 * 104
	-10^4 <= nums[i] <= 10^4
	nums 已按升序排列
输出：
	不含重复元素的数组
样例输入：
	[1,1,2]
	[0,0,1,1,1,2,2,3,3,4]
	[]
样例输出：
	[1,2]
	[0,1,2,3,4]
	[]
*/

int removeDuplicates(vector<int>& nums);

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
	int len = removeDuplicates(t);
	for (int i = 0; i < len; i++)
		cout << t[i] << ' ';
	cout << endl;

	return 0;
}

int removeDuplicates(vector<int>& nums)
{
	int i, j, t;

	if (!nums.size())
		return 0;
	i = j = t = 0;
	while (i < nums.size() && j < nums.size())
	{
		j = i + 1 + t;
		while (j < nums.size())
		{
			if (nums[j] != nums[i])
			{
				nums[++i] = nums[j];
				t = j - i;
				break;
			}
			else
				++j;
		}
	}

	return i + 1;
}