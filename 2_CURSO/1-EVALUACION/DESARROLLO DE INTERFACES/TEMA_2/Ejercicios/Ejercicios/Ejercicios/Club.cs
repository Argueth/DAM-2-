using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    internal class Club
    {
        List<Asociado> asociados = new List<Asociado>();

        public void addAsociado(String name, int antiguedad)
        {
            asociados.Add(new Asociado(name, antiguedad));
        }
        public void mayorAntiguedad()
        {
            Asociado antiguo = asociados[0];
            foreach (Asociado asociado in asociados)
            {
                if (asociado.Antiquity > antiguo.Antiquity)
                {
                    antiguo = asociado;
                }
            }

            Console.WriteLine($"El asociado de mayor antigüead es {antiguo.Name} con una antugüedad de {antiguo.Antiquity}");
        }
    }
}
