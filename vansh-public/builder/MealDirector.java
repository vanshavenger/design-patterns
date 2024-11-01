public class MealDirector {

    private MealBuilder mealBuilder;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct() {
        mealBuilder.addCurry();
        mealBuilder.addRice();
        mealBuilder.addNaan();
        mealBuilder.addPapadum();
        return mealBuilder.build();
    }
}
