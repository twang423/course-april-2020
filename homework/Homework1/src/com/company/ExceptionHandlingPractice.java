package com.company;

public class ExceptionHandlingPractice {
    public static void main(String[] args) {
        try {
            ExceptionHandler.handleException("amex", "abc");
        } catch (CardTypeException exception) {
            System.out.println(exception.toString());
            exception.printStackTrace();
        } catch (AddressException exception) {
            System.out.println(exception.toString());
            exception.printStackTrace();
        }
    }
}

class CardTypeException extends Exception {
    @Override
    public String toString() {
        return super.toString();
    }
}

class AddressException extends Exception {
    @Override
    public String toString() {
        return super.toString();
    }
}

class ExceptionHandler {
    public static void handleException(String cardType, String address) throws CardTypeException, AddressException {
        if ("amex".equalsIgnoreCase(cardType)) {
            throw new CardTypeException();
        }
        if (!isInUS(address)) {
            throw new AddressException();
        }
    }
    private static boolean isInUS(String address) {
        return true;
    }
}
