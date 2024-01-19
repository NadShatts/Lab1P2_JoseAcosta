/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2_joseacosta;

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



    
    public String toString() {
            return String.format(
                    "\n" +
                    "Nombre: %s\n" +
                    "Apellido: %s\n" +
                    "Fecha de nacimiento: %s\n" +
                    "Correo electrónico: %s\n" +
                    "Contraseña: %s",
                    nombre, apellido, cumpleaños, correo, contraseña);
            
        }
    
}
