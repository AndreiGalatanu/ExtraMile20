public enum DensityLevel {

    HIGH,
    AVERAGE,
    LOW;


    public static DensityLevel calculateDensity(long density) {
        if (density >= 1000) {
            return HIGH;
        } else if (density < 200) {
            return AVERAGE;
        } else {
            return LOW;
        }
    }

    }
