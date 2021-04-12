package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    //method
    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment ");
            System.out.println("2. My Schedule appointments ");
            System.out.println("0. logout ");

            Scanner input = new Scanner(System.in);
            response = Integer.valueOf(input.nextLine());
            switch (response){
                case 1:
                    showAddAvailableAppointmentMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (response!=0);
    }
    private static void showAddAvailableAppointmentMenu(){
        int response = 0;
        do {
            System.out.println(":: Add available Appointment");
            System.out.println(":: Select a month");
            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");
            Scanner input = new Scanner(System.in);
            response = Integer.valueOf(input.nextLine());

            if(response>0 && response<4){
                int monthSelect = response;
                System.out.println(monthSelect+". "+ UIMenu.MONTHS[monthSelect-1]);
                System.out.println("Insert the date available: [dd/mm/yyyy] ");
                String date = input.nextLine();
                System.out.println("Your date is: "+ date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(input.nextLine());
                if(responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available "+ date+"[13:00]");
                    time = input.nextLine();
                    System.out.println("Your date is: "+ time+ "\n1. Correct \n2. Change Date");
                    responseTime = Integer.valueOf(input.nextLine());
                }while (responseTime ==2);

                UIMenu.doctorLogged.addAvailableAppointment(date,time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);

            }else if(response == 0){
                showDoctorMenu();
            }
        }while (response!=0);
    }
    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if(doctor.getAvailableAppointments().size()>0
        && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
