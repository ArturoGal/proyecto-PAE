package proyectoPAE;

import java.io.Serializable;

public class Image implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title, desc, subjectName, path;

    public String getDescription() {
        return desc;
    }

    public String getTitle() {
        return title;
    }
    
    public String getSubject() {
    	return subjectName;
    }
    
    public String getPath(){
    	return path;
    }
    
    
    public Image(String title, String desc, String subject, String path) {
        this.desc = desc;
        this.title = title;
        this.subjectName = subject;
        this.path = path;
    }
}

