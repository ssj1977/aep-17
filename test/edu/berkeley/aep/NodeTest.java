package edu.berkeley.aep;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sung Joo Son on 2017-04-07.
 */
public class NodeTest {
    Node nodeA = new Node("a");
    Node nodeB = new Node("b");
    Node nodeC = new Node("c");
    Node nodeD = new Node("d");
    Node nodeE = new Node("e");
    Node nodeF = new Node("f");
    Node nodeG = new Node("g");
    Node nodeH = new Node("h");

    @Before
    public void setUp() {
        nodeA.connect(nodeF, 72);
        nodeB.connect(nodeC, 402);
        nodeB.connect(nodeA, 179);
        nodeC.connect(nodeE, 320);
        nodeC.connect(nodeE, 749);
        nodeC.connect(nodeD, 126);
        nodeD.connect(nodeE, 79);
        nodeE.connect(nodeB, 312);
        nodeH.connect(nodeB, 87);
    }

    @Test
    public void CanAirportReachItself() {
        assertTrue(nodeH.isConnected(nodeH));
    }

    @Test
    public void AirportGShouldNotBeConnectedToAirportH() {
        assertFalse(nodeG.isConnected(nodeH));
    }

    @Test
    public void AirportHIsConnectedWithB() {
        assertTrue(nodeH.isConnected(nodeB));
    }

    @Test
    public void AirportHIsConnectedWithD() {
        assertTrue(nodeH.isConnected(nodeD));
    }

    @Test
    public void AirportHIsConnectedWithG() {
        assertFalse(nodeH.isConnected(nodeG));
    }

    @Test
    public void HopsFromHtoGIsMinusOne() {
        assertEquals(nodeH.countHops(nodeG), -1);
    }

    @Test
    public void HopsFromBtoBIs0() {
        assertEquals(nodeB.countHops(nodeB), 0);
    }

    @Test
    public void HopsFromBtoAIs1() {
        assertEquals(nodeB.countHops(nodeA), 1);
    }

    @Test
    public void HopsFromBtoDIs2() {
        assertEquals(nodeB.countHops(nodeD), 2);
    }

    @Test
    public void HopsFromBtoASIs1() {
        assertEquals(nodeB.countHops(nodeA), 1);
    }

    @Test
    public void HopsFromCtoEIs1() {
        assertEquals(nodeC.countHops(nodeE), 1);
    }

    @Test
    public void MininumHopsFromBtoEShouldBe2() {
        assertEquals(nodeB.countHops(nodeE), 2);
    }

    @Test
    public void MininumHopsFromHtoAShouldBe2() {
        assertEquals(nodeH.countHops(nodeA), 2);
    }

    @Test
    public void MininumHopsFromGtoEShouldBeMinusOne() {
        assertEquals(nodeG.countHops(nodeE), -1);
    }

    @Test
    public void MininumHopsFromCtoFShouldBe4() {
        assertEquals(nodeC.countHops(nodeF), 4);
    }

    @Test
    public void MinCostFromHtoBShouldBe87(){
        assertEquals(87, nodeH.getMinCostTo(nodeB));
    }

    @Test
    public void MinCostFromAtoAShouldBe0(){
        assertEquals(0, nodeA.getMinCostTo(nodeA));
    }

    @Test
    public void MinCostFromHtoAShouldBe266(){
        assertEquals(266, nodeH.getMinCostTo(nodeA));
    }

    @Test
    public void MinCostFromCtoEShouldBe320(){
        assertEquals(320, nodeC.getMinCostTo(nodeE));
    }
}
