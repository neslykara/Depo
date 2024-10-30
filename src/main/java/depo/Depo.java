package depo;

import java.util.Map;
import java.util.Scanner;

public class Depo
{
    public static void main(String[] args)
    {
        start();

    }

    private static void start()
    {
        Scanner scan = new Scanner(System.in);
        UrunService urunService = new UrunService();

        int select;

        do {
            System.out.println("Yapmak istediginiz islem icin secim yapınız");
            System.out.println("1-Urun Tanımlama");
            System.out.println("2-Urun Listeleme");
            System.out.println("3-Urun Girisi");
            System.out.println("4-Urun RafaKoy");
            System.out.println("5-Urun Cıkıs");
            System.out.println("0-CIKIS");
            select = scan.nextInt();

            if (select == 1){

                urunService.urunTanimlama();
                System.out.println("1- ANA MENÜ");
                int devam = scan.nextInt();

            } else if (select == 2) {

                urunService.urunListele(urunService.urunler);
                System.out.println("1- ANA MENU");
                int devam = scan.nextInt();

            } else if (select == 3) {
                urunService.urunGirisi(urunService.urunler);
                System.out.println("1- ANA MENÜ");
                int devam = scan.nextInt();

            } else if (select == 4) {
                urunService.urunRafaKoy(urunService.urunler);
                System.out.println("1- ANA MENÜ");
                int devam = scan.nextInt();

            } else if (select == 5) {
                urunService.urunCikisi(urunService.urunler);
                System.out.println("1- ANA MENÜ");
                int devam = scan.nextInt();

            } else if (select == 0) {
                System.out.println("Güvenli çıkısınız saglanıyor...\n İYİ GÜNLER DİLERİZ.");

            } else {
                System.out.println("Hatalı giris yaptınız.Tekrar deneyiniz");
            }
        }while (select != 0);

    }
}
