package com.tms.spring.service;

import com.tms.spring.domain.Pair;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data
@NoArgsConstructor
public class BetServiceImpl implements BetService {
    @Override
    public int doBet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your bet amount(min = 10):  ");
        int bet = scanner.nextInt();
        return bet;
    }

    @Override
    public int choosePair() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a pair:  ");
        int choosePair = scanner.nextInt();
        return choosePair;
    }
}
