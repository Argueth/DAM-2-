using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    internal class Empleado
    {
        public String Name { get; set; }
        public double Salary { get; set; }

        public Empleado(String name, double salary)
        {
            Name = name;
            Salary = salary;
        }

        public void payTaxes()
        {
            if(Salary > 2000)
            {
                Console.WriteLine("EL empleado debe pagar impuestos.");
            }else {
                Console.WriteLine("El empleado no tiene que pagar impuestos.");
            }
        }

        public override String ToString()
        {
            return $"{Name} - {Salary:0.00}";
        }
    }
}
