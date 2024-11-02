package practice.structural.adapter;

public sealed interface RowingBoat permits BoatAdapter {

  void row(); // Implementation of TECHNIQUES of ROWING
}
