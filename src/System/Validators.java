package System;

public class Validators {

    // Customer validators
    static String customerNameValidator = "^[\\p{IsLatin}]{2,}([ ]{1}[\\p{IsLatin}]++)*$";
    static String customerPhoneValidator = "^[0-9]++([-]{1}[0-9]++)*$";
    static String customerIdValidator = "^[0-9]{6,12}$";

    // Flight validators
    static String flightCodeValidator = "^[\\p{IsLatin}\\p{Digit}]{7}$";
    static String flightOrigDestValidator = "^[\\p{IsLatin}]{2,}([ ]{1}[\\p{IsLatin}]++)*$";

    // Plane validators
    static String airplaneNameValidator = "^[\\p{IsLatin}\\p{Digit}]{2,}([ ]{1}[\\p{IsLatin}\\p{Digit}]++)*$";
    static String airplaneCodeValidator = "^[a-zA-Z]{3}[-]{1}[0-9]{4}$";

}
