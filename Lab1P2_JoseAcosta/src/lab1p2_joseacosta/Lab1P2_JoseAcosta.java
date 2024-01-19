/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_joseacosta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author josed
 */
public class Lab1P2_JoseAcosta {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static final String[] ACCEPTED_DOMAINS = {"gmail.com", "outlook.com", "yahoo.com", "icloud.com", "protonmail.com", "fastmail.com"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Listar Todo");
            System.out.println("3. Listar por Dominio.");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    registroUsuario();
                    break;

                case 2:
                    if(usuarios.isEmpty()){
                        System.out.println("No hay ningun usuario registrado. Disculpenos");
                    }else

                    System.out.println("Lista de Usuarios:");
                    listarTodos();
                    break;

                case 3:
                    listarUsuariosPorDominio();
                    break;

                case 4:
                    System.out.println("Saliendo del Registro. Vuelva Pronto..");
                    break;

                default:
                    System.out.println("Opcion invalida para el registro. Intente denuevo.");

            }

        } while (opcion != 4);
    }

    private static void registroUsuario() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingresa tu apellido: ");
        String apellido = entrada.nextLine();
        System.out.println("Ingresa tu fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNacimiento = entrada.nextLine();
        System.out.println("Ingresa tu correo electrónico: ");
        String correo = entrada.nextLine();
        System.out.println("Ingresa tu contraseña: ");
        String contraseña = entrada.nextLine();


        
        if(!validarContraseña(contraseña)){
            mostrarError("Su contraseña no es valida");
        }


        if (existeUsuarioConCorreo(correo)) {
            mostrarError("Ya existe un usuario con el mismo correo electrónico.");
            return;
        }

        Usuario usuario = new Usuario(nombre, apellido, fechaNacimiento, correo, contraseña);

        usuarios.add(usuario);

        mostrarMensaje("Usuario registrado correctamente.");
    }
    

       

    private static boolean validarContraseña(String contraseña) {
    if (contraseña.length() < 8) {
        return false;
    }
    boolean contieneMayuscula = false;
    boolean contieneMinuscula = false;
    boolean contieneNumero = false;
    boolean contieneSimbolo = false;

    for (char caracter : contraseña.toCharArray()) {
        if (Character.isUpperCase(caracter)) {
            contieneMayuscula = true;
        } else if (Character.isLowerCase(caracter)) {
            contieneMinuscula = true;
        } else if (Character.isDigit(caracter)) {
            contieneNumero = true;
        } else if ("!?,<>$%".indexOf(caracter) != -1) {
            contieneSimbolo = true;
        }
    }
    return contieneMayuscula && contieneMinuscula && contieneNumero && contieneSimbolo;
}
    
    private static void listarTodos() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }


    private static void mostrarError(String mensaje) {
    System.out.println("Error: " + mensaje);
}

private static void mostrarMensaje(String mensaje) {
    System.out.println(mensaje);
}

private static void listarUsuariosPorDominio() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el dominio: ");
        String dominio = entrada.nextLine();

        for (Usuario usuario : usuarios) {
            String correoElectronico = usuario.getCorreo();
            if (correoElectronico.toLowerCase().endsWith(dominio.toLowerCase())) {
                System.out.println("Nombre: " + usuario.getNombre());
                System.out.println("Apellido: " + usuario.getApellido());
                System.out.println("Fecha de Nacimiento: " + usuario.getCumpleaños());
                System.out.println("Correo Electrónico: " + correoElectronico);
                System.out.println("Contraseña: " + usuario.getContraseña());

            }
}
}
    
    private static boolean existeUsuarioConCorreo(String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                return true;
            }
        }

        return false;
    }
}
    


