package Tareas.Tarea3.src.Tarea3;

import java.util.ArrayList;

public class Javapato implements Atraccion{
    private String nombre;
    
    public Javapato(String nombre){
        this.nombre = nombre;
    }

    public void setnombre(String nombre){
        this.nombre = nombre;
    }
    public String getnombre(){
        return this.nombre;
    }

    @Override
    public int visitar(ArrayList<Persona> personas) {
        int cantidad_de_personas_granjeras = 0;
        int cantidad_de_personas_cientificas = 0;
        int cantidad_de_personas_herreras = 0;

        for(int i = 0; i < personas.size(); i++){
            if(personas.get(i).getnombre() == "Granjero"){
                cantidad_de_personas_granjeras++;
            }
            if(personas.get(i).getnombre() == "Cienfico"){
                cantidad_de_personas_cientificas++;
            }
            if(personas.get(i).getnombre() == "Herrero"){
                cantidad_de_personas_herreras++;
            } 
        }
        int javalares = ((6*cantidad_de_personas_granjeras)/2) + 6 * (int)Math.floorDiv(cantidad_de_personas_cientificas,4)  + ((6*cantidad_de_personas_herreras)/2);
        return javalares;
    }
}