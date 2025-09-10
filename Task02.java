/*
Написать программу – телефонная книга.
Программа должна иметь возможность создавать и сохранять новые контакты. Просматривать ранее
сохраненные имена. Искать контакт по номеру телефона или по имени. Контакт может включать в себя:
■ имя;
 ■ фамилия;
■ прозвище;
■ номера телефонов (неограниченное количество, может быть несколько с одинаковым типом). Номера
телефонов не должны повторяться для разных контактов (домашний, рабочий, мобильный, факс)
 ■ электронные адреса (проверка на корректность);
■ год рождения.

 */

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

interface Storable {
    void saveToFile(String filename);
    void loadFromFile(String filename);
}

class Contact implements Serializable { // for file saving (bytes)
    private String firstName;
    private String lastName;
    private String nickname;
    private List<String> phones = new ArrayList<>();
    private List<String> emails = new ArrayList<>();
    private int birthYear;

    public Contact(String firstName, String lastName, String nickname, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.birthYear = birthYear;
    }

    public String getFullName() {
        return firstName + " " + lastName + " (" + nickname + ")";
    }

    public List<String> getPhones() {
        return phones;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void addPhone(String phone) {
        if (!phones.contains(phone)) {
            phones.add(phone);
        }
    }

    public boolean addEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (Pattern.matches(regex, email)) {
            emails.add(email);
            return true;
        }
        return false;
    }

    public boolean matches(String keyword) {
        return getFullName().toLowerCase().contains(keyword.toLowerCase())
                || phones.contains(keyword);
    }
// redefinition
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                ", Nickname: " + nickname +
                ", Birth year: " + birthYear +
                "\nPhones: " + phones +
                "\nEmails: " + emails + "\n";
    }
}

class PhoneBook implements Storable {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact c) {
        for (Contact existing : contacts) {
            for (String phone : c.getPhones()) {
                if (existing.getPhones().contains(phone)) {
                    System.out.println("ERROR! Phone " + phone + " belongs to another contact!");
                    return;
                }
            }
        }
        contacts.add(c);
    }

    public void showAll() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook's empty.");
        } else {
            contacts.forEach(System.out::println);
        }
    }

    public void search(String keyword) {
        boolean found = false;
        for (Contact c : contacts) {
            if (c.matches(keyword)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("No contacts found for: " + keyword);
    }

    @Override
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(contacts);
            System.out.println("Congrats! Phonebook saved");
        } catch (IOException e) {
            System.out.println("Saving ERROR: " + e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("unchecked") // no need to check object type
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            contacts = (List<Contact>) ois.readObject();
            System.out.println("Congrats! Phonebook loaded");
        } catch (FileNotFoundException e) {
            System.out.println("No previous phonebook found");
        } catch (Exception e) {
            System.out.println("Loading ERROR: " + e.getMessage());
        }
    }
}


public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        String file = "phonebook.txt";

        phoneBook.loadFromFile(file);

        while (true) {
            System.out.println("\nPhoneBook Menu:");
            System.out.println("1. Add contact");
            System.out.println("2. Show all contacts");
            System.out.println("3. Search by name/phone");
            System.out.println("4. Save and Exit");
            System.out.print("Pick option - ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume line

            switch (choice) {
                case 1 -> {
                    System.out.print("First name - ");
                    String fn = scanner.nextLine();
                    System.out.print("Last name - ");
                    String ln = scanner.nextLine();
                    System.out.print("Nickname - ");
                    String nn = scanner.nextLine();
                    System.out.print("Birth year - ");
                    int by = scanner.nextInt();
                    scanner.nextLine();

                    Contact c = new Contact(fn, ln, nn, by);

                    while (true) {
                        System.out.print("Add phone (or 'done'): ");
                        String ph = scanner.nextLine();
                        if (ph.equalsIgnoreCase("done")) break;
                        c.addPhone(ph);
                    }

                    while (true) {
                        System.out.print("Add email (or 'done'): ");
                        String em = scanner.nextLine();
                        if (em.equalsIgnoreCase("done")) break;
                        if (!c.addEmail(em)) {
                            System.out.println("Invalid email format!");
                        }
                    }

                    phoneBook.addContact(c);
                }
                case 2 -> phoneBook.showAll();
                case 3 -> {
                    System.out.print("Enter name or phone - ");
                    String keyword = scanner.nextLine();
                    phoneBook.search(keyword);
                }
                case 4 -> {
                    phoneBook.saveToFile(file);
                    return;
                }
                default -> System.out.println("Pick from the list!");
            }
        }
    }
}
