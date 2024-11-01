public class Burger {
    private final String size;

    private final boolean egg;

    private final boolean extraCheese;

    private final boolean mayonnaise;

    private final boolean mustard;

    private final boolean onion;

    private final boolean pickles;

    private final boolean lettuce;

    private final boolean tomato;

    private Burger(BurgerBuilder burgerBuilder) {

        this.size = burgerBuilder.size;
        this.egg = burgerBuilder.egg;
        this.extraCheese = burgerBuilder.extraCheese;
        this.mayonnaise = burgerBuilder.mayonnaise;
        this.mustard = burgerBuilder.mustard;
        this.onion = burgerBuilder.onion;
        this.pickles = burgerBuilder.pickles;
        this.lettuce = burgerBuilder.lettuce;
        this.tomato = burgerBuilder.tomato;

    }

    public String getSize() {
        return size;
    }

    public boolean isEgg() {
        return egg;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public boolean isMayonnaise() {
        return mayonnaise;
    }

    public boolean isMustard() {
        return mustard;
    }

    public boolean isOnion() {
        return onion;
    }

    public boolean isPickles() {
        return pickles;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public boolean isTomato() {
        return tomato;
    }

    public static class BurgerBuilder {
        private String size;

        private boolean egg;

        private boolean extraCheese;

        private boolean mayonnaise;

        private boolean mustard;

        private boolean onion;

        private boolean pickles;

        private boolean lettuce;

        private boolean tomato;

        public BurgerBuilder size(String size) {
            this.size = size;
            return this;
        }

        public BurgerBuilder egg(boolean egg) {
            this.egg = egg;
            return this;
        }

        public BurgerBuilder extraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        public BurgerBuilder mayonnaise(boolean mayonnaise) {
            this.mayonnaise = mayonnaise;
            return this;
        }

        public BurgerBuilder mustard(boolean mustard) {
            this.mustard = mustard;
            return this;
        }

        public BurgerBuilder onion(boolean onion) {
            this.onion = onion;
            return this;
        }

        public BurgerBuilder pickles(boolean pickles) {
            this.pickles = pickles;
            return this;
        }

        public BurgerBuilder lettuce(boolean lettuce) {
            this.lettuce = lettuce;
            return this;
        }

        public BurgerBuilder tomato(boolean tomato) {
            this.tomato = tomato;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }

    }

}
