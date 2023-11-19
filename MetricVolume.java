/**
 * The `MetricVolume` class represents a volume in milliliters and provides a
 * method to convert the volume into a `BakingMeasure`.
 */
public class MetricVolume {
    private int millilitres;

    /**
     * Creates a `MetricVolume` object with the specified volume in milliliters.
     *
     * @param milliliters The volume in milliliters.
     */
    public MetricVolume(int millilitres) {
        this.millilitres = millilitres;
    }

    /**
     * Converts a volume measurement in millilitres to a BakingMeasure, which is
     * represented in cups, tablespoons, and teaspoons.
     *
     * @return A BakingMeasure object containing the equivalent volume in cups,
     *         tablespoons, and teaspoons.
     */
    public BakingMeasure convert() {
        // Constant measures in millilitres
        final double TEASPOON_CAPACITY_ML = 4.9289d; // teaspoon = 4.9289 ml
        final int TEASPOONS_IN_TABLESPOONS = 3; // tablespoon = 14.7867 ml
        final int TABLESPOONS_IN_CUPS = 16; // cup = 236.5872 ml

        int teaspoons = (int) Math.round(millilitres / TEASPOON_CAPACITY_ML);

        // check how many teaspoons can be converted to tablespoons
        // and update teaspoon amount accordingly
        int tablespoons = teaspoons / TEASPOONS_IN_TABLESPOONS;
        teaspoons %= TEASPOONS_IN_TABLESPOONS;

        int cups = tablespoons / TABLESPOONS_IN_CUPS;
        tablespoons %= TABLESPOONS_IN_CUPS;

        return new BakingMeasure(cups, tablespoons, teaspoons);
    }
}
