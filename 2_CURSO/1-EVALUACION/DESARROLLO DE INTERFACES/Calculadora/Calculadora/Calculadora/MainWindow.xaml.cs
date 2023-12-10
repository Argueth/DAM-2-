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

namespace Calculadora
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private String operacion = "sumar";
        private double resultado = 0;
        private bool root = false;
        private bool equal = false;
        public MainWindow()
        {
            InitializeComponent();

        }

        private void click0(object sender, EventArgs e)
        {
            if (resultado != 0)
            {
                resultadoText.Text += "0";
            }
            else
            {
                resultadoText.Text = "0";
            }
        }
        private void click1(object sender, EventArgs e)
        {
            if (resultado != 0)
            {
                resultadoText.Text += "1";
            }
            else
            {
                resultadoText.Text = "1";
            }
        }

        private void click2(object sender, EventArgs e)
        { 
            if (resultado != 0)
            {
                resultadoText.Text += "2";
            }
            else
            {
                resultadoText.Text = "2";
            }
        }

        private void click3(object sender, EventArgs e)
        {
            if (resultado != 0)
            {
                resultadoText.Text += "3";
            }
            else
            {
                resultadoText.Text = "3";
            }
        }

        private void click4(object sender, EventArgs e)
        {
            if (resultado != 0)
            {
                resultadoText.Text += "4";
            }
            else
            {
                resultadoText.Text = "4";
            }
        }

        private void click5(object sender, EventArgs e)
        {
            if (resultado != 0)
            {
                resultadoText.Text += "5";
            }
            else
            {
                resultadoText.Text = "5";
            }
        }

        private void click6(object sender, EventArgs e)
        {
            if (resultado != 0)
            {
                resultadoText.Text += "6";
            }
            else
            {
                resultadoText.Text = "6";
            }
        }

        private void click7(object sender, EventArgs e)
        {
            if (resultado != 0)
            {
                resultadoText.Text += "7";
            }
            else
            {
                resultadoText.Text = "7";
            }
        }

        private void click8(object sender, EventArgs e)
        {
            if (resultado != 0)
            {
                resultadoText.Text += "8";
            }
            else
            {
                resultadoText.Text = "8";
            }
        }

        private void click9(object sender, EventArgs e)
        {
            if (resultado != 0)
            {
                resultadoText.Text += "9";
            }
            else
            {
                resultadoText.Text = "9";
            }
        }

        private void clickDot(object sender, EventArgs e)
        {
            if (resultado != 0)
            {
                resultadoText.Text += ".";
            }
            else
            {
                resultadoText.Text = "Syntax Error";
            }
        }
        private void clickSum(object sender, EventArgs e)
        {
            if(!equal)
            {
                calculateResult(double.Parse(resultadoText.Text));
                operacion = "sumar";
                resultadoText.Text = "";
            }
            else
            {
                operacion = "sumar";
                resultadoText.Text = "";
                equal = false;
            }
                
        }

        private void clickRest(object sender, EventArgs e)
        {
            if(!equal)
            {
                calculateResult(double.Parse(resultadoText.Text));
                operacion = "restar";
                resultadoText.Text = "";
            }
            else
            {
                operacion = "restar";
                resultadoText.Text = "";
                equal = false;
            }
        }

        private void clickMult(object sender, EventArgs e)
        {
            if(!equal)
            {
                calculateResult(double.Parse(resultadoText.Text));
                operacion = "multiplicar";
                resultadoText.Text = "";
            }
            else
            {
                operacion = "multiplicar";
                resultadoText.Text = "";
                equal = false;
            }
        }

        private void clickDiv(object sender, EventArgs e)
        {
            if(!equal)
            {
                calculateResult(double.Parse(resultadoText.Text));
                operacion = "dividir";
                resultadoText.Text = "";
            }
            else
            {
                operacion = "dividir";
                resultadoText.Text = "";
                equal = false;
            }
        }

        private void clickRoot(object sender, EventArgs e)
        {
            if (resultadoText.Text != "" && resultadoText.Text != "0")
            {
                resultadoText.Text = Math.Sqrt(double.Parse(resultadoText.Text)).ToString();
                Console.WriteLine(resultado);
                equal = true;
            }
        }

        private void clickC(object sender, EventArgs e)
        {
            resultado = 0;
            resultadoText.Text = "0";
            operacion = "sumar";
            equal = false;
        }

        private void changeSign(object sender, EventArgs e)
        {
            try
            {
                resultadoText.Text = (double.Parse(resultadoText.Text) * (-1)).ToString();
                resultado *= -1;
                Console.WriteLine(resultado);
            }
            catch (Exception ex)
            {
                resultadoText.Text = "Syntax Error";
            }
        }

        private void clickEqual(object sender, EventArgs e)
        {
            calculateResult(double.Parse(resultadoText.Text));
            resultadoText.Text = resultado.ToString();
            equal = true;
        }
        private void calculateResult(double num)
        {
            try
            {
                switch (operacion)
                {
                    case "sumar":
                        resultado += num;
                        break;
                    case "restar":
                        resultado -= num;
                        break;
                    case "multiplicar":
                        resultado *= num;
                        break;
                    case "dividir":
                        resultado /= num;
                        break;
                }
                Console.WriteLine(resultado);
            }
            catch (DivideByZeroException ex)
            {
                resultadoText.Text = "Syntax Error";
            } 
        }
    }
}
