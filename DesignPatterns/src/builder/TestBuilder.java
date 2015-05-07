package builder;

public class TestBuilder {

	public static void main (String[] args) {
		MealBuilder builder = new MealBuilder();
		Meal vegMeal = builder.getVegMeal();
		vegMeal.showItems();
		System.out.println("Total Cost ->"+vegMeal.getTotalCost());
		
		Meal nonVeagMeal = builder.getNonVegMeal();
		nonVeagMeal.showItems();
		System.out.println("Total Cost ->"+nonVeagMeal.getTotalCost());
	}	
}
