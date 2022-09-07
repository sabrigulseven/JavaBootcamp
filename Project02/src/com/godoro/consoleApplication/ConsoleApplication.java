package com.godoro.consoleApplication;


import java.util.Scanner;


public class ConsoleApplication {
    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanChoice();
            handleChoice(choice);
        }

    }

    private static void handleChoice(int choice) {
        System.out.println("Kotarılıyor : " + choice);
        switch (choice) {
            
            case 1:
                doLoad();
                break;
            case 2:
                doStore();
                break;
            case 3:
                doList();
                break;
            case 4:
                doFind();
                break;
            case 5:
                doAdd();
                break;
            case 6:
                doUpdate();
                break;
            case 7:
                doDelete();
                break;
            case 0:
                doExit();
                break;
            default:
                System.out.println("Geçersiz Seçim: " + choice);
        }
    }

    private static void doDelete() {
    }

    private static void doUpdate() {
    }

    private static void doAdd() {
    }

    private static void doFind() {
    }

    private static void doList() {
    }

    private static void doStore() {
    }

    private static void doLoad() {
    }

    private static void doExit() {
        System.exit(0);
    }

    private static int scanChoice() {
        int choice = scanner.nextInt();
        System.out.println("Seçilen: " + choice);
        return choice;
    }

    private static void printMenu() {
        System.out.println("Menü");
        System.out.println("1. Yükle");
        System.out.println("2. Sakla");
        System.out.println("3. Dizelgele");
        System.out.println("4. Bul");
        System.out.println("5. Ekle");
        System.out.println("6. Güncelle");
        System.out.println("7. Sil");
        System.out.println("0. Çık");
        System.out.println(" ");
        System.out.println("Seçiniz:");

    }

    private static Scanner scanner = new Scanner(System.in);
    //private List<Supplier> supplierList = new ArrayList<>();
}
