package com.mycompany.mvc.util;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    // Nombre de archivo con precisión de milisegundos (sin guiones)
    private static final DateTimeFormatter FORMATO_ARCHIVO = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    private static final DateTimeFormatter FORMATO_LOG = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public static void log(String nivel, String mensaje, Exception e) {
        try {
            String timestamp = LocalDateTime.now().format(FORMATO_ARCHIVO);
            Path ruta = Paths.get("log_" + timestamp + ".txt");
            
            String contenido = String.format("[%s] %s: %s%n", 
                LocalDateTime.now().format(FORMATO_LOG), 
                nivel, 
                mensaje);
            
            if (e != null) {
                contenido += "Detalle Técnico: " + e.toString() + "\n";
            }

            Files.writeString(ruta, contenido, StandardOpenOption.CREATE);
        } catch (IOException ioEx) {
            System.err.println("Error crítico escribiendo el log.");
        }
    }
}