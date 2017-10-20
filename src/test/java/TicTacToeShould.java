import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        int[] row = {0, 1, 2};
        int[] secondRow = {3, 4, 5};
        int[] thirdRow = {6, 7, 8};
        return playerOccupies(player, chars, row) ||
                playerOccupies(player, chars, secondRow) ||
                playerOccupies(player, chars, thirdRow);
    }

    private boolean playerOccupies(char valueOfCase, char[] chars, int[] row) {
        return caseAtPosIsOccupiedBy(row[0], valueOfCase, chars) &&
                caseAtPosIsOccupiedBy(row[1], valueOfCase, chars) &&
                caseAtPosIsOccupiedBy(row[2], valueOfCase, chars);
    }

    private boolean caseAtPosIsOccupiedBy(int pos, char valueOfCase, char[] cases) {
        return cases[pos] == valueOfCase;
    }


}
