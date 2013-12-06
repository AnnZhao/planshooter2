package cs2114.aircraftbattle;

import junit.framework.TestCase;

public class AircraftBattleScreenTest
    extends TestCase

{
    private AircraftBattleScreen aircraftBattleScreen;
    public void setUp()
    {
        // not necesarry since no constructor exists
    }

    public void intializeTest() {
        this.aircraftBattleScreen.setXPosition(10.0f);
        this.aircraftBattleScreen.initialize();
        assertEquals(5, this.aircraftBattleScreen.getXPosition());
    }
}
