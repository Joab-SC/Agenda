package co.edu.uniquindio.poo;

import java.util.Scanner;

public class Contacto {

    private String nombre;
    private String alias;
    private String direccion;
    private String telefono;
    private String email;

    public Contacto(String nombre, String alias, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.alias = alias;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        
        assert !nombre.isBlank();
        assert !alias.isBlank();
        assert !direccion.isBlank();
        assert !telefono.isBlank();
        assert !email.isBlank();
        assert email.contains("@");
        assert telefono.chars().anyMatch(Character :: isDigit);


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static Contacto ingresarContacto(int numero){
        Scanner scanner = new Scanner(System.in);

        Contacto.mostrarMensaje("Ingresar el contacto número " + numero + "\n");
        Contacto.mostrarMensaje("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();

        Contacto.mostrarMensaje("Ingrese el alias del contacto: ");
        String alias = scanner.nextLine();

        Contacto.mostrarMensaje("Ingrese la dirección del contacto: ");
        String direccion = scanner.nextLine();

        Contacto.mostrarMensaje("Ingrese el teléfono del contacto: ");
        String telefono = scanner.nextLine();

        Contacto.mostrarMensaje("Ingrese el E-mail del contacto: ");
        String email = scanner.nextLine();

        Contacto contacto = new Contacto(nombre, alias, direccion, telefono, email);

        return contacto;
    }

    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    @Override
    public String toString() {
        return "Contacto [nombre=" + nombre + ", alias=" + alias + ", direccion=" + direccion + ", telefono=" + telefono
                + ", email=" + email + "]";
    }

    
    
}
