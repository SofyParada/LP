package Tarea3;

import java.util.ArrayList;

public class Laboratorio extends Edificio{

    public Laboratorio(String nombre, int nivel, int capacidad, ArrayList<Persona> personas){
        super(nombre, nivel, capacidad, personas);
    }
    int capacidad = getCapcidad();
    int nivel = getnivel();

    public void mejorar(){
        setnivel(getnivel() + 1);
        setCapacidad(getCapcidad() + 2);
    }

    public ArrayList<Integer> producir(){
        ArrayList<Integer> producir = new ArrayList<Integer>(4);
        int javalares = 0;
        int trigo = 0;
        int tecnologia = 0;
        int hierro = 0;
        int cientificos = 0;
        int noCientificas = 0;
        for(int j = 0; j < getListPersonas().size(); j++ ){
            if(getListPersonas().get(j) instanceof Cientifico){
                cientificos++;
            }
            else{
                noCientificas++;
            }
        }
        if(cientificos > (int)Math.floor((3*getListPersonas().size())/4)){
            for(int i = 0; i < getListPersonas().size(); i++){
                javalares = javalares + es_cientifico(getListPersonas().get(i))* getListPersonas().get(i).trabajo_realizado();
                tecnologia = tecnologia + es_cientifico(getListPersonas().get(i))* getListPersonas().get(i).trabajo_realizado();
            }
            javalares = (int)Math.floor((javalares*noCientificas)/ getListPersonas().size());
        }
        else{
            javalares = javalares + getListPersonas().size()*-4;
        }

        producir.add(0, javalares);
        producir.add(1, hierro);
        producir.add(2, trigo);
        producir.add(3, tecnologia);

        return producir;

    }

    
}