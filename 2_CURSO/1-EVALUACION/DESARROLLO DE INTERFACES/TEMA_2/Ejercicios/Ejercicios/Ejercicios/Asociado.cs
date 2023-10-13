using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    internal class Asociado
    {
        public String Name {  get; set; }
        public int Antiquity { get; set; }

        public Asociado(String name, int antiquity) 
        {
            Name = name;
            Antiquity = antiquity;
        }

        public String toString()
        {
            return $"{Name} - {Antiquity}";
        }
    }
}
