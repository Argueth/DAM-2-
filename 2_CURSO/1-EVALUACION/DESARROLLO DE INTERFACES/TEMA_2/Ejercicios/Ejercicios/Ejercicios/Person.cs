using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    internal class Person
    {
        public String Name { get; set; }
        public int Age { get; set; }

        public Person(String name, int age) 
        {
            Name = name;
            Age = age;
        }

        public String toString() { return $"{Name} - {Age}"; }

        public void print() { Console.WriteLine(toString()); }
    }
}
