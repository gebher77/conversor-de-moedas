package br.com.converter.models;

public class Conversion {
private double conversion;
private String base;
private String target;
    public double getConversion() {
        return conversion;
    }

    public String getBase() {
        return base;
    }

    public String getTarget() {
        return target;
    }

    public Conversion(ConversionResult conversionResult){

    this.conversion = conversionResult.conversion_result();
    this.base = conversionResult.base_code();
    this.target = conversionResult.target_code();

}

    @Override
    public String toString() {
        return "Conversão: " + conversion;
    }
}
