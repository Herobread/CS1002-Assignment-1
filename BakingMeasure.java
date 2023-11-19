import java.util.ArrayList;

/**
 * The `BakingMeasure` class represents a baking measure expressed in cups,
 * tablespoons, and teaspoons.
 * It provides a method to 'pretty print' the measure with correct pluralities
 * and omissions.
 */
public class BakingMeasure {
    private int cups;
    private int tablespoons;
    private int teaspoons;

    /**
     * Creates a `BakingMeasure` object with the specified quantities of cups,
     * tablespoons, and teaspoons.
     *
     * @param cups        The number of cups in the baking measure.
     * @param tablespoons The number of tablespoons in the baking measure.
     * @param teaspoons   The number of teaspoons in the baking measure.
     */
    public BakingMeasure(int cups, int tablespoons, int teaspoons) {
        this.cups = cups;
        this.tablespoons = tablespoons;
        this.teaspoons = teaspoons;
    }

    /**
     * Formats and prints a list of measures, including cups, tablespoons, and
     * teaspoons.
     * If any of these measures are non-zero, they are included in the formatted
     * output.
     * Measures are separated by commas and the last measure is joined with "and."
     * If all measures are zero, it prints "Nothing is needed."
     */
    public void prettyPrint() {
        ArrayList<String> formattedMeasures = new ArrayList<>();

        // Formatting values one by one and adding them to formattedMeasures array to
        // join later
        if (cups != 0) {
            formattedMeasures.add(prettyPrintOneMeasure(cups, "cup"));
        }

        if (tablespoons != 0) {
            formattedMeasures.add(prettyPrintOneMeasure(tablespoons, "tablespoon"));
        }

        if (teaspoons != 0) {
            formattedMeasures.add(prettyPrintOneMeasure(teaspoons, "teaspoon"));
        }

        // Joining the formatted values: adding coma and/or "and" if needed
        String joinedOutput = "";

        switch (formattedMeasures.size()) {
            case 1:
                joinedOutput = formattedMeasures.get(0);
                break;
            case 2:
                joinedOutput = formattedMeasures.get(0) + " and " + formattedMeasures.get(1);
                break;
            case 3:
                joinedOutput = formattedMeasures.get(0) + ", " +
                        formattedMeasures.get(1) + " and " +
                        formattedMeasures.get(2);
                break;
            default:
                joinedOutput = "Nothing is needed";
                break;
        }

        System.out.println(joinedOutput);
    }

    /**
     * Formats a measure depending on the amount, making the string empty if there
     * are none.
     *
     * @param amount The amount of the measure.
     * @param name   The name of the measure.
     * @return A formatted string representing the measure.
     */
    private String prettyPrintOneMeasure(int amount, String name) {
        if (amount == 0) {
            return "";
        }

        if (amount == 1) {
            return amount + " " + name;
        }

        return amount + " " + name + "s";
    }
}
