package zombietsunami.api;

import java.util.List;

/**
 * This interface unify the elements of the model in the MVC pattern, by calling
 * all their useful methods that has to comunicate with the controller
 * interface.
 */
public interface Model {

  /**
   * Returns the list of bombs from the map.
   */
  void getBombsFromMap(List<Integer> bomblist, int x, int y, Integer strength);

  /**
   * Calls the zombie's update method
   * {@link zombietsunami.model.zombiemodel.api.Zombie}.
   */
  void updateZombie();

  /**
   * @return the List of Integers that contains all the values of the map's txt
   *         file
   */
  List<Integer> getMapList();

  /**
   * @return the List that contains the tile's elements file name of the game map
   */
  List<String> getTileElem();

  /**
   * @return the List of Pairs that contains the position of every single tile in
   *         the map
   */
  List<Pair<Integer, Integer>> getScreenTilePos();

  /**
   * @return the zombie's map X coordinate
   */
  int getZombieMapX();

  /**
   * @return the zombie's map Y coordinate
   */
  int getZombieMapY();

  /**
   * @return the speed fo the zombie
   */
  int getSpeed();

  int getPersonMapX();

  int getPersonMapY();

  int getNumXp();

  /**
   * @return the strenght of the zombie
   */
  int getStrenght();

  /**
   * Calls the increese strenght method of the zombie
   * {@link zombietsunami.model.zombiemodel.api.Zombie}.
   */
  void increaseStrenght();

  /**
   * Calls the set strenght method of the zombie
   * {@link zombietsunami.model.zombiemodel.api.Zombie}.
   * 
   * @param strenght is the strenght that will be setted
   */
  void setStrenght(int strenght);

  /**
   * @return the zombie's screen X coordinate
   */
  int getZombieScreenX();

  /**
   * @return the zombie's screen Y coordinate
   */
  int getZombieScreenY();

  /**
   * @return the obstacle's map X coordinate
   */
  int getObstacleMapX();

  /**
   * @return the obstacle's map Y coordinate
   */
  int getObstacleMapY();

  boolean canBreakObstacle(int zombieStrength);

  /**
   * Calls the jumpPress method of the zombie
   * {@link zombietsunami.model.zombiemodel.api.Zombie}.
   */
  void jumpPress();

  /**
   * Calls the updateJumpZombie method of the zombie
   * {@link zombietsunami.model.zombiemodel.api.Zombie}.
   */
  void updateJumpZombie();

  /**
   * Calls the getJumping method of the zombie
   * {@link zombietsunami.model.zombiemodel.api.Zombie}.
   * 
   * @return true if zombie is jumping
   */
  boolean isJumping();

  void updateOstacle();

  /**
   * @return the List of Integers that contains all the values of the obstacle
   *         map's txt file
   */
  List<Integer> getObstacleList();

  /**
   * Calls the set end position method in {@link zombietsunami.api.MightWin}.
   * 
   * @param endX is the flag's X coordinate
   */
  void setEndPos(int endX);

  /**
   * @return true if the flag's X position arrives in a certain axis
   */
  boolean isWin();
}
