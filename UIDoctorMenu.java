package ui;

import model.Doctor;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("::Doctor::");
            System.out.println("Welcome! "+ UImenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled appointments");
            System.out.println("0. Logout");

            Scanner entrada = new Scanner(System.in);
            response = Integer.valueOf(entrada.nextLine());

            switch (response){
                case 1:
                    showAddAvailableAppointmentMenu();
                    break;
                case 2:

                    break;
                case 0:
                    UImenu.showMenu();
                    break;
            }
        }while (response !=0);
    }

    private static void showAddAvailableAppointmentMenu(){
        int response = 0;
        do {
            System.out.println();
            System.out.println("::Add Available Appointment::");
            System.out.println("::Select a Month");

            for (int i=0; i<3 ; i++){
                int j = i+1;
                System.out.println(j+". "+UImenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner entrada = new Scanner(System.in);
            response = Integer.valueOf(entrada.nextLine());

            if (response>0 && response<4){
                int monthSelected = response;
                System.out.println(monthSelected+" . "+UImenu.MONTHS[monthSelected-1]);
                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = entrada.nextLine();

                System.out.println("Your date is: "+date+"\n1. Correct \n2. Change date");
                int responseDate = Integer.valueOf(entrada.nextLine());
                if (responseDate == 2)continue;

                int responseTime = 0;
                String time="";
                do {
                    System.out.println("Insert the time available for date "+ date +" [hh:mm]");
                    time = entrada.nextLine();
                    System.out.println("Your time is: "+ time +"\n1. Correct \n2. Change time");
                    responseTime = entrada.nextInt();
                }while (responseTime == 2);

                UImenu.doctorLogged.addAvailableAppointment(date,time);
                checkDoctorAvailableAppointments(UImenu.doctorLogged);
            }else if (response == 0){
                showDoctorMenu();
            }

        }while (response !=0);
    }

    private  static void checkDoctorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size()>0 && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }

    }


}
