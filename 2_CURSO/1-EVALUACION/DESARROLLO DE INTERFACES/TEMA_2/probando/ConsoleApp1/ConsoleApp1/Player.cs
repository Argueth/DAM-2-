using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Player
    {
        public String Name { get; set; }
        public String Surname { get; set; }
        public int Age { get; set; }

        public Player(String name, String surname, int age)
        {
            Name = name;
            Surname = surname;
            Age = age;
        }
    }
}
