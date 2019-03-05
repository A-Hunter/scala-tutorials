package com.scala.exercises.ex2_high_order_functions

/**
  * Created by Ghazi Naceur on 05/03/2019
  * Email: ghazi.ennacer@gmail.com
  *
  * partition function takes a function as a parameter (p: Int => Boolean)
  * => partition function is a high order function
  */

abstract class HighOrderFunctions {

  val ingredients: Array[Ingredient]
  val (eatNow, eatLater) = ingredients.partition(i => i.shelfLife < 7)
  // This example could be replaced with this one :
//  val (eatNow, eatLater) = ingredients.partition(_.shelfLife < 7)
}

/**
  This Scala code is equivalent to this one in Java :
    List<Ingredient> ingredients;
    List<Ingredient> eatNow = new ArrayList<Ingredient>(ingredients.size());
    List<Ingredient> eatLater = new ArrayList<Ingredient>(ingredients.size());
    for(Ingredient ingredient : ingredients){
      if(ingredient.getShelfLife() < 7){
        eatNow.add(ingredient);
      } else {
        eatLater.add(ingredient);
      }
    }
  */