import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int startCoordinateX = 0;
        int startCoordinateY = 0;
        int finishCoordinateX = 3;
        int finishCoordinateY = 3;
        String[][] matrixOfTerrain = new String[4][4];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку описывающую карту");
        String stringOfMap = scanner.nextLine();
        System.out.println("Введите строку описывающую рассу");
        String race = scanner.nextLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\properties.txt"));
        List<String> terrainType;
        List<String> propertyMassive = null;
        Map<String, Integer> mapOfCostsOfMovingOnTerrain = new HashMap<String, Integer>();
        String propertyLine;
        terrainType = Arrays.asList(bufferedReader.readLine().split(" "));
        while ((propertyLine = bufferedReader.readLine()) != null) {
            if (propertyLine.startsWith(race)) {
                propertyMassive = Arrays.asList(propertyLine.split(" "));
            }
        }
        for (int i = 0; i < terrainType.size(); i++) {
            mapOfCostsOfMovingOnTerrain.put(terrainType.get(i), Integer.valueOf(propertyMassive.get(i + 1)));
        }
        for (int i = 0; i < matrixOfTerrain.length; i++) {
            for (int j = 0; j < matrixOfTerrain[0].length; j++) {
                matrixOfTerrain[i][j] = stringOfMap.toCharArray()[i * 4 + j] + "";
            }
        }
        System.out.println(Solution.getResult(matrixOfTerrain, mapOfCostsOfMovingOnTerrain, startCoordinateX, startCoordinateY, finishCoordinateX, finishCoordinateY));
    }
}
