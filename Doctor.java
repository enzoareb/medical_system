package model;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //atributos
    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    //constructor
    public Doctor(String name, String email) {
        super(name, email);
        this.speciality = speciality;
    }

    //funciones
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    public void addAvailableAppointment(String date, String time){
        availableAppointments.add(new AvailableAppointment(date,time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString()+"\nSpeciality: "+speciality+"\nAppointment: "+availableAppointments;
    }

    @Override
    public void showDataUser() { //metodo abstracto obligatorio
        System.out.println("Empleado del hospital LIBERTY");
    }

    //clase interna directamente vinculada con la externa
    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        public AvailableAppointment(String date, String time){
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }
        //metodos get y set
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
            return date;
        }
        public String getDate(){
            return format.format(date);
        }
        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available appointment\n"+ "date: "+getDate()+"\ntime: "+getTime();
        }
    }
}
