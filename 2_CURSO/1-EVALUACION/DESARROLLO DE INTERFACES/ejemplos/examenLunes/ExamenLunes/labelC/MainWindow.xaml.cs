using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace labelC
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            addLabel();
        }

        public void addLabel()
        {
            int cont = 0;

            for (int i = 0; i < 25; i++)
            {
                Label label = new Label
                {
                    Content = (i+5).ToString(),
                    FontSize = 30,
                };
                label.MouseLeftButtonDown += changeColor;
                miGrid.Children.Add(label);
            }
        }

        public void changeColor(object sender, EventArgs e)
        {
            Label label = (Label)sender;

            label.Foreground = Brushes.DarkGreen;
        }
    }
}
