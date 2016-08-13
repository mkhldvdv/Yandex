import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mikhail.davydov on 2016/1/21.
 */
public class RtriangleProviderTest {

    private Rtriangle rtriangle;

    @Before
    public void setUp() throws Exception {
        rtriangle = RtriangleProvider.getRtriangle();
    }

    @Test
    public void testGetRtriangle() throws Exception {

        List<Double> powLenghts = new ArrayList<Double>();

        // check if null
        assertNotNull("RTriangle should not be null", rtriangle);

        // fill in the list
        powLenghts.add(getPowLenght(rtriangle.getApexX1(), rtriangle.getApexY1(), rtriangle.getApexX2(), rtriangle.getApexY2()));
        powLenghts.add(getPowLenght(rtriangle.getApexX2(), rtriangle.getApexY2(), rtriangle.getApexX3(), rtriangle.getApexY3()));
        powLenghts.add(getPowLenght(rtriangle.getApexX3(), rtriangle.getApexY3(), rtriangle.getApexX1(), rtriangle.getApexY1()));

        // sorting
        Collections.sort(powLenghts);

        // check all elements' length
        for (Double powLenght : powLenghts) {
            assertNotEquals("Side length should be more than 0", 0.0, powLenght, 0.0);
        }

        // check triangle is right
        double zero = powLenghts.get(0) + powLenghts.get(1) - powLenghts.get(2);
        assertEquals("RTrianle is not right", 0.0, zero, 0.0);
    }

    /**
     * get the length pow 2 by coordinates
     * @param apexX1    x1
     * @param apexY1    y1
     * @param apexX2    x2
     * @param apexY2    y2
     * @return          length pow 2
     */
    private Double getPowLenght(int apexX1, int apexY1, int apexX2, int apexY2) {
        return Math.pow((apexX1 - apexX2), 2) + Math.pow((apexY1 - apexY2), 2);
    }
}