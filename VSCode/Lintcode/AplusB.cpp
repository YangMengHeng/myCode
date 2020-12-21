/*
算法题目：A+B问题
问题描述：
	判给出两个整数 aa 和 bb , 求他们的和；
输入：
	1
    2
输出：
	3
注意：
    显然你可以直接返回a+b，但是你是否可以挑战一下不这样做？（不使用+等算术运算符）
*/

class Solution {
public:
        /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    int aplusb(int a, int b) {
        return b == 0 ? a:aplusb(a ^ b, (a & b) << 1);
    }
};