package com.tms.spring.service;

import com.tms.spring.domain.Pair;
import com.tms.spring.domain.Player;

import java.util.List;

public class HorseRacingServiceImpl implements HorseRacingService{
    private final BetService betService;
    private Player player;

    public HorseRacingServiceImpl(BetService betService, Player player) {
        this.betService = betService;
        this.player = player;
    }

    @Override
    public void startRace(List<Pair> pairs) throws InterruptedException {
        for (int i = 0; i < pairs.size(); i++) {
            System.out.println("Pair " + (i + 1) + ":" + pairs.get(i));
        }

        int bet = betService.doBet();
        int choosePair = betService.choosePair();

        System.out.println("start race!");
        Pair leadPair = null;
        for (int i = 1; i < 6; i++) {
            System.out.println("Round " + i);
            System.out.println("Horses are running...");
            leadPair = processRound(pairs);
            System.out.println("Leading pair: " + leadPair);
        }
        System.out.println("Pair has just won: " + leadPair);
        Integer balance = player.getWallet().getBalance();
        if(leadPair.getNumber() == choosePair){
            balance = balance + bet;
        } else {
            balance = balance - bet;
        }
        player.getWallet().setBalance(balance);
        System.out.println("Your balance: " + balance);
    }

    private static Pair processRound(List<Pair> pairs) throws InterruptedException {
        for (Pair pair: pairs){
            pair.changeSpeed();
        }

        Double maxSpeed = 0.0;
        Pair leadPair = null;
        for (int j = 0; j < pairs.size(); j++) {
          if(maxSpeed < pairs.get(j).getSpeed()){
              maxSpeed = pairs.get(j).getSpeed();
              leadPair = pairs.get(j);
          }
        }
        Thread.sleep(5000);
        return leadPair;
    }
}
