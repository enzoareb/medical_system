package ui;

import model.Doctor;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("::Patient::");
            System.out.println(":Welcome!"+UImenu.patientLogged.getName()+":");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UImenu.showMenu();
                    break;
            }
        } while (response != 0);
    }
    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println("::Book an appointment::");
            System.out.println(":Select Date:");
            //numeracion de lista de fechas
            //indice de la fecha seleccionada por usuario
            // 1. Doctor1
            // - - - 1. Fecha1
            // - - - 2. Fecha2
            // 2. Doctor2
            // 3. Doctor3
            Map<Integer,Map<Integer, Doctor>> doctors = new TreeMap<>();
            int key = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size() ; i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer,Doctor> doctorAppointment = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size() ; j++) {
                    key++;
                    System.out.println(key+" . "+availableAppointments.get(j).getDate());
                    doctorAppointment.put(Integer.valueOf(j),UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(key),doctorAppointment);
                }
                Scanner sc = new Scanner(System.in);
                int responseDateSelected = Integer.valueOf(sc.nextLine());
                Map<Integer,Doctor> doctorAvailableSelected = doctors.get(responseDateSelected) ;
                Integer indexDate = 0;
                Doctor doctorSelected = new Doctor("","");

                for (Map.Entry<Integer,Doctor> doc : doctorAvailableSelected.entrySet()){
                    indexDate = doc. getKey();
                    doctorSelected = doc.getValue();
                }

                System.out.println(doctorSelected.getName()+". Date: "+doctorSelected.getAvailableAppointments().get(indexDate).getDate()+". Time: "+ doctorSelected.getAvailableAppointments().get(indexDate).getTime());

                System.out.println("Cofirm your appointment: \n1. yes \n2. change data");
                response = Integer.valueOf(sc.nextLine());

                if (response == 1){
                    UImenu.patientLogged.addAppointmentDoctors(doctorSelected,doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                    showPatientMenu();
                }

            }

        }while (response !=0);
    }

    private static void  showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println("::My Appointments::");
            if (UImenu.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("Don´t have appointments");
                break;
            }
            for (int i = 0; i < UImenu.patientLogged.getAppointmentDoctors().size(); i++){
                int j = i+1;
                System.out.println(j+". "+UImenu.patientLogged.getAppointmentDoctors().get(i).getDate()+" Time: "+ UImenu.patientLogged.getAppointmentDoctors().get(i).getTime()+"\n Doctor: "+UImenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
            }
            System.out.println("0. Return");
        }while (response!=0);
    }
















}
