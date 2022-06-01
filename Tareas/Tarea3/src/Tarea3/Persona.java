package Tareas.Tarea3.src.Tarea3;

public abstract class Persona{
    private String nombre;
    private int edad;
    private int nivel;
    private int productividad;

    public Persona(String nombre, int edad, int nivel, int productividad){
        this.nombre = nombre;
        this.edad = edad;
        this.nivel = nivel;
        this.productividad = productividad;
    }

    /*
     *Nombre de función: envejecer
     *Parametros: no tiene parametros
     * Descripción: Tiene la función de aumentar un año más a una persona
    */
    public void envejecer(){
        edad++;
    }

    /*
     *Nombre de función: mejorar
     *Parametros: No tiene parametros
     * Descripción: Tiene la función de subir de nivel de nivel a la persona y de mejorar su productividad.
    */
    public abstract void mejorar();

    /*
     *Nombre de función: trabajo_realizado
     *Parametros: No tiene parametros
     * Descripción: Lo que hace esta función retornar un numero entero segun su productividad y nivel.
    */
    public abstract int trabajo_realizado();

    //setters y getters de los atributos de la clase.
    public void setnombre(String nombre){
        this.nombre = nombre;
    }
    public String getnombre(){
        return this.nombre;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }
    public int getEdad(){
        return this.edad;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    public int getnivel(){
        return this.nivel;
    }

    public void setProductividad(int productividad){
        this.productividad = productividad;
    }
    public int getProductividad(){
        return this.productividad;
    }
    
    

}