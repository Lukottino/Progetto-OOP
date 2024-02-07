package zombietsunami.model.mapModel.impl;

import java.util.ArrayList;
import java.util.List;

import zombietsunami.api.Pair;
import zombietsunami.model.mapModel.api.MapPosList;

/**
 * This class implements the MapPosList interface
 * {@link zombietsunami.model.mapModel.api.MapPosList}.
 */
public final class MapPosListImpl implements MapPosList {

    @Override
    public List<Pair<Integer, Integer>> getScreenTilePosition(final int maxWorldRow, final int maxWorldCol,
            final int titleSize, final int zombieWorldX, final int zombieWorldY, final int zombieScreenX,
            final int zombieScreenY) {
        final List<Pair<Integer, Integer>> screenTilePos = new ArrayList<>();
        int worldX;
        int worldY;
        int pos = 0;

        for (int worldRow = 0; worldRow < maxWorldRow; worldRow++) {
            for (int worldCol = 0; worldCol < maxWorldCol; worldCol++) {

                worldX = worldCol * titleSize;
                worldY = worldRow * titleSize;
                final int screenX = worldX - zombieWorldX + zombieScreenX;
                final int screenY = worldY - zombieWorldY + zombieScreenY;

                if (worldX + titleSize > zombieWorldX - zombieScreenX
                        && worldX - titleSize < zombieWorldX + zombieScreenX
                        && worldY + titleSize > zombieWorldY - zombieScreenY
                        && worldY < zombieWorldY + zombieScreenY) {
                    screenTilePos.add(pos, new Pair<Integer, Integer>(screenX, screenY));
                } else {
                    screenTilePos.add(pos, null);
                }
                pos++;
            }
        }

        return screenTilePos;
    }

}
