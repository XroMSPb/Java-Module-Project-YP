public class Formatter {
    private static int roundRubles(double rubles){
        return (int) Math.floor(rubles);
    }

    public static String formatRubles(double sumOfRubles){
        String formattedRubles;
        if (10 < roundRubles(sumOfRubles) && roundRubles(sumOfRubles) < 15)
            formattedRubles = "лей";
        else
            switch (roundRubles(sumOfRubles) % 10) {
                case 1 -> formattedRubles = "ль";
                case 2, 3, 4 -> formattedRubles = "ля";
                default -> formattedRubles = "лей";
            }
        return formattedRubles;
    }
}
