package com.java.helpful.csv.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Note: No third parth dependency used for this example
 * @author Naresh Makhija
 *
 */
public class CSVGenerator {
    
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    public static void generateCSV(List<User> users, String filePath) {
        FileWriter fileWriter = null;
        
        try {
            fileWriter = new FileWriter(filePath);
            
            // Write CSV header
            fileWriter.append("ID");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("Name");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("Age");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("Phone Number");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append("Address");
            fileWriter.append(NEW_LINE_SEPARATOR);
            
            // Write user data to CSV
            for (User user : users) {
                fileWriter.append(String.valueOf(user.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(user.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(user.getAge()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(user.getPhoneNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(user.getAddress());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            
            System.out.println("CSV file was created successfully!");
            
        } catch (Exception e) {
            System.out.println("Error in CSV file generation: " + e.getMessage());
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing file writer: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Naresh Makhija", 25, "1234567890", "123 Main St"));
        users.add(new User(2, "Rahul", 30, "9876543210", "456 Elm St"));
        users.add(new User(3, "Sunil", 30, "9876543210", "456 Elm St"));
        
        String filePath = "users.csv";
        generateCSV(users, filePath);
    }
}

class User {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private String address;
    
    public User(int id, String name, int age, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
}
