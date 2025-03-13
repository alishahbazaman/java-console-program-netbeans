/*
	Student Name: Ali Shahbaz Aman
	Student ID: 12165410
	Submission Date: 28/05/2021
	Class: COIT20245 - Introduction to Programming
	Assessment 2: Yeppoon Caravan Park Menu
	Purpose: To exercise the fundamentals of Java learned during classes which include input/output operations, primitive and built-in types, arrays,
	selection, sorting, looping, and Java defined objects.
*/

import java.util.Scanner; //input scanner
import java.util.Arrays; //array utility

public class YeppoonCaravanParkMenu //class name
{
    
    // menu items and their numbers
    final int ENTER_BOOKING = 1;
    final int DISPLAY_BOOKINGS = 2;
    final int DISPLAY_STATISTICS = 3;
    final int SEARCH_BOOKINGS = 4;
    final int SORT_BOOKINGS = 5;
    final int EXIT = 6;


    Scanner inputMenuChoice = new Scanner(System.in); //scanner object for menu choice

    final int MAX_BOOKINGS = 10; // TODO -- declare any further constants
    Booking [] bookingArray = new Booking[MAX_BOOKINGS]; // TODO -- declare array of Booking objects
    int currentBooking = 0; // TODO -- declare variable for the current booking entered (integer)

    private int getMenuItem()
    {
           //assign integers to menu items
        System.out.println("\nPlease select from the following");
        System.out.println(ENTER_BOOKING + ". Enter booking name and number of nights and guests");
        System.out.println(DISPLAY_BOOKINGS + ". Display all booking names, number of nights and guests and charges");
        System.out.println(DISPLAY_STATISTICS + ". Display Statistics");
        System.out.println(SEARCH_BOOKINGS + ". Search for booking");
        System.out.println(SORT_BOOKINGS + ". Sort the bookings");
        System.out.println(EXIT + ". Exit the application");
        System.out.println("Enter choice ==> ");

        String choice = inputMenuChoice.nextLine();
        while (choice.equals("") || !isStringNumeric(choice))
        {
            //error message code when chosen a non numeric value
            System.out.printf("Error - Menu selection name cannot be blank and must be numeric%n");

            System.out.println("Enter choice ==> ");

            choice = inputMenuChoice.nextLine();
        }

        return Integer.parseInt(choice);
    }


    private boolean isStringNumeric(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }

