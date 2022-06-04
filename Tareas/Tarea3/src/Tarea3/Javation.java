
package Tarea3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Javation {
    public static void main(String [] args)throws IOException{
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = entrada.next();

        System.out.println("BIENVENIDO(A) " + nombre);

        ArrayList<Persona> personasJugador = new ArrayList<>();
        ArrayList<Edificio> edificios = new ArrayList<>();
        ArrayList<Feria> ferias = new ArrayList<>();
        ArrayList<Museo> museos = new ArrayList<>();
        ArrayList<Javapato> javapatos = new ArrayList<>();
        ArrayList<String> personasFallecidas = new ArrayList<>();

        Jugador jugador = new Jugador(nombre, 30, 30, 10, 6, personasJugador, edificios, ferias, museos, javapatos);
        System.out.println("Inicialmente tenemos " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");

        
        boolean turno;
        while(jugador.getJavalares() >= 0){
            turno = true;
            while(turno == true){
                System.out.println("¿Que quieres hacer? \n1.Crear una Persona\n2.Crear un Edificio\n3.Crear una Atracción\n4.Mejorar a una Persona\n5.Mejorar a un Edificio\n6.Mover a una Persona a un Edificio\n7.Sacar a una Persona de un Edificio\n8.Mostrar Personas sin Edificio\n9.Mostrar Edificios construidos con personas\n10.Mostrar Atracciones contruidas\n11.Terminar el juego\nResponda con el numero correspondiente: ");
                String Respuesta = entrada.next();
                if(Respuesta.equals("1")){
                    System.out.println("Ingrese el nombre de la Persona: ");
                    String nombrePersona = entrada.next();
                    System.out.println("¿Que profesión tiene " + nombrePersona + "? \n1.Granjero: 5 Javalares \n2.Cientifico: 8 Javalares\n3.Herrero: 6 Javalares\nResponda con el número correspondiente: ");
                    String profesion = entrada.next();
                    if(profesion.equals("1")){
                        if(jugador.getJavalares() >= 5){
                            Granjero granjero = new Granjero(nombrePersona, 15, 1, 8);
                            jugador.agregar_persona(granjero);
                            jugador.setJavalares(jugador.getJavalares() - 5);
                            System.out.println("Se ha creado el/la Granjero/a " +  nombrePersona + ".\nAhora tenemos " + jugador.getJavalares() + " Javalares, "  + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                        } 
                        else{
                            System.out.println("No se puede comprar el/la Granjero/a " + nombrePersona);
                        }
                    }
                    else if(profesion.equals("2")){
                        if(jugador.getJavalares() >= 8){
                            Cientifico cientifico = new Cientifico(nombrePersona, 24, 1, 10);
                            jugador.agregar_persona(cientifico);
                            jugador.setJavalares(jugador.getJavalares() - 8);
                            System.out.println("Se ha creado el/la Cientifico/a " +  nombrePersona + ".\nAhora tenemos " + jugador.getJavalares() + " Javalares, "  + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                        } 
                        else{
                            System.out.println("No se puede comprar el/la Cientifico/a " + nombrePersona);
                        }
                    }
                    else if(profesion.equals("3")){
                        if(jugador.getJavalares() >= 6){
                            Herrero herrero = new Herrero(nombrePersona, 18, 1, 9);
                            jugador.agregar_persona(herrero);
                            jugador.setJavalares(jugador.getJavalares() - 6);
                            System.out.println("Se ha creado el/la Herrero/a " +  nombrePersona + ".\nAhora tenemos " + jugador.getJavalares() + " Javalares, "  + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                        } 
                        else{
                            System.out.println("No se puede comprar el/la Herrero/a " + nombrePersona);
                        }
                    }
                    else{
                        System.out.println("Opción invalida, reintentar ");
                    }
                }

                else if(Respuesta.equals("2")){
                    System.out.println("Ingrese el nombre del Edificio: ");
                    String nombreEdificio = entrada.next();
                    System.out.println("¿Que tipo de Edificio es " + nombreEdificio + "? \n1.Granero: 10 Javalares, 5 Hierro y 5 Trigo \n2.Laboratorio: 30 Javalares y 10 Hierro\n3.Herrería: 20 Javalares y 20 Hierro\n4.ZonaComun:15 Javalares, 3 Hierro y 3 Trigo\nResponda con el número correspondiente: ");
                    String tipoEdificio = entrada.next();
                    if(tipoEdificio.equals("1")){
                        if(jugador.getJavalares() >= 10 && jugador.getHierro() >= 5 && jugador.getTrigo() >= 5){
                            ArrayList<Persona> personasGranero = new ArrayList<>();
                            Granero granero = new Granero(nombreEdificio, 1, 10, personasGranero);
                            jugador.agregar_edificio(granero);
                            jugador.setJavalares(jugador.getJavalares() - 10);
                            jugador.setHierro(jugador.getHierro() - 5);
                            jugador.setTrigo(jugador.getTrigo() - 5);
                            System.out.println("Se ha creado el Granero " + nombreEdificio + ".\nAhora tenemos " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                        } 
                        else{
                            System.out.println("No se puede comprar el Granero " + nombreEdificio);
                        }
                    } 
                    else if(tipoEdificio.equals("2")){
                        if(jugador.getJavalares() >= 30 && jugador.getHierro() >= 10){
                            ArrayList<Persona> personasLabortorio = new ArrayList<>();
                            Laboratorio laboratorio = new Laboratorio(nombreEdificio, 1, 5, personasLabortorio);
                            jugador.agregar_edificio(laboratorio);
                            jugador.setJavalares(jugador.getJavalares() - 30);
                            jugador.setHierro(jugador.getHierro() - 10);
                            System.out.println("Se ha creado el Laboratorio " + nombreEdificio + ".\nAhora tenemos " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                        } 
                        else{
                            System.out.println("No se puede comprar el Laboratorio " + nombreEdificio);
                        }
                    } 
                    else if(tipoEdificio.equals("3")){
                        if(jugador.getJavalares() >= 20 && jugador.getHierro() >= 20){ 
                            ArrayList<Persona> personasHerreria = new ArrayList<>();
                            Herrería herreria = new Herrería(nombreEdificio, 1, 8, personasHerreria);
                            jugador.agregar_edificio(herreria);
                            jugador.setJavalares(jugador.getJavalares() - 20);
                            jugador.setHierro(jugador.getHierro() - 20);
                            System.out.println("Se ha creado la Herrería " + nombreEdificio + ".\nAhora tenemos " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                        } 
                        else{
                            System.out.println("No se puede comprar el Herrería " + nombreEdificio);
                        }
                    } 
                    else if(tipoEdificio.equals("4")){
                        if(jugador.getJavalares() >= 15 && jugador.getHierro() >= 3 && jugador.getTrigo() >= 3){ 
                            ArrayList<Persona> personasZonaComun = new ArrayList<>();
                            ZonaComun zonacomun = new ZonaComun(nombreEdificio, 1, 6, personasZonaComun);                  
                            jugador.agregar_edificio(zonacomun);
                            jugador.setJavalares(jugador.getJavalares() - 15);
                            jugador.setHierro(jugador.getHierro() - 3);
                            jugador.setTrigo(jugador.getTrigo() - 3);
                            System.out.println("Se ha creado la ZonaComun " + nombreEdificio + ".\nAhora tenemos " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro y " + jugador.getTrigo() + " Trigo.");
                        } 
                        else{
                            System.out.println("No se puede comprar el ZonaComun " + nombreEdificio);
                        }
                    }
                }

                else if(Respuesta.equals("3")){
                    System.out.println("Ingrese el nombre de la Atraccion: ");
                    String nombreAtraccion = entrada.next();
                    System.out.println("Que tipo de Atración es "+ nombreAtraccion + "? \n1.Feria: 50 Javalares, 25 Hierro, 25 Trigo y 10 Tecnología\n2.Museo: 50 Javalares, 30 Hierro, 3 Trigo y 30 Tecnología\n3.Javapato: 50 Javalares, 40 Hierro y 20 Tecnología\nResponda con el número correspondiente: ");
                    String tipoAtraccion = entrada.next();
                    if(tipoAtraccion.equals("1")){
                        if(jugador.getJavalares() >= 50 && jugador.getHierro() >= 25 && jugador.getTrigo() >= 25 && jugador.getTecnologia() >= 10){
                            Feria feria = new Feria(nombreAtraccion);
                            jugador.agregar_feria(feria);
                            jugador.setJavalares(jugador.getJavalares() - 50);
                            jugador.setHierro(jugador.getHierro() - 25);
                            jugador.setTrigo(jugador.getTrigo() - 25);
                            jugador.setTecnologia(jugador.getTecnologia() - 10);
                            System.out.println("Se ha creador la Feria " + nombreAtraccion + ".\nAhora tenemos " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                        } 
                        else{
                            System.out.println("No se puede comprar la Feria " + nombreAtraccion);
                        }
                    } 
                    else if(tipoAtraccion.equals("2")){
                        if(jugador.getJavalares() >= 50 && jugador.getHierro() >= 30 && jugador.getTrigo() >= 3 && jugador.getTecnologia() >= 30){
                            Museo museo = new Museo(nombreAtraccion);
                            jugador.agregar_Museo(museo);
                            jugador.setJavalares(jugador.getJavalares() - 50);
                            jugador.setHierro(jugador.getHierro() - 30);
                            jugador.setTrigo(jugador.getTrigo() - 3);
                            jugador.setTecnologia(jugador.getTecnologia() - 30);
                            System.out.println("Se ha creador el Museo " + nombreAtraccion + ".\nAhora tenemos " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                        } 
                        else{
                            System.out.println("No se puede comprar el Museo " + nombreAtraccion);
                        }
                    } 
                    else if(tipoAtraccion.equals("3")){
                        if(jugador.getJavalares() >= 50 && jugador.getHierro() >= 40 && jugador.getTecnologia() >= 20){
                            Javapato javapato = new Javapato(nombreAtraccion);
                            jugador.agregar_javapato(javapato);
                            jugador.setJavalares(jugador.getJavalares() - 50);
                            jugador.setHierro(jugador.getHierro() - 40);
                            jugador.setTecnologia(jugador.getTecnologia() - 20);
                            System.out.println("Se ha creador el Javapato " + nombreAtraccion + ".\nAhora tenemos " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                        } 
                        else{
                            System.out.println("No se puede comprar el Javapato " + nombreAtraccion);
                        }
                    }
                }

                else if(Respuesta.equals("4")){
                    System.out.println("Mejorar a una persona tiene un costo de 15 Javalares.\n¿Que persona quieres mejorar? ");
                    String nombrePersonaMejora = entrada.next();
                    for(int i = 0; i < jugador.getListPersonas().size(); i++){
                        if(jugador.getListPersonas().get(i).getnombre().equals(nombrePersonaMejora)){
                            if(jugador.getListPersonas().get(i) instanceof Granjero){
                                if(jugador.getJavalares() >= 15){
                                    jugador.getListPersonas().get(i).mejorar();
                                    jugador.setJavalares(jugador.getJavalares() - 15);
                                    System.out.println("Se ha mejorado el/la Grajero/a " + nombrePersonaMejora + ". Ahora su nivel es " + jugador.getListPersonas().get(i).getnivel() + " y su productividad es " + jugador.getListPersonas().get(i).getProductividad() + ".\nQuedan " + jugador.getJavalares() + " Javalares, "  + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                                } 
                                else{
                                    System.out.println("No alcanza para mejorar al/la Granjero/a " + nombrePersonaMejora);
                                }
                            }
                            else if(jugador.getListPersonas().get(i) instanceof Cientifico){
                                if(jugador.getJavalares() >= 15){
                                    jugador.getListPersonas().get(i).mejorar();
                                    jugador.setJavalares(jugador.getJavalares() - 15);
                                    System.out.println("Se ha mejorado el/la Cientifico/a " + nombrePersonaMejora + ". Ahora su nivel es " + jugador.getListPersonas().get(i).getnivel() + " y su productividad es " + jugador.getListPersonas().get(i).getProductividad() + ".\nQuedan " + jugador.getJavalares() + " Javalares, "  + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                                } 
                                else{
                                    System.out.println("No alcanza para mejorar al/la Cientifico/a " + nombrePersonaMejora);
                                }
                            }
                            else if(jugador.getListPersonas().get(i) instanceof Herrero){
                                if(jugador.getJavalares() >= 15){
                                    jugador.getListPersonas().get(i).mejorar();
                                    jugador.setJavalares(jugador.getJavalares() - 15);
                                    System.out.println("Se ha mejorado el/la Herrero/a " + nombrePersonaMejora + ". Ahora su nivel es " + jugador.getListPersonas().get(i).getnivel() + " y su productividad es " + jugador.getListPersonas().get(i).getProductividad() + ".\nQuedan " + jugador.getJavalares() + " Javalares, "  + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                                } 
                                else{
                                    System.out.println("No alcanza para mejorar al/la Herrero/la " + nombrePersonaMejora);
                                }
                            }
                        }
                    }
                    for(int x = 0;  x < jugador.getListEdificios().size(); x++){
                        for(int y = 0; y < jugador.getListEdificios().get(x).getListPersonas().size(); y++){
                            if(jugador.getListEdificios().get(x).getListPersonas().get(y).getnombre().equals(nombrePersonaMejora)){
                                if(jugador.getListEdificios().get(x).getListPersonas().get(y) instanceof Granjero){
                                    if(jugador.getJavalares() >= 15){
                                        jugador.getListEdificios().get(x).getListPersonas().get(y).mejorar();
                                        jugador.setJavalares(jugador.getJavalares() - 15);
                                        System.out.println("Se ha mejorado el/la Granjero/a " + nombrePersonaMejora +". Ahora su nivel es " + jugador.getListEdificios().get(x).getListPersonas().get(y).getnivel() + " y su productividad es " + jugador.getListEdificios().get(x).getListPersonas().get(y).getProductividad() + ".\nQuedan " + jugador.getJavalares() + " Javalares, "  + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                                    }
                                    else{
                                        System.out.println("No alcanza para mejorar al/la Granjero/a " + nombrePersonaMejora);
                                    }
                                }
                                else if(jugador.getListEdificios().get(x).getListPersonas().get(y) instanceof Cientifico){
                                    if(jugador.getJavalares() >= 15){
                                        jugador.getListEdificios().get(x).getListPersonas().get(y).mejorar();
                                        jugador.setJavalares(jugador.getJavalares() - 15);
                                        System.out.println("Se ha mejorado el/la Cientifico/a " + nombrePersonaMejora +". Ahora su nivel es " + jugador.getListEdificios().get(x).getListPersonas().get(y).getnivel() + " y su productividad es " + jugador.getListEdificios().get(x).getListPersonas().get(y).getProductividad() + ".\nQuedan " + jugador.getJavalares() + " Javalares, "  + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                                    }
                                    else{
                                        System.out.println("No alcanza para mejorar al/la Cientifico/a " + nombrePersonaMejora);
                                    }
                                }
                                else if(jugador.getListEdificios().get(x).getListPersonas().get(y) instanceof Herrero){
                                    if(jugador.getJavalares() >= 15){
                                        jugador.getListEdificios().get(x).getListPersonas().get(y).mejorar();
                                        jugador.setJavalares(jugador.getJavalares() - 15);
                                        System.out.println("Se ha mejorado el/la Herrero/a " + nombrePersonaMejora +". Ahora su nivel es " + jugador.getListEdificios().get(x).getListPersonas().get(y).getnivel() + " y su productividad es " + jugador.getListEdificios().get(x).getListPersonas().get(y).getProductividad() + ".\nQuedan " + jugador.getJavalares() + " Javalares, "  + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                                    }
                                    else{
                                        System.out.println("No alcanza para mejorar al/la Herrero/a " + nombrePersonaMejora);
                                    }
                                }
                            }
                        }
                    }
                }

                else if(Respuesta.equals("5")){
                    System.out.println("Costos:\nGranero: 20 Javalares, 10 Hierro y 15 Trigo\nLaboratorio: 20 Javalares, 15 Hierro y 1o Tecnología\nHerrería: 20 Javalares y 20 Hierro\nZonaComun: 15 Javalares, 10 Hierro, 10 Trigo y 10 Tecnología \n¿Que Edificio quieres mejorar? (responde con el nombre del Edificio) ");
                    String nombreEdificioMejora = entrada.next();
                    for(int i = 0; i < jugador.getListEdificios().size(); i++){
                        if(jugador.getListEdificios().get(i).getnombre().equals(nombreEdificioMejora)){
                            if(jugador.getListEdificios().get(i) instanceof Granero){
                                if(jugador.getJavalares() >= 20 && jugador.getHierro() >= 10 && jugador.getTrigo() >= 15){
                                    jugador.getListEdificios().get(i).mejorar();
                                    jugador.setJavalares(jugador.getJavalares() - 20);
                                    jugador.setHierro(jugador.getHierro() - 10);
                                    jugador.setTrigo(jugador.getTrigo() - 15);
                                    System.out.println("Se ha mejorado el Granero " + nombreEdificioMejora + ". Ahora su nivel es " + jugador.getListEdificios().get(i).getnivel() + " y su capacidad es " + jugador.getListEdificios().get(i).getCapcidad() + ".\nQuedan " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                                } 
                                else{
                                    System.out.println("No alcanza para mejorar el Granero " + nombreEdificioMejora);
                                }
                            }
                            else if(jugador.getListEdificios().get(i) instanceof Laboratorio){
                                if(jugador.getJavalares() >= 20 && jugador.getHierro() >= 15){
                                    jugador.getListEdificios().get(i).mejorar();
                                    jugador.setJavalares(jugador.getJavalares() - 20);
                                    jugador.setHierro(jugador.getHierro() - 15);
                                    System.out.println("Se ha mejorado el Laboratorio " + nombreEdificioMejora + ". Ahora su nivel es " + jugador.getListEdificios().get(i).getnivel() + " y su capacidad es " + jugador.getListEdificios().get(i).getCapcidad() + ".\nQuedan " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                                } 
                                else{
                                    System.out.println("No alcanza para mejorar el Laboratorio " + nombreEdificioMejora);
                                }
                            }
                            else if(jugador.getListEdificios().get(i) instanceof Herrería){
                                if(jugador.getJavalares() >= 20 && jugador.getHierro() >= 20){
                                    jugador.getListEdificios().get(i).mejorar();
                                    jugador.setJavalares(jugador.getJavalares() - 20);
                                    jugador.setHierro(jugador.getHierro() - 20);
                                    System.out.println("Se ha mejorado el Herrería " + nombreEdificioMejora + ". Ahora su nivel es " + jugador.getListEdificios().get(i).getnivel() + " y su capacidad es " + jugador.getListEdificios().get(i).getCapcidad() + ".\nQuedan " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                                } 
                                else{
                                    System.out.println("No alcanza para mejorar la Herrería " + nombreEdificioMejora);
                                }
                            }
                            else if(jugador.getListEdificios().get(i) instanceof ZonaComun){
                                if(jugador.getJavalares() >= 15 && jugador.getHierro() >= 10 && jugador.getTrigo() >= 10 && jugador.getTecnologia() >= 10){
                                    jugador.getListEdificios().get(i).mejorar();
                                    jugador.setJavalares(jugador.getJavalares() - 15);
                                    jugador.setHierro(jugador.getHierro() - 10);
                                    jugador.setTrigo(jugador.getTrigo() - 10);
                                    jugador.setTecnologia(jugador.getTecnologia() - 10);
                                    System.out.println("Se ha mejorado el ZonaComun " + nombreEdificioMejora + ". Ahora su nivel es " + jugador.getListEdificios().get(i).getnivel() + " y su capacidad es " + jugador.getListEdificios().get(i).getCapcidad() + ".\nQuedan " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
                                    
                                } 
                                else{
                                    System.out.println("No alcanza para mejorar la ZonaComun " + nombreEdificioMejora);
                                }
                            }
                        }
                    }

                }
                
                //me parece que fue innecesario poner lo if con instanceof ya que sin ellos es lo mismo.
                else if(Respuesta.equals("6")){
                    System.out.println("¿Qué Persona quieres mover? ");
                    String moverPersona = entrada.next();
                    System.out.println(("¿A que Edificio lo quieres mover? "));
                    String moverAEdificio = entrada.next();
                    for(int j = 0; j < jugador.getListEdificios().size(); j++){
                        if(jugador.getListEdificios().get(j).getnombre().equals(moverAEdificio)){
                            for(int i = 0; i < jugador.getListPersonas().size();i++){
                                if(jugador.getListPersonas().get(i).getnombre().equals(moverPersona)){
                                    if(jugador.getListEdificios().get(j).getListPersonas().size() <= jugador.getListEdificios().get(j).getCapcidad() ){
                                        if(jugador.getListEdificios().get(j) instanceof Granero){
                                            if(jugador.getListPersonas().get(i) instanceof Granjero){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Granjero/a " + moverPersona + " se movio al Granero " + moverAEdificio + ".");
                                            }
                                            else if(jugador.getListPersonas().get(i) instanceof Cientifico){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Cientifico/a " + moverPersona + " se movio al Granero " + moverAEdificio + ".");
                                            }
                                            else if(jugador.getListPersonas().get(i) instanceof Herrero){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Herrero/a " + moverPersona + " se movio al Granero " + moverAEdificio + ".");
                                            }
                                        }
                                        else if(jugador.getListEdificios().get(j) instanceof Laboratorio){
                                            if(jugador.getListPersonas().get(i) instanceof Granjero){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Granjero/a " + moverPersona + " se movio al Laboratorio " + moverAEdificio + ".");
                                            }
                                            else if(jugador.getListPersonas().get(i) instanceof Cientifico){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Cientifico/a " + moverPersona + " se movio al Laboratorio " + moverAEdificio + ".");
                                            }
                                            else if(jugador.getListPersonas().get(i) instanceof Herrero){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Herrero/a " + moverPersona + " se movio al Laboratorio " + moverAEdificio + "+");
                                            }
                                        }
                                        else if(jugador.getListEdificios().get(j) instanceof Herrería){
                                            if(jugador.getListPersonas().get(i) instanceof Granjero){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Granjero/a " + moverPersona + " se movio a la Herrería " + moverAEdificio + ".");
                                            }
                                            else if(jugador.getListPersonas().get(i) instanceof Cientifico){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Cientifico/a " + moverPersona + " se movio a la Herrería " + moverAEdificio + ".");
                                            }
                                            else if(jugador.getListPersonas().get(i) instanceof Herrero){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Herrero/a " + moverPersona + " se movio a la Herrería " + moverAEdificio + ".");
                                            }
                                        }
                                        else if(jugador.getListEdificios().get(j) instanceof ZonaComun){
                                            if(jugador.getListPersonas().get(i) instanceof Granjero){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Granjero/a " + moverPersona + " se movio a la ZonaComun " + moverAEdificio + ".");
                                            }
                                            else if(jugador.getListPersonas().get(i) instanceof Cientifico){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Cientifico/a " + moverPersona + " se movio a la ZonaComun " + moverAEdificio + ".");
                                            }
                                            else if(jugador.getListPersonas().get(i) instanceof Herrero){
                                                jugador.getListEdificios().get(j).agregar_persona(jugador.getListPersonas().get(i));
                                                System.out.println("El/La Herrero/a " + moverPersona + " se movio a la ZonaComun " + moverAEdificio + ".");
                                            }
                                        }
                                        jugador.sacar_persona(moverPersona);
                                    }
                                    else{
                                        System.out.println("No entran más personas en este Edificio. ");
                                    }
                                }
                            }
                        }
                    }
                }
                else if(Respuesta.equals("7")){
                    System.out.println("¿Que persona quieres sacar? ");
                    String SacarPersona = entrada.next();
                    System.out.println("¿De que Edificio lo quieres sacar? ");
                    String sacardeEdificio = entrada.next();
                    for(int j = 0; j < jugador.getListEdificios().size(); j++){
                        if(jugador.getListEdificios().get(j).getnombre().equals(sacardeEdificio)){
                            for(int i = 0; i < jugador.getListEdificios().get(j).getListPersonas().size(); i++){
                                if(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre().equals(SacarPersona)){
                                    jugador.agregar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i));
                                    if(jugador.getListEdificios().get(j) instanceof Granero){
                                        if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Granjero){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Granjero/a " + SacarPersona + " a salido del Granero " + sacardeEdificio + ".");
                                        }
                                        else if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Cientifico){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Cientifico/a " + SacarPersona + " a salido del Granero " + sacardeEdificio + ".");
                                        }
                                        else if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Herrero){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Herrero/a " + SacarPersona + " a salido del Granero " + sacardeEdificio + ".");
                                        }
                                    }
                                    if(jugador.getListEdificios().get(j) instanceof Laboratorio){
                                        if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Granjero){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Granjero/a " + SacarPersona + " a salido del Laboratorio " + sacardeEdificio + ".");
                                        }
                                        else if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Cientifico){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Cientifico/a " + SacarPersona + " a salido del Laboratorio " + sacardeEdificio + ".");
                                        }
                                        else if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Herrero){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Herrero/a " + SacarPersona + " a salido del Laboratorio " + sacardeEdificio + ".");
                                        }
                                    }
                                    if(jugador.getListEdificios().get(j) instanceof Herrería){
                                        if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Granjero){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Granjero/a " + SacarPersona + " a salido del Herrería " + sacardeEdificio + ".");
                                        }
                                        else if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Cientifico){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Cientifico/a " + SacarPersona + " a salido del Herrería " + sacardeEdificio + ".");
                                        }
                                        else if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Herrero){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Herrero/a " + SacarPersona + " a salido del Herrería " + sacardeEdificio + ".");
                                        }
                                    }
                                    if(jugador.getListEdificios().get(j) instanceof ZonaComun){
                                        if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Granjero){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Granjero/a " + SacarPersona + " a salido del ZonaComun " + sacardeEdificio + ".");
                                        }
                                        else if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Cientifico){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Cientifico/a " + SacarPersona + " a salido del ZonaComun " + sacardeEdificio + ".");
                                        }
                                        else if(jugador.getListEdificios().get(j).getListPersonas().get(i) instanceof Herrero){
                                            jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(i).getnombre());
                                            System.out.println("El/La Herrero/a " + SacarPersona + " a salido del ZonaComun " + sacardeEdificio + ".");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else if(Respuesta.equals("8")){
                    jugador.mostrarNombrePersonas();
                }
                else if(Respuesta.equals("9")){
                    jugador.mostrarNombreEdificios();
                }
                else if(Respuesta.equals("10")){
                    jugador.mostrarNombreAtraccion();
                }

                else if(Respuesta.equals("11")){
                    System.out.print("Finalización del juego.\n");
                    System.exit(0);
                }
                else{
                    System.out.println("No se encuentra esta opcion, intentalo de nuevo.");
                }

                System.out.println("¿Quieres terminar el turno? (Si quiere terminar el turno, responda SI): ");
                String RespuestaTurno = entrada.next();
                if(RespuestaTurno.equals("SI")){
                    turno = false;
                }
            }

            //post turno

            for(int i = 0; i < jugador.getListEdificios().size(); i++){
                if(jugador.getListEdificios().get(i) instanceof Granero){
                    if(jugador.getListEdificios().get(i).getListPersonas().size() != 0){
                        jugador.setJavalares(jugador.getJavalares() + jugador.getListEdificios().get(i).producir().get(0));
                        jugador.setHierro(jugador.getHierro() + jugador.getListEdificios().get(i).producir().get(1));
                        jugador.setTrigo(jugador.getTrigo() + jugador.getListEdificios().get(i).producir().get(2));
                        jugador.setTecnologia(jugador.getTecnologia() + jugador.getListEdificios().get(i).producir().get(3));
                        System.out.println("El Granero "+jugador.getListEdificios().get(i).getnombre() + " produjo " + jugador.getListEdificios().get(i).producir().get(0) + " Javalares, " + jugador.getListEdificios().get(i).producir().get(1) + " Hierro, " + jugador.getListEdificios().get(i).producir().get(2) + " Trigo, " + jugador.getListEdificios().get(i).producir().get(3) + " Tecnología.");
                    }
                }
                else if(jugador.getListEdificios().get(i) instanceof Laboratorio){
                    if(jugador.getListEdificios().get(i).getListPersonas().size() != 0){
                        jugador.setJavalares(jugador.getJavalares() + jugador.getListEdificios().get(i).producir().get(0));
                        jugador.setHierro(jugador.getHierro() + jugador.getListEdificios().get(i).producir().get(1));
                        jugador.setTrigo(jugador.getTrigo() + jugador.getListEdificios().get(i).producir().get(2));
                        jugador.setTecnologia(jugador.getTecnologia() + jugador.getListEdificios().get(i).producir().get(3));
                        System.out.println("El Laboratorio " + jugador.getListEdificios().get(i).getnombre() + " produjo " + jugador.getListEdificios().get(i).producir().get(0) + " Javalares, " + jugador.getListEdificios().get(i).producir().get(1) + " Hierro, " + jugador.getListEdificios().get(i).producir().get(2) + " Trigo, " + jugador.getListEdificios().get(i).producir().get(3) + " Tecnología.");
                    }
                }
                else if(jugador.getListEdificios().get(i) instanceof Herrería){
                    if(jugador.getListEdificios().get(i).getListPersonas().size() != 0){
                        jugador.setJavalares(jugador.getJavalares() + jugador.getListEdificios().get(i).producir().get(0));
                        jugador.setHierro(jugador.getHierro() + jugador.getListEdificios().get(i).producir().get(1));
                        jugador.setTrigo(jugador.getTrigo() + jugador.getListEdificios().get(i).producir().get(2));
                        jugador.setTecnologia(jugador.getTecnologia() + jugador.getListEdificios().get(i).producir().get(3));
                        System.out.println("La Herrería " + jugador.getListEdificios().get(i).getnombre() + " produjo " + jugador.getListEdificios().get(i).producir().get(0) + " Javalares, " + jugador.getListEdificios().get(i).producir().get(1) + " Hierro, " + jugador.getListEdificios().get(i).producir().get(2) + " Trigo, " + jugador.getListEdificios().get(i).producir().get(3) + " Tecnología.");
                    }
                }
                else if(jugador.getListEdificios().get(i) instanceof ZonaComun){
                    if(jugador.getListEdificios().get(i).getListPersonas().size() != 0){
                        jugador.setJavalares(jugador.getJavalares() + jugador.getListEdificios().get(i).producir().get(0));
                        jugador.setHierro(jugador.getHierro() + jugador.getListEdificios().get(i).producir().get(1));
                        jugador.setTrigo(jugador.getTrigo() + jugador.getListEdificios().get(i).producir().get(2));
                        jugador.setTecnologia(jugador.getTecnologia() + jugador.getListEdificios().get(i).producir().get(3));
                        System.out.println("La ZonaComun " + jugador.getListEdificios().get(i).getnombre() + " produjo " + jugador.getListEdificios().get(i).producir().get(0) + " Javalares, " + jugador.getListEdificios().get(i).producir().get(1) + " Hierro, " + jugador.getListEdificios().get(i).producir().get(2) + " Trigo, " + jugador.getListEdificios().get(i).producir().get(3) + " Tecnología.");
                    }
                }
            }

            for(int j = 0; j < jugador.getListFerias().size(); j++){
                int money = 0;
                for(int i = 0; i < jugador.getListEdificios().size(); i++){
                    jugador.setJavalares(jugador.getJavalares() + jugador.getListFerias().get(j).visitar(jugador.getListEdificios().get(i).getListPersonas()));
                    money = money + jugador.getListFerias().get(j).visitar(jugador.getListEdificios().get(i).getListPersonas());
                }
                jugador.setJavalares(jugador.getJavalares() + jugador.getListFerias().get(j).visitar(jugador.getListPersonas()));
                money = money + jugador.getListFerias().get(j).visitar(jugador.getListPersonas());
                System.out.println("La Feria " + jugador.getListFerias().get(j).getnombre() + " gano " + money + " Javalares.");
            }
            
            for(int j = 0; j < jugador.getListMuseos().size(); j++){
                int money = 0;
                for(int i = 0; i < jugador.getListEdificios().size(); i++){
                    jugador.setJavalares(jugador.getJavalares() + jugador.getListMuseos().get(j).visitar(jugador.getListEdificios().get(i).getListPersonas()));
                    money = money + jugador.getListMuseos().get(j).visitar(jugador.getListEdificios().get(i).getListPersonas());
                }
                jugador.setJavalares(jugador.getJavalares() + jugador.getListMuseos().get(j).visitar(jugador.getListPersonas()));
                money = money + jugador.getListMuseos().get(j).visitar(jugador.getListPersonas());
                System.out.println("El Museo " + jugador.getListMuseos().get(j).getnombre() + " gano " + money + " Javalares.");
            }
            for(int j = 0; j < jugador.getListJavapatos().size(); j++){
                int money = 0;
                for(int i = 0; i < jugador.getListEdificios().size(); i++){
                    jugador.setJavalares(jugador.getJavalares() + jugador.getListJavapatos().get(j).visitar(jugador.getListEdificios().get(i).getListPersonas()));
                    money = money + jugador.getListJavapatos().get(j).visitar(jugador.getListEdificios().get(i).getListPersonas());
                }
                jugador.setJavalares(jugador.getJavalares() + jugador.getListJavapatos().get(j).visitar(jugador.getListPersonas()));
                money = money + jugador.getListJavapatos().get(j).visitar(jugador.getListPersonas());
                System.out.println("El Javapato " + jugador.getListJavapatos().get(j).getnombre() + " gano " + money + " Javalares.");
            }

            for(int i = 0; i < jugador.getListPersonas().size(); i++){
                if(jugador.getListPersonas().get(i).getEdad() < 29){
                    jugador.getListPersonas().get(i).envejecer();
                    System.out.println(jugador.getListPersonas().get(i).getnombre() + " cumplio " + jugador.getListPersonas().get(i).getEdad() + " años.");
                }
                else{
                    System.out.println(jugador.getListPersonas().get(i).getnombre() + " falleció.");
                    personasFallecidas.add(jugador.getListPersonas().get(i).getnombre());
                    jugador.sacar_persona(jugador.getListPersonas().get(i).getnombre()); 
                }
            }
            for(int j = 0; j < jugador.getListEdificios().size(); j++){
                for(int x = 0; x < jugador.getListEdificios().get(j).getListPersonas().size(); x++){
                    if(jugador.getListEdificios().get(j).getListPersonas().get(x).getEdad() < 29){
                        jugador.getListEdificios().get(j).getListPersonas().get(x).envejecer();
                        System.out.println(jugador.getListEdificios().get(j).getListPersonas().get(x).getnombre() + " cumplio " + jugador.getListEdificios().get(j).getListPersonas().get(x).getEdad() + " años.");
                    }
                    else{
                        System.out.println(jugador.getListEdificios().get(j).getListPersonas().get(x).getnombre() + " falleció.");
                        personasFallecidas.add(jugador.getListEdificios().get(j).getListPersonas().get(x).getnombre());
                        jugador.getListEdificios().get(j).sacar_persona(jugador.getListEdificios().get(j).getListPersonas().get(x).getnombre());
                    }
                }
            }

            if(personasFallecidas.size() != 0){
                System.out.println("Personas fallecillas: ");
                for(int i = 0; i < personasFallecidas.size(); i++){
                    System.out.println(personasFallecidas.get(i));
                }
            }
            System.out.println("Quedaron " + jugador.getJavalares() + " Javalares, " + jugador.getHierro() + " Hierro, " + jugador.getTrigo() + " Trigo y " + jugador.getTecnologia() + " Tecnología.");
        }
        System.out.println("Finalización del juego.");
        entrada.close();   
    }
}