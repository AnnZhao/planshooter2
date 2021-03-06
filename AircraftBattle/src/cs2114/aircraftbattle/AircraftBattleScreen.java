package cs2114.aircraftbattle;

import sofia.graphics.Color;
import sofia.util.Random;
import sofia.app.ShapeScreen;

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
    private float xPosition;
    private float yPosition;
    private Aircraft aircraft;
    private Bullet   bullet;
    private Enemy   enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private int    count  = 0;
    private int score = 0;

    Random random = Random.generator();
    public float getXPosition()
    {
        return this.xPosition;
    }
    public void setXPosition(float xPosition)
    {
        this.xPosition = xPosition;
    }



    public boolean isLost()
    {
        return lost;
    }
    public void setLost(boolean lost)
    {
        this.lost = lost;
    }
    public float getyPosition()
    {
        return yPosition;
    }
    public void setyPosition(float yPosition)
    {
        this.yPosition = yPosition;
    }
    public Aircraft getAircraft()
    {
        return aircraft;
    }
    public void setAircraft(Aircraft aircraft)
    {
        this.aircraft = aircraft;
    }
    public Bullet getBullet()
    {
        return bullet;
    }
    public void setBullet(Bullet bullet)
    {
        this.bullet = bullet;
    }
    public Enemy getEnemy1()
    {
        return enemy1;
    }
    public void setEnemy1(Enemy enemy1)
    {
        this.enemy1 = enemy1;
    }
    public Enemy getEnemy2()
    {
        return enemy2;
    }
    public void setEnemy2(Enemy enemy2)
    {
        this.enemy2 = enemy2;
    }
    public Enemy getEnemy3()
    {
        return enemy3;
    }
    public void setEnemy3(Enemy enemy3)
    {
        this.enemy3 = enemy3;
    }
    public int getCount()
    {
        return count;
    }
    public void setCount(int count)
    {
        this.count = count;
    }
    public int getScore()
    {
        return score;
    }
    public void setScore(int score)
    {
        this.score = score;
    }
    public Random getRandom()
    {
        return random;
    }
    public void setRandom(Random random)
    {
        this.random = random;
    }
    public void initialize()
    {
        xPosition = getWidth() / 2;
        yPosition = getHeight() - 90;


        addAircraft(xPosition, yPosition);
        addEnemy();
        while(!lost)
        {
            try
            {
                Thread.sleep(1000);
                addBullet(xPosition, yPosition - 25);
                bullet.move();
            }
            catch (InterruptedException e)
            {
                //
            }
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
    public void addEnemy()
    {
        while (count < 10)
        {
            try
            {
                int time = random.nextInt(3);
                Thread.sleep(1000 * time);
                float position = random.nextFloat(5, getWidth());
                int type = random.nextInt(1, 3);
                if (type == 1)
                {
                    int speed = random.nextInt(0, 300);
                    enemy1 = new Enemy(position - 12, 0, position + 12, 40);
                    enemy1.setFillColor(Color.blue);
                    add(enemy1);
                    enemy1.speed(speed);
                    count++;
                }
                else if (type == 2)
                {
                    int speed = random.nextInt(0, 300);
                    enemy2 = new Enemy(position - 15, 0, position + 15, 55);
                    enemy2.setFillColor(Color.green);
                    add(enemy2);
                    enemy2.speed(speed);
                    count++;
                }
                else if (type == 3)
                {
                    int speed = random.nextInt(0, 300);
                    enemy3 = new Enemy(position - 25, 0, position + 25, 75);
                    enemy3.setFillColor(Color.yellow);
                    add(enemy3);
                    enemy3.speed(speed);
                    count++;
                }
            }
            catch (InterruptedException e)
            {
                //
            }
        }
    }

//    // ----------------------------------------------------------
//    /**
//     * Place a description of your method here.
//     * @param x
//     * @param y
//     */
    public void onTouchMove(float x, float y)
   {    //move = true;
    System.out.println("In on touch move..............");
    xPosition = x;
    yPosition = y;
    aircraft.remove();
    //bullet.remove();
    addAircraft(xPosition, yPosition);
    //addBullet(xPosition, yPosition);
   }
}

