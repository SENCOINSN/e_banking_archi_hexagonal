package com.sid.gl.utils;

public class CompteGenerateur {

    public static String generateCompte(String type, String codeAgence, String codeClient) {
        StringBuilder compte = new StringBuilder();
        compte.append(type).append("-");

        // Ensure codeAgence is 4 characters long
        if (codeAgence.length() < 4) {
            compte.append(String.format("%04d", Integer.parseInt(codeAgence)));
        } else {
            compte.append(codeAgence);
        }

        // Ensure codeClient is 6 characters long
        if (codeClient.length() < 6) {
            compte.append(String.format("%06d", Integer.parseInt(codeClient)));
        } else {
            compte.append(codeClient);
        }

        return compte.toString();
    }

    public static String generateRIB() {
        StringBuilder rib = new StringBuilder();
        rib.append("SN33"); // IBAN prefix for SEN
        rib.append(String.format("%02d", (int) (Math.random() * 100))); // Random 2 digits for control key
        rib.append("30002"); // Bank code (example)
        rib.append(String.format("%05d", (int) (Math.random() * 100000))); // Branch code
        rib.append(String.format("%011d", (int) (Math.random() * 10000000000L))); // Account number
        rib.append("00"); // RIB key

        return rib.toString();
    }

    public static String generateCodeAgence() {
        return String.format("%04d", (int) (Math.random() * 10000)); // Random 4 digits
    }

    public static String generateNumeroCompte(int length) {
        StringBuilder numeroCompte = new StringBuilder();
        for (int i = 0; i < length; i++) {
            numeroCompte.append((int) (Math.random() * 10)); // Random digit
        }
        return numeroCompte.toString();
    }

    public static String generateCodeClient() {
        return String.format("%06d", (int) (Math.random() * 1000000)); // Random 6 digits
    }
}
