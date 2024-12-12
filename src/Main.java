import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       menu();
    }
    public static void menu(){
        Scanner scan=new Scanner(System.in);
        boolean acabar=false;
        String opccion;
        do {
            System.out.println("Elija una opccion: \n");

            System.out.println("(a) Mayor de edad");
            System.out.println("(b) Calculadora de ingresos de canal de youtube");
            System.out.println("(c)Calculo horario");
            System.out.println("(d)Salir");
            opccion=scan.next();
            switch(opccion){
                case "a":
                    System.out.println("Has elegido la opccion (a) Mayor de edad\n");
                    System.out.println("Eliga el numero de personas que desea poner la edad");
                    int numeroPersonas= scan.nextInt();
                    if (numeroPersonas>0){
                        System.out.println("El numero de personas que son mayores de edad son: "+edadMayor(numeroPersonas)+"\n");
                    }else {
                        System.out.println("Ese numero no es correcto\n");
                    }

                    break;

                case "b":
                    System.out.println("Has elegido la opccion (b) Calculadora de ingresos de canal de youtube\n");
                    double total=ingresoCanal();
                    if (total>0.1){
                        System.out.println("El dinero total es de "+total+" Euros");
                    }else{
                        System.out.println("Aun no ha ganado nada\n");
                    }
                    break;

                case "c":
                    System.out.println("Has elegido la opccion (c)Calculo horario\n");
                    calcularHoras();
                    break;

                case "d":
                    System.out.println("Has elegido la opccion (d)Salir\n");
                    acabar=true;
                    break;
                default:
                    System.out.println("No es un caracter correcto\n");
            }

        }while(acabar==false);

    }


    public static int edadMayor(int numeroPersonas){
        Scanner scan=new Scanner(System.in);
        int mayorEdad=0;
        for (int i=1;i<=numeroPersonas;i++){
            System.out.println("Ingrese el "+i+" año");
            int añoActual=Year.now().getValue();
            int añoNacido= scan.nextInt();
            if (añoNacido<0||añoNacido>añoActual){
                System.out.println("Ese valor es erroneo");
            }else{
                if (añoActual-añoNacido>=18){
                    mayorEdad++;
                }

            }


        }
        return mayorEdad;
    }


    public static double ingresoCanal() {
        Scanner scan = new Scanner(System.in);
        int video = 0;
        double ingresoTotal = 0;
        boolean cerrar=false;
        while (cerrar==false) {
            System.out.println("Ingrese de que trata el video:\n");
            System.out.println("(1)asmr");
            System.out.println("(2)deportes");
            System.out.println("(3)animales");
            System.out.println("(4)tecnologia");
            System.out.println("(5)bebés");
            System.out.println("(6)Acabar de poner videos y recibir resultado");
            video = scan.nextInt();
            double dineroVideo=0;
            switch (video) {
                case 1:
                    dineroVideo = ingresoVideo(0.1);
                    dineroVideo=Math.round(dineroVideo*1000)/1000;
                    ingresoTotal = ingresoTotal + dineroVideo;
                    break;
                case 2:
                    dineroVideo = ingresoVideo(1.0);
                    dineroVideo=Math.round(dineroVideo*100)/100;
                    ingresoTotal = ingresoTotal + dineroVideo;
                    break;
                case 3:
                    dineroVideo = ingresoVideo(0.2);
                    dineroVideo=Math.round(dineroVideo*100)/100;
                    ingresoTotal = ingresoTotal + dineroVideo;
                    break;
                case 4:
                    dineroVideo = ingresoVideo(0.5);
                    dineroVideo=Math.round(dineroVideo*100)/100;
                    ingresoTotal = ingresoTotal + dineroVideo;
                    break;
                case 5:
                    dineroVideo = ingresoVideo(0.5);
                    dineroVideo=Math.round(dineroVideo*100)/100;
                    ingresoTotal = ingresoTotal + dineroVideo;
                    break;
                case 6:
                    cerrar=true;
                    break;
                default:
                    System.out.println("Ese numero no es correcto\n");
            }
        }

        return ingresoTotal;
    }

    public static double ingresoVideo(double cpm){
        Scanner scan=new Scanner(System.in);
        int visitas;
        do {
            System.out.println("Ingrese el numero de visitas del video mayor a 0 por favor");
            visitas= scan.nextInt();
        }while(visitas<=0);
        double calculo=cpm*visitas/1000;
        return calculo;
    }

    public static void calcularHoras(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese la hora: ");
        int hora= scan.nextInt();

        System.out.println("Ingrese los minutos: ");
        int minutos= scan.nextInt();


        System.out.println("es (1)AM O (2)PM");
        int cadena= scan.nextInt();

        System.out.println("Escriba el huso del -11 al 12");
        int huso= scan.nextInt();
         int calculado=0;
         int calculadoFinal=0;
        if (hora>=0&&hora<=12&&minutos>=0&&minutos<=60&&huso>=-11&&huso<=12&&cadena==1){
               calculado= hora+huso;
           if (calculado>12){
               calculadoFinal=calculado-12;
               String cadenaResultado="PM";
               System.out.println("La hora es: "+calculadoFinal+":"+minutos+" "+cadenaResultado);
           } else if (calculado<00) {
               calculadoFinal=12-calculado;
               String cadenaResultado="PM";
               System.out.println("La hora es: "+calculadoFinal+":"+minutos+" "+cadenaResultado);
           }

        } else if (hora>=1&&hora<=11&&minutos>=0&&minutos<=60&&huso>=-11&&huso<=12&&cadena==2) {
            System.out.println("Entro en el 2");
            calculado= hora+huso;
            System.out.println(calculado);
            if (calculado<1){
                calculadoFinal=hora-calculado;
                String cadenaResultado="AM";
                System.out.println("La hora es: "+calculadoFinal+":"+minutos+" "+cadenaResultado);
            } else if (calculado>11) {
                calculadoFinal=calculado-hora-1;
                String cadenaResultado="AM";

                System.out.println("La hora es: "+calculadoFinal+":"+minutos+" "+cadenaResultado);
            }
        }else{
            System.out.println("Valores incorrectos");
        }



    }
}