        return true;
    }


    private void processOrders()
    {
        int choice = getMenuItem();
        while (choice != EXIT)
        {
            switch (choice)
            {
                // assigning methods to menu choice
                case ENTER_BOOKING:
                    enterBooking();
                    break;
                case DISPLAY_BOOKINGS:
                    displayAllBookings(bookingArray, currentBooking);
                    break;
                case DISPLAY_STATISTICS:
                    displayStatistics();
                    break;
                case SEARCH_BOOKINGS:
                    searchBookings();
                    break;
                case SORT_BOOKINGS:
                    sortBookings();
                    break;
                default:
                    System.out.println("ERROR choice not recognised");
            }
            choice = getMenuItem();
        }
    }


    private void enterBooking() //enterBooking method
    {
    // TODO -- check if maximum bookings has been reached (do this after getting the other functionality working)
        if (currentBooking >= MAX_BOOKINGS)
        {
            System.out.printf("ERROR - Maximum bookings to be entered has been reached%n");
        }

        else
        {
            Scanner inText = new Scanner(System.in); 	// Scanner object for reading text
            Scanner inNumber = new Scanner(System.in);	// Scanner object for reading numbers

            String bookingName = "";
            int nights = 0;
            int guests = 0;

            final int MIN_NIGHTS = 1;
            final int MIN_GUESTS = 1;

            for (int i = 0; i < 1; i++)
            {
            // TODO -- read in the booking name (as a string)
            // TODO -- create validation loop (do this after getting the other functionality working)
            System.out.printf("Please enter the booking name ==> %n");
            bookingName = inText.nextLine();

            while(bookingName.equals(""))  // validation loop
            {
                System.out.printf("ERROR booking name cannot be blank%n");
                System.out.printf("Please enter the booking name ==> %n");
                bookingName = inText.nextLine();
            }

            // TODO -- read in the number of nights to stay
            // TODO -- create validation loop (do this after getting the other functionality working)
            System.out.printf("Please enter the number of nights ==> %n" );
            nights = inNumber.nextInt();

            while (nights < MIN_NIGHTS) // validation loop
            {
                System.out.printf("ERROR number of nights must be greater than or equal to %d%n", MIN_NIGHTS);
                System.out.printf("Please enter the number of nights ==> %n" );
                nights = inNumber.nextInt();
            }

            // TODO -- read in the number of guests
            // TODO -- create validation loop (do this after getting the other functionality working)
            System.out.printf("Please enter the number of guests ==> %n" );
            guests = inNumber.nextInt();

            while (guests < MIN_GUESTS) // validation loop
            {
                System.out.printf("ERROR number of guests must be greater than or equal to %d%n", MIN_GUESTS);
                System.out.printf("Please enter the number of guests ==> %n" );
                guests = inNumber.nextInt();
            }
        }

            // TODO -- add the data to the array (use the new keyword and the parameterised constructor in Booking class)
            bookingArray[currentBooking] = new Booking (bookingName, nights, guests);
            System.out.printf("%nDetails for booking %d entered%n", currentBooking);

            // TODO -- display the booking name, number of nights and guests and the charge
            displayHeading();
            displayBooking(currentBooking);

            // TODO -- increment the current booking variable for the next entry
            currentBooking++;
        }
    }


    private void displayHeading() // displayHeading method
    {
            System.out.printf("%n%-30s%-11s%-11s%-6s%n", 
                "Booking Name", "Nights", "Guests", "Charge");

    }


    private void displayBooking(int index) //single displayBooking method
    {
        System.out.printf("%-30s%-11d%-11d%-6.2f%n", 
            bookingArray[index].getBookingName(),
            bookingArray[index].getNights(),
            bookingArray[index].getGuests(),    
            bookingArray[index].calculateCharge());
    }


    private void displayAllBookings(Booking [] bookingArray, int currentBooking)
    //displayAllBookings method
    {
    // TODO -- check if there has been an booking entered 
    //(do this after getting the other functionality working)
        if (currentBooking < 1)
            System.out.printf("ERROR - You must enter at least one booking to display bookings%n");

        else
        // TODO -- display all of the entries entered so far
        // (just display the current entries not the whole array)
        // (use the current booking variable as the termination condition)
        displayHeading();
        for (int i = 0; i < currentBooking; i++)
        {
            displayBooking(i);
        }
    }


    private void displayStatistics() //displayStatistics method
    {
    // TODO -- check if there has been an booking entered
    // (do this after getting the other functionality working)
        if (currentBooking < 1)
        {
            System.out.printf("ERROR - You must enter at least one booking to display statistics%n");
        }

        else
        {
            int index = 0;
            double charge = bookingArray[index].calculateCharge();
            String bookingName = bookingArray[index].getBookingName();
            int nights = bookingArray[index].getNights();
            int guests = bookingArray[index].getGuests();

            int totalNights = 0;
            double totalCharges = 0.0;
            double average = 0.0;

            int minimumNights = Integer.MAX_VALUE;
            String minimumBookingName = "";
            int maximumNights = Integer.MIN_VALUE;
            String maximumBookingName = "";
            totalCharges += charge; // tally the charges
            totalNights += nights;

            for (int i = 0; i < 1; i++)
            {
                if (nights < minimumNights)
                {
                    minimumNights = nights;
                    minimumBookingName = bookingName;
                }
                if (nights > maximumNights)
                {
                    maximumNights = nights;
                    maximumBookingName = bookingName;
                }
                bookingArray[currentBooking] = new Booking (bookingName, nights, guests);

                // print statistical information
                System.out.println("%n%nStatistical information for Yeppoon Caravan Park%n");
                System.out.println(minimumBookingName + " has the minimum number of " + minimumNights + " nights");
                System.out.println(maximumBookingName + " has the maximum number of " + maximumNights + " nights");

                average = (double) totalNights/bookingArray.length;

                System.out.printf("The average number of nights stay per booking is: %.2f nights%n", average);
                System.out.printf("The total charges collected is $%.2f%n%n", totalCharges);
            }
        }

    // TODO -- loop though the current entries in the array and calculate and display the statistics

    }


    private void searchBookings() //searchBookings method
    {
        // TODO -- check if there has been an booking entered
        // (do this after getting the other functionality working)
        if (currentBooking < 1)
        {
            System.out.printf("ERROR - You must enter at least one booking to search%n");
        }

        else
        {
            Scanner input = new Scanner(System.in);
            System.out.printf("Please enter the booking name ==> ");
            String searchKey = input.nextLine();

            int index = 0;
            boolean found = false;

            while (index < currentBooking && !found)
            {
        // TODO -- read the search key
                if(bookingArray[index].getBookingName().equalsIgnoreCase(searchKey))
                {
                    found = true;
                }

                else
                {
        // TODO -- loop though the current entries in the 
            // array to search for the search key
                    index++;
                }
            }
            if(found)
            {
                    displayHeading();
                    displayBooking(index);
            }

            else
            {
        // TODO -- display the found item or report it has not been found
                System.out.printf("%s not found%n", searchKey);
            }
        }
    }


    private void sortBookings() //sortBookings method
    {
        // TODO -- check if there has been two bookings entered
        // (do this after getting the other functionality working)
        if (currentBooking < 2)
        {
            System.out.printf("ERROR - You must enter at least two bookings to sort%n");
        }

        else
        {
            for(int next = 1; next < bookingArray.length; next++)
            {
                Booking insert = bookingArray[next];
                int moveItem = next;

                // TODO -- sort the entries based on the booking name 
                // (case insensitve)
                while (moveItem > 0 && bookingArray[moveItem - 1].getBookingName()
                            .compareToIgnoreCase(insert.getBookingName()) > 0)
                {
                    bookingArray[moveItem] = bookingArray[moveItem - 1];
                    moveItem--;
                }

                bookingArray[moveItem] = insert;
            }
            // TODO -- display the sorted list
            displayAllBookings(bookingArray, currentBooking);
        }

    }


    public static void main(String [] args)
    {
         // welcome message
        System.out.printf("Welcome to the Yeppoon Caravan Park Management System%n%n"); 

        YeppoonCaravanParkMenu app = new YeppoonCaravanParkMenu();

        app.processOrders();
        
        // end message
        System.out.printf("%n%n%nThank you for using Yeppoon Caravan Park Management System%n");
        // my student ID
        System.out.printf("Program written by 12165410%n%n"); 
    }
}