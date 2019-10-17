package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private double[] temperatureSeries;

    private void is_empty() {
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void resize() {
        int l = this.temperatureSeries.length;
        double[] new_temperatureSeries = new double[l * 2];
        System.arraycopy(this.temperatureSeries, 0, new_temperatureSeries, 0, l);
        setTemperatureSeries(new_temperatureSeries);
    }

    public TemperatureSeriesAnalysis() {
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.setTemperatureSeries(temperatureSeries);
    }

    public double average() {
        this.is_empty();
        double sum = 0;
        for (double temp : this.temperatureSeries) {
            sum += temp;
        }
        return sum / this.temperatureSeries.length;
    }

    public double deviation() {
        double deviation = 0, average;
        average = this.average();
        for (double temp : this.temperatureSeries) {
            deviation += (average - temp) * (average - temp);
        }
        return deviation;
    }

    public double min() {
        this.is_empty();
        double mini = this.temperatureSeries[0];
        for (double temp : this.temperatureSeries) {
            mini = Math.min(temp, mini);
        }
        return mini;
    }

    public double max() {
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double maxi = this.temperatureSeries[0];
        for (double temp : this.temperatureSeries) {
            maxi = Math.max(temp, maxi);
        }
        return maxi;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        this.is_empty();
        double value = this.temperatureSeries[0];
        for (double temp : this.temperatureSeries) {
            if (Math.abs(temp - tempValue) < Math.abs(value - tempValue)) {
                value = temp;
            }
            if (Math.abs(temp - tempValue) == Math.abs(value - tempValue)) {
                value = temp - tempValue > 0 ? temp : value;
            }
        }
        return value;
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] res_arr = new double[this.temperatureSeries.length];
        int index = 0;
        for (double temp : this.temperatureSeries) {
            if (temp < tempValue) {
                res_arr[index++] = temp;
            }
        }
        double[] new_res = new double[index];
        System.arraycopy(res_arr, 0, new_res, 0, index);
        return new_res;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] res_arr = new double[this.temperatureSeries.length];
        int index = 0;
        for (double temp : this.temperatureSeries) {
            if (temp >= tempValue) {
                res_arr[index++] = temp;
            }
        }
        double[] new_res = new double[index];
        System.arraycopy(res_arr, 0, new_res, 0, index);
        return new_res;
    }

    public TempSummaryStatistics summaryStatistics() {
        is_empty();
        return new TempSummaryStatistics(this);
    }

    public double addTemps(double ... temps) {
        int index = this.temperatureSeries.length;
        double sum = 0;

        for (double temp : temps) {
            if (index == this.temperatureSeries.length)
                this.resize();
            this.temperatureSeries[index++] = temp;
        }
        for (double temp : this.temperatureSeries) {
            sum += temp;
        }
        return sum;
    }

    public double[] getTemperatureSeries() {
        return temperatureSeries;
    }

    public void setTemperatureSeries(double[] temperatureSeries) {
        for (double temperatureSery : temperatureSeries)
            if (temperatureSery < -273)
                throw new InputMismatchException();
        this.temperatureSeries = temperatureSeries;
    }
}
