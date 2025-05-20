package misc;

public class PorcionLaberinto {
  private int value;

  // isFree?
  private boolean north, south, east, west;

  public PorcionLaberinto(int value, boolean north, boolean south, boolean east, boolean west){
    this.value = value;
    this.north = north;
    this.south = south;
    this.east = east;
    this.west = west;
  }

  public int getValue() {
    return value;
  }

  public boolean isNorthFree(){
    return north;
  }

  public boolean isSouthFree(){
    return south;
  }

  public boolean isEastFree(){
    return east;
  }

  public boolean isWestFree(){
    return west;
  }

  @Override
  public String toString(){
    return Integer.toString(value);
  }
}
