using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Csharp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            float A, E, M_PI, x1, y1, x2, y2;
            int D, i;

            D = 100;
            M_PI = 3.1415926535897932f;
            for(i = 0; i <= 720; i++)
            {
                A = i * M_PI / 360;
                E = (float)(D * (1 + System.Math.Sin(4 * A)));
                x1 = (float)(320 + E * System.Math.Cos(A));
                x2 = (float)(320 + E * System.Math.Cos(A + M_PI / 5));
                y1 = (float)(240 + E * System.Math.Sin(A));
                y2 = (float)(240 + E * System.Math.Sin(A + M_PI / 5));
                Pen pen = Pens.Red;
                Graphics gdi = this.CreateGraphics();
                gdi.DrawLine(pen, x1, y1, x2, y2);
            }
        }
    }
}
