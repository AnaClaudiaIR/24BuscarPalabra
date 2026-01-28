import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BuscarPalabra {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contarL = 0;
        int contarP = 0;
        String palabra = ""; //Palabra introducida por el usuario
        String texto = ""; //Variable donde se guarda le texto

        try (BufferedReader reader = new BufferedReader(new FileReader("describir.txt"))) {
            String linea;;

            System.out.println("¿Qué palabra desea buscar?");
            palabra = sc.nextLine();

            System.out.println("TEXTO: ");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
                if (linea.contains(palabra)) {
                    contarL++; //Contar la línea
                    texto += linea + "\n"; //Guardar el texto
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

        String[] palabras = texto.trim().split("\\s+"); //Pasar el string a un array --> Para contar las palabras ("//s+" para ignorar simbolos de puntuación)
        for (String p:palabras){
            if (palabra.equalsIgnoreCase(p)){
                contarP++; //Sumar 1 si la palabra coincide
            }
        }
            System.out.println("\nLa palabra '" + palabra + "' aparece en " + contarL + " líneas.");
            System.out.println("La palabra '" + palabra + "' aparece " + contarP + " veces.");
    }
}
