import org.junit.Test;

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
    public void hasWinnerIsOneCombinationOfXXX() throws Exception {
        //given
        String game =
                "xxx" +
                "o-o" +
                "-o-";

        char player = 'x';

        //when
        boolean hasWinner = hasWinner(game, player);

        //then
        assertThat(hasWinner).isTrue();

    }


    @Test
    public void hasWinnerIsOneCombinationOfOOO() throws Exception {
        //given
        String game =
                "ooo" +
                "x-x" +
                "-x-";

        char player = 'o';

        //when
        boolean hasWinner = hasWinner(game, player);

        //then
        assertThat(hasWinner).isTrue();

    }

    private boolean hasWinner(String game, char valueOfCase) {
        char[] chars = game.toCharArray();
        return caseAtPosIsOccupiedBy(0, valueOfCase, chars) &&
                caseAtPosIsOccupiedBy(1, valueOfCase, chars) &&
                caseAtPosIsOccupiedBy(2, valueOfCase, chars);
    }

    private boolean caseAtPosIsOccupiedBy(int pos, char valueOfCase, char[] cases) {
        return cases[pos] == valueOfCase;
    }


}
