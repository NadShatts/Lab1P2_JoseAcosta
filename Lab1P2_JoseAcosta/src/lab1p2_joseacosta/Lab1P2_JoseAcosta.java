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
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Scanner entrada = new Scanner(System.in);
        
        int opcion;
        do{
            System.out.println("Menu:");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Listar Todo");
            System.out.println("3. Listar por Dominio.");
            System.out.println("4. Salir");
            opcion = entrada.nextInt();
            
            switch(opcion){
                
                case 1:
                    System.out.println("Bienvenido al registro del usuario....");
                   break;
                   
                case 2:
                    System.out.println("Su lista seria la siguiente: ");
                    break;
                    
                case 3:
                  break;
                  
                case 4:
                    System.out.println("Saliendo del Registro. Vuelva Pronto..");
                    break;
                   
                default:
                    System.out.println("Opcion invalida para el registro. Intente denuevo.");
                   
                
            }
            
        }while(opcion!=4);
    }
    
}
