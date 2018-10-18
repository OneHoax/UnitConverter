package andres.androidprojects.unitconverter;

public class Units {
    private double millimeter;
    private double centimeter;
    private double meter;
    private double inch;
    private double foot;

    public Units() {
        millimeter = 0;
        centimeter = 0;
        meter = 0;
        inch = 0;
        foot = 0;
    }

    public double getMillimeter() {
        return millimeter;
    }

    public double getCentimeter() {
        return centimeter;
    }

    public double getMeter() {
        return meter;
    }

    public double getInch() {
        return inch;
    }

    public double getFoot() {
        return foot;
    }

    public void convert(double input) {
        if (MainActivity.millimeter > 0) {
            millimeter = input;
            centimeter = input / 10;
            meter = input / 1000;
            inch = input * 0.0393701;
            foot = input * 0.00328084;
        } else if (MainActivity.centimeter > 0) {
            millimeter = input * 10;
            centimeter = input;
            meter = input / 100;
            inch = input * 0.393701;
            foot = input * 0.0328084;
        } else if (MainActivity.meter > 0) {
            millimeter = input * 1000;
            centimeter = input * 100;
            meter = input;
            inch = input * 39.3701;
            foot = input * 3.28084;
        } else if (MainActivity.inch > 0) {
            millimeter = input * 25.4;
            centimeter = input * 2.54;
            meter = input * 0.0254;
            inch = input;
            foot = input * 0.0833333;
        } else if (MainActivity.foot > 0) {
            millimeter = input * 304.8;
            centimeter = input * 30.48;
            meter = input * 0.3048;
            inch = input * 12;
            foot = input;
        }
        millimeter = (double)Math.round(millimeter * 1000) / 1000;
        centimeter = (double)Math.round(centimeter * 1000) / 1000;
        meter = (double)Math.round(meter * 1000) / 1000;
        inch = (double)Math.round(inch * 1000) / 1000;
        foot = (double)Math.round(foot * 1000) / 1000;
    }

    public void refresh() {
        millimeter = 0;
        centimeter = 0;
        meter = 0;
        inch = 0;
        foot = 0;
    }
}
