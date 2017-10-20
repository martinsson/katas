import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeShould {
    @Test
    public void noWinnerToBeginWith() throws Exception {
        String game =
                "---" +
                "---" +
                "---";

        char player = 'x';
        boolean hasAWinner = hasWinner(game, player);
        assertThat(hasAWinner).isFalse();
    }

    @Test
    public void winOnFirstRowXXX() throws Exception {
        //given
        String game =
                "xxx" +
                "o-o" +
                "-o-";

        char player = 'x';
        boolean hasWinner = hasWinner(game, player);
        assertThat(hasWinner).isTrue();
    }


    @Test
    public void winOnAnyRow() throws Exception {
        //given
        List<String> gamesWinningOnRow = Arrays.asList(
                "ooo" +
                "x-x" +
                "-x-",

                "x-x" +
                "ooo" +
                "-x-",

                "x-x" +
                "-x-" +
                "ooo"
        );

        char player = 'o';
        assertAllGamesHaveWinner(gamesWinningOnRow, player);

    }

    @Test
    public void winOnAnyColumn() throws Exception {
        //given
        List<String> gamesWinningOnColumn = Arrays.asList(
                "xoo" +
                "x-o" +
                "xo-",

                "oxo" +
                "-x-" +
                "-xo",

                "x-x" +
                "-ox" +
                "oox"
        );

        char player = 'x';
        assertAllGamesHaveWinner(gamesWinningOnColumn, player);

    }

    @Test
    public void winOnAnyDiagonal() throws Exception {
        //given
        List<String> gamesWinningOnDiagonal = Arrays.asList(
                "xoo" +
                "oxo" +
                "xox",

                "x-x" +
                "-xo" +
                "xoo"
        );

        char player = 'x';
        assertAllGamesHaveWinner(gamesWinningOnDiagonal, player);

    }


    private void assertAllGamesHaveWinner(List<String> gamesWinningOnRow, char player) {
        gamesWinningOnRow.forEach(game -> {
            boolean hasWinner = hasWinner(game, player);
            assertThat(hasWinner).isTrue();
        });
    }

    private boolean hasWinner(String game, char player) {
        char[] chars = game.toCharArray();
        List<int[]> rows = Arrays.asList(
                new int[]{0, 1, 2},
                new int[]{3, 4, 5},
                new int[]{6, 7, 8}
        );
        List<int[]> columns = Arrays.asList(
                new int[]{0, 3, 6},
                new int[]{1, 4, 7},
                new int[]{2, 5, 8}
        );
        List<int[]> diagonals = Arrays.asList(
                new int[]{0, 4, 8},
                new int[]{2, 4, 6}
        );
        return Stream.of(rows, columns, diagonals)
                .flatMap(Stream::of)
                .anyMatch(combination -> playerOccupies(player, chars, combination));
    }

    private boolean playerOccupies(char player, char[] cases, int[] row) {
        return Arrays.stream(row).allMatch(position -> cases[position] == player);
    }

    /*
     * finding the datastructure
     *  - started with boolean
     *  - needed to introduce string or array of cases in order to describe the problem on third test (winning game)
     *
     *  Finding the algorithm, refactor on duplication
     *  - rule of 3
     *
     *  Primitives all over the place so far (before creating any classes)
     *
     *  I eventually backtracked to extraction of caseOfPositionIsOccupiedBy, using a lambda instead
     */

}
