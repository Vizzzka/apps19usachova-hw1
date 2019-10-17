package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;


public class TemperatureSeriesAnalysisTest {

    private static final double delta = 0.00001;

    @Test
    public void testAverageWithOneElementArray() {

        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, delta);
    }

    @Test
    public void testDeviationWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 56.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, delta);
    }


    @Test
    public void testMinMaxWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResultMin = -1.0;
        double expResultMax = -1.0;

        // call tested method
        double actualResultMin = seriesAnalysis.min();
        double actualResultMax = seriesAnalysis.max();

        // compare expected result with actual result
        assertEquals(expResultMin, actualResultMin, delta);
        assertEquals(expResultMax, actualResultMax, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
        seriesAnalysis.max();
    }

    @Test
    public void testMinMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResultMin = -5.0;
        double expResultMax = 5.0;

        double actualResultMin = seriesAnalysis.min();
        double actualResultMax = seriesAnalysis.max();

        assertEquals(expResultMin, actualResultMin, delta);
        assertEquals(expResultMax, actualResultMax, delta);

    }

    @Test
    public void testClosestToValueWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(3);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, delta);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToValue(0);
    }

    @Test
    public void testClosestToValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(-6.0);

        assertEquals(expResult, actualResult, delta);
    }

    @Test
    public void testLessThanValueWithoutLess() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0, 2.0, 99.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[0];

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(-2.0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLessThanValueEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToValue(0);
    }

    @Test
    public void testLessThanValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, 7.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3.0, -5.0, 1.0};

        double[] actualResult = seriesAnalysis.findTempsLessThen(5.0);

        assertArrayEquals(expResult, actualResult, delta);
    }


    @Test
    public void testSummaryStatisticsArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0, 3.0, 2.0, -9.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics expResult = new TempSummaryStatistics(seriesAnalysis);

        // call tested method
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

        // compare expected result with actual result
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testAddTemps() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0, 3.0, 2.0, -9.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 6.0;

        // call tested method
        double actualResult = seriesAnalysis.addTemps(2.0, 2.0, 3.0, 4.0);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, delta);
    }

}