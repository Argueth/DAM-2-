using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
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

namespace controlesC
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            createButtons();
        }

        private void createButtons()
        {
            for (int i = 1;i <= 36; i++)
            {
                if (i % 2 == 0)
                {
                    Button button = new Button
                    {
                        Content = i.ToString(),
                        HorizontalContentAlignment = HorizontalAlignment.Center,
                        VerticalContentAlignment = VerticalAlignment.Center,
                        FontSize = 30 //Pongo el tamaño de la letra un poco más grande para que se vea correctamente el número.
                    };
                    button.MouseRightButtonDown += changeBack;
                    miGrid.Children.Add(button);
                }
            }
        }

        private void changeBack(object sender, RoutedEventArgs e) 
        { 
            Button button = (Button)sender;
            button.Background = Brushes.BlueViolet;
        }
    }
}
