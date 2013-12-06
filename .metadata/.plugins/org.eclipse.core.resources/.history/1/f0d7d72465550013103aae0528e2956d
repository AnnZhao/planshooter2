package cs2114.aircraftbattles;

import sofia.app.ShapeScreen;
import sofia.util.Random;
import java.util.*;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Hangxin Liu
 * @version 2013-11-8
 */
public class AircraftBattlesScreen
    extends ShapeScreen
{

    // Field
    Aircraft aircraft;
    Enemy1 enemy1;
    Enemy2 enemy2;
    Enemy3 enemy3;
    Bullet bullet;
    float  xPosition;
    float  yPosition;
    int    count  = 0;
    int score = 0;
    boolean lost;
    /**
    *
    */
    Random random = Random.generator();


    public void initialize()
    {
        lost = false;

        addAircraft(getWidth() / 2, getHeight(), 0, 0);
        addBullet(getWidth() / 2, getHeight(), 0, 0);
        addEnemy();

        while (aircraft.onCollisionWith(enemy1) ||
            aircraft.onCollisionWith(enemy2) ||
            aircraft.onCollisionWith(enemy3))
        {
            lost = true;
        }

        if (enemy1.onCollisionWith(bullet))
        {
            count--;
            score = score + 1000;
        }
        else if (enemy2.onCollisionWith(bullet))
        {
            count--;
            score = score + 2000;
        }
        else if (enemy3.onCollisionWith(bullet))
        {
            count--;
            score = score + 5000;
        }

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void addAircraft(float left, float top, float right, float bottom)
    {
        aircraft = new Aircraft(left, top, right, bottom);
        add(aircraft);

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param x
     * @param y
     */
    public void addBullet(float left, float top, float right, float bottom)
    {
        bullet = new Bullet(getWidth() / 2, getHeight(), 0 , 0);
        add(bullet);
        bullet.moveBy(0, -20);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void addEnemy()
    {
        while (count < 10)
        {
            float position = random.nextFloat(5, getWidth());
            int type = random.nextInt(1, 3);
            int speed = random.nextInt(30);
            if (type == 1)
            {
                enemy1 = new Enemy1(position, 0, 0, 0);
                add(enemy1);
                enemy1.moveBy(0, speed);
                count++;
            }
            else if (type == 2)
            {
                enemy2 = new Enemy2(position, 0, 0, 0);
                add(enemy2);
                enemy2.moveBy(0, speed);
                count++;
            }
            else if (type == 3)
            {
                enemy3 = new Enemy3(position, 0, 0, 0);
                add(enemy3);
                enemy3.moveBy(0, speed);
                count++;
            }
        }
    }




}
