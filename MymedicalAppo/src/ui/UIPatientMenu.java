package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu(){
        int respose = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient ");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointmens");
            System.out.println("3. logout");

            Scanner input = new Scanner(System.in);
            respose = Integer.valueOf(input.nextLine());

            switch (respose){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;



            }


        }while (respose!=0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println(":: Book an Appointment");
            System.out.println(":: Select date: ");
            // Coleccion de objetos: Numeracion de listas de fechas
            //Indice de la fecha que seleccion el usuario
            //Lista de doctores
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {

                    k++;
                    System.out.println(k+ ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);

                }
            }
            Scanner input = new Scanner(System.in);
            int resposeDataSelected = Integer.valueOf(input.nextLine());
            Map<Integer, Doctor> doctorAvailabeSelected = doctors.get(resposeDataSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","","");
            for (Map.Entry<Integer, Doctor> doc:doctorAvailabeSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            System.out.println(doctorSelected.getName()+
                    ". Time: "+ doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Date: "+ doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            System.out.println("Confirm your appointment: \n1.Yes \n2. Change Data");
            Integer respose = Integer.valueOf(input.nextLine());

            if (response== 1){
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                );
                showPatientMenu();

            }

        }while (response!=0);
    }

    private static void showPatientMyAppointments(){
        int respose = 0;
        do{
            System.out.println(":: My appointments");
            if (UIMenu.patientLogged.getAppointmentDoctors().size()==0){
                System.out.println("Don't have appointments");
                break;

            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i+1;
                System.out.println(j + ". " +
                        "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()
                );
            }
            System.out.println("0. Return");
        }while (respose!=0);
    }
}
