package HighFive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by whong53 on 2/27/17.
 */
public class Solution {
    /**
     * There are two properties in the node student id and scores,
     * to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.
     *
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> answer = new HashMap<>();
        Map<Integer, List<Integer>> topFiveHash = new HashMap<>();
        for (Record record : results) {
            if (!topFiveHash.containsKey(record.id)) {
                topFiveHash.put(record.id, new ArrayList<>());
            }
            if (topFiveHash.get(record.id).size() < 5) {
                topFiveHash.get(record.id).add(record.score);
            } else {
                int idx = 0;
                for (int i = 1; i < 5; i++) {
                    if (topFiveHash.get(record.id).get(i) < topFiveHash.get(record.id).get(idx)) {
                        idx = i;
                    }
                }
                if (topFiveHash.get(record.id).get(idx) < record.score) {
                    topFiveHash.get(record.id).set(idx, record.score);
                }
            }
        }

        for (Map.Entry entry : topFiveHash.entrySet()) {
            int key = (int) entry.getKey();
            List<Integer> scores = (List<Integer>) entry.getValue();
            double avg = 0.0;
            for (int i = 0; i < scores.size(); i++) {
                avg += scores.get(i);
            }
            avg = avg / scores.size();
            answer.put(key, avg);
        }
        return answer;
    }
}

class Record {
    public int id, score;

    public Record(int id, int score) {
        this.id = id;
        this.score = score;
    }
}