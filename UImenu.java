package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UImenu {
    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu() {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    UIDoctorMenu.showDoctorMenu();
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    UIPatientMenu.showPatientMenu();
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }
/*
    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i+". "+MONTHS[i-1]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }*/

    //validacion base de datos
    private static void authUser(int userType){
        //userType = 1 doctor
        //userType = 2 patient

        ArrayList<Doctor>doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Martinez","alejandro@hospital.com"));
        doctors.add(new Doctor("Karen Sosa","karen@hospital.com"));
        doctors.add(new Doctor("Javier Santos","javier@hospital.com"));

        ArrayList<Patient>patient = new ArrayList<>();
        patient.add(new Patient("Anahi Salgado","anahi@gmail.com"));
        patient.add(new Patient("Roberto Rodriguez","roberto@gmail.com"));
        patient.add(new Patient("Carlos Sanchez","carlos@gmail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email:[usuario@dominio.com]");
            Scanner entrada = new Scanner(System.in);
            String email = entrada.nextLine();
            if (userType == 1){
                for (Doctor d:doctors){
                    if (d.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener usuario logeado
                        doctorLogged = d;
                        //showDoctorMenu
                    }
                }
            }
            if (userType == 2){
                for (Patient p:patient){
                    if (p.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener usuario logeado
                        patientLogged = p;

                    }
                }
            }


        }while (!emailCorrect);

    }












}