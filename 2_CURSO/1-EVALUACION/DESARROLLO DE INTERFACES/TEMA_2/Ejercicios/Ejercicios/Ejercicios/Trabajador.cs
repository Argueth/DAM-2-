using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    internal class Trabajador : Person
    {
        public double Salary { get; set; }

        public Trabajador(String name, int age, double salary ) : base(name, age)
        {
            Salary = salary;
        }

        public String toString() { return $"{Name} - {Age} - {Salary}€"; }

        public void print() { Console.WriteLine(toString()); }
    }
}
