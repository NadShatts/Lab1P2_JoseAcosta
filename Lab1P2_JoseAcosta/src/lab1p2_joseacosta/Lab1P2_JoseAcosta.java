/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_joseacosta;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 *
 * @author josed
 */
public class Lab1P2_JoseAcosta {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
   
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
                    System.out.println("Registro Cibernetico");
                    registroUsuario();
                    break;

                case 2:
                    if (usuarios.isEmpty()) {
                        System.out.println("No hay ningun usuario registrado. Disculpenos");
                    } else {
                        System.out.println("Lista de Usuarios Registrados:");
                        for (Usuario usuario : usuarios) {
            String correoElectronico = usuario.getCorreo();
            System.out.println("");
            System.out.println("Usuario."); 
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Edad: " + usuario.getEdad());
            System.out.println("Correo Electrónico: " + correoElectronico);
            System.out.println("Contraseña: " + usuario.getContraseña());

        }
    }
                    break;

                case 3:
                    if (usuarios.isEmpty()) {
                        System.out.println("No hay ningun usuario registrado hasta el momento. Disculpenos");
                    } else {
                        listarUsuariosPorDominio();
                        break;
                    }

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
        System.out.println("Ingresa tu fecha de nacimiento (dd/MM/yyyy): ");
        String fechaNacimiento = entrada.nextLine();
        System.out.println("Ingresa tu correo electrónico: ");
        System.out.println("@gmail.com | @outlook.com | @yahoo.com | @icloud.com |  @rotonmail.com |  @fastmail.com");
        String correo = entrada.nextLine();
        System.out.println("Ingresa tu contraseña: ");
        String contraseña = entrada.nextLine();

         if (!validarCorreoElectronico(correo)) {
            System.out.println("Correo electrónico no válido o ya registrado.");
            return;
        }
         
        if (!validarFechaNacimiento(fechaNacimiento)) {
            mostrarError("Fecha de nacimiento no valida. Vuelva a intentarlo");
            return;
        }

        if (!validarContraseña(contraseña)) {
            mostrarError("Su contraseña no es valida. Vuelva a intentarlo");
        }

        Usuario usuario = new Usuario(nombre, apellido, fechaNacimiento, correo, contraseña);

        usuarios.add(usuario);

        mostrarMensaje("Usuario registrado correctamente.");

    }

   private static boolean validarCorreoElectronico(String correo) {
    String verificar = "^[a-zA-Z0-9_.%&$-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    String[] correo1 = correo.split("@");
    String nombreUsuario = correo1[0];
    String dominio = correo1[1].toLowerCase();

    if (!correo.matches(verificar) || existeUsuario(nombreUsuario, dominio) || !esDominioValido(dominio)) {
        return false;
    } 
    return true;
}

private static boolean esDominioValido(String dominio) {
    String[] aceptado = {"gmail.com", "outlook.com", "yahoo.com", "icloud.com", "protonmail.com", "fastmail.com"};

    for (String dominioAceptado : aceptado) {
        if (dominio.equals(dominioAceptado)) {
            return true;
        }
    }
    return false;
}

    private static boolean existeUsuario(String nombreUsuario, String dominio) {
        for (Usuario usuario : usuarios) {
            String correoUsuario = usuario.getCorreo();
            String[] partesCorreoUsuario = correoUsuario.split("@");
            String nombreUsuarioRegistrado = partesCorreoUsuario[0];
            String dominioRegistrado = partesCorreoUsuario[1].toLowerCase();

            if (nombreUsuario.equalsIgnoreCase(nombreUsuarioRegistrado) && dominio.equals(dominioRegistrado)) {
                return true;
            }
        }
        return false;
    }

    private static boolean validarFechaNacimiento(String fechaNacimiento) {

        String[] fechas = fechaNacimiento.split("/");
        int dia = Integer.parseInt(fechas[0]);
        int mes = Integer.parseInt(fechas[1]);
        int año = Integer.parseInt(fechas[2]);

        Date fechaActual = new Date();

        Calendar nacimiento = Calendar.getInstance();
        nacimiento.set(año, mes - 1, dia);
        Calendar calendarioActual = Calendar.getInstance();
        calendarioActual.setTime(fechaActual);
        int edad = calendarioActual.get(java.util.Calendar.YEAR) - nacimiento.get(java.util.Calendar.YEAR);
        if (calendarioActual.get(java.util.Calendar.MONTH) < nacimiento.get(java.util.Calendar.MONTH)
                || (calendarioActual.get(java.util.Calendar.MONTH) == nacimiento.get(java.util.Calendar.MONTH)
                && calendarioActual.get(java.util.Calendar.DAY_OF_MONTH) < nacimiento.get(java.util.Calendar.DAY_OF_MONTH))) {
            edad--;
        }
        return edad >= 13;
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


    private static void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    private static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    private static void listarUsuariosPorDominio() {
    Scanner entrada = new Scanner(System.in);
    System.out.println("gmail.com | outlook.com | yahoo.com | icloud.com | protonmail.com | fastmail.com");
    System.out.print("Ingrese el dominio: ");
    String dominio = entrada.nextLine();

    for (Usuario usuario : usuarios) {
        String correoElectronico = usuario.getCorreo();
        StringTokenizer tokenizer = new StringTokenizer(correoElectronico, "@");

        if (tokenizer.countTokens() == 2) {
            String nombreUsuario = tokenizer.nextToken();
            String dominioUsuario = tokenizer.nextToken().toLowerCase();

            if (dominioUsuario.equals(dominio.toLowerCase())) {
                System.out.println("");
                System.out.println("Usuario");
                System.out.println("Nombre: " + usuario.getNombre());
                System.out.println("Apellido: " + usuario.getApellido());
                System.out.println("Edad: " + usuario.getEdad());
                System.out.println("Correo Electrónico: " + correoElectronico);
                System.out.println("Contraseña: " + usuario.getContraseña());
            }
        }
    }
    }
}
