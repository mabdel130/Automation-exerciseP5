package util;
import net.minidev.json.parser.JSONParser;
import org.apache.http.ParseException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

import java.io.FileReader;
import java.security.SecureRandom;
import java.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NAME_LENGTH = 10;
    private static final String SAUDI_MOBILE_PREFIXES[] = {"050", "053", "054", "055", "056", "057", "058", "059"};
    private static final int PHONE_NUMBER_LENGTH = 9;
    private static final String CHARACTERS1 = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "outlook.com"}; //added more domains
    private static final int MAX_USERNAME_LENGTH = 15;
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+={}[]|;:'\",.<>/?";
    private static final String[] STREET_NAMES = {"Main", "Oak", "Pine", "Maple", "Cedar", "Park", "Hill", "Lake", "River", "Sunset"};
    private static final String[] STREET_TYPES = {"St", "Ave", "Blvd", "Dr", "Ct", "Ln", "Rd", "Pl", "Way", "Terrace"};
    private static final String[] CITIES = {"Cairo", "Chicago", "Houston", "Phoenix", "Philadelphia", "SanAntonio", "SanDiego", "Dallas", "SanJose"};
    private static final String[] STATES = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    private static final String[] ZIP_CODES_PREFIXES = {"90", "10", "60", "77", "85", "19", "78", "92", "75", "95"}; // Just some sample prefixes


    private static final SecureRandom random = new SecureRandom();// Excluding the prefix
    //read from Excel


    //parse data
    public static String getSingleJsonData(String jsonFilePath, String jsonField) throws IOException, ParseException, net.minidev.json.parser.ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get(jsonField).toString();
    }

    //generate Random name
    public static String generateRandomName(int n) {
        if (n <= 0 || n > NAME_LENGTH) {
            throw new IllegalArgumentException("n must be between 1 and " + NAME_LENGTH);
        }

        Random random = new Random();
        StringBuilder sb = new StringBuilder(NAME_LENGTH);

        // Generate the first 'n' random letters
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }


        // Fill the rest with random letters as well (instead of digits)
        for (int i = n; i < NAME_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }
    // generate randome state

    // generate Random Saudi Number
    public static String generateRandomSaudiNumber() {
        Random random = new Random();

        // Choose a random prefix
        String prefix = SAUDI_MOBILE_PREFIXES[random.nextInt(SAUDI_MOBILE_PREFIXES.length)];

        // Generate the remaining 9 digits
        StringBuilder sb = new StringBuilder(PHONE_NUMBER_LENGTH);
        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }

        return prefix + sb.toString();
    }

    public static String generateRandomSaudiNumberWithCountryCode() {
        return "+966" + generateRandomSaudiNumber().substring(1); //remove the leading zero after adding country code
    }

    // genetate random Email
    public static String generateRandomEmail() {
        Random random = new Random();

        // Generate random username
        int usernameLength = random.nextInt(MAX_USERNAME_LENGTH) + 5; // Username length between 5 and 19 (inclusive)
        StringBuilder username = new StringBuilder(usernameLength);
        for (int i = 0; i < usernameLength; i++) {
            username.append(CHARACTERS1.charAt(random.nextInt(CHARACTERS1.length())));
        }
        String domain = DOMAINS[random.nextInt(DOMAINS.length)];

        return username.toString() + "@" + domain;
    }


    public static String generateComplexPassword(int length) {
        if (length < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 characters.");
        }

        // Ensure at least one character from each set
        StringBuilder password = new StringBuilder();
        password.append(getRandomCharacter(LOWERCASE));
        password.append(getRandomCharacter(UPPERCASE));
        password.append(getRandomCharacter(NUMBERS));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS));

        // Fill the rest with random characters from all sets
        String allCharacters = LOWERCASE + UPPERCASE + NUMBERS + SPECIAL_CHARACTERS;
        for (int i = password.length(); i < length; i++) {
            password.append(getRandomCharacter(allCharacters));
        }

        // Shuffle the password to further randomize the character positions
        java.util.List<Character> passwordList = password.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(passwordList, random);

        return passwordList.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private static char getRandomCharacter(String characterSet) {
        return characterSet.charAt(random.nextInt(characterSet.length()));
    }

