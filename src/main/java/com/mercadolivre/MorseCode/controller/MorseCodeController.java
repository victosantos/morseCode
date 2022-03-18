package com.mercadolivre.MorseCode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mercadolivre.MorseCode.classes.Symbols;

@RestController
public final class MorseCodeController {
    @GetMapping("/TranslatePortugueseToMorseCode")
    public String TranslatePortugueseToMorseCode(@RequestParam(value = "phrase",
            defaultValue = "Ola Mundo!") String phrase){
        return MorseCodeController.MorseCode(phrase);
    }

    @GetMapping("/TranslateMorseCodeToPortuguese")
    public String TranslateMorseCodeToPortuguese(@RequestParam(value = "phrase",
            defaultValue = "--- .-.. .-   -- ..- -. -.. --- -.-.--") String phrase){
        return MorseCodeController.Portuguese(phrase);
    }

    public static String MorseCode(String phrase) {
        System.out.println(phrase.toUpperCase().toCharArray());
        StringBuilder morseText = new StringBuilder();
        for (char letter : phrase.toUpperCase().toCharArray()) {
            if (morseText.length() > 0) {
                morseText.append(" ");
            }
            System.out.println(letter);
            morseText.append(portuegueseLetter(letter));
        }
        return morseText.toString();
    }

    public static String Portuguese(String morse) {
        StringBuilder normalText = new StringBuilder();
        String[] morseWords = morse.split("\\Q   \\E");
        for (String morseWord : morseWords) {
            if (normalText.length() > 0) {
                normalText.append(" ");
            }
            String[] morseLetters = morseWord.trim().split(" ");
            for (String morseLetter : morseLetters) {
                normalText.append(MorseLetter(morseLetter));
            }
        }
        return normalText.toString();
    }

    private static String portuegueseLetter(char letter) {
        for (Symbols symbol : Symbols.getSymbols()) {
            if (symbol.getPortuguese() == letter) {
                return symbol.getMorseCode();
            }
        }
        throw new IllegalArgumentException("Símbolo inválido: \"" + letter + "\"");
    }

    private static char MorseLetter(String morse) {
        for (Symbols symbol : Symbols.getSymbols()) {
            if (symbol.getMorseCode().equals(morse)) {
                return symbol.getPortuguese();
            }
        }
        throw new IllegalArgumentException("Símbolo inválido: \"" + morse + "\"");
    }
}
