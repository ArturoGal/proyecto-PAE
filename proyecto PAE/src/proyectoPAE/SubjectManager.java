
package proyectoPAE;

import java.util.*;
import java.io.*;

public class SubjectManager {
	private ArrayList<Subject> Subjects;
//Nombre del archivo de Subject
    private static final String Subject_FILE = "files//Subjects.dat";
//Entrada y salida de datos
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public SubjectManager() {
        Subjects = new ArrayList<>();
    }
//Inicia la carga y el ordenamiento de datos
    public ArrayList<Subject> getSubjects() {
        loadSubjectFile();
        return Subjects;
    }
    
    public ArrayList<String> getSubjectNames() {
        loadSubjectFile();
        ArrayList<String> names = new ArrayList<String>();
        for(Subject s : Subjects){
        	names.add(s.getName());
        }
        return names;
    }

//Agrega un nuevo Subject
    public void addSubject(String name, String description) {
        loadSubjectFile();
        Subjects.add(new Subject(name, description));
        updateSubjectFile();
    }
//Carga el archivo 
    @SuppressWarnings("unchecked")
	public void loadSubjectFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(Subject_FILE));
            Subjects = (ArrayList<Subject>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[ File n f Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[ IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
            }
        }

    }
//Escribe el archivo de Subject con nuevos valores 
    public void updateSubjectFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(Subject_FILE));
            outputStream.writeObject(Subjects);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }

     
}
