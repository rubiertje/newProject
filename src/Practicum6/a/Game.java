package Practicum6.a;


import java.time.LocalDate;
import java.util.Objects;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    Game(String naam, int releaseJaar, double nieuwprijs){
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.nieuwprijs = nieuwprijs;
    }

    public String getNaam() {
        return naam;
    }

    public int getReleaseJaar() {
        return releaseJaar;
    }

    public double huidigeWaarde(){
        int jaarDaling = LocalDate.now().getYear() - releaseJaar;
        double prijs = nieuwprijs;
        for (int i=0; i<jaarDaling; i++){
            prijs *= 0.7;
        }
        return prijs;
    }

    public boolean equals(Object andereObject){
        boolean s = false;
        String k = andereObject.toString();
//        System.out.println("START");
//        System.out.println(andereObject);
//        System.out.println(getNaam());
//        System.out.println(strreleasejaar);
        if (andereObject == getNaam() || andereObject.equals(releaseJaar)){
            s = true;
        }
        try{
            String geheleString = andereObject.toString();
            String strreleasejaar = String.valueOf(releaseJaar);
            int indexcomma = geheleString.indexOf(",");
            int indexpuntcomma = geheleString.indexOf(";");
            String naam = geheleString.substring(0, indexcomma);
            String releasjaar = geheleString.substring(indexcomma+16, indexpuntcomma);
//            System.out.println("IN DE TRY");
//            System.out.println("mijn string: " + toString());
//            System.out.println("mijn naam: "+ getNaam());
//            System.out.println("mijn jaar: "+ strreleasejaar);
//            System.out.println("andere object: "+geheleString);
//            System.out.println("naam andereobject: "+ naam);
//            System.out.println("releasejaar andereobject: "+ releasjaar);
            //                System.out.println("return true");
            //                System.out.println("return false");
            return Objects.equals(getNaam(), naam) && Objects.equals(strreleasejaar, releasjaar);
        }catch (Exception ignored){}
        return s;
    }

    public String toString() {
        return naam + ", uitgegeven in " + releaseJaar + "; nieuwprijs: €" + String.format("%.2f", nieuwprijs) + " nu voor: €" + String.format("%.2f", huidigeWaarde());
    }
}
