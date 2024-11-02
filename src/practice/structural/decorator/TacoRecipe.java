package practice.structural.decorator;

public sealed interface TacoRecipe permits PlainTaco, TacoDecorator {

  Integer BASE_PRICE = 100;

  float getCost();

  void printCost();
}
