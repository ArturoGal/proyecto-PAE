package proyectoPAE;

import java.io.Serializable;

public class FlashCard implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title, info;
    private Subject subject;

    public String getDescription() {
        return info;
    }

    public String getName() {
        return title;
    }
    
    public Subject getSubject() {
    	return subject;
    }

    public FlashCard(String title, String info, Subject subject) {
        this.info = info;
        this.title = title;
        this.subject = subject;
    }
}
