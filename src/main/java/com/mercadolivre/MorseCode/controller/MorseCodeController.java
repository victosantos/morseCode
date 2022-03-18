package com.mercadolivre.MorseCode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mercadolivre.MorseCode.classes.Symbols;

@RestController
public final class MorseCodeController {
    @GetMapping("/TranslateMorseCodeToPortuguese")
    public String TranslateMorseCodeToPortuguese(@RequestParam(value = "phrase",
            defaultValue = "--- .-.. .- -- ..- -. -.. --- -.-.--") String phrase){
        return MorseCodeController.MorseCode(phrase);
    }

    @GetMapping("/TranslatePortugueseToMorseCode")
    public String TranslatePortugueseToMorseCode(@RequestParam(value = "phrase",
            defaultValue = "Olá Mundo!") String phrase){
        return MorseCodeController.Portuguese(phrase);
    }

    public static String MorseCode(String phrase) {
        StringBuilder textMorse = new StringBuilder();
        for (char letter : phrase.toUpperCase().toCharArray()) {
            if (textMorse.length() > 0) {
                textMorse.append(" ");
            }
            textMorse.append(ToMorse(letter));
        }
        return textMorse.toString();
    }

    public static String Portuguese(String morse) {
        StringBuilder textNormal = new StringBuilder();
        String[] palavrasMorse = morse.split("\\Q   \\E");
        for (String palavraMorse : palavrasMorse) {
            if (textNormal.length() > 0) {
                textNormal.append(" ");
            }
            String[] letrasMorse = palavraMorse.trim().split(" ");
            for (String letraMorse : letrasMorse) {
                textNormal.append(ToPortuguese(letraMorse));
            }
        }
        return textNormal.toString();
    }

    private static String ToMorse(char letter) {
        for (Symbols Symbol : Symbols.getSymbols()) {
            if (Symbol.getPortuguese() == letter) {
                return Symbol.getMorseCode();
            }
        }
        throw new IllegalArgumentException("Símbolo inválido: \"" + letter + "\"");
    }

    private static char ToPortuguese(String morse) {
        for (Symbols symbol : Symbols.getSymbols()) {
            if (symbol.getMorseCode().equals(morse)) {
                return symbol.getPortuguese();
            }
        }
        throw new IllegalArgumentException("Símbolo inválido: \"" + morse + "\"");
    }
}
