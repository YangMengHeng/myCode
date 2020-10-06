using System;

namespace tmp
{
    class Program
    {
        static void Main(string[] args)
        {
            double num1, num2, result;

            Console.Write("Pls enter tow numbers to add:\n");
            num1 = double.Parse(Console.ReadLine());
            num2 = double.Parse(Console.ReadLine());
            result = num1  + num2;
            Console.Write("The result is: {0}\n", result);
        }
    }
}