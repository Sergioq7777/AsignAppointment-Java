package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"","Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Oct", "Nov", "Dic" };
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println("Welcome to my appointments");
        System.out.println("select an option");

        int response = 0;
        do {
            System.out.println("1. model.Doctor");
            System.out.println("2. model.Patient");
            System.out.println("3. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    response =0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thanks for the visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n \n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment: ");
            System.out.println("2. My appointments");
            System.out.println("0. Return ");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println(":: Book an appointment");
                    System.out.println("All months: ");
 /*                   for (String month: MONTHS) {
                        System.out.println("Months: " + month);
                    }

                   for (int i = 0; i < MONTHS.length; i++) {

                        System.out.println("\n" + i + "." + MONTHS[i]);
                    }

  */

                    for (int i = 1; i < 4; i++) {
                        System.out.println(i + "." + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    System.out.println("See you ... ");
                    showMenu();
                    break;
            }
        }while (response != 0);
    }
    public static void authUser(int UserType){
        //UserType 1 = Doctor
        //UserType 2 = Patient

        ArrayList<Doctor> doc = new ArrayList<>();
        doc.add(new Doctor("Sergio","sergiog@","Cardiology"));
        doc.add(new Doctor("Andres","andresq@","Pediatria"));
        doc.add(new Doctor("Vale","valeq@","Terapy "));

        ArrayList<Patient> pat = new ArrayList<>();
        pat.add(new Patient("Nat","nat@"));
        pat.add(new Patient("Pau","lush@"));
        pat.add(new Patient("Marlen","quir@"));
        boolean emailCorrect = false;
        do {
            System.out.println("Print your email correctly...");
            Scanner input = new Scanner(System.in);
            String emailC = input.next();
            if (UserType == 1){
                for (Doctor d: doc){
                    if (d.getEmail().equals(emailC)){
                        emailCorrect = true;
                        //obtener el usuario logeado
                        doctorLogged = d;
                        UIDoctorMenu.showDoctorMenu();
                        //showDoctorMenu
                    }
                }
            }
            if (UserType ==2){
                for (Patient p: pat){
                    if (p.getEmail().equals(emailC)){
                        emailCorrect=true;
                        patientLogged = p;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
        }while(!emailCorrect);

    }
}
