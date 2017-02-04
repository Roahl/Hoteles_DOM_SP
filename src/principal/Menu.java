package principal;

import java.io.IOException;

import static principal.Main.lee;

/**
 * Created by Saul on 29/01/2017.
 */
public class Menu {
    public static byte principal() throws IOException {
        byte op;
        System.out.printf("\n+-------------Menu principal--------------+" +
                          "\n1.>Altas" +
                          "\n2.>Bajas" +
                          "\n3.>Modificaciones" +
                          "\n4.>Listado de hoteles" +
                          "\n5.>Listado de hoteles de categoria superior" +
                          "\n6.>Añadir etiqueta cadena dentro de hotel" +
                          "\n7.>Salir" +
                          "\nEliga opción: ");
        op = Byte.parseByte(lee.readLine());
        return op;
    }
}
