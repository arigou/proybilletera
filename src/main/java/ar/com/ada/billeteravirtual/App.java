package ar.com.ada.billeteravirtual;

import java.util.*;

import ar.com.ada.billeteravirtual.excepciones.PersonaEdadException;
import ar.com.ada.billeteravirtual.security.Crypto;

public class App {

    public static Scanner Teclado = new Scanner(System.in);

    public static PersonaManager ABMPersona = new PersonaManager();

    public static UsuarioManager ABMUsuario = new UsuarioManager(); 

    public static BilleteraManager ABMBilletera = new BilleteraManager(); 

    public static CuentaManager ABMCuentas = new CuentaManager(); 

    public static void main(String[] args) throws Exception {
        ABMPersona.setup();
        ABMUsuario.setup();
        ABMBilletera.setup (); 
        ABMCuentas.setup ();

        printOpciones();

        int opcion = Teclado.nextInt();
        Teclado.nextLine();

        while (opcion > 0) {

            switch (opcion) {
            case 1:
            
                try {
                    alta();            
                } catch (PersonaEdadException exedad){
                    System.out.println("La edad permitida es a partir de 18 anios");
                }
                break;

            case 2:
                baja();
                break;

            case 3:
                modifica();
                break;

            case 4:
                listar();
                break;

            case 5:
                listarPorNombre();
                break;

            default:
                System.out.println("La opcion no es correcta.");
                break;
            }

            printOpciones();

            opcion = Teclado.nextInt();
            Teclado.nextLine();
        }

        // Hago un safe exit del manager
        ABMPersona.exit();
        ABMUsuario.exit();
        ABMBilletera.exit(); 
        ABMCuentas.exit(); 

    }

    public static void alta() throws Exception {

        Persona p = new Persona();
        System.out.println("Ingrese el nombre:");
        p.setNombre(Teclado.nextLine());
        System.out.println("Ingrese el DNI:");
        p.setDni(Teclado.nextLine());
        System.out.println("Ingrese la edad:");
        p.setEdad(Teclado.nextInt());
        Teclado.nextLine();
        System.out.println("Ingrese el Email:");
        p.setEmail(Teclado.nextLine());

        //ABMPersona.create(p);

        System.out.println("Persona generada con exito.  " + p);

        //System.out.println("Desea crear un usuario para esta persona?");
        //String rta;
        //rta = Teclado.nextLine();
        //if (rta.equals("si")) {

            Usuario u = new Usuario();
            u.setUserName(p.getEmail());
            System.out.println("Su nombre de usuario es " + u.getUserName());
            System.out.println("Ingrese un password:");
            
            //La password ingresa en texto claro a la variable y luego se encripta
            String passwordEnTextoClaro;
            String passwordEncriptada;
            String passwordEnTextoClaroDesencriptado;

            passwordEnTextoClaro = Teclado.nextLine();

            passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUserName());

            passwordEnTextoClaroDesencriptado = Crypto.decrypt(passwordEncriptada, u.getUserName());

            System.out.println("Tu password encriptada es :" +  passwordEncriptada);

            System.out.println("Tu password desencriptada es :" +  passwordEnTextoClaroDesencriptado);

            if (passwordEnTextoClaro.equals(passwordEnTextoClaroDesencriptado))
            {
                System.out.println("Ambas passwords coinciden");
            }
            else {
                System.out.println("Las passwords no coinciden, nunca debio entrar aqui");
            }

            u.setPassword(passwordEncriptada);

            /*
             * System.out.println("Su mail es:"); u.setUserEmail(p.getEmail());
             */
            //System.out.println("Ingrese su email de usuario:");
            u.setUserEmail(u.getUserName());

            p.setUsuario(u);
            //u.setPersona(p); <- esta linea hariaa falta si no lo hacemos en el p.SetUsuario(u)
            //u.setPersonaId(p.getPesonaId());
            //ABMUsuario.create(u);

            //System.out.println("Usuario generado con exito.  " + u);
        //}
        Billetera b = new Billetera();
        b.setPersona(p);

        Cuenta c = new Cuenta ();
        c.setMoneda("ARS");
        b.agregarCuentas(c);

        Movimiento m = new Movimiento();
        m.setImporte(256.10);
        c.setSaldo(c.getSaldo()+m.getImporte()); 
        m.setConceptoOperacion("Depósito");
        
        

        ABMPersona.create(p);

