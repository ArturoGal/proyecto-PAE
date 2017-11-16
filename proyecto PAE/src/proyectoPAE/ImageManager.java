package proyectoPAE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ImageManager {
	private ArrayList<Image> images;
	//Nombre del archivo de images
	    private static final String Image_FILE = "files//Images.dat";
	//Entrada y salida de datos
	    ObjectOutputStream outputStream = null;
	    ObjectInputStream inputStream = null;

	    public ImageManager() {
	        images = new ArrayList<>();
	    }

	    public ArrayList<Image> getImages() {
	        loadImageFile();
	        return images;
	    }
	    
	    public ArrayList<String> getImageTitles() {
	        loadImageFile();
	        ArrayList<String> names = new ArrayList<String>();
	        for(Image s : images){
	        	names.add(s.getTitle());
	        }
	        return names;
	    }
	    
	    public void deleteImage(String name){
	    	loadImageFile();
	    	images.removeIf(i ->  i.getTitle().equals(name));
	    	updateImageFile();
	    }

	//Agrega un nuevo Image
	    public void addImage(String name, String description, String subject, String path) {
	        loadImageFile();
	        images.add(new Image(name, description, subject, path));
	        updateImageFile();
	    }
	//Carga el archivo 
	    @SuppressWarnings("unchecked")
		public void loadImageFile() {
	        try {
	            inputStream = new ObjectInputStream(new FileInputStream(Image_FILE));
	            images = (ArrayList<Image>) inputStream.readObject();
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
	//Escribe el archivo de Image con nuevos valores 
	    public void updateImageFile() {
	        try {
	            outputStream = new ObjectOutputStream(new FileOutputStream(Image_FILE));
	            outputStream.writeObject(images);
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

