package com.mercadolivre.MorseCode.classes;

public class Symbols {

    private final char Portuguese;
    private final String MorseCode;

    Symbols(char Portuguese, String MorseCode) {
        this.Portuguese = Portuguese;
        this.MorseCode = MorseCode;
    }

    public char getPortuguese() {
        return Portuguese;
    }

    public String getMorseCode() {
        return MorseCode;
    }

    public static Symbols[] getSymbols() {
        return SYMBOLS;
    }

    private static final Symbols[] SYMBOLS = new Symbols[] {
            new Symbols('A', ".-"),
            new Symbols('B', "-..."),
            new Symbols('C', "-.-."),
            new Symbols('D', "-.."),
            new Symbols('E', "."),
            new Symbols('F', "..-."),
            new Symbols('G', "--."),
            new Symbols('H', "...."),
            new Symbols('I', ".."),
            new Symbols('J', ".---"),
            new Symbols('K', "-.-"),
            new Symbols('L', ".-.."),
            new Symbols('M', "--"),
            new Symbols('N', "-."),
            new Symbols('O', "---"),
            new Symbols('P', ".--."),
            new Symbols('Q', "--.-"),
            new Symbols('R', ".-."),
            new Symbols('S', "..."),
            new Symbols('T', "-"),
            new Symbols('U', "..-"),
            new Symbols('V', "...-"),
            new Symbols('W', ".--"),
            new Symbols('X', "-..-"),
            new Symbols('Y', "-.--"),
            new Symbols('Z', "--.."),
            new Symbols('0', "-----"),
            new Symbols('1', ".---"),
            new Symbols('2', "..---"),
            new Symbols('3', "...--"),
            new Symbols('4', "....-"),
            new Symbols('5', "....."),
            new Symbols('6', "-...."),
            new Symbols('7', "--..."),
            new Symbols('8', "---.."),
            new Symbols('9', "----."),
            new Symbols(' ', "   ")
    };
}
