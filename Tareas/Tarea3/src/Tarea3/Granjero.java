package Tarea3;

public class Granjero extends Persona{
    public Granjero(String nombre, int edad, int nivel, int productividad){
        super(nombre, edad, nivel, productividad);
    }


    public void mejorar(){
        setNivel(getnivel() + 1);
        setProductividad(getProductividad() + 2);
            
    }

    public int trabajo_realizado(){
        return (getProductividad()*2)+(int)Math.floorDiv(getnivel(), 2);
    }
    
}