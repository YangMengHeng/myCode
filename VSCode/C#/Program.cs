using System;

namespace C_
{
    public class Fraction
    {
        private int num;
        private int deno;

        public int Num
        {
            get{ return num; }
            private set
            { num = value; }
        }
        public int Deno
        {
            get{ return deno; }
            private set
            {
                if(value < 0)
                {
                    int t = -value;
                    deno = t;
                    num = -num;
                }
                else
                    { deno = value; }
            }
        }
        public Fraction()
        {
            num = deno = 1;
        }
        public Fraction(int num, int deno)
        {
            if(deno == 0)
            {
                Console.WriteLine("分母的值不能为0！请重新输入！");
            }
            else
            {
                Num = num;
                Deno = deno;
            }
        }
        public static int gcd(int m, int n)
        {
            if(n == 0) return m;
            return gcd(n, m % n);
        }
        public static Fraction operator+(Fraction a, Fraction b)
        {
            Fraction tmp = new Fraction();
            int ade = a.Deno;
            int bde = b.Deno;
            int an = a.Num;
            int bn = b.Num;

            an *= bde;
            bn *= ade;
            an += bn;
            ade *= bde;
            int maxDiv = gcd(ade, an);
            an /= maxDiv;
            ade /= maxDiv;
            tmp.num = an;
            tmp.deno = ade;

            return tmp;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("输入第一个分数的分子：");
            int a1 = int.Parse(Console.ReadLine());
            Console.WriteLine("输入第一个分数的分母：");
            int a2 = int.Parse(Console.ReadLine());
            Console.WriteLine("输入第二个分数的分子：");
            int b1 = int.Parse(Console.ReadLine());
            Console.WriteLine("输入第二个分数的分母：");
            int b2 = int.Parse(Console.ReadLine());
            Fraction frac1 = new Fraction(a1, a2);
            Fraction frac2 = new Fraction(b1, b2);
            Fraction frac3 = frac1 + frac2;
            double dec = frac3.Num * 1.0 / frac3.Deno;
            Console.WriteLine("{0}/{1} + {2}/{3} = {4} ", frac1.Num, frac1.Deno, frac2.Num, frac2.Deno, dec);
        }
    }
}
