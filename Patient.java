package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    //atributos
    private String birthday;
    private double weight;
    private double height;
    private String blood;
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(doctor,date,time);
        appointmentDoctor.schudle(date,time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    //constructor
    public Patient (String name, String email){
        super(name,email);
    }

    //metodo
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWeight() {
        return weight + " kgs.";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height + " mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nAge:"+getBirthday()+"\nweight:"+getWeight()+"\nheight"+getHeight()+"\nblood:"+getBlood();
    }

    @Override
    public void showDataUser() { //metodo abstracto obligatorio
        System.out.println("Paciente del hospital LIBERTY");
    }
}
