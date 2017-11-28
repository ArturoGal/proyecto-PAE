
package proyectoPAE;

import java.util.*;
import java.io.*;

public class FlashCardManager {
	private ArrayList<FlashCard> flashcards;
//Nombre del archivo de FlashCards
    private static final String FlashCard_FILE = "files//FlashCards.dat";
//Entrada y salida de datos
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public FlashCardManager() {
        flashcards = new ArrayList<>();
    }
//Inicia la carga y el ordenamiento de datos
    public ArrayList<FlashCard> getFlashCards() {
        loadFlashCardFile();
        return flashcards;
    }
    
    public ArrayList<String> getFlashCardTitles() {
        loadFlashCardFile();
        ArrayList<String> titles = new ArrayList<String>();
        for(FlashCard s : flashcards){
        	titles.add(s.getTitle());
        }
        return titles;
    }
    
    public void deleteFlashCard(String title){
    	loadFlashCardFile();
    	flashcards.removeIf(fc ->  fc.getTitle().equals(title));
    	updateFlashCardFile();
    }


//Agrega un nuevo FlashCard
    public void addFlashCard(String title, String info, String subject) {
        loadFlashCardFile();
        flashcards.add(new FlashCard(title, info, subject));
        
        updateFlashCardFile();
    }
//Carga el archivo 
    @SuppressWarnings("unchecked")
	public void loadFlashCardFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(FlashCard_FILE));
            flashcards = (ArrayList<FlashCard>) inputStream.readObject();
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
//Escribe el archivo de FlashCard con nuevos valores 
    public void updateFlashCardFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(FlashCard_FILE));
            outputStream.writeObject(flashcards);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] Error: " + e.getMessage() + ", the program will try and make a new file");
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

