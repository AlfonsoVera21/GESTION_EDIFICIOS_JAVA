package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static ArrayList<Edificio> edificio= new ArrayList<Edificio>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("Digite la opcion que desea");
            System.out.println("1. Registrar la información de los edificios ");
            System.out.println("2. Buscar edificios por tipo (empresa, gimnasio, residencial) e imprimir los datos");
            System.out.println("3. Buscar edificios por dirección e imprimir los datos ");
            System.out.println("4. Buscar los edificios con una cantidad específica de pisos e imprimir los datos");
            System.out.println("5. Mostrar los inquilinos de un edificio e imprimir sus datos ");
            System.out.println("6. Salir");
            System.out.println("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            try {
                switch (opcion) {
                    case 1 -> registrarInfoEdificio();
                    case 2 -> buscarEdificioPorTipo();
                    case 3 -> buscarEdificioPorDireccion();
                    case 4 -> buscarEdificioPorPiso();
                    case 5 -> System.out.println("Has seleccionado la opcion 5");
                    case 6 -> salir = true;
                    default -> System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }
    }
    public static void registrarInfoEdificio(){
        int opcion;
        char resp;
        do {
            do {
                System.out.println("Digite que edificio desea registrar");
                System.out.println("1. Empresa");
                System.out.println("2. Gimnasio");
                System.out.println("3. Residencial");
                System.out.println("Opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();
            } while (opcion<1 || opcion>3);

            switch (opcion) {
                case 1 -> //llenar empresa
                        llenarEmpresa();
                case 2 -> // llenar gimnasio
                        llenarGimnasio();
                case 3 -> // llenar residencial
                        llenarResidencial();
            }
            System.out.println("Desea ingresar otro edificio (s/n): ");
            resp = sc.next().charAt(0);
            System.out.println("\n");
            sc.nextLine();
        }while (resp == 's' || resp == 'S');

    }
    public static void llenarEmpresa(){
        String nombre,direccion;
        int numPisos;
        System.out.println("Digite el nombre del edificio tipo empresa");
        nombre = sc.nextLine();
        System.out.println("Digite la direccion del edificio");
        direccion = sc.nextLine();
        System.out.println("Digite el numero de pisos del edificio");
        numPisos = sc.nextInt();
        Empresa empresa = new Empresa(nombre,direccion,numPisos);
        edificio.add(empresa);
        sc.nextLine();
    }
    public static void llenarGimnasio(){
        String nombre,direccion;
        int numPisos;
        System.out.println("Digite el nombre del edificio tipo gimnasio");
        nombre = sc.nextLine();
        System.out.println("Digite la direccion del edificio");
        direccion = sc.nextLine();
        System.out.println("Digite el numero de pisos del edificio");
        numPisos = sc.nextInt();
        Gimnasio gimnasio = new Gimnasio(nombre,direccion,numPisos);
        edificio.add(gimnasio);
        sc.nextLine();
    }
    public static void llenarResidencial(){
        String nombre,direccion;
        int numPisos;
        System.out.println("Digite el nombre del edificio residencial");
        nombre = sc.nextLine();
        System.out.println("Digite la direccion del edificio");
        direccion = sc.nextLine();
        System.out.println("Digite el numero de pisos del edificio");
        numPisos = sc.nextInt();
        Residencial residencial = new Residencial(nombre,direccion,numPisos);
        edificio.add(residencial);
        sc.nextLine();
    }
    public static void buscarEdificioPorTipo(){
        String tiEdificio;
        System.out.println("Ingrese el tipo de edificio que desea buscar Empresa, Gimnasio, Residencical: ");
        tiEdificio = sc.nextLine();
        try {
            for (Edificio edif: edificio){
                if (edif.tipoEdificio.equals(tiEdificio)){
                    System.out.println(edif.toString());
                }
            }
            System.out.println("\n");
            sc.nextLine();
        }catch (Exception e){
            System.out.println("error ..."+e);
        }

    }
    public static void buscarEdificioPorDireccion(){
        String direccion;
        System.out.println("Ingrese la direccion del edificio que desea buscar: ");
        direccion = sc.nextLine();
        try {
            for (Edificio edif: edificio){
                if (edif instanceof Empresa) {
                    Empresa empre = (Empresa) edif;
                    String dirEmpr = empre.getDireccion();
                    if (direccion.equals(dirEmpr)) {
                        System.out.println(edif.toString());
                    }
                } else if (edif instanceof Gimnasio) {
                    Gimnasio gym = (Gimnasio) edif;
                    String dirGym = gym.getDireccion();
                    if (direccion.equals(dirGym)) {
                        System.out.println(edif.toString());
                    }
                } else if (edif instanceof Residencial) {
                    Residencial resi = (Residencial) edif;
                    String dirResi = resi.getDireccion();
                    if (direccion.equals(dirResi)) {
                        System.out.println(edif.toString());
                    }
                }
            }
            System.out.println("\n");
        }catch (ClassCastException e){
            System.out.println(" El error viene por un casteo "+ e);
        }
        sc.nextLine();

    }
    public static void buscarEdificioPorPiso(){
        int pisos;
        System.out.println("Ingrese la cantidad especifica de pisos del edificio que desea buscar: ");
        pisos = sc.nextInt();
        try{
            for (Edificio edif: edificio){
                if (edif instanceof Empresa) {
                    Empresa empre = (Empresa) edif;
                    int pisEmp = empre.getNumPisos();
                    if (pisos == pisEmp) {
                        System.out.println(edif.toString());
                    }
                } else if (edif instanceof Gimnasio) {
                    Gimnasio gym = (Gimnasio) edif;
                    int pisGym = gym.getNumPisos();
                    if (pisos == pisGym) {
                        System.out.println(edif.toString());
                    }
                } else if (edif instanceof Residencial) {
                    Residencial resi = (Residencial) edif;
                    int pisResi = resi.getNumPisos();
                    if (pisos == pisResi) {
                        System.out.println(edif.toString());
                    }
                }
            }
            System.out.println("\n");
            sc.nextLine();
        }catch (ClassCastException e){
            System.out.println(" El error viene por un casteo "+ e);
        }

    }
}