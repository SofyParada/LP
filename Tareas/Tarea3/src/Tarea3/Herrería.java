package Tarea3;


import java.util.ArrayList;

public class Herrería extends Edificio{
    public Herrería(String nombre, int nivel, int capacidad, ArrayList<Persona> personas){
        super(nombre, nivel, capacidad, personas);
    }

    public void mejorar(){
        setnivel(getnivel() + 1);
        setCapacidad(getCapcidad() + 4);
    }

    public ArrayList<Integer> producir(){
        ArrayList<Integer> producir = new ArrayList<Integer>(4);
        int javalares = 0;
        int trigo = 0;
        int tecnologia = 0;
        int hierro = 0;
        int cientificos = 0;
        int noHerreros = 0;
        for(int j = 0; j < getListPersonas().size(); j++){
            if(!(getListPersonas().get(j) instanceof Herrero)){
                noHerreros++;
            }
            if(getListPersonas().get(j) instanceof Cientifico){
                cientificos++;
            }
        }

        for(int i = 0; i < getListPersonas().size(); i++){
            javalares = javalares + es_herrero(getListPersonas().get(i))*getListPersonas().get(i).trabajo_realizado();
            hierro = hierro + es_herrero(getListPersonas().get(i))*getListPersonas().get(i).trabajo_realizado();
            tecnologia = tecnologia + es_cientifico(getListPersonas().get(i))*getListPersonas().get(i).trabajo_realizado()*(1/3);
        }
        javalares = (int)Math.floorDiv(javalares, getListPersonas().size());
        if(noHerreros != 0){
            hierro = (int)Math.floorDiv(hierro, noHerreros);
        }
        else{
            hierro = 0;
        }
        if(cientificos != 0){
            tecnologia = (int)Math.floorDiv(tecnologia, cientificos);
        }
        else{
            tecnologia = 0;
        }
        producir.add(0, javalares);
        producir.add(1, hierro);
        producir.add(2, trigo);
        producir.add(3, tecnologia);

        return producir;

    }

    
}