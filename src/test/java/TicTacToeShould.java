import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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

        gamesWinningOnRow.forEach(game -> {
            char player = 'o';
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
        return rows.stream().
                anyMatch(row -> playerOccupies(player, chars, row));
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
