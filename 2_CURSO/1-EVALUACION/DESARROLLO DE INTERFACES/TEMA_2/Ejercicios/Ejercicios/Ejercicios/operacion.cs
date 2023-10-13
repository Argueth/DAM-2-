using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    internal class operacion
    {
        private int A {  get; set; }
        private int B { get; set; }

        public operacion(int A, int B)
        {
            this.A = A;
            this.B = B;
            Console.WriteLine($"La suma de los números es: {sumar()}");
            Console.WriteLine($"La resta de los números es: {restar()}");
            Console.WriteLine($"La multiplicación de los números es {multiplicar()}");
            Console.WriteLine($"La división de los núemros es: {dividir():0.00}");
        }

        public int sumar() { return this.A + this.B;}

        public int restar() { return this.A - this.B;}

        public int multiplicar() { return this.A * this.B;}

        public double dividir()
        { 
            if(B!=0)
            {
                double resultado = (double)A / B;
                return resultado;
            }
            else
            {
                throw new DivideByZeroException("No se puede dividir por cero");
            }
        }
    }
}
