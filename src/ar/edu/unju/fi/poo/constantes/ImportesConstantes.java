package ar.edu.unju.fi.poo.constantes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImportesConstantes {
    public static final Float SUELDO_BASICO = 150000f;
    public static final Float PORCENTAJE_DESCUENTOS = 0.15f;

    public static Float ADICIONAL_TITULO;
    public static Float VALOR_ANTIGUEDAD;
    public static Float VALOR_HIJO;

    public static final Map<Integer, Float> CATEGORIAS = new HashMap<>();

    static {
        leerValoresDesdeArchivo();
    }

    private static void leerValoresDesdeArchivo() {
        String archivo = "src/ar/edu/unju/fi/poo/constantes/valores.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("ADICIONAL_TITULO")) {
                    String[] partes = linea.split(":");
                    ADICIONAL_TITULO = Float.parseFloat(partes[1].trim());
                } else if (linea.startsWith("CATEGORIA")) {
                    String[] partes = linea.split(":");
                    int categoria = Integer.parseInt(partes[1].trim());
                    float valor = Float.parseFloat(partes[2].trim());
                    CATEGORIAS.put(categoria, valor);
                } else if (linea.startsWith("VALOR_ANTIGUEDAD")) {
                    String[] partes = linea.split(":");
                    VALOR_ANTIGUEDAD = Float.parseFloat(partes[1].trim());
                } else if (linea.startsWith("VALOR_HIJO")) {
                    String[] partes = linea.split(":");
                    VALOR_HIJO = Float.parseFloat(partes[1].trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static float getValorCategoria(int categoria) {
        return CATEGORIAS.getOrDefault(categoria, 0.0f);
    }
}