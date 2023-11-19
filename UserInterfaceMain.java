import java.util.Scanner;

/**
 * contains the main method and responsible for outputting prompts to the user,
 * getting and validating user input, and creating objects and calling methods.
 */
class UserInterfaceMain {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        String prompt = """
                What would you like to do?
                1. Pretty print a baking measure.
                2. Convert metric volume to baking measure.""";

        int choice = Input.promptInt(prompt, scanner);

        switch (choice) {
            case 1:
                handlePrettyPrint();
                break;
            case 2:
                handleConvert();
                break;
            default:
                System.out.println("Invalid choice. Goodbye.");
                break;
        }

        scanner.close();
    }

    private static void handlePrettyPrint() {
        int cups = Input.promptInt("Enter the number of cups", scanner);
        int tablespoons = Input.promptInt("Enter the number of tablespoons", scanner);
        int teaspoons = Input.promptInt("Enter the number of teaspoons", scanner);

        if (cups < 0 || tablespoons < 0 || teaspoons < 0) {
            System.out.println("Invalid baking measure. Cannot have negative units.");
            return;
        }

        if (cups == 0 && tablespoons == 0 && teaspoons == 0) {
            System.out.println("Invalid baking measure. At least one unit must be greater than 0.");
            return;
        }

        BakingMeasure measure = new BakingMeasure(cups, tablespoons, teaspoons);
        measure.prettyPrint();
    }

    private static void handleConvert() {
        int milliliters = Input.promptInt("Enter the number of millilitres", scanner);

        if (milliliters <= 2) {
            System.out.println("Invalid millilitres. Must be greater than 2.");
            return;
        }

        System.out.println(milliliters + " millilitres in baking measures is:");

        MetricVolume volume = new MetricVolume(milliliters);
        BakingMeasure measure = volume.convert();
        measure.prettyPrint();
    }
}