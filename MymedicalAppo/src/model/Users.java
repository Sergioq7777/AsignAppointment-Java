package model;

//Super Class: the idea its avoid the same atributtes in other classes
public abstract class Users {
    //Atributtes
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumb;

    // Constructor method
    public Users(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
        if(phoneNumb.length() == 8) {
            //System.out.println("\n" + name + ":");
            this.phoneNumb = phoneNumb;
        }else{
            System.out.println("\n" + name + ":");
            System.out.println("The number needs to be equals to 8 digits" + "\n");
        }
    }

    // Se sobre escribe directamente de Object.java
    @Override
    public String toString() {
        return "User: "+ name +"\nEmail: "+email + "\nAddress: " +
                address + "Phone: " + phoneNumb;
    }

    //method
    public abstract void showDataUser();
}
