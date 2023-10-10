using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Team
    {
        public string Name { get; set; }
        public String Stadium { get; set; }
        public List<Player> players { get; set; }

        public Team(string name, String stadium)
        {
            this.Name = name;
            this.Stadium = stadium;
            players = new List<Player>();
        }

        public void addPlayer ()
        {
            Console.WriteLine("Introduce el nombre del jugador: ");
            String name = Console.ReadLine();

            Console.WriteLine("Introduce el apellido del jugador");
            String surname = Console.ReadLine();

            Console.WriteLine("Introduce la edad del jugador");
            int age = int.Parse(Console.ReadLine());

            players.Add(new Player(name, surname, age));
        }

        public void listPlayers()
        {
            foreach (Player player in players)
            {
                Console.WriteLine($"EL jugador {player.Name} {player.Surname} tiene {player.Age} años.");
            }
        }
    }
}
