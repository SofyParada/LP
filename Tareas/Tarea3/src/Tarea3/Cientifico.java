package Tarea3;

public class Cientifico extends Persona{
    public Cientifico(String nombre, int edad, int nivel, int productividad){
        super(nombre, edad, nivel, productividad);
    }


    public void mejorar(){
        setNivel(getnivel() + 1);
        setProductividad(getProductividad() + 1);

    }

    public int trabajo_realizado(){
        return (getProductividad()*3) + getnivel();

    }
    
}