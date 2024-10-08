package com.ig2i.solutions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SolutionFileDelimiter {
    NB_TOUR("//NbTournees"),
    TOUR_NB_PARCELS("//IdTournes NbColis"),
    TOUR_PARCELS("//IdColis IdCommandeInColis NbProducts IdProd1 QtyProd1 IdProd2 QtyProd2 ...");

    private final String delimiter;
}
