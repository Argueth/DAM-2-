using System.Runtime.ExceptionServices;

namespace Ejercicios
{
    internal class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                showMenu();
                int option = int.Parse(Console.ReadLine());
                switch (option)
                {
                    case 1:
                        Ejercicio1.Ejercicio();
                        break;
                    case 2:
                        Ejercicio2.Ejercicio();
                        break;
                    case 3:
                        Ejercicio3.Ejercicio();
                        break;
                    case 4:
                        Ejercicio4.Ejercicio();
                        break;
                    case 5:
                        Ejercicio5.Ejercicio();
                        break;
                    case 6:
                        Ejercicio6.Ejercicio();
                        break;
                    case 7:
                        Ejercicio7.Ejercicio();
                        break;
                    case 8:
                        Ejercicio8.Ejercicio();
                        break;
                    case 9:
                        Ejercicio9.Ejercicio();
                        break;
                    case 0:
                        Console.WriteLine("Bye!!");
                        Environment.Exit(0);
                        break;
                }
            } 
        }

        public static void showMenu()
        {
            Console.WriteLine(@"
********************************************************************************************************
                         OPTION MENU

    1. Recorre los números del 1 al 200. Utiliza un bucle for.

    2. Recorre los números del 1 al 200. Utiliza un bucle while.

    3. Recorre los números del 1 al 200. Muestra los números pares e impares por separado. Usar
       el tipo de bucle que quieras.

    4. Implementa un programa que pida los tres lados de un triángulo al usuario. Tienes que
       implementar los siguientes métodos: inicialización (en el cual se consigue la información);
       tipo_de_triángulo, que dependiendo de la medida de los lados nos diga si es equilátero, 
       isósceles o escaleno; area_triángulo que nos va a informar de la medida del área del
       triángulo.

    5. Implementad una clase Alumno y definid como atributos su nombre y su edad. Definid
       otros dos métodos para imprimir los datos que se han ingresado y un mensaje indicando si 
       es mayor de edad o no (edad >=18).

    6. Crea una clase que represente a los empleados de una empresa. Establece su nombre y 
       salario como atributos. Carga los atributos en el constructor, luego imprime sus datos en 
       otro método y finalmente imprime un mensaje si tiene que pagar impuestos (si el salario
       supera los 2000 €).

    7. En esta actividad debes implementar una clase llamada operación. Hay que cargar dos
       valores enteros en el constructor y a continuación, calcular su suma, resta, multiplicación y
       división, cada una en un método. A continuación, imprimir dichos resultados.

    8. Crea una clase llamada club y otra clase llamada asociado. La clase asociado ha de tener los 
       siguientes atributos privados: nombre y antigüedad en el club (en años). En el constructor
       de la clase debes pedir el nombre y su antigüedad.
       La clase Club debe tener 3 objetos de la clase asociado como atributos. Define un método
       que imprima el nombre del asociado del club con el mayor tiempo de antigüedad.

    9. Implementa una clase Individuo que tenga como atributos el nombre y la edad (definid las 
       propiedades para poder acceder a dichos atributos). Detalla un método para imprimir.
       Desarrollar una segunda clase Trabajador que herede de la clase Persona. Agregad un
       atributo salario (y su propiedad) y el método para imprimir su sueldo. Crea un objeto de la
       clase Individuo y llama a sus métodos y propiedades.
       También debes crear un objeto de la clase Trabajador y llamar a sus métodos y propiedades.


    0. Salir

*******************************************************************************************************

    Elige la opcion deseada: 
                ");
        }
    }

    public class Ejercicio1
    {
        public static void Ejercicio()
        {
            for (int i = 1; i <= 200; i++)
            {
                Console.WriteLine(i);
            }
        }
    }

    public class Ejercicio2
    {
        public static void Ejercicio()
        {
            int i = 1;
            while (i <= 200)
            {
                Console.WriteLine(i);
                i++;
            }
        }
    }

    public class Ejercicio3
    {
        public static void Ejercicio()
        {
            List<int> listEven = new List<int>();
            List<int> listOdd = new List<int>();
            for (int i = 1;i <= 200; i++)
            {
                if(i%2 == 0)
                {
                    listEven.Add(i);
                }else
                {
                    listOdd.Add(i);
                }
            }
            Console.WriteLine("List of even numbers:");
            foreach (int i in listEven)
            {
                Console.WriteLine(i);
            }
            Console.WriteLine("List of odd numbers:");
            foreach (int i in listOdd)
            {
                Console.WriteLine(i);
            }
        }
    }

    public class Ejercicio4
    {
        public static void Ejercicio()
        {
            int lado1, lado2, lado3;

            inicialization(out lado1 , out lado2, out lado3);
            Console.WriteLine($"El triángulo es de tipo {tipo_de_triangulo(lado1, lado2, lado3)}");
            Console.WriteLine($"El área del triángulo es {area_triangulo(lado1, lado2, lado3, tipo_de_triangulo(lado1, lado2, lado3)):0.00}");

            
        }

        public static void inicialization(out int lado1, out int lado2, out int lado3)
        {
            Console.WriteLine("Introduce la medida del primer lado: ");
            lado1 = int.Parse(Console.ReadLine());

            Console.WriteLine("Introduce la medida del segundo lado: ");
            lado2 = int.Parse(Console.ReadLine());

            Console.WriteLine("Introduce la medida del tercer lado: ");
            lado3 = int.Parse(Console.ReadLine());
        }

        public static String tipo_de_triangulo(int lado1, int lado2, int lado3)
        {
            String tipo;
            if (lado1 == lado2 && lado2 == lado3)
            {
                tipo = "equilatero";
            }else if((lado1 == lado2) || (lado1 == lado3) || (lado2 == lado3)){
                tipo = "isosceles";
            }else
            {
                tipo = "escaleno";
            }
            return tipo;
        }

        public static double area_triangulo(int lado1, int lado2, int lado3, String tipo)
        {
            double area = 0;
            if (tipo == "equilatero")
            {
                area = (Math.Sqrt(3) / (4) * Math.Pow(lado1, 2));
            }else if(tipo == "isosceles")
            {
                if(lado1 == lado2)
                {
                    double altura = Math.Sqrt(Math.Pow(lado1, 2) - Math.Pow(lado3 / 2, 2));
                    area = (lado3 * altura) / 2;
                }else if (lado1 == lado3)
                {
                    double altura = Math.Sqrt(Math.Pow(lado1, 2) - Math.Pow(lado2 / 2, 2));
                    area = (lado2 * altura) / 2;
                }
                else
                {
                    double altura = Math.Sqrt(Math.Pow(lado2, 2) - Math.Pow(lado1 / 2, 2));
                    area = (lado1 * altura) / 2;
                }
            }else
            {
                double semiperimetro = (lado1 + lado2 + lado3) / 2;
                area = Math.Sqrt(semiperimetro * (semiperimetro - lado1) * (semiperimetro - lado2) * (semiperimetro - lado3));
            }
            return area;
        }
    }

    public class Ejercicio5
    {
        public static void Ejercicio()
        {
            Console.WriteLine("Introduce el nombre del alumno: ");
            String name = Console.ReadLine();
            Console.WriteLine("Introduce la edad del alumno: ");
            int edad = int.Parse(Console.ReadLine());
            Alumno alumno = new Alumno(name, 33);
            alumno.printName();
            alumno.printAge();
            alumno.legalAge();
        }
    }

    public class Ejercicio6
    {
        public static void Ejercicio()
        {
            Console.WriteLine("Introduce el nombre del empleado");
            String name = Console.ReadLine();
            Console.WriteLine("Introduce el salario del empleado: ");
            double salary = double.Parse(Console.ReadLine());

            Empleado empleado = new Empleado(name, salary);
            Console.WriteLine(empleado.ToString());
            empleado.payTaxes();
        }
    }

    public class Ejercicio7
    {
        public static void Ejercicio()
        {
            try
            {
                Console.WriteLine("Introduce el primer número entero: ");
                int a = int.Parse(Console.ReadLine());
                Console.WriteLine("Introduce el segundo número: ");
                int b = int.Parse(Console.ReadLine());

                operacion obojOperacion = new operacion(a, b);
            }
            catch (DivideByZeroException e)
            {
                Console.WriteLine(e.ToString());
            }
        }
    }

    public class Ejercicio8
    {
        public static void Ejercicio()
        {
            Club club = new Club();

            while (true)
            {
                Console.WriteLine($"Introduce el nombre del socio");
                String name = Console.ReadLine();
                if( name == "") 
                {
                    break;
                }
                Console.WriteLine($"Introduce la antigüedad del socio");
                int antiguedad = int.Parse(Console.ReadLine());

                club.addAsociado(name, antiguedad);
            }

            club.mayorAntiguedad();
        }
    }

    public class Ejercicio9
    {
        public static void Ejercicio()
        {
            Person person = new Person("Carmen", 46);
            Trabajador trab = new Trabajador("Pablo", 33, 1500);

            person.print();
            trab.print();
        }
    }
}