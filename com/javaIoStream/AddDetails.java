package com.javaIoStream;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddDetails {
    Scanner scanDetails = new Scanner(System.in);
    // Edit method use to edit the data.
    public void editContact(ArrayList<PersonDetails> contactDetails) {
        String data = scanDetails.nextLine();
        for (int i = 0; i < contactDetails.size(); i++) {
            if (contactDetails.get(i).getFirstName().equals(data)) {
                System.out.println("1. Enter The update First Name :");
                System.out.println("2. Enter The update LastName. ");
                System.out.println("3. Enter The update Address. ");
                System.out.println("4. Enter The update City. ");
                System.out.println("5. Enter The update State. ");
                System.out.println("6. Enter The update ZipCode. ");
                System.out.println("7. Enter The update PhoneNumber. ");
                System.out.println("9. Enter The update Email. ");
                int replace = scanDetails.nextInt();
                scanDetails.nextLine();

                switch (replace) {

                    case 1:
                        System.out.println("Enter the First Name");
                        String firstNameData = scanDetails.nextLine();
                        contactDetails.get(i).setFirstName(firstNameData);
                        break;

                    case 2:
                        System.out.println("Enter the Last Name");
                        String lastNameData = scanDetails.nextLine();
                        contactDetails.get(i).setLastName(lastNameData);
                        break;

                    case 3:
                        System.out.println("Enter the Address");
                        String addressData = scanDetails.nextLine();
                        contactDetails.get(i).setAddress(addressData);
                        break;

                    case 4:
                        System.out.println("Enter the City");
                        String cityData = scanDetails.nextLine();
                        contactDetails.get(i).setCity(cityData);
                        break;

                    case 5:
                        System.out.println("Enter the State");
                        String stateData = scanDetails.nextLine();
                        contactDetails.get(i).setState(stateData);
                        break;

                    case 6:
                        System.out.println("Enter the Zip Code");
                        String zipCodeData = scanDetails.nextLine();
                        contactDetails.get(i).setZipCode(zipCodeData);
                        break;

                    case 7:
                        System.out.println("Enter the Phone Number");
                        String phoneNumberData = scanDetails.nextLine();
                        contactDetails.get(i).setPhoneNumber(phoneNumberData);
                        break;

                    case 8:
                        System.out.println("Enter the Email");
                        String emailData = scanDetails.nextLine();
                        contactDetails.get(i).setEmail(emailData);
                        break;

                    default:
                        System.out.println("you have not update any details");
                        break;
                }
            }
        }
    }

    // Delete method use to delete the data.
    public void deleteContact(ArrayList<PersonDetails> contactDetails) {
        System.out.println("Enter The Name");
        String data = scanDetails.nextLine();
        for (int i = 0; i < contactDetails.size(); i++) {
            if (contactDetails.get(i).getFirstName().equals(data)) {
                contactDetails.remove(i);
            } else
                System.out.println("not match any details");
        }
    }

    public boolean duplicateDetailsRemove(ArrayList<PersonDetails> addNewDetails, String firstName) {
        boolean result = addNewDetails.stream().filter(personDetail -> personDetail.getFirstName().equals(firstName)).findFirst().isPresent();
        return result;
    }

    public void searchDetails(Hashtable<Integer, ArrayList<PersonDetails>> hashtable) {
        System.out.println("Enter the City or State Name");
        String cityOrStateName = scanDetails.nextLine();
        int totalNumberOfCount = 0;
        for (int i = 1; i <= hashtable.size(); i++) {
            List<PersonDetails> numberOfCity = hashtable.get(i).stream().filter(search -> search.getCity().equalsIgnoreCase(cityOrStateName)
                    || search.getState().equals(cityOrStateName)).collect(Collectors.toList());
            System.out.println("Details of CityOrState " + numberOfCity + "\n" + "Number of Times " + numberOfCity.size());
        }
    }
}