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
/*
    public Card(int nominate, String descriptionNominate, String descriptionSuits) {
        this.nominate = nominate;
        this.descriptionNominate = descriptionNominate;
        this.descriptionSuits = descriptionSuits;
    }
/*
    public int getNominate() {
        return nominate;
    }

    public void setNominate(int nominate) {
        this.nominate = nominate;
    }

    public String getDescriptionNominate() {
        return descriptionNominate;
    }

    public void setDescriptionNominate(String descriptionNominate) {
        this.descriptionNominate = descriptionNominate;
    }

    public String getDescriptionSuits() {
        return descriptionSuits;
    }

    public void setDescriptionSuits(String descriptionSuits) {
        this.descriptionSuits = descriptionSuits;
    }



 */

    @Override
    public String toString() {
        return "Card{" +
                "nominate=" + nominate +
                ", descriptionNominate='" + descriptionNominate + '\'' +
                ", descriptionSuits='" + descriptionSuits + '\'' +
                '}';
    }

}
