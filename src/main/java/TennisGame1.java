import java.util.HashMap;

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

    private String getScoresTied(String key) {
        HashMap<String, String> scores = new HashMap<>();

        scores.put("0-0", "Love-All");
        scores.put("1-1", "Fifteen-All");
        scores.put("2-2", "Thirty-All");
        return scores.getOrDefault(key, "Deuce");
    }

    private String getScoresOdd(String score1, String score2) {
        HashMap<String, String> scores = new HashMap<>();
        scores.put("0", "Love");
        scores.put("1", "Fifteen");
        scores.put("2", "Thirty");
        scores.put("3", "Forty");
        return String.format("%s-%s", scores.get(score1), scores.get(score2));
    }

    public String getScore() {
        String runningScore = "";
        int tempScore = 0;
        if (matchScoreP1 == matchScoreP2) {
            String matchScoreString = String.format("%d-%d", matchScoreP1, matchScoreP2);
            runningScore = getScoresTied(matchScoreString);

        } else if (matchScoreP1 >= 4 || matchScoreP2 >= 4) {
            int minusResult = matchScoreP1 - matchScoreP2;
            if (minusResult == 1) runningScore = "Advantage player1";
            else if (minusResult == -1) runningScore = "Advantage player2";
            else if (minusResult >= 2) runningScore = "Win for player1";
            else runningScore = "Win for player2";
        } else {
            runningScore = getScoresOdd(String.valueOf(matchScoreP1), String.valueOf(matchScoreP2));

        }
        return runningScore;
    }
}
