package model;

public abstract class User {
    //clase abstracta no puede ser instanciada solo las clases hijas de la misma

    //atributos
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    //constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //metodos
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

    public String getPhoneNumber() {
        return "11" + phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() >8){
            System.out.println("el numero debe tener maximo 8 digitos");
        }else {
            this.phoneNumber = phoneNumber;
        }
    }

    @Override //sobre escritura de metodos
    public String toString() {
        return "model.User: "+getName()+"\nemail: "+getEmail()+"\naddress: "+getAddress()+"\nphone: "+getPhoneNumber();
    }

    public abstract void showDataUser();//metodo obligatorio de impplementar en clases hijas
}
