using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    internal class Alumno
    {
        public String Name { get; set; }
        public int Age { get; set; }

        public Alumno(String name, int age)
        {
            Name = name;
            Age = age;
        }

        public void printName()
        {
            Console.WriteLine(Name);
        }

        public void printAge()
        {
            Console.WriteLine(Age);
        }

        public void legalAge()
        {
            if(Age < 18)
            {
                Console.WriteLine("Es menor.");
            }else
            {
                Console.WriteLine("Es mayor.");
            }
        }

    }
}
