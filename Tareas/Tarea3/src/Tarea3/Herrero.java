package Tarea3;

public class Herrero extends Persona{
    public Herrero(String nombre, int edad, int nivel, int productividad){
        super(nombre, edad, nivel, productividad);
    }
    
    public  void mejorar(){
        setNivel(getnivel() + 1);
        setProductividad(getProductividad() + 3);
    }

    public int trabajo_realizado(){
        return getProductividad()+(getnivel()*2);
    }
    
}
