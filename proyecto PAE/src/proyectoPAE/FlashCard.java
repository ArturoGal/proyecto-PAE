package proyectoPAE;

import java.io.Serializable;

public class FlashCard implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title, info, subjectName;

    public String getContent() {
        return info;
    }

    public String getTitle() {
        return title;
    }
    
    public String getSubject() {
    	return subjectName;
    }

    public FlashCard(String title, String info, String subject) {
        this.info = info;
        this.title = title;
        this.subjectName = subject;
    }
}
