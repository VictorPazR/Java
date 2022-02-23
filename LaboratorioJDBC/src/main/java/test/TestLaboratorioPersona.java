
package test;

import datos.*;
import domain.Persona;
import java.util.List;


public class TestLaboratorioPersona {
    public static void main(String[] args) {
        PersonaDAO persona1 = new PersonaDAO();
        //persona1.seleccionar();
        //Persona personaNueva= new Persona("Manolo", "Manolito123");
        //persona1.insertar(personaNueva);
        //Persona personaNueva = new Persona(5, "Oscar", "Oscar123");
        //persona1.actualizar(personaNueva);
        Persona personaNueva = new Persona(5);
        persona1.eliminar(personaNueva);
        
        
        List<Persona> personas = persona1.seleccionar();
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
    
    
}
