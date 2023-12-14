
public class TennisGame1 implements TennisGame {

    private int matchScoreP1 = 0;
    private int matchScoreP2 = 0;


    public void wonPoint(String playerName) {
        String playerName1 = "player1";
        if (playerName1.equalsIgnoreCase(playerName))
            matchScoreP1 += 1;
        else
            matchScoreP2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (matchScoreP1 == matchScoreP2) {
            switch (matchScoreP1) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (matchScoreP1 >= 4 || matchScoreP2 >= 4) {
            int minusResult = matchScoreP1 - matchScoreP2;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = matchScoreP1;
                else {
                    score += "-";
                    tempScore = matchScoreP2;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }
}
