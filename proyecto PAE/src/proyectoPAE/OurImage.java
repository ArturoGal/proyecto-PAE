package proyectoPAE;

import java.io.Serializable;


public class OurImage implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title, desc, subjectName, url;

    public String getDescription() {
        return desc;
    }

    public String getTitle() {
        return title;
    }
    
    public String getSubject() {
    	return subjectName;
    }
    
    public String getURL(){
    	return url;
    }
    
    public OurImage(String title, String desc, String subject, String url) {
        this.desc = desc;
        this.title = title;
        this.subjectName = subject;
        this.url = url;
    }
}

