package Tareas.Tarea3.src.Tarea3;

public class Herrero extends Persona{
    public Herrero(String nombre, int edad, int nivel, int productividad){
        super(nombre, edad, nivel, productividad);
    }
    
    public  void mejorar(){
        setnombre(getnombre() + 1);
        setProductividad(getProductividad() + 3);
    }

    public int trabajo_realizado(){
        return getProductividad()+(getnivel()*2);
    }
    
}
