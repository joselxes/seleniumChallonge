import java.util.Random;
public class RandomVar {

    public static String getRandomAMPM() {
        Random random = new Random();
        int randomInt = random.nextInt(2); // Generates a random integer: 0 or 1

        // Return "AM" if randomInt is 0, otherwise return "PM"
        return randomInt == 0 ? " AM" : " PM";
    }
    public static int generateRandomIntInRange(int min, int max) {
        Random random = new Random();
        // Generate a random integer within the specified range
        return random.nextInt((max - min) + 1) + min;
    }

    public static String generateRandomText(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // Generate a random lowercase letter
            char randomChar = (char) ('a' + random.nextInt(26));
            sb.append(randomChar);
        }

        // Return the generated random text
        return sb.toString();
    }

    public static String generateRandomDate() {
        String randomDate = "";
        int min = 1;

        // Generate random values for year, month, day, hour, and minutes
        int year = generateRandomIntInRange(2023, 2024);
        int month = generateRandomIntInRange(min, 12);
        int day = generateRandomIntInRange(min, 29);
        int hour = generateRandomIntInRange(min, 23);
        int minutes = generateRandomIntInRange(min, 59);

        // Construct the random date string in the desired format
        randomDate = randomDate + Integer.toString(year);
        randomDate = randomDate + "/" + Integer.toString(month);
        randomDate = randomDate + "/" + Integer.toString(day);
        randomDate = randomDate + " " + Integer.toString(hour);
        randomDate = randomDate + ":" + Integer.toString(minutes) + getRandomAMPM();;

        // Return the generated random date string
        return randomDate;
    }

}
