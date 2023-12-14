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

    private String getScores(String matchScore) {
        HashMap<String, String> scores = new HashMap<>();
        scores.put("0-0", "Love-All");
        scores.put("1-1", "Fifteen-All");
        scores.put("2-2", "Thirty-All");
        return scores.getOrDefault(matchScore, "Deuce");
    }

    private String getScores(String matchScoreP1, String matchScoreP2) {
        HashMap<String, String> scores = new HashMap<>();
        scores.put("0", "Love");
        scores.put("1", "Fifteen");
        scores.put("2", "Thirty");
        scores.put("3", "Forty");
        return String.format("%s-%s", scores.get(matchScoreP1), scores.get(matchScoreP2));
    }

    private String getScores(int matchScoreP1, int matchScoreP2) {

        boolean isPLayerP1 = true;
        int difference = 0;

        if (matchScoreP1 > matchScoreP2) {
            difference = matchScoreP1 - matchScoreP2;
        } else {
            difference = matchScoreP2 - matchScoreP1;
            isPLayerP1 = false;
        }

        return String.format("%s%s", difference == 1 ? "Advantage player" : "Win for player", isPLayerP1 ? "1" : "2");
    }

    public String getScore() {
        if (matchScoreP1 == matchScoreP2) {
            String matchScoreString = String.format("%d-%d", matchScoreP1, matchScoreP2);
            return getScores(matchScoreString);
        }
        if (matchScoreP1 < 4 && matchScoreP2 < 4) {
            return getScores(String.valueOf(matchScoreP1), String.valueOf(matchScoreP2));
        } else {
            return getScores(matchScoreP1, matchScoreP2);
        }
    }
}
