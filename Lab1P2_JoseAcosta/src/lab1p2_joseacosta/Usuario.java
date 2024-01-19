/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2_joseacosta;

import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author josed
 */
public class Usuario {
    
    
    private String nombre;
    private String apellido;
    private String cumpleaños;
    private String correo;
    private String contraseña;

    public Usuario(String nombre, String apellido, String cumpleaños, String correo, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cumpleaños = cumpleaños;
        this.correo = correo;
        this.contraseña = contraseña;
    }


    
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCumpleaños() {
        return cumpleaños;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }
    
   public String getEdad() {
        String[] partesFecha = cumpleaños.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int año = Integer.parseInt(partesFecha[2]);

   Date fechaActual = new Date();

        Calendar calendarioNacimiento = Calendar.getInstance();
        calendarioNacimiento.set(año, mes - 1, dia);
        Calendar calendarActual = java.util.Calendar.getInstance();
        calendarActual.setTime(fechaActual);

        int diferenciaAños = calendarActual.get(java.util.Calendar.YEAR) - calendarioNacimiento.get(java.util.Calendar.YEAR);
        int diferenciaMeses = calendarActual.get(java.util.Calendar.MONTH) - calendarioNacimiento.get(java.util.Calendar.MONTH);
        int diferenciaDias = calendarActual.get(java.util.Calendar.DAY_OF_MONTH) - calendarioNacimiento.get(java.util.Calendar.DAY_OF_MONTH);

        if (diferenciaDias < 0) {
            int ultimoDiaDelMesNacimiento = calendarioNacimiento.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
            diferenciaDias = ultimoDiaDelMesNacimiento + diferenciaDias;
            diferenciaMeses--; 
        }

        if (diferenciaMeses < 0) {
            diferenciaMeses = 12 + diferenciaMeses; 
            diferenciaAños--; 
        }

        return diferenciaAños + " años, " + diferenciaMeses + " meses  y " + diferenciaDias + " días";
    }
}



    
    
