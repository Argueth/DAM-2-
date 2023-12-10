using Microsoft.Win32;
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

namespace PosibleExamen
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void sumarElemento(object sender, EventArgs e)
        {
            int numero = lista.Items.Count;
            lista.Items.Add($"Elemento{numero + 1}");
        }

        private void restarElemento(Object sender, EventArgs e)
        {
            lista.Items.Remove(lista.SelectedItem);
        }

        private void guardar(object sender, RoutedEventArgs e)
        {
            SaveFileDialog save = new SaveFileDialog();

            if(save.ShowDialog() == true)
            {
                System.IO.File.WriteAllText(save.FileName, texto.Text);
            }
                
        }

        private void openFile(object sender, RoutedEventArgs e)
        {
            OpenFileDialog open = new OpenFileDialog();

            if(open.ShowDialog() == true)
            {
                texto.Text = System.IO.File.ReadAllText(open.FileName);
            }
        }

        private void borrar(object sender, RoutedEventArgs e)
        {
            texto.Text = "";
        }

        private void pais(object sender, RoutedEventArgs e)
        {
            ListBoxItem item = (ListBoxItem)sender;
            textoPaises.Text = item.Content.ToString();
        }

        private void seleccionarDate(object sender, SelectionChangedEventArgs e)
        {
            if(e.AddedItems.Count > 0 && e.AddedItems[0] is DateTime selectedDate)
            {
                textoPaises.Text += selectedDate.ToString("dd-MM-yyyy ");
            }
        }

        private void addElement(object sender, RoutedEventArgs e)
        {
            if(listOrigin.SelectedItem != null)
            {
                ListBoxItem seleccionado = (ListBoxItem)listOrigin.SelectedItem;
                listOrigin.Items.Remove(listOrigin.SelectedItem);
                listDest.Items.Add(seleccionado);
                listDest.SelectedItem = seleccionado;
            }
        }

        private void deleteElement(object sender, RoutedEventArgs e)
        {
            if (listDest.SelectedItem != null)
            {
                ListBoxItem seleccionado = (ListBoxItem)listDest.SelectedItem;
                listDest.Items.Remove(listDest.SelectedItem);
                listOrigin.Items.Add(seleccionado);
                listOrigin.SelectedItem = seleccionado;
            }
        }

        private void setearTexto(object sender, RoutedEventArgs e)
        {
            ListBoxItem listBoxItem = (ListBoxItem)sender;
            texto.Text = listBoxItem.Content.ToString();
        }

        private void ponerTexto(object sender, RoutedEventArgs e)
        {
            ComboBoxItem comboItem = (ComboBoxItem)sender;
            texto.Text = comboItem.Content.ToString();
        }

        private void borrar2(object sender, RoutedEventArgs e)
        {
            textoPaises.Text = "";
        }

        private void guardar2(object sender, RoutedEventArgs e)
        {
            SaveFileDialog saveFileDialog = new SaveFileDialog();

            if(saveFileDialog.ShowDialog() == true)
            {
                System.IO.File.WriteAllText(saveFileDialog.FileName, textoPaises.Text);
            }
        }
    }
}


