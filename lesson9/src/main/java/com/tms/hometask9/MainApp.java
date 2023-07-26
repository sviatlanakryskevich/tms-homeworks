package com.tms.hometask9;

import static com.tms.hometask9.Document.documentNumber;

public class MainApp {
    public static void main(String[] args) {
        DocumentService.showNumbers(documentNumber);
        DocumentService.replaceLetters(documentNumber);
        DocumentService.showLowerLetters(documentNumber);
        DocumentService.showUpperLetters(documentNumber);
        DocumentService.findMatch(documentNumber, "aMr");
        DocumentService.checkStartMatch(documentNumber, "555");
        DocumentService.checkEndMatch(documentNumber, "1a2b");
    }
}
