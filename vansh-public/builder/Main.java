public class Main {
    public static void main(String[] args) {
        Burger burger = new Burger.BurgerBuilder()
                .size("Large")
                .egg(true)
                .mayonnaise(true)
                .mustard(true)
                .onion(true)
                .pickles(true)
                .lettuce(true)
                .tomato(true)
                .build();

        

        System.out.println(burger);

        MealBuilder vegMealBuilder = new VegMealBuilde();
        MealDirector mealDirector = new MealDirector(vegMealBuilder);

        Meal meal = mealDirector.construct();

        System.out.println(meal);

        MealBuilder nonVegMealBuilder = new NonVegMealBuilder();

        mealDirector = new MealDirector(nonVegMealBuilder);

        meal = mealDirector.construct();

        System.out.println(meal);



    }
}