//    public static int generateRandomNumberBetween1And3() {
//        // nextInt(3) generates numbers from 0 to 2 (inclusive).
//        // Adding 1 shifts the range to 1 to 3 (inclusive).
//        return random.nextInt(3) + 1;
//    }

    //generate dynamic
    public static int generateRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max) + 1; // Generate a random number between 1 and 8 (inclusive)
    }

    /// //generateAndPri
    public static void generateshuffleRandomNumber(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max must be greater than 0");
        }

        Random rand = new Random();
        int randomNumber = rand.nextInt(max) + 1;  // Generates a random number between 1 and max (inclusive)

        // Print the generated random number
        // System.out.println("Generated Random Number: " + randomNumber);

        // Generate a list of numbers from 1 to randomNumber-1
        List<Integer> availableNumbers = new ArrayList<>();
        for (int i = 1; i < randomNumber; i++) {
            availableNumbers.add(i);
        }

        // Shuffle the list to randomize the order
        Collections.shuffle(availableNumbers);

        // Print the shuffled list (it will contain random numbers less than the random number)
        // System.out.println("Random Numbers Less Than " + randomNumber + ": " + availableNumbers);
    }
//    public static int generateRandomNumberBetween1And8() {
//        // nextInt(3) generates numbers from 0 to 2 (inclusive).
//        // Adding 1 shifts the range to 1 to 3 (inclusive).
//        return random.nextInt(8) + 1;
//    }

//    public static int generateRandomNumberBetween1And2() {
//        // nextInt(3) generates numbers from 0 to 2 (inclusive).
//        // Adding 1 shifts the range to 1 to 3 (inclusive).
//        return random.nextInt(2) + 1;
//    }

//    public static int generateRandomNumberBetween1And5() {
//        // nextInt(3) generates numbers from 0 to 2 (inclusive).
//        // Adding 1 shifts the range to 1 to 3 (inclusive).
//        return random.nextInt(5) + 1;
//    }

    //generate random city


    //genraterandomPostalCode

    // openBrowserNetworkTab


    //




//    /*
//    // generate random firstname
//    private static final String CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    private static final int RANDOM_STRING_LENGTH = 10;
//
//    public static String generateRandomFirstName() {
//        StringBuilder randStr = new StringBuilder();
//        Random rand = new Random();
//
//        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
//            int index = rand.nextInt(CHAR_LIST.length());
//            char c = CHAR_LIST.charAt(index);
//            randStr.append(c);
//        }
//
//        return randStr.toString();
//    }
//
//    //generate random mobile number
//    private static final String COUNTRY_CODE = "+966"; // Replace with the desired country code
//    private static final String[] PREFIXES = { "50", "53", "54", "55", "56", "59" };
//
//    public static String generateRandomPhoneNumber() {
//        Random rand = new Random();
//
//        // Choose a random prefix
//        String prefix = PREFIXES[rand.nextInt(PREFIXES.length)];
//
//        // Generate 7 random digits for the remaining part of the number
//        String remainingDigits = String.format("%07d", rand.nextInt(10000000));
//
//        // Combine country code, prefix, and remaining digits
//        String phoneNumber = COUNTRY_CODE + prefix + remainingDigits;
//
//        return phoneNumber;
//    }
//
    /// /    public static void main(String[] args) {
    /// /        String randomPhoneNumber = generateRandomPhoneNumber();
    /// /        System.out.println("Random Phone Number: " + randomPhoneNumber);
    /// /    }
    ///
    /// @return
//
//    //Generate LastNAme
//    private static final String charList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    private static final int randomStringLingth = 10;
//
//    // Method to generate a random last name
//    public static String generateRandomLastName() {
//        StringBuilder randStr = new StringBuilder();
//        Random rand = new Random();
//
//        for (int i = 0; i < randomStringLingth; i++) {
//            int index = rand.nextInt(charList.length());
//            char c = CHAR_LIST.charAt(index);
//            randStr.append(c);
//        }
//
//        return randStr.toString();
//    }
//     */

//public static int generateRandomNumber(int max) {
//    Random rand = new Random();
//    return rand.nextInt(max) + 1; // Generate a random number between 1 and max (inclusive)
//}

    // Method to generate unique random numbers and save them in an ArrayList
    public static ArrayList<Integer> generateUniqueRandomNumbers(int max, int count) {
        // Set to ensure uniqueness of random numbers
        Set<Integer> uniqueNumbersSet = new HashSet<>();
        ArrayList<Integer> uniqueNumbersList = new ArrayList<>(); // To store the unique numbers

        // Generate unique random numbers
        for (int i = 1; i <= count; i++) {
            int uniqueRandomNum;
            do {
                uniqueRandomNum = generateRandomNumber(max); // Generate random number
            } while (uniqueNumbersSet.contains(uniqueRandomNum)); // Ensure uniqueness

            uniqueNumbersSet.add(uniqueRandomNum); // Add to the set to ensure uniqueness
            uniqueNumbersList.add(uniqueRandomNum); // Save the unique number to the list
        }

        return uniqueNumbersList;
    }


}




