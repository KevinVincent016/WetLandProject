package ui;

import java.time.LocalDate;
import java.util.Scanner;
import model.Municipality;

public class Main {
    
    private Scanner reader;

    private Municipality theMunicipality;

    public static void main(String[] args) {

        Main Program = new Main();

        Program.initializationController();

        int answer = 0;

        do{
            answer= Program.Menu();
            Program.answerOption(answer);
        }while (answer != 0);
    }

    public Main(){
        reader = new Scanner(System.in);
    }

    public int Menu() {
		int input;
		System.out.println("\n\nMenu del programa, digite una opcion\n"+ 
		                    "(1) Crear un humedal\n" +
		                    "(2) Registrar una nueva especie en el humedal\n" +
		                    "(3) Registrar un evento en el humedal\n"+
                            "(4) Registrar plan de mantenimiento al humedal\n" +
		                    "(5) Mantenimientos dados en los humedales en un año\n"+
		                    "(6) Mostrar humedal con menos especies de flora\n"+
                            "(7) Buscar humedal dado el nombre de una especie\n"+
                            "(8) Mostrar informacion de los humedales\n"+
                            "(9) Mostrar humedal con mayor cantidad de animales\n"+
		                    "(0) Para salir"
	
		);
		input = reader.nextInt();
		reader.nextLine();
		return input;
	}

    public void answerOption(int userOption) {
		switch(userOption) {
		case 0: 
			System.out.println("cerrando la aplicacion");
			break;
		case 1:
            registerWetland();
			break;
		case 2:
            registerSpecieInWetland();
			break;
		case 3:
            registerEventToWetland();
			break;
		case 4: 
            registerEnvManagementToWetland();
			break;
		case 5: 
            getEnviromentalMag();
            break;
        case 6:
            break;
        case 7:
            break;
        case 8:
            break;
        case 9:
            break;

		}	
	}

    public void initializationController(){
        System.out.println("Bienvenido al sistema de registro de humedales, digite el municipio");
        String name = reader.nextLine();
        theMunicipality = new Municipality(name);
    }

    public void registerWetland(){
        System.out.println("Para el registro de un humedal se debe llenar la siguiente informacion:");
        System.out.println("Indique el nombre del humedal");
        String nm = reader.nextLine();
        System.out.println("Indique en que zona se encuentra:");
        System.out.println("(1) Urbano");
        System.out.println("(2) Rural");
        int locationOption = reader.nextInt();
        String locationZ = "";
        boolean ct = true;
        while(ct==true){
            switch(locationOption){
                case 1:
                    locationZ = "Urbano";
                    ct=false;
                    break;
                case 2:
                    locationZ = "Rural";
                    ct=false;
                    break;
                default:
                    System.out.println("Solo se permiten los valores mostrados, seleccione entre las siguientes opciones:");
                    System.out.println("(1) Urbano");
                    System.out.println("(2) Rural");
                    locationOption = reader.nextInt();
            }
        }
        reader.nextLine();
        String zName = "";
        if(locationZ.equalsIgnoreCase("Urbano")){
            System.out.println("Indique el nombre del barrio");
            zName = "Barrio: " + reader.nextLine();
        }
        if(locationZ.equalsIgnoreCase("Rural")){
            System.out.println("Indique el nombre del corregimiento");
            zName = "Corregimiento: " + reader.nextLine();
        }
        System.out.println("Indique el tipo de humedal");
        System.out.println("(1) Publico");
        System.out.println("(2) Privado");
        int tp = reader.nextInt();
        String type = "";
        boolean ct2 = true;
        while(ct2==true){
            switch(tp){
                case 1:
                type = "Publico";
                ct2=false;
                break;
                case 2:
                type = "privado";
                ct2=false;
                break;
                default:
                System.out.println("Solo se permiten los valores mostrados, seleccione entre las siguientes opciones:");
                System.out.println("(1) Publico");
                System.out.println("(2) Privado");
                tp = reader.nextInt();
            }
        }
        reader.nextLine();
        System.out.println("Ingrese los Km2 del humedal");
        double km2 = reader.nextDouble();
        reader.nextLine();
        System.out.println("Ingrese la URL de la foto del humedal");
        String photo = reader.nextLine();
        System.out.println("Por ultimo, indique si el humedal es una zona protegida (Si/No)");
        String zP = reader.nextLine();
        boolean protectedZone=false;
        if(zP.equalsIgnoreCase("si")){
            protectedZone=true;
        }else{
            protectedZone=false;
        }
        System.out.println("\n" + theMunicipality.addWetland(nm, zName, locationZ, type, km2, photo, protectedZone));
    }

