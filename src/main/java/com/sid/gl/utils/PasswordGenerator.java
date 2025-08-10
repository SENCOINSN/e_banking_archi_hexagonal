package com.sid.gl.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "@$!%*?&";
    private static final String ALL = UPPERCASE + LOWERCASE + LOWERCASE + DIGITS + SPECIALS;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generatePassword() {
        int length = RANDOM.nextInt(13) + 8; // longueur entre 8 et 20

        List<Character> passwordChars = new ArrayList<>();

        // Au moins un caractère de chaque type requis
        passwordChars.add(getRandomChar(UPPERCASE));
        passwordChars.add(getRandomChar(DIGITS));
        passwordChars.add(getRandomChar(SPECIALS));

        // Compléter le reste avec des caractères aléatoires
        for (int i = passwordChars.size(); i < length; i++) {
            passwordChars.add(getRandomChar(ALL));
        }

        // Mélanger les caractères
        Collections.shuffle(passwordChars, RANDOM);

        // Construire le mot de passe
        StringBuilder password = new StringBuilder();
        for (char c : passwordChars) {
            password.append(c);
        }

        return password.toString();
    }

    private static char getRandomChar(String characters) {
        return characters.charAt(RANDOM.nextInt(characters.length()));
    }
}
