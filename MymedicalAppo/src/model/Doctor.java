package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Users {
    //atributtes
    private String speciality;


    ///////-----------Functions to recive an array and return it;

    //collecion de datos ArrayList<nested class> newname = new Arraylist<>();
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();



    //Constructor with the super class users
    public Doctor(String name, String email, String speciality) {
        super(name, email);
        this.speciality = speciality;


    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "speciality: " + speciality +
                "\nAvailable: " + availableAppointments.toString()
                + super.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Departamento: central");
    }




    //metodo para añadir citas e incrementar la lista
    //Recive date and time
    public  void addAvailableAppointment(String date, String time){

        //take the ArrayList and create a new date
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

    //Devolver contenido
    public ArrayList<AvailableAppointment>getAvailableAppointments(){
        return availableAppointments;
    }

//----------- Nested Class-------------------------------->>


    public static class AvailableAppointment{
        private int id_availableAppontment;
        private Date date;
        private  String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        //availabe appointment

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e){
                e.printStackTrace();
            }
            this.time = time;
        }


        //Getters and Setters Available Appointments -----------

        public int getId_availableAppontment() {
            return id_availableAppontment;
        }

        public void setId_availableAppontment(int id_availableAppontment) {
            this.id_availableAppontment = id_availableAppontment;
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
            return "Available appointments: \nDate: "+date+
                    "\n Time" + time;
        }
    }


}
