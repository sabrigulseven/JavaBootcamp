package com.godoro.consoleApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanChoice();
            try {
                handleChoice(choice);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private static void handleChoice(int choice) throws IOException {
        System.out.println("Kotarılıyor : " + choice);
        switch (choice) {

            case 1:
                new Thread(() -> {
                    try {
                        doLoad();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                        .start();

                break;
            case 2:
                new Thread(() -> {
                    try {
                        doStore();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                        .start();

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

    private static void doLoad() throws IOException {
        SupplierFiler supplierFiler = openPath();
        supplierList = supplierFiler.load();

    }

    private static SupplierFiler openPath() {
        String path = "C:\\Users\\Sabri\\Desktop\\workspace\\Suppliers.txt";
        SupplierFiler supplierFiler = new SupplierFiler(path);
        return supplierFiler;
    }

    private static void doStore() throws IOException {
        SupplierFiler supplierFiler = openPath();
        supplierFiler.store(supplierList);

    }

    private static void doList() {
        for (Supplier supplier : supplierList) {
            System.out.println(supplier.getSupplierId() + " "
                    + supplier.getSupplierName() + " "
                    + supplier.getTotalCredit());
        }
    }

    private static void doFind() {
        System.out.println("Bulmak istediğiniz satıcının ID numarasını giriniz: ");
        long l = scanner.nextLong();
        Supplier supplier = find(supplierList, l);
        if (supplier == null) {
            System.out.println("Satıcı bulunamadı.");
        } else {
            System.out.println(supplier.getSupplierId() + " "
                    + supplier.getSupplierName() + " "
                    + supplier.getTotalCredit());
        }
    }

    private static Supplier find(List<Supplier> supplierList, long supplierId) {
        for (Supplier supplier : supplierList) {
            if (supplier.getSupplierId() == supplierId) {
                return supplier;
            }
        }
        return null;
    }

    private static void doAdd() throws IOException {
        System.out.println("Eklemek istediğiniz Satıcının: ");
        System.out.println("ID numarasını giriniz.");
        long l = scanner.nextLong();
        System.out.println("Adını ve Soyadını giriniz: ");
        String s = scanner.nextLine();
        System.out.println("Toplam Kredisini giriniz: ");
        double d = scanner.nextDouble();
        Supplier supplier = new Supplier(l, s, d);
        supplierList.add(supplier);
        doStore();

    }

    private static void doUpdate() {
        System.out.println("Değiştirmek istediğiniz Satıcının: ");
        System.out.println("ID numarasını giriniz.");
        long l = scanner.nextLong();
        System.out.println("Yeni Adını ve Soyadını giriniz: ");
        String s = scanner.nextLine();
        System.out.println("Yeni Toplam Kredisini giriniz: ");
        double d = scanner.nextDouble();
        Supplier supplier = find(supplierList, l);
        if (supplier == null) {
            System.out.println("Satıcı bulunamadı.");
        } else {
            supplier.setSupplierName(s);
            supplier.setTotalCredit(d);
        }
    }

    private static void doDelete() {
        System.out.println("Silmek istediğiniz Satıcının: ");
        System.out.println("ID numarasını giriniz.");
        long l = scanner.nextLong();
        Supplier supplier = find(supplierList, l);
        if (supplier == null) {
            System.out.println("Satıcı bulunamadı.");
        } else {
            supplierList.remove(supplier);
        }
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
        System.out.println("-------------------------");
        System.out.println("Menü:");
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
        System.out.println();
    }

    private static Scanner scanner = new Scanner(System.in);
    private static List<Supplier> supplierList = new ArrayList<>();
}
