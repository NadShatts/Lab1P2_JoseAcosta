/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_joseacosta;

import java.util.ArrayList;
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
                    listarTodo();
                    break;

                case 3:
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
        System.out.println("Ingrese la información del usuario:");
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Apellido: ");
        String apellido = entrada.nextLine();
        System.out.print("Fecha de Nacimiento (AAAA-MM-DD): ");
        String fechaNacimiento = entrada.nextLine();
        System.out.print("Correo Electrónico: ");
        String correoElectronico = entrada.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = entrada.nextLine();

        
        Usuario usuario = new Usuario(nombre, apellido, fechaNacimiento, correoElectronico, contraseña);
        usuarios.add(usuario);
        System.out.println("Usuario registrado exitosamente.");

    }
    
    
    private static void listarTodo(){
        
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
    }
    }
    

