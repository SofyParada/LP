package Tareas.Tarea3.src.Tarea3;

import java.util.ArrayList;

public class ZonaComun extends Edificio{
    public ZonaComun(String nombre, int nivel, int capacidad, ArrayList<Persona> personas){
        super(nombre, nivel, capacidad, personas);
    }

    int capacidad = getCapcidad();
    int nivel = getnivel();

    public void mejorar(){
        setnivel(getnivel() + 1);
        setCapacidad(getCapcidad() + 4);
    }

    public ArrayList<Integer> producir(){
        ArrayList<Integer> producir = new ArrayList<Integer>(4);
        int javalares = getListPersonas().size();
        int trigo = 0;
        int tecnologia = 0;
        int hierro = 0;

        producir.add(0, javalares);
        producir.add(1, hierro);
        producir.add(2, trigo);
        producir.add(3, tecnologia);

        return producir;
    }

    
}