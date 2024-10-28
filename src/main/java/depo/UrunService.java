package depo;

import java.util.*;

public class UrunService
{
    Scanner scan = new Scanner(System.in);
    Map<Integer,Urun> urunler = new TreeMap<>();

    public UrunService() {
        Urun un = new Urun(1001,"UN", "HEKIMOGLU",100,"cuval", "RAF1");
        Urun sut = new Urun(1002,"SUT", "HEKIMOGLU",100,"kutu", "RAF2");
        urunler.put(un.getId(), un);
        urunler.put(sut.getId(), sut);
    }


    public void urunTanimlama(){
        Urun urun = new Urun(0,null,null,0,null,null);
        System.out.println("Urun id giriniz:");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Urun ismi giriniz:");
        String urunIsim = scan.nextLine().toUpperCase();
        System.out.println("Uretici ismi giriniz:");
        String ureticiIsim = scan.nextLine().toUpperCase();
        System.out.println("Urun miktarını giriniz:");
        int miktar = scan.nextInt();
        scan.nextLine();
        System.out.println("Urun icin birim giriniz:");
        String birim = scan.nextLine().toLowerCase();
 //       System.out.println("Urun icin raf belirleyiniz:");   //rafa koymayı method ile yapacağız
 //       String raf = scan.nextLine().toUpperCase();

        //urunu set edelim
        urun.setId(id);
        urun.setUrunIsmi(urunIsim);
        urun.setUretici(ureticiIsim);
        urun.setMiktar(miktar);
        urun.setBirim(birim);
  //      urun.setRaf(raf);
        if (!this.urunler.containsKey(urun.getId())){
            this.urunler.put(urun.getId(), urun);
        }else {
            System.out.println("Bu urun sistemde kayıtlı. Urun girisi ile güncelleme yapabilir veya konrol edip yeniden deneyebilirsiniz.");
        }

    }
    public void urunListele(Map<Integer,Urun> urunler){
        System.out.printf("%-7s %-12s %-15s %-7s %-10s %-10s%n"," id  ","URUN ISMI ", "URETICI ISMI ","MIKTAR ","BIRIM  ","" +
                "RAF   ");
        System.out.printf("%-7s %-12s %-15s %-7s %-10s %-10s%n","---- ","--------- ","------------ ","------ ","-----  ","----    ");
        List<Urun> urunValue =new ArrayList<>(urunler.values());
        for (Urun urun : urunValue){
            System.out.printf("%-7s %-12s %-15s %-7s %-10s %-10s%n",urun.getId(),urun.getUrunIsmi(),urun.getUretici(),urun.getMiktar(),urun.getBirim(),urun.getRaf());
        }
    }
    public void urunGirisi(Map<Integer,Urun> urunler){
        System.out.println("Urun id giriniz.");
        int id = scan.nextInt();
        if (urunler.containsKey(id)){
            System.out.println("Ekleyeceginiz urun miktarını giriniz");
            int miktar = scan.nextInt();
            urunler.get(id).setMiktar(urunler.get(id).getMiktar()+miktar);
        }else {
            System.out.println("Girdiginiz id kayıtlı degil. Listeden id konrol edip tekrar deneyiniz.");
        }
    }
    public void urunRafaKoy(Map<Integer,Urun> urunler){
        System.out.println("Urun id giriniz");
        int id = scan.nextInt();
        if (urunler.containsKey(id)){
            System.out.println("Urunler için raf no giriniz");
            int rafNo = scan.nextInt();
            urunler.get(id).setRaf("RAF"+rafNo);
        }else {
            System.out.println("Girdiginiz id kayıtlı degil. Listeden id konrol edip tekrar deneyiniz.");
        }
    }
    public void urunCikisi(Map<Integer,Urun> urunler){
        System.out.println("Urun cıkısı icin id giriniz");
        int id = scan.nextInt();
        if (urunler.containsKey(id)){
            System.out.println("Cıkıs için miktar belirleyiniz");
            int miktar = scan.nextInt();
            if (miktar <= urunler.get(id).getMiktar()){
                urunler.get(id).setMiktar(urunler.get(id).getMiktar()-miktar);
                System.out.println(urunler.get(id).getUrunIsmi()+ "--> Kalan miktar: "+urunler.get(id).getMiktar());
            } else {
                System.out.println("Depoda yeterli miktarda urun yok!");
                System.out.println("En fazla "+urunler.get(id).getMiktar() +" adet urun cıkısı yapabilirsiniz.");

            }

        }else {
            System.out.println("Girdiginiz id kayıtlı degil. Listeden id konrol edip tekrar deneyiniz.");
        }
    }

}
