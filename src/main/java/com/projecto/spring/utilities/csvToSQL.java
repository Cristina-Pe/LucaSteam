package com.projecto.spring.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * @author Sebastian
 *  Método que lee un archivo CSV y genera una base de datos SQL
 */
public class csvToSQL {
    
    public static void convertToSql() throws FileNotFoundException, IOException{
        BufferedReader input = new BufferedReader(new FileReader(new File("./src/main/resources/vgsales.csv")));         //FALTA RUTA
        Writer output = new BufferedWriter(new FileWriter(new File("./src/main/resources/vgsales.sql")));                 //FALTA RUTA

        input.readLine();
        output.write("CREATE DATABASE IF NOT EXISTS Juego;\r\n" + "USE Juegos;\r\n" + "CREATE TABLE IF NOT EXISTS Juego\r\n"
				+ "(\r\n"
				+ "ID INT primary key not null AUTO_INCREMENT,\r\n"
				+ "`Name` VARCHAR(1000),\r\n"
				+ "`Platform` VARCHAR(1000),\r\n"
				+ "`Year` VARCHAR(1000),\r\n"
				+ "`Genre` VARCHAR(1000),\r\n"
				+ "`Publisher` VARCHAR(1000),\r\n"
				+ "`Sales_NA` VARCHAR(100),\r\n"
				+ "`Sales_EU` VARCHAR(100),\r\n"
				+ "`Sales_JP` VARCHAR(100),\r\n"
				+ "`Sales_Other` VARCHAR(100),\r\n"
				+ "`Sales_Global` VARCHAR(100)\r\n"
				+ ");\n");
        String line = "";
        String splitBy = "}"; 
        try {
            
            while ((line = input.readLine()) != null) {
                
                String[] st = line.split(splitBy);
                
                
                output.write("INSERT INTO Juego "
	                      + "(`ID`, `Name`, `Platform`, `Year`, `Genre`, `Publisher`, `Sales_NA`, `Sales_EU`, `Sales_JP`, `Sales_Other`, `Sales_Global`) VALUES "
	                      + "(" + st[0] + ", " + "\"" + st[1] + "\"" + ", " + "\"" + st[2] + "\"" + ", " + "\""+ st[3] + "\"" + ", "+ "\"" + st[4] + "\"" + ", " + "\"" +  st[5] + "\"" + ", " + "\"" + st[6] + "\"" + ", " + "\"" + st[7] + "\"" + ", " + "\""+ st[8] + "\"" + ", "+ "\"" + st[9]+ "\"" + ", "+ "\"" + st[10]+ "\"" + ")"
	                      + ";"
	                      + "\n");
            }
            
        } finally {
            
            input.close();
            output.close();
        }
    }

}