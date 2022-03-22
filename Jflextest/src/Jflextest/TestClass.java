package Jflextest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;  
import java.io.FileWriter; 
import java.io.FileNotFoundException;  
import java.util.Scanner; 

import javax.swing.JOptionPane;

public class TestClass {
		
	public static void main(String args[]) throws IOException{
		String str = "";
	    FileWriter myWtriter = new FileWriter("example.html");
		try(Scanner myReader = new Scanner(new File("filename.txt"));) {
		      while (myReader.hasNextLine()) {
		    	  
		        str += myReader.nextLine()+ System.lineSeparator();
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		    	JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		      e.printStackTrace();
		    }
		 
		 InputStream is = new ByteArrayInputStream(str.getBytes());
		 
		 
		 NewLexer lexer = new NewLexer (is);
		 String resultados ="";
		 
		 while(true){
			 Token token = lexer.yylex();
			 if(token ==null){
				 myWtriter.close();
				 break;
			 }
	
			 switch(token){
				 case ERROR: break;
				 case Nombre: myWtriter.write("<b>"+lexer.lexeme+"</b>");break;
				 case Telefono: myWtriter.write("<p style=\"color:green;\">"+lexer.lexeme+"</p>"); break;
				 case Celular: myWtriter.write("<p style=\"color:red;\">"+lexer.lexeme+"</p>"); break; 
				 case Email: myWtriter.write("<a href=\"mailto:"+lexer.lexeme+"\">"+lexer.lexeme+"</a><br>");break;
				 case Mastercard: myWtriter.write("<p style=\"color:blue;\">"+lexer.lexeme+"</p>");break;

				 default: myWtriter.write("<p>"+lexer.lexeme+"</p>"); break;
				 }
			 }
		 
		 	myWtriter.close(); JOptionPane.showMessageDialog(null, "HTML Creado con Exito!");
			 
		 }
		 
		 
}
