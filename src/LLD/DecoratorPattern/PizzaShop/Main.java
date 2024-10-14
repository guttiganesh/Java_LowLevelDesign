package LLD.DecoratorPattern.PizzaShop;

import LLD.DecoratorPattern.PizzaShop.Pizzas.BasePizza;
import LLD.DecoratorPattern.PizzaShop.Pizzas.VegDelight;
import LLD.DecoratorPattern.PizzaShop.Toppings.ExtraCheese;
import LLD.DecoratorPattern.PizzaShop.Toppings.Mushroom;

public class Main {
    public static void main(String[] args){
        BasePizza pizza = new Mushroom(new ExtraCheese(new VegDelight()));
        System.out.println(pizza.cost());
    }
}
