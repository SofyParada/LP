package Tareas.Tarea3.src.Tarea3;

import java.util.ArrayList;

public  class Granero  extends Edificio{
    public Granero(String nombre, int nivel, int capacidad, ArrayList<Persona> personas){
        super(nombre, nivel, capacidad, personas);
    }

    public void mejorar(){
        setnivel(getnivel() + 1);
        setCapacidad(getCapcidad() + 3);
           
    }

    

    public ArrayList<Integer> producir(){
        ArrayList<Integer> producir = new ArrayList<Integer>(4);
        int javalares = 0;
        int trigo = 0;
        int tecnologia = 0;
        int hierro = 0;
        int granjeros = 0;
        int cientificos =  0;
        for(int j = 0; j <= getListPersonas().size() - 1; j++ ){
            if(getListPersonas().get(j) instanceof Granjero){
                granjeros++;
            }
            if(getListPersonas().get(j) instanceof Cientifico){
                cientificos++;
            }
        }
        if(granjeros > getListPersonas().size()/2){
            for(int i = 0; i <= getListPersonas().size() - 1; i++){
                javalares = javalares + getListPersonas().get(i).trabajo_realizado();
                trigo = trigo + getListPersonas().get(i).trabajo_realizado();
            }
            javalares = javalares / getListPersonas().size();
            trigo = (trigo*2)/getListPersonas().size();
            
            if(cientificos != 0){
                for(int j = 0; j < cientificos/2; j++){
                    tecnologia = tecnologia + 1;
                }
            }
        }

        else{
            javalares = getListPersonas().size()*-2;
        }


        producir.add(0, javalares);
        producir.add(1, hierro);
        producir.add(2, trigo);
        producir.add(3, tecnologia);

        return producir;
    }

}