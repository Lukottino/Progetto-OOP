package zombietsunami;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import zombietsunami.model.obstaclemodel.api.Bomb;
import zombietsunami.model.obstaclemodel.api.Breakable;
import zombietsunami.model.obstaclemodel.api.ObstacleManager;
import zombietsunami.model.obstaclemodel.impl.BombImpl;
import zombietsunami.model.obstaclemodel.impl.BreakableImpl;
import zombietsunami.model.obstaclemodel.impl.ObstacleManagerImpl;
import zombietsunami.model.zombiemodel.impl.ZombieImpl;
import zombietsunami.model.CollisionImpl;
import zombietsunami.model.MapData;
import zombietsunami.model.mapmodel.api.GameMap;
import zombietsunami.model.mapmodel.impl.GameMapImpl;

// CHECKSTYLE: MagicNumber OFF
/**
 * Test class for CollisionImpl.
 * 
 * This class contains unit tests for various functionalities of the
 * CollisionImpl
 * class.
 */
class TestCollision {

    private final ZombieImpl zombie = new ZombieImpl();
    private final Bomb bomb = new BombImpl();
    private final Breakable breakable = new BreakableImpl(1);
    private final ObstacleManager obstacleManager = new ObstacleManagerImpl();
    private final CollisionImpl collision = new CollisionImpl();
    private final GameMap gameMap = new GameMapImpl();

    /**
     * This function generates two obstacles, namely a bomb and 
     * a breakable object. The screen coordinates of both obstacles 
     * are intentionally set to match those of the zombie.
     * Subsequently, these two obstacles are added to their respective 
     * lists, and the collision method is invoked to determine whether 
     * a collision between the zombie and the two obstacles occurs.
     * In the event of a collision, the two obstacles are 
     * expected to be marked as null.
     */
    @Test
    void checkIfCollides() {
        bomb.setX(75);
        bomb.setY(288);
        bomb.setDamage(1);

        breakable.setX(75);
        breakable.setY(288);

        obstacleManager.getBreakableList().add(0, breakable);
        obstacleManager.getBombList().add(0, bomb);
        zombie.setStrength(5);
        collision.collisionZombieObstacle(obstacleManager.getBombList(), obstacleManager.getBreakableList(),
                MapData.getTitSize(), zombie, gameMap);

        assertNull(obstacleManager.getBombList().get(0));
        assertNull(obstacleManager.getBreakableList().get(0));
    }
}
