﻿using System;
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

namespace ExamenLunes
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class PabloGinerBarrios : Window
    {
        public PabloGinerBarrios()
        {
            InitializeComponent();
        }

        private void acercaDe(object sender, EventArgs e)
        {
            MessageBox.Show("Esta aplicación ha sido desarrollada por Pablo Giner Barrios", "Acerca de");
        }
    }
}