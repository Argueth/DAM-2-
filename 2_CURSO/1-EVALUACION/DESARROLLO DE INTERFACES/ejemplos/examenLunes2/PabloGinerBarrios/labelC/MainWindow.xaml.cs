using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
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
            int rows = 5;
            int columns = 5;

            addLabel(rows, columns);
        }

        private void addLabel(int rows, int columns)
        {
            int cont = 0;
            for (int i = 0; i < rows; i++)
            {
                for(int j = 0; j < columns; j++)
                {
                    Label label = new Label
                    {
                        Content = cont.ToString(),
                        HorizontalAlignment = HorizontalAlignment.Center,
                        VerticalAlignment = VerticalAlignment.Center,
                        FontSize = 25
                    };

                    label.MouseLeftButtonDown += changeColor;
                    cont++;
                    Grid.SetRow(label, i);
                    Grid.SetColumn(label, j);
                    miGrid.Children.Add(label);
                }
            }
        }

        private void changeColor(object sender, EventArgs e)
        {
            Label label = (Label)sender;
            label.Background = Brushes.DarkGreen;
        }
    }
}
