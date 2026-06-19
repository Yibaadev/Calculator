package co.kozao.calculator.service;
import org.apache.commons.math3.util.CombinatoricsUtils;

public class calculatorService {

    public static double addition(double nbre1, double nbre2) {
        return nbre1 + nbre2;
    }

    public static double substraction(double nbre1, double nbre2) {
        return nbre1 - nbre2;
    }

    public static double multiplication(double nbre1, double nbre2) {
        return nbre1 * nbre2;
    }

    public static String division(double nbre1, double nbre2) {
        if (nbre2 == 0) {
            return "Erreur : impossible de diviser par zéro";
        } else {
            return String.valueOf(nbre1 / nbre2);
        }
    }

    public static double power(double nbre1, double nbre2) {
        return Math.pow(nbre1, nbre2);
    }

    public static String squaReoot(double nbre1) {
        if (nbre1 < 0) {
            return "Erreur : impossible de calculer la racine d'un nombre négatif";
        } else {
            return String.valueOf(Math.sqrt(nbre1));
        }
    }

    public static long factorial(int nbre1) {
        if (nbre1 < 0) {
            throw new IllegalArgumentException("Erreur : Factorielle d'un nombre négatif");
        }
        return CombinatoricsUtils.factorial(nbre1);
    }
}