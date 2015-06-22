/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.article.dll.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author Alexandr
 */
public class DDLGenerator {

    private static final String DEFAULT_DRIVER = "org.postgresql.Driver";
    private static final String DEFAULT_URL = "jdbc:postgresql://localhost:5432/pharmacy";
    private static final String DEFAULT_USERNAME = "postgres";
    private static final String DEFAULT_PASSWORD = "Admin123#";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("///////////////////////////////////////////////////////////////////////");
            if (args != null && args.length > 0) {
                for (String arg : args) {
                    System.out.println("arg=" + arg);
                }
            }
            Connection conn = createConnection(DEFAULT_DRIVER, DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
            fileReader(conn, args);
            System.out.println("///////////////////////////////////////////////////////////////////////");
        } catch (SQLException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DDLGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(DDLGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DDLGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void fileReader(Connection conn, String[] args) throws FileNotFoundException, IOException, SQLException {
        String arg = args[0];
        File fileDirectory = new File(arg);
        File[] files = fileDirectory.listFiles();
        Reader reader;
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for (File file : files) {
            System.out.println("Execute file: " + file.getAbsolutePath());
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            reader = new FileReader(file);
            runScript(conn, reader);
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
        }
    }

    /**
     * Runs an SQL script (read in using the Reader parameter) using the
     * connection passed in
     *
     * @param conn - the connection to use for the script
     * @param reader - the source of the script
     * @throws SQLException if any SQL errors occur
     * @throws IOException if there is an error reading from the Reader
     */
    private static void runScript(Connection conn, Reader reader) throws IOException {
        LineNumberReader lineReader = new LineNumberReader(reader);
        String line;
        while ((line = lineReader.readLine()) != null) {
            String sqlStatement = line.trim();
            System.out.println(sqlStatement);
            Statement statement;
            try {
                statement = conn.createStatement();
                statement.execute(sqlStatement);
            } catch (SQLException ex) {
                //do nothing
            }
        }
    }

    public static Connection createConnection(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        if ((username == null) || (password == null) || (username.trim().length() == 0) || (password.trim().length() == 0)) {
            return DriverManager.getConnection(url);
        } else {
            return DriverManager.getConnection(url, username, password);
        }
    }
}
