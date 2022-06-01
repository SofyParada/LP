Sofía Parada
202004671-9

JFLAGS = -g
JC =javac
.SUFFIXES:.java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Javation.java\
	Jugador.java\
	Persona.java\
	Granjero.java\
	Herrero.java\
	Cientifico.java\
	Edificio.java\
	Granero.java\
	Laboratorio.java\
	Herrería.java\
	ZonaComun.java\
	Atraccion.java\
	Feria.java\
	Museo.java\
	Javapato.java

MAIN =Javation

default:CLASSES

classes:$(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

clean:\
	$(RM) *.class