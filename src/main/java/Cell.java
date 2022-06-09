public class Cell {
    private int weight;
    private int maxAvailableWeight;
    private int xCoordinate;
    private int yCoordinate;

    public Cell(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Cell(int weight, int maxAvailableWeight, int xCoordinate, int yCoordinate) {
        this.weight = weight;
        this.maxAvailableWeight = maxAvailableWeight;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxAvailableWeight() {
        return maxAvailableWeight;
    }

    public void setMaxAvailableWeight(int maxAvailableWeight) {
        this.maxAvailableWeight = maxAvailableWeight;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
