package depo;

import java.time.LocalDate;
import java.util.*;

public class UrunService
{
    Scanner scan = new Scanner(System.in);
    Map<String,Urun> urunler = new LinkedHashMap<>();

    public UrunService() {
        Urun un = new Urun(null,"UN", "HEKIMOGLU",100,"cuval", "RAF1");
        Urun sut = new Urun(null,"SUT", "HEKIMOGLU",100,"kutu", "RAF2");
       idTanimla(un);
       urunler.put(un.getId(), un);
       idTanimla(sut);
       urunler.put(sut.getId(), sut);
    }

    public void idTanimla( Urun urun){
        urun.setId(urun.getUrunIsmi().substring(0,2)+LocalDate.now().getYear()+Urun.getCounter());
        Urun.setCounter(Urun.getCounter()+1);
    }

    public void urunTanimlama(){
        Urun urun = new Urun(null,null,null,0,null,null);
        System.out.println("Urun ismi giriniz:");
        String urunIsim = scan.nextLine().toUpperCase();
        System.out.println("Uretici ismi giriniz:");
        String ureticiIsim = scan.nextLine().toUpperCase();
        System.out.println("Urun miktarını giriniz:");
        int miktar = scan.nextInt();
        scan.nextLine();
        System.out.println("Urun icin birim giriniz:");
        String birim = scan.nextLine().toLowerCase();


        //urunu set edelim

        urun.setUrunIsmi(urunIsim);
        urun.setUretici(ureticiIsim);
        urun.setMiktar(miktar);
        urun.setBirim(birim);
        idTanimla(urun);
        if (!this.urunler.containsKey(urun.getId())){
            this.urunler.put(urun.getId(), urun);
        }else {
            System.out.println("Bu urun sistemde kayıtlı. Urun girisi ile güncelleme yapabilir veya konrol edip yeniden deneyebilirsiniz.");
        }

    }
    public void urunListele(Map<String,Urun> urunler){
        System.out.printf("%-15s %-12s %-15s %-7s %-10s %-10s%n"," URUN ID ","URUN ISMI ", "URETICI ISMI ","MIKTAR ","BIRIM  "," RAF   ");
        System.out.printf("%-15s %-12s %-15s %-7s %-10s %-10s%n"," ------- ","--------- ","------------ ","------ ","-----  ","----    ");
        List<Urun> urunValue =new ArrayList<>(urunler.values());
        for (Urun urun : urunValue){
            System.out.printf("%-15s %-12s %-15s %-7s %-10s %-10s%n",urun.getId(),urun.getUrunIsmi(),urun.getUretici(),urun.getMiktar(),urun.getBirim(),urun.getRaf());
        }
    }
    public void urunGirisi(Map<String,Urun> urunler){
        System.out.println("Urun id giriniz.");
        String id = scan.nextLine();
        if (urunler.containsKey(id)){
            System.out.println("Ekleyeceginiz urun miktarını giriniz");
            int miktar = scan.nextInt();
            urunler.get(id).setMiktar(urunler.get(id).getMiktar()+miktar);
        }else {
            System.out.println("Girdiginiz id kayıtlı degil. Listeden id konrol edip tekrar deneyiniz.");
        }
    }
    public void urunRafaKoy(Map<String,Urun> urunler){
        System.out.println("Urun id giriniz");
        String id = scan.nextLine();
        if (urunler.containsKey(id)){
            System.out.println("Urunler için raf no giriniz");
            int rafNo = scan.nextInt();
            urunler.get(id).setRaf("RAF"+rafNo);
        }else {
            System.out.println("Girdiginiz id kayıtlı degil. Listeden id konrol edip tekrar deneyiniz.");
        }
    }
    public void urunCikisi(Map<String,Urun> urunler){
        System.out.println("Urun cıkısı icin id giriniz");
        String id = scan.nextLine();
        if (urunler.containsKey(id)){
            System.out.println("Cıkıs için miktar belirleyiniz");
            int miktar = scan.nextInt();
            if (miktar <= urunler.get(id).getMiktar()){
                urunler.get(id).setMiktar(urunler.get(id).getMiktar()-miktar);
                System.out.println(urunler.get(id).getUrunIsmi()+ "--> Kalan miktar: "+urunler.get(id).getMiktar()+" "+urunler.get(id).getBirim());
            } else {
                System.out.println("Depoda yeterli miktarda urun yok!");
                System.out.println("En fazla "+urunler.get(id).getMiktar() +" adet urun cıkısı yapabilirsiniz.");

            }

        }else {
            System.out.println("Girdiginiz id kayıtlı degil. Listeden id konrol edip tekrar deneyiniz.");
        }
    }

}
