package cs2114.aircraftbattles;

import sofia.app.ShapeScreen;
import java.util.*;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author liuhx
 * @version 2013-11-23
 */
public class AircraftBattleScreen
    extends ShapeScreen
{
    private boolean  lost;
    private Aircraft aircraft;
    private Bullet   bullet;
    private Enemy1   enemy1;


    public void initialize()
    {
        lost = false;
        addAircraft(getWidth() / 2, getHeight() - 90);

        addEnemy(getWidth() / 2, 1);
        enemy1.speed(100);

        while (!lost)
        {
            try
            {
                Thread.sleep(1000);
                addBullet(getWidth() / 2, getHeight() - 105);
                bullet.move();
            }
            catch (InterruptedException e)
            {
                //
            }

        }


    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void addAircraft(float x, float y)
    {
        aircraft = new Aircraft(x - 20, y, x + 20, y + 60);
        add(aircraft);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void addBullet(float x, float y)
    {
        bullet = new Bullet(x - 2, y, x + 2, y + 15);
        add(bullet);

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void addEnemy(float x, float y)
    {
        enemy1 = new Enemy1(x - 12, y, x + 12, y + 40);
        add(enemy1);
    }
}
