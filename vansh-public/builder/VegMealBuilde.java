public class VegMealBuilde extends MealBuilder {
    private final Meal meal;

    public VegMealBuilde() {
        meal = new Meal();
    }

    @Override
    public void addCurry() {
        this.meal.setCurry("Vegetable Curry");
    }

    @Override
    public void addRice() {
        this.meal.setRice(true);
    }

    @Override

    public void addNaan() {
        this.meal.setNaan(true);
    }

    @Override
    public void addPapadum() {
        this.meal.setPapadum(true);
    }

    @Override
    public Meal build() {
        return this.meal;
    }

}
