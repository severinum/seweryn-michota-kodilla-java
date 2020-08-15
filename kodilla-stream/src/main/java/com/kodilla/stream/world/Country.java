package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final BigDecimal peopleQty;

    public Country(BigDecimal peopleQty) {
        this.peopleQty = peopleQty;
    }

    BigDecimal getPeopleQuantity(){
        return this.peopleQty;
    }
}
