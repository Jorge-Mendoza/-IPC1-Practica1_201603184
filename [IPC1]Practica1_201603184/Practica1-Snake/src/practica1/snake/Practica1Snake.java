/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.snake;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author FERNANDO
 */

public class Practica1Snake {
    static Console consola;
    static String nombre;
    static int valX;
    static int valY; 
    static int tSnake;
    static int score=0;
    static String matrix[][];
    static String posiciones[];
    static Scanner lector=new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
    }
    
    public static void menu(){
        System.out.println("\033[31m--------------------------------");
        System.out.println("\033[32m*******Bienvenido a Snake*******");
        System.out.println("\033[31m--------------------------------");
        System.out.println("\033[36m*******       Menú       *******");
        System.out.println("\033[34m******* Elije una opción *******");
        System.out.println("\033[34m------- [1] Inicio Juego -------");
        System.out.println("\033[34m------[2] Datos estudiante------");
        System.out.println("\033[34m------[3] Partidas jugadas------");
        System.out.println("\033[34m------     [4] Salir      ------");
        System.out.println("\033[31m--------------------------------");
        String opcion;
        
        opcion=lector.next();
        
        
        switch(opcion){
            case "1":
                snake();
            break;
            case "2":
                info();
            break;
            case "3":
                jugadas();
            break;
            case "4":
                System.exit(0);
            default:
                clear();
                System.out.println("Has ingresado un dato erróneo, ingresa el numero de opcion que prefieras");
                menu();
                
        }
    }
    public static void snake(){
        System.out.println("Ingresa tu nombre de jugador");
        nombre=lector.next();
        
        try{
         System.out.println("Ingresa el tamaño en 'x' para el tablero");   
         valX=lector.nextInt();   
         
        }
        catch(Exception ex){
            System.out.println("Oh oh, has ingresado un dato incorrectamente, revisa y vuelve");
            
            snake();
        }
        try{
         System.out.println("Ingresa el tamaño en 'y' para el tablero");   
         valY=lector.nextInt();   
         
        }
        catch(Exception ex){
            System.out.println("Oh oh, has ingresado un dato incorrectamente, revisa y vuelve");
            
            snake();
        }
        try{
         
        System.out.println("Ingresa el tamaño inicial del Snake");
        tSnake=lector.nextInt();
        }
        catch(Exception ex){
            System.out.println("Oh oh, has ingresado un dato incorrectamente, revisa y vuelve");
            
            snake();
        }
        
        String jugador= nombre+String.valueOf(valX)+String.valueOf(valY)+String.valueOf(tSnake);
        if (valX<10||valY<10||nombre.isEmpty()||tSnake==0){
            System.out.println("\033[31m ¡¡¡¡Has ingresado un dato erróneo, comienza de nuevo :D !!!");
            snake();
        }
        
        matrix=new String[valX][valY];
        posiciones= new String[tSnake+1];
        juego(0,0);
    }
    
    public static void info(){
        clear();
        animacion();
        System.out.println("\033[33m°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        System.out.println("\033[32m° Nombre: Jorge Fernando Mendoza Espinoza °");
        System.out.println("\033[32m°             Carné: 201603184            °");
        System.out.println("\033[32m°         Curso: IPC1, Sección: D         °");
        System.out.println("\033[33m°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        animacion();
        info();
        menu();
    }
    public static void jugadas(){
        System.out.println("Usted esta saliendo del juego");
        menu();
        
    }
    public static void clear(){
       
        for(int i=0; i<30; i++){
            System.out.println();
        }
    } 
    
    public static void juego(int movX, int movY){
        String muro="#";
        int x=0;
        int y=0;
        
        int cont=0;
        generaFruto();
        System.out.println("Punteo: "+score+"    "+nombre);
        for(int j=1;j<=valY;j++){
            System.out.println();
        for(int i=1;i<=valX;i++){
          if(i==((valX/2)+movX) &&j==((valY/2)+movY)){
                for(int k=1;k<=tSnake;k++){
                   System.out.print("*");
                   x=i;
                   y=j;
                   mueveteSnake(i,j,k);
                }
           }
           if(j==1||i==1||j==valY||i==valX){
               System.out.print("\033[36m"+muro);
           }
           
           
           
//            if(i==posX && j==posY){
//               System.out.println("@");
//               cont++;
//                    
//           }
           
           else{
               System.out.print(" ");
           }
           
               
        }
        }
        System.out.println();
        System.out.println(x+" "+y);
        System.out.println(damePosicion());
        System.out.println("Tus ultimas jugadas");
        System.out.println();
        movimientos();
    }
    public static void movimientos(){
        int j=0;
        int i=0;
        String movimiento="";
        System.out.println();
        System.out.println("Has algún movimiento");
        movimiento=lector.next();
        if (movimiento.equalsIgnoreCase("w")){
            j=j+1;
            juego(0,1);
        }
        if (movimiento.equalsIgnoreCase("s")){
            j=j-1;
            juego(0,-1);
        }
        if(movimiento.equalsIgnoreCase("a")){
            i=i-1;
            juego(-1,0);
        }
        if(movimiento.equalsIgnoreCase("d")){
            i=i+1;
            juego(1,0);
            
        }
        if(movimiento.equalsIgnoreCase("e")){
            jugadas();
        }
        
    }
    static int i;
    static int j;
    static int k;
    static String posicion;
    public static void mueveteSnake(int x, int y,int k){
        
        i=x;
        j=y;
        
            posiciones[k]=x+" "+y;
            posicion=posiciones[k];
            
        
        
    }
    public static String damePosicion(){
        return posicion;
    }
    static int posX;
    static int posY;
    public static void generaFruto(){
        Random numero=new Random();
        posX=(numero.nextInt(valX))+1;
        posY=(numero.nextInt(valY))+1;
         
    }
    public static void animacion(){
        int movimiento=0;
        do{
                if( movimiento%2==0){
                    
                   System.out.println("\033[33m    $$$$ $$   $ $$$$ $ $   $$$$");
                   System.out.println("\033[33m    $    $ $  $ $  $ $$$   $   ");
                   System.out.println("\033[33m    $    $  $ $ $$$$ $  $  $$$ ");
                   System.out.println("\033[33m    $    $   $  $  $ $   $ $   ");
                   System.out.println("\033[33m$$$$$    $    $ $  $ $   $ $$$$");   
                        
                    
                    
                }
                if(movimiento%3==0){
                   System.out.println("\033[32m    $$$$ $$   $ $$$$ $ $   $$$$");
                   System.out.println("\033[32m    $    $ $  $ $  $ $$$   $   ");
                   System.out.println("\033[32m    $    $  $ $ $$$$ $  $  $$$ ");
                   System.out.println("\033[32m    $    $   $  $  $ $   $ $   ");
                   System.out.println("\033[32m$$$$$    $    $ $  $ $   $ $$$$");
                  
                }
                 clear();
                movimiento++;
                  
            }while(movimiento<3);
      
       
    }
    
    
}
 