package org.example;

import java.util.*;

public class Drunkard {
    private Set<Card> cardDeck = new HashSet<>();
    private final ArrayList<String> cardNominate =
            new ArrayList<>(Arrays.asList("6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"));
    private final ArrayList<String> cardSuits = new ArrayList<>(Arrays.asList("Крести", "Буби", "Пики", "Черви"));
    private ArrayList<Card> cardsPlayerOne;
    private ArrayList<Card> cardsPlayerTwo;

    private void addCardToDeck() {
        int countNominate = 0;
        int countSuits = 0;
        while (cardDeck.size() < 36) {
            if (countNominate == 9) {
                countNominate = 0;
            }
            if (countSuits == 4) {
                countSuits = 0;
            }
            cardDeck.add(new Card(countNominate, cardNominate.get(countNominate), cardSuits.get(countSuits)));
            countNominate++;
            countSuits++;
        }
    }

    private void addCardToPlayers() {
        List<Card> cardSplit = new ArrayList<>(cardDeck);
        Collections.shuffle(cardSplit);
        cardsPlayerOne = new ArrayList<>(cardSplit.subList(0, (cardSplit.size() + 1) / 2));
        cardsPlayerTwo = new ArrayList<>(cardSplit.subList(((cardSplit.size() + 1) / 2), cardSplit.size()));
    }

    private void gamerWin(ArrayList<Card> winner, ArrayList<Card> loser, int i) {
        winner.add(0, winner.get(winner.size() - 1));
        winner.remove(winner.size() - 1);
        if (loser.size() > i) {
            winner.add(0, loser.get(loser.size() - 1));
            loser.remove(loser.size() - 1);
        } else if (loser.size() == 0) {

        } else {
            winner.add(0, loser.get(loser.size() - 1));
            loser.remove(0);
        }
    }

    public void game() {
        addCardToDeck();
        addCardToPlayers();
        int move = 1, numberOfEquals = 1;
        Card getCardPlayerOne, getCardPlayerTwo;
        while (true) {
            if (cardsPlayerOne.size() < numberOfEquals) {
                getCardPlayerOne = cardsPlayerOne.get(cardsPlayerOne.size() - 1);
                getCardPlayerTwo = cardsPlayerTwo.get(cardsPlayerTwo.size() - numberOfEquals);
            } else if (cardsPlayerTwo.size() < numberOfEquals) {
                getCardPlayerOne = cardsPlayerOne.get(cardsPlayerOne.size() - numberOfEquals);
                getCardPlayerTwo = cardsPlayerTwo.get(cardsPlayerTwo.size() - 1);
            } else {
                getCardPlayerOne = cardsPlayerOne.get(cardsPlayerOne.size() - numberOfEquals);
                getCardPlayerTwo = cardsPlayerTwo.get(cardsPlayerTwo.size() - numberOfEquals);
            }
            Integer gameCardPlayerOne = getCardPlayerOne.getNominate();
            Integer gameCardPlayerTwo = getCardPlayerTwo.getNominate();
            System.out.println();
            System.out.println("Ход " + move++);

            int result = gameCardPlayerOne.compareTo(gameCardPlayerTwo);
            if (result == 0) {
                System.out.println(getCardPlayerOne + " = " + getCardPlayerTwo);
                System.out.println("Карты равны");
                numberOfEquals++;
            }
            if (result > 0) {
                System.out.println(getCardPlayerOne + " > " + getCardPlayerTwo);
                checkWhoWin(numberOfEquals, result, cardsPlayerOne, cardsPlayerTwo);
                numberOfEquals = 1;
                if (cardsPlayerOne.size() == 0 || cardsPlayerTwo.size() == 0) {
                    break;
                }
            }
            if (result < 0) {
                System.out.println(getCardPlayerOne + " < " + getCardPlayerTwo);
                checkWhoWin(numberOfEquals, result, cardsPlayerOne, cardsPlayerTwo);
                numberOfEquals = 1;
                if (cardsPlayerOne.size() == 0 || cardsPlayerTwo.size() == 0) {
                    break;
                }
            }
        }
        System.out.println("Игра завершена");
    }

    public void checkWhoWin(int numberOfEquals, int result, ArrayList<Card> cardsPlayerOne, ArrayList<Card> cardsPlayerTwo) {
        if (result > 0) {
            for (int i = 1; i <= numberOfEquals; i++) {
                gamerWin(cardsPlayerOne, cardsPlayerTwo, i);
            }
            System.out.println("Игрок один победил");
        }
        if (result < 0) {
            for (int i = 1; i <= numberOfEquals; i++) {
                gamerWin(cardsPlayerTwo, cardsPlayerOne, i);
            }
            System.out.println("Игрок два победил");
        }
    }
}



