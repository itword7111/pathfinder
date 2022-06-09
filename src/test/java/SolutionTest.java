import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest {

    @Test
    void getResult() {
        //STWSWTPPTPTTPWPP
        String[][] matrixOfTerrain = {
                {"S", "T", "W", "S"},
                {"W", "T", "P", "P"},
                {"T", "P", "T", "T"},
                {"P", "W", "P", "P"}
        };
        Map<String, Integer> mapOfCostsOfMovingOnTerrain = new HashMap<String, Integer>();
        mapOfCostsOfMovingOnTerrain.put("S", 5);
        mapOfCostsOfMovingOnTerrain.put("W", 2);
        mapOfCostsOfMovingOnTerrain.put("T", 3);
        mapOfCostsOfMovingOnTerrain.put("P", 1);

        Assertions.assertEquals(Solution.getResult(matrixOfTerrain, mapOfCostsOfMovingOnTerrain, 0, 0, 3, 3), 10);
    }
}
