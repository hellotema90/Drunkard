package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Card {
    private int nominate;
    private String descriptionNominate;
    private String descriptionSuits;

    @Override
    public String toString() {
        return "Card{" +
                "nominate=" + nominate +
                ", descriptionNominate='" + descriptionNominate + '\'' +
                ", descriptionSuits='" + descriptionSuits + '\'' +
                '}';
    }
}