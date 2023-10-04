package com.tms.spring.service;

import com.tms.spring.domain.Pair;
import com.tms.spring.domain.Wallet;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Data
@Service
public class BetServiceImpl implements BetService {
    private List<Pair> pairs;
    private Wallet wallet;

    public BetServiceImpl(List<Pair> pairs, Wallet wallet) {
        this.pairs = pairs;
        this.wallet = wallet;
    }

    @Override
    public int doBet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your bet amount:  ");
        int bet = scanner.nextInt();
        if((bet > 0) && (bet <= wallet.getBalance())){
            return bet;
        } else{
            return doBet();
        }
    }

    @Override
    public int choosePair() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a pair:  ");
        int myChoosePair = scanner.nextInt();
        if((myChoosePair > 0) && (myChoosePair <= pairs.size())){
            return myChoosePair;
        }else {
            return choosePair();
        }
    }
}
