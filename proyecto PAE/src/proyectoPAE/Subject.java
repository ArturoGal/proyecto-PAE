
package proyectoPAE;

import java.io.Serializable;

public class Subject  implements Serializable {
  
	private static final long serialVersionUID = 1L;
    private String name, description;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Subject(String name, String description) {
        this.description = description;
        this.name = name;
    }
}