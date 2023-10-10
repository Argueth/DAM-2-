namespace ConsoleApp1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Team Barcelona = new Team("Barcelona", "Bernabeu");

            Barcelona.addPlayer();
            Barcelona.addPlayer();

            Barcelona.listPlayers();
        }
    }
}