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

 #region 系统托盘
        /*
         * 窗体大小改变事件
         */
        private void Form1_SizeChanged(object sender, EventArgs e)
        {
            if (this.WindowState == FormWindowState.Minimized)
            {
                this.Visible = false;
                notifyIcon1.Visible = true;
            }
        }

        /*
         * 系统托盘双击事件
         */
        private void notifyIcon1_DoubleClick(object sender, EventArgs e)
        {
            this.Visible = true;
            notifyIcon1.Visible = false;
            this.WindowState = FormWindowState.Normal;
        }

        /*
         * 系统托盘菜单——打开
         */
        private void tsmiOpenForm_Click(object sender, EventArgs e)
        {
            this.Visible = true;
            notifyIcon1.Visible = false;
            this.WindowState = FormWindowState.Normal;
        }

        #region 播放模式
        /*
         * 详见博客：https://blog.csdn.net/qq_34802416/article/details/77220654
         */
        private string GetPath()
        {
            int currIndex = lvSongList.SelectedItems[0].Index;
            switch (currPlayMode)
            {
                case PlayMode.ListLoop:
                    if (currIndex != lvSongList.Items.Count - 1)
                        currIndex += 1;
                    else
                        currIndex = 0;

                    break;
                case PlayMode.SingleLoop:
                    Console.WriteLine("SingleLoop");
                    //do nothing
                    break;
                case PlayMode.Shuffle:
                    //当局结束
                    if (randomListIndex > randomList.Length - 1)
                        StarNewRound();

                    //匹配到需要跳过的歌曲
                    if (randomList[randomListIndex] == jumpSongIndex)
                        if (randomListIndex == randomList.Length - 1)   //当局结束
                            StarNewRound();
                        else
                            randomListIndex++;

                    currIndex = randomList[randomListIndex++];

                    break;
            }

            lvSongList.Items[currIndex].Selected = true;//设定选中            
            lvSongList.Items[currIndex].EnsureVisible();//保证可见
            lvSongList.Items[currIndex].Focused = true;
            currPlaySong = new SongsInfo(lvSongList.SelectedItems[0].SubItems[6].Text);

            return currPlaySong.FilePath;
        }

        private void StarNewRound()
        {
            //重新生成随机序列
            BuildRandomList(lvSongList.Items.Count);
            //第二轮开始 播放所有歌曲 不跳过
            jumpSongIndex = -1;
        }

        private void BuildRandomList(int songListCount)
        {
            randomListIndex = 0;
            randomList = new int[songListCount];

            //初始化序列
            for (int i = 0; i < songListCount; i++)
            {
                randomList[i] = i;
            }

            //随机序列
            for (int i = songListCount - 1; i >= 0; i--)
            {
                Random r = new Random(Guid.NewGuid().GetHashCode());
                int j = r.Next(0, songListCount - 1);
                swap(randomList, i, j);
            }

            //输出序列
            //for (int i = 0; i < songListCount; i++)
            //{
            //    Console.Write(randomList[i] + " ");
            //}
            //Console.WriteLine(" ");
        }

        private void swap(int[] arr, int a, int b)
        {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        #endregion