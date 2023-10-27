package pl.dpotyralski.spockintroduction.strategy;

interface Promotion {

    Item apply(Item item);

    boolean enabled();

    int order();

}
