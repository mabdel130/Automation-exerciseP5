package util;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Random;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Utlity {
    public static void main(String[] args) {
        int firstNameLength = 5;
        String randomFirstName = generateRandomFirstName();
        System.out.println("Random Capitalized First Name: " + randomFirstName);

        String randomLastName = generateRandomLastName();
        System.out.println("Random Capitalized Last Name: " + randomLastName);

        String dynamicEmail = generateDynamicEmail();
        System.out.println("Dynamic Email: " + dynamicEmail);

        String dynamicPhoneNumber = generateEgyptianPhoneNumber();
        System.out.println("Dynamic Egyptian Phone Number: " + dynamicPhoneNumber);

        String dynamicPassword = generateDynamicPassword();
        System.out.println("Dynamic Password: " + dynamicPassword);
    }

    public static String generateRandomFirstName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = 5; // Change the length if needed
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }

        return sb.substring(0, 1).toUpperCase() + sb.substring(1); // Capitalize the first letter
    }
    public static String generateRandomFullName() {
        // Characters to choose from
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        // Generate a random first name with a random length between 3 and 8
        String firstName = generateRandomNamePart(letters, random, 3, 8);

        // Generate a random last name with a random length between 4 and 10
        String lastName = generateRandomNamePart(letters, random, 4, 10);

        // Combine them into a full name
        return firstName+lastName;
    }
    public static String getExcelData(int RowNum, int ColNum, String SheetName) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        String projectPath = System.getProperty("user.dir");
        String cellData = null;
        try {
            workBook = new XSSFWorkbook(projectPath + "/src/test/resources/data_driven/data.xlsx");
            sheet = workBook.getSheet(SheetName);
            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellData;
    }

    public static String generateRandomDate(int startYear, int endYear) {
        // Define the start and end dates
        LocalDate startDate = LocalDate.of(startYear, 1, 1);
        LocalDate endDate = LocalDate.of(endYear, 12, 31);

        // Generate a random day between the start and end dates
        long randomEpochDay = ThreadLocalRandom.current().nextLong(startDate.toEpochDay(), endDate.toEpochDay());
        LocalDate randomDate = LocalDate.ofEpochDay(randomEpochDay);

        // Format the date as yyyy-MM-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return randomDate.format(formatter);
    }
    // Generate a random year between startYear and endYear
    public static int generateRandomYear(int startYear, int endYear) {
        return ThreadLocalRandom.current().nextInt(startYear, endYear + 1);
    }

    // Generate a random month (1 to 12)
    public static int generateRandomMonth() {
        return ThreadLocalRandom.current().nextInt(1, 13);
    }

    // Generate a random day based on the given month and year
    public static int generateRandomDay(int year, int month) {
        // Get the maximum number of days in the given month & year
        int maxDays = LocalDate.of(year, month, 1).lengthOfMonth();
        return ThreadLocalRandom.current().nextInt(1, maxDays + 1);
    }

    private static String generateRandomNamePart(String letters, Random random, int minLength, int maxLength) {
        int length = random.nextInt(maxLength - minLength + 1) + minLength; // Random length in range
        StringBuilder sb = new StringBuilder();

        // Build the random name part
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }

        return sb.toString();
    }


    public static String generateUniqueUsername() {
        String lettersAndDigits = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Letters and numbers
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Adjust the length to 8 to allow space for uniqueness
        int length = 8;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(lettersAndDigits.length());
            sb.append(lettersAndDigits.charAt(index));
        }

        // Append a shorter timestamp (last two digits of the current milliseconds)
        String uniqueUsername = sb.toString() + "_" + (System.currentTimeMillis() % 100);

        // Trim to a max of 10 characters
        if (uniqueUsername.length() > 10) {
            uniqueUsername = uniqueUsername.substring(0, 10);
        }

        return uniqueUsername;
    }


    public static String generateRandomLastName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = 7; // You can change the length if needed
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }

        // Capitalize the first letter and return the name
        String lastName = sb.toString();
        return lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
    }


    public static String generateRandomMiddleName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = 7; // You can change the length if needed
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }

        return sb.toString();
    }

    public static String generateDynamicEmail() {

        String uniqueId = UUID.randomUUID().toString().substring(0, 8);

        String dynamicEmail = "user" + uniqueId + "@example.com";

        return dynamicEmail;
    }

    public static String generateRandomMessage() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = random.nextInt(50) + 20; // Random length between 20 and 70 characters
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }

        // Capitalize the first letter and return the message
        String message = sb.toString().trim();
        return message.substring(0, 1).toUpperCase() + message.substring(1);
    }

    public static String generateEgyptianPhoneNumber() {
        final AtomicInteger counter = new AtomicInteger(0);

        String[] egyptianPrefixes = {"010", "011", "012", "015"};
        String prefix = egyptianPrefixes[(int) (Math.random() * egyptianPrefixes.length)];


        int randomNumber = (int) (Math.random() * 10000000);


        AtomicInteger uniqueValue = counter;


        return "+20" + prefix + String.format("%07d", randomNumber) + uniqueValue;
    }
    public static long generateUniqueEmployeeId() {
        Random random = new Random();

        // Minimum 6-digit value (100000), maximum 6-digit value (999999)
        long min = 100000L;
        long max = 999999L;

        // Generate a random 6-digit employee ID
        long uniqueEmployeeId = min + (long) (random.nextDouble() * (max - min + 1));

        // Return the generated ID
        return uniqueEmployeeId;
    }




    public static String generateDynamicPassword() {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

        // Combine all character sets
        String allCharacters = capitalLetters + smallLetters + numbers + specialCharacters;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each set is included
        password.append(capitalLetters.charAt(random.nextInt(capitalLetters.length())));
        password.append(smallLetters.charAt(random.nextInt(smallLetters.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        // Fill the remaining characters to meet the 7-character minimum
        int remainingLength = 7 - password.length();
        for (int i = 0; i < remainingLength; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Shuffle the password to randomize character positions
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        ArrayList<Object> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle((java.util.List<?>) characters);
        StringBuilder shuffled = new StringBuilder();
        for (Object c : characters) {
            shuffled.append(c);
        }
        return shuffled.toString();
    }


    public static String shuffleString() {
        String input = String.valueOf(1);
        char[] characters = input.toCharArray();
        Random random = new Random();
        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }

    public static String generateRandomPostalCode() {
        Random random = new Random();
        return String.format("%05d", random.nextInt(100000));
    }

    public static String generateRandomAddress() {
        Random random = new Random();

        // Generate random number (house number)
        int number = random.nextInt(1000) + 1;

        // Generate random street name (letters)
        char letter1 = (char) ('a' + random.nextInt(26));
        char letter2 = (char) ('a' + random.nextInt(26));
        char letter3 = (char) ('a' + random.nextInt(26));
        String streetName = letter1 + "" + letter2 + letter3 + " Street";

        // Generate random city name (letters)
        char cityLetter1 = (char) ('a' + random.nextInt(26));
        char cityLetter2 = (char) ('a' + random.nextInt(26));
        char cityLetter3 = (char) ('a' + random.nextInt(26));
        String city = cityLetter1 + "" + cityLetter2 + cityLetter3 + " City";

        // Generate random state abbreviation
        String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
        String state = states[random.nextInt(states.length)];

        // Generate random zip code
        int zipCode = random.nextInt(90000) + 10000;

        return number + " " + streetName + ", " + city + ", " + state + " " + zipCode;
    }
    public static String generateRandomState() {
        Random random = new Random();

        // Array of U.S. state abbreviations
        String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA",
                "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT",
                "VA", "WA", "WV", "WI", "WY"};

        // Pick a random state abbreviation from the array
        String state = states[random.nextInt(states.length)];

        return state;  // Return the selected random state abbreviation
    }
    public static String generateRandomCity() {
        String[] cities = {"New York", "London", "Paris", "Tokyo", "Cairo", "Sydney", "Mumbai", "Beijing", "Dubai", "Rio de Janeiro", "Berlin", "Toronto", "Los Angeles", "Cape Town", "Singapore", "Mexico City", "Seoul", "Moscow", "Istanbul", "Bangkok"};
        Random random = new Random();
        return cities[random.nextInt(cities.length)];
    }

    public static String generateRandomCompanyName() {
        String[] companies = {"TechCorp", "Global Solutions", "NextGen Innovations", "BlueSky Technologies", "Quantum Systems", "EcoLogic Industries", "Fusion Dynamics", "Visionary Labs", "EverGreen Ventures", "Summit Enterprises"};
        Random random = new Random();
        return companies[random.nextInt(companies.length)];

    }

    public static String generateRandomPin(int minLength) {
        Random random = new Random();
        StringBuilder pin = new StringBuilder();

        // Ensure the length is at least 6 (or the given minLength)
        int pinLength = Math.max(minLength, 6);

        // Generate each digit of the PIN (between 1 and 9)
        for (int i = 0; i < pinLength; i++) {
            int digit = random.nextInt(9) + 1;  // Generate a random number between 1 and 9
            pin.append(digit);  // Append the digit to the PIN
        }

        return pin.toString();  // Return the generated PIN as a string
    }

    public static void openBrowserNetworkTab() throws AWTException {
        // Create Robot instance
        Robot robot = new Robot();

        // Add a delay for setup (optional)
        robot.delay(2000); // Wait for the browser window to be active

        // Step 1: Press Ctrl+Shift+I to open Developer Tools
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_I);

        // Add a delay for Developer Tools to open
        robot.delay(1000);

        // release press buttons
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_I);

        // Step 2: Navigate to the Network tab
        // Use Right Arrow key multiple times to move to the Network tab
        for (int i = 0; i < 3; i++) {
            // Press and hold Ctrl
            robot.keyPress(KeyEvent.VK_CONTROL);

            // Press and release
            robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
            robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);

            // Release Ctrl
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Add a small delay between presses
            robot.delay(200);
        }

    }
    public static String generateRandomCardNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Start with a valid prefix (e.g., 4 for Visa, 5 for Mastercard)
        int prefix = random.nextInt(2) == 0 ? 4 : 5; // Randomly choose 4 or 5
        sb.append(prefix);

        // Generate the remaining 15 digits
        for (int i = 0; i < 15; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }

        return sb.toString();
    }

    public static String generateRandomCVC() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Generate 3 random digits
        for (int i = 0; i < 3; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }

        return sb.toString();
    }

}




