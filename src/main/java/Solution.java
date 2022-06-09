import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    private static String[][] matrixOfTerrain;
    private static Map<String, Integer> mapOfCostsOfMovingOnTerrain;
    private static int finishCoordinateX;
    private static int finishCoordinateY;
    private static int count = 0;

    public static int getResult(String[][] matrixOfTerrain, Map<String, Integer> mapOfCostsOfMovingOnTerrain, int startCoordinateX, int startCoordinateY, int finishCoordinateX, int finishCoordinateY) {
        List<Cell> listOfSteps = new ArrayList<Cell>();
        List<Cell> listOfCellsToDelete;
        Solution.finishCoordinateX = finishCoordinateX;
        Solution.finishCoordinateY = finishCoordinateY;
        Solution.matrixOfTerrain = matrixOfTerrain;
        Solution.mapOfCostsOfMovingOnTerrain = mapOfCostsOfMovingOnTerrain;
        listOfSteps.add(new Cell(0,1,startCoordinateX, startCoordinateY));
        while (true) {
            List<Cell> newListOfSteps = new ArrayList<Cell>();
            listOfCellsToDelete = new ArrayList<Cell>();
            count = 0;
            for (Cell cell : listOfSteps) {

                int result = 0;
                //go right
                if ((result = Step(cell.getxCoordinate() + 1, cell.getyCoordinate(), cell, newListOfSteps)) > 0) {
                    return result;
                }
                //go left
                if ((result = Step(cell.getxCoordinate() - 1, cell.getyCoordinate(), cell, newListOfSteps)) > 0) {
                    return result;
                }
                //go down
                if ((result = Step(cell.getxCoordinate(), cell.getyCoordinate() + 1, cell, newListOfSteps)) > 0) {
                    return result;
                }
                //go up
                if ((result = Step(cell.getxCoordinate(), cell.getyCoordinate() - 1, cell, newListOfSteps)) > 0) {
                    return result;
                }
                if (count == 0) {
                    listOfCellsToDelete.add(cell);
                }
                //more weight allows to move expansive cells
                cell.setMaxAvailableWeight(cell.getMaxAvailableWeight() + 1);
            }
            //delete useless cells
            listOfSteps.removeAll(listOfCellsToDelete);
            listOfSteps.addAll(newListOfSteps);
        }
    }

    private static int Step(int x, int y, Cell cell, List<Cell> newListOfSteps) {
        if (x > -1 && y > -1 && x < matrixOfTerrain[0].length && y < matrixOfTerrain.length && (!matrixOfTerrain[x][y].equals(""))) {
            int weightOfTerrain = mapOfCostsOfMovingOnTerrain.get(matrixOfTerrain[x][y]);
            if (weightOfTerrain <= cell.getMaxAvailableWeight()) {
                if (x == finishCoordinateX && y == finishCoordinateY) {
                    return weightOfTerrain + cell.getWeight();
                }
                newListOfSteps.add(new Cell(weightOfTerrain + cell.getWeight(), 1, x, y));
                matrixOfTerrain[x][y] = "";
            }
            count++;
            return 0;
        }
        return 0;
    }

}