        System.out.println("Persona generada con exito.  " + p);
        System.out.println("Tambien se le creo un usuario: " + p.getUsuario().getUserName());
        System.out.println("Billetera virtual generada con exito.  " );




    }

    public static void baja()  {
        System.out.println("Ingrese el nombre:");
        String n = Teclado.nextLine();
        System.out.println("Ingrese el ID de Persona:");
        int id = Teclado.nextInt();
        Teclado.nextLine();
        Persona personaEncontrada = ABMPersona.read(id);

        if (personaEncontrada == null) {
            System.out.println("Persona no encontrada.");

        } else {
            ABMPersona.delete(personaEncontrada);
            System.out.println("El registro de " + personaEncontrada.getDni() + " ha sido eliminado.");
        }
    }

    public static void bajaPersonaPorDNI() {
        System.out.println("Ingrese el nombre:");
        String n = Teclado.nextLine();
        System.out.println("Ingrese el DNI de Persona:");
        String dni = Teclado.nextLine();
        Persona personaEncontrada = ABMPersona.readByDNI(dni);

        if (personaEncontrada == null) {
            System.out.println("Persona no encontrada.");

        } else {
            ABMPersona.delete(personaEncontrada);
            System.out.println("El registro de " + personaEncontrada.getDni() + " ha sido eliminado.");
        }
    }

    public static void modifica() throws Exception {
        // System.out.println("Ingrese el nombre de la persona a modificar:");
        // String n = Teclado.nextLine();
        System.out.println("Ingrese el ID de la persona a modificar:");
        int id = Teclado.nextInt();
        Teclado.nextLine();
        Persona personaEncontrada = ABMPersona.read(id);

        if (personaEncontrada != null) {

            System.out.println(personaEncontrada.toString() + "seleccionado para modificacion.");
            System.out.println("Ingrese el nuevo nombre:");
            personaEncontrada.setNombre(Teclado.nextLine());
            System.out.println("Ingrese el nuevo DNI:");
            personaEncontrada.setDni(Teclado.nextLine());
            // Teclado.nextLine();
            System.out.println("Ingrese la nueva edad:");
            personaEncontrada.setEdad(Teclado.nextInt());
            Teclado.nextLine();

            System.out.println("Ingrese el nuevo Email:");
            personaEncontrada.setEmail(Teclado.nextLine());

            ABMPersona.update(personaEncontrada);
            System.out.println("El registro de " + personaEncontrada.getDni() + " ha sido modificado.");

        } else {
            System.out.println("Persona no encontrada.");
        }

    }

    public static void modificaPersonaByDNI() throws Exception {
        // System.out.println("Ingrese el nombre de la persona a modificar:");
        // String n = Teclado.nextLine();
        System.out.println("Ingrese el DNI de la persona a modificar:");
        String dni = Teclado.nextLine();
        Persona personaEncontrada = ABMPersona.readByDNI(dni);

        if (personaEncontrada != null) {

            System.out.println(personaEncontrada.toString() + "seleccionado para modificacion.");
            System.out.println("Ingrese el nuevo nombre:");
            personaEncontrada.setNombre(Teclado.nextLine());
            System.out.println("Ingrese el nuevo DNI:");
            personaEncontrada.setDni(Teclado.nextLine());
            // Teclado.nextLine();
            System.out.println("Ingrese la nueva edad:");
            personaEncontrada.setEdad(Teclado.nextInt());
            Teclado.nextLine();

            System.out.println("Ingrese el nuevo Email:");
            personaEncontrada.setEmail(Teclado.nextLine());

            ABMPersona.update(personaEncontrada);
            System.out.println("El registro de " + personaEncontrada.getDni() + " ha sido modificado.");

        } else {
            System.out.println("Persona no encontrada.");
        }

    }

    public static void listar() {

        List<Persona> todas = ABMPersona.buscarTodas();
        for (Persona p : todas) {
            System.out.println("Id: " + p.getPersonaId() + " Nombre: " + p.getNombre());
        }
    }

    public static void listarPorNombre() {

        System.out.println("Ingrese el nombre:");
        String nombre = Teclado.nextLine();

        List<Persona> personas = ABMPersona.buscarPor(nombre);
        for (Persona p : personas) {
            System.out.println("Id: " + p.getPersonaId() + " Nombre: " + p.getNombre());
        }
    }

    public static void printOpciones() {
        System.out.println("=======================================");
        System.out.println("");
        System.out.println("Para agregar una persona presione 1.");
        System.out.println("Para eliminar una persona presione 2.");
        System.out.println("Para modificar una persona presione 3.");
        System.out.println("Para ver el listado presione 4.");
        System.out.println("Buscar una persona por nombre especifico(SQL Injection)) 5.");
        System.out.println("Para terminar presione 0.");
        System.out.println("");
        System.out.println("=======================================");
    }
}