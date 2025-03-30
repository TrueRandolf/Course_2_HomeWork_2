package org.skypro.skyshop.Exeptions;

public class BestResultNotFound extends IllegalArgumentException {
    public BestResultNotFound(String s) {
        super(s);
    }
}