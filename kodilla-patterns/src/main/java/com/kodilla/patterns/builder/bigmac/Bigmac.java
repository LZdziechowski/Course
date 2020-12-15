package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    private final boolean bunSesame;
    private final int numberOfBurgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    private Bigmac(final boolean bunSesame, final int numberOfBurgers, final Sauce sauce, final List<Ingredient> ingredients) {
        this.bunSesame = bunSesame;
        this.numberOfBurgers = numberOfBurgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public static final class BigmacBuilder {
        private boolean bunSesame;
        private int numberOfBurgers;
        private Sauce sauce;
        private final List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder bunSesame(boolean bunSesame) {
            this.bunSesame = bunSesame;
            return this;
        }

        public BigmacBuilder numberOfBurgers(int numberOfBurgers) {
            this.numberOfBurgers = numberOfBurgers;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bunSesame, numberOfBurgers, sauce, ingredients);
        }
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bunSesame=" + bunSesame +
                ", numberOfBurgers=" + numberOfBurgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }

    public boolean isBunSesame() {
        return bunSesame;
    }

    public int getNumberOfBurgers() {
        return numberOfBurgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
