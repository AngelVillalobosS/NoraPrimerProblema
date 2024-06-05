import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;


public class home {
    public static void main(String[] args) {
        try{

            File file = new File("entrada_salida.txt");//Lanza NullPointerException, si la cadena es vacía

// Crea el fichero si no existe
            boolean success = file.createNewFile();
//Lanza IOException o SecurityException

            if (success) {
// El fichero no existe y se crea:
                System.out.println("El fichero no existe y se crea");
//Comprueba que el fichero se puede escribir y leer:
                System.out.println("El fichero se puede escribir " + file.canWrite());
                System.out.println("El fichero se puede leer " + file.canRead());

//Le asociamos al fichero un búfer de escritura:
                BufferedWriter file_escribir =

                        new BufferedWriter (new FileWriter (file));
//Lanza IOException

//Escribimos cadenas de caracteres en el fichero
//Separadas por saltos de líneas:
                file_escribir.write("Una primera sentencia:");

//Lanza IOException
                file_escribir.newLine();
                file_escribir.write("8.5");
//Lanza IOException
                file_escribir.newLine();
                file_escribir.write("6");
//Lanza IOException
                file_escribir.newLine();
                file_escribir.flush();//Lanza IOException
                file_escribir.close();//Lanza IOException
//Abrimos ahora el fichero para lectura
//por medio de la clase Scanner:

                Scanner file_lectura =
                        new Scanner (file);
//Lanza FileNotFoundException

//Leemos cadenas de caracteres del mismo:
                String leer = file_lectura.nextLine();
//Lanza IllegalStateException
//o NoSuchElementException
                String leer2 = file_lectura.nextLine();
//Lanza IllegalStateException
//o NoSuchElementException
                String leer3 = file_lectura.nextLine();
//Lanza IllegalStateException

            //o NoSuchElementException
//Intentamos convertir cada cadena
//a su tipo de dato original:
            double leer_double;
            int leer_int;
            leer_double = Double.parseDouble(leer2);
//Lanza NumberFormatException
            leer_int = Integer.parseInt (leer3);
//Mostramos por la consola las diversas cadenas:
            System.out.println ("La cadena leida es " + leer);
            System.out.println ("El double leido " + leer_double);
            System.out.println ("El entero leido " + leer_int);
        }
else {
// El fichero ya existe:

            System.out.println("El fichero ya existe y no se creo");

        }
    }
catch (FileNotFoundException f_exception) {
//Excepcion que surge si no encontramos el fichero

//al crear el Scanner

        System.out.println ("Las operaciones de lectura no se han podido llevar a cabo,");
        System.out.println ("ya que ha sucedido un problema al buscar el fichero para lectura");
        System.out.println (f_exception.toString());
    }
catch (IOException io_exception){
//Excepcion que puede surgir en
//alguna de las operaciones de escritura

        System.out.println("Ocurrio algun error de entrad y salida");
        System.out.println (io_exception.toString());
    }
catch (NumberFormatException nb_exception){
//Excepcion que ocurre al realizar una conversion de una cadena
//de caracteres a un tipo numerico
        System.out.println ("Ha ocurrido un error de conversión de cadenas a numeros");
        System.out.println (nb_exception.toString());
    }
catch (NoSuchElementException nse_exception){
//Excepcion que ocurre cuando el metodo
//"nextLine(): String" no encuentra una cadena
        System.out.println ("No se ha podido encontrar el siguiente elemento del Scanner");
        System.out.println (nse_exception.toString());
    }
    catch (Exception e_exception){
//Un ultimo bloque que nos permita
//capturar cualquier tipo de excepcion
        System.out.println (e_exception.toString());
    }
}
}