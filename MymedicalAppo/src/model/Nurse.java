package model;

public class Nurse extends Users{
    private String speciality;

    public Nurse(String name, String email) {
        super(name, email);

    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Verde");
        System.out.println("Departamento: Ntriologia");
    }
}
