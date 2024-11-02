package practice.creational.factory;

public sealed interface MetalCoin permits BronzeCoin, SilverCoin {

  void printWorth(); // Prints monetary WORTH of minted Metal COIN
}
