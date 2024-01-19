/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_joseacosta;

import java.text.ParseException;
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
                    System.out.println("Su lista seria la siguiente: ");
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

        if (!validarFechaNacimiento(fechaNacimiento)) {
            mostrarError("La fecha de nacimiento no es válida.");
            return;
        }
        
        if(!validarContraseña(contraseña)){
            mostrarError("Su contraseña no es valida");
        }

        if (!validarCorreo(correo)) {
            mostrarError("El correo electrónico no es válido.");
            return;
        }

        if (existeUsuarioConCorreo(correo)) {
            mostrarError("Ya existe un usuario con el mismo correo electrónico.");
            return;
        }

        Usuario usuario = new Usuario(nombre, apellido, fechaNacimiento, correo, contraseña);

        usuarios.add(usuario);

        mostrarMensaje("Usuario registrado correctamente.");
    }
    

        private static boolean validarFechaNacimiento(String fechaNacimiento) {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fechaNacimientoDate = null;
    try {
        fechaNacimientoDate = sdf.parse(fechaNacimiento);
    } catch (ParseException e) {
    }

    if (fechaNacimientoDate == null) {
        return false; 
    }

    Date fechaActual = new Date();
    long edad = (long) ((fechaActual.getTime() - fechaNacimientoDate.getTime()) / (1000 * 60 * 60 * 24 * 365.25));
    return edad >= 13;
}

    
    
    private static boolean existeUsuarioConCorreo(String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                return true;
            }
        }

        return false;
    }
    
    private static boolean validarCorreo(String correo) {

    if (!correo.matches("^[a-zA-Z0-9-_&$%]+@[a-zA-Z0-9-_&$%]+\\.(gmail|outlook|yahoo|icloud|protonmail|fastmail)$")) {
        return false;
    }

    for (Usuario usuario : usuarios) {
        if (usuario.getCorreo().equals(correo)) {
            return false;
        }
    }

    return true;
}
    
}

