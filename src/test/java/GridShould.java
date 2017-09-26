import org.junit.Assert;
import org.junit.Test;

public class GridShould {

    static final int GRID_SIZE = 10;

    @Test
    public void s() throws Exception {
        DefaultDataService grid = newGrid();
        turnOn(grid);
        String expectedGrid =
                "**********" + "\n" +
                "**********" + "\n" +
                "**********" + "\n" +
                "**********" + "\n" +
                "**********" + "\n" +
                "**********" + "\n" +
                "**********" + "\n" +
                "**********" + "\n" +
                "**********" + "\n" +
                "**********" + "\n";
        Assert.assertEquals(expectedGrid, isTotallyOn(grid));
    }

    private DefaultDataService newGrid() {
        return new DefaultDataService(GRID_SIZE);
    }

    private String isTotallyOn(DefaultDataService grid) {
        return grid.defaultUtils();
    }

    private void turnOn(DefaultDataService grid) {
        BusinessDefaultImpl lowerLeft = new BusinessDefaultImpl(0, 0);
        BusinessDefaultImpl uppterRight = new BusinessDefaultImpl(9, 9);
        turnOn(grid, lowerLeft, uppterRight);
    }

    private void turnOn(DefaultDataService grid, BusinessDefaultImpl lowerLeft, BusinessDefaultImpl uppterRight) {
        grid.abstractExecutor(lowerLeft, uppterRight);
    }


}
