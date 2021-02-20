package Practicum6.a;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;

    Persoon(String naam, double budget){
        this.naam = naam;
        this.budget = budget;
        mijnGames = new ArrayList<Game>();
    }

    public double getBudget(){
        return budget;
    }

    public boolean koop(Game game){
//        System.out.println(mijnGames);
//        System.out.println(game);
        for (int i=0; i < mijnGames.size(); i++) {
//            System.out.println(mijnGames.get(i));
//            System.out.println(game.getNaam());
            if (mijnGames.get(i).equals(game.getNaam()) && mijnGames.get(i).equals(game.getReleaseJaar())){
//                System.out.println("niet gelukt");
                return false;
            }
        }
        if (game.huidigeWaarde() < budget){
            this.budget -= game.huidigeWaarde();
            mijnGames.add(game);
            return true;
        }
        return false;
    }

    public boolean verkoop (Game game, Persoon koper) {
        for (int i = 0; i < mijnGames.size(); i++) {
            if (mijnGames.get(i).equals(game.getNaam()) && mijnGames.get(i).equals(game.getReleaseJaar())) {
                if (koper.mijnGames.size() == 0){
                    if (koper.budget > game.huidigeWaarde()) {
                        koper.budget -= game.huidigeWaarde();
                        budget += game.huidigeWaarde();
                        mijnGames.remove(game);
                        koper.mijnGames.add(game);
                        return true;
                    }
                }
                for (Game game2 : koper.mijnGames) {
                    if (game2.equals(game.getNaam()) && game2.equals(game.getReleaseJaar())) {
                    } else {
                        if (koper.budget > game.huidigeWaarde()) { ;
                            koper.budget -= game.huidigeWaarde();
                            budget += game.huidigeWaarde();
                            mijnGames.remove(game);
                            koper.mijnGames.add(game);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(naam + " heeft een budget van €" + String.format("%.2f", getBudget()) + " en bezit de volgende games:");
        if (mijnGames.size() == 0){
            return s.toString();
        }
        s.append("\n");
        for (int i=0; i <mijnGames.size();i++){
            s.append(mijnGames.get(i));
            if (i != mijnGames.size()-1){
                s.append("\n");
            }
        }
        return s.toString();
    }
}