    public void registerSpecieInWetland(){
        System.out.println("Indique el humedal donde se va a registrar la especie:");
        String wetlandName = reader.nextLine();
        boolean conf = theMunicipality.findWetland(wetlandName);
        if(conf==true){
            System.out.println("Ahora indique el nombre de la especie");
            String nm = reader.nextLine();
            System.out.println("indique el nombre cientifico de la especie");
            String cnm = reader.nextLine();
            System.out.println("Indique el tipo de la especie");
            System.out.println("(1) Flora");
            System.out.println("(2) Animal");
            int typeOption = reader.nextInt();
            boolean ct = true;
            String type = "";
            while(ct==true){
                switch(typeOption){
                    case 1:
                        type = "Flora";
                        ct = false;
                        break;
                    case 2:
                        type = "Animal";
                        ct = false;
                        break;
                    default:
                        System.out.println("Solo se permiten los valores mostrados, seleccione entre las siguientes opciones:");
                        System.out.println("(1) Flora");
                        System.out.println("(2) Animal");
                        typeOption = reader.nextInt(); 
                }
            }
            reader.nextLine();
            System.out.println("La especie a registrar es migratoria? (Si/No)");
            String opMig = reader.nextLine();
            boolean MigSpecie = false;
            if(opMig.equalsIgnoreCase("si")){
                MigSpecie = true;
            }else{
                MigSpecie = false;
            }
            System.out.println("\n" + theMunicipality.addSpecieToWetland(wetlandName, nm, cnm, MigSpecie, type));
        }else{
            System.out.println("\n" + "El humedal " + wetlandName + " no existe o no esta registrado");
        }
    }

    public void registerEventToWetland(){
        System.out.println("Indique el humedal donde se va a registrar la especie:");
        String wetlandName = reader.nextLine();
        boolean conf = theMunicipality.findWetland(wetlandName);
        if(conf==true){
            System.out.println("Indique el nombre del encargado del evento");
            String mang = reader.nextLine();
            System.out.println("Indique el costo que tendra el evento");
            double cost = reader.nextDouble();
            reader.nextLine();
            System.out.println("Añada una descripcion para el evento");
            String desc = reader.nextLine();
            System.out.println("Por ultimo añada la fecha del evento");
            System.out.print("Dia: ");
            int d = reader.nextInt();
            System.out.print("Mes: ");
            int m = reader.nextInt();
            System.out.print("Año: ");
            int y = reader.nextInt();
            System.out.println("\n" + theMunicipality.addEventToWetland(wetlandName, mang, cost, desc, d, m, y));
        }
    }
    
    public void registerEnvManagementToWetland(){
        System.out.println("Para registrar el plan de mantenimiento de un humedal, primero indica el nombre del humedal");
        String Wname = reader.nextLine();
        System.out.println("Ahora indica el tipo de mantenimiento es:");
        System.out.println("(1) Restauracion");
        System.out.println("(2) Mantenimiento");
        System.out.println("(3) Conservacion");
        int MagOption = reader.nextInt();
        boolean ct = true;
        String MagType = "";
        while(ct==true){
            switch(MagOption){
                case 1:
                    MagType = "Restauracion";
                    ct = false;
                    break;
                case 2:
                    MagType = "Mantenimiento";
                    ct = false;
                    break;
                case 3:
                    MagType = "Conservacion";
                    ct = false;
                    break;
                default:
                    System.out.println("Solo se permiten los valores mostrados, seleccione entre las siguientes opciones:");
                    System.out.println("(1) Restauracion");
                    System.out.println("(2) Mantenimiento");
                    System.out.println("(3) Conservacion");
                    MagOption = reader.nextInt(); 
            }
        }
        reader.nextLine();
        System.out.println("Cual es el porcentaje de cumplimiento del plan (indicar solo el numero)");
        double prc = reader.nextDouble()/100;
        theMunicipality.addEnvMag(Wname, MagType, prc);
    }

    public void getEnviromentalMag(){
        System.out.println("Los planes de mantenimiento hambientales en los humedales registrados son los siguientes :");
        System.out.println(theMunicipality.showEnvManagements());
    }
}
