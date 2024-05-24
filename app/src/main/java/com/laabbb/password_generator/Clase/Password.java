package com.laabbb.password_generator.Clase;

import java.util.Random;

public class Password {

    public static String generarRandomPassword(int progress, boolean letra_Mayus, boolean letra_Minus, boolean Num, boolean simbol) {
            String Caracteres = "";
            if (letra_Mayus) {
                Caracteres += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            }
            if (letra_Minus) {
                Caracteres += "abcdefghijklmnopqrstuvwxyz";
            }
            if (Num) {
                Caracteres += "0123456789";
            }
            if (simbol) {
                Caracteres += "!@#$%^&*()-_=+";
            }

            String password = "";
            int pos;
            Random r = new Random();

            for (int i = 0; i < progress; i++) {
                pos = r.nextInt(Caracteres.length());
                password += Caracteres.charAt(pos);

            }

            return password.toString();
    }

}
