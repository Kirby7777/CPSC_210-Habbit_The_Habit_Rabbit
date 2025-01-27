package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class Tracker implements Writable {
    private ArrayList<Habit> tracker;
    private Habit selected;
    private Rabbit rabbit;

    // EFFECTS: creates a new instance of a habit tracker that keeps track of
    //          the progress of each habit.
    public Tracker(String j) {
        this.tracker = new ArrayList<>();
        this.rabbit = new Rabbit(j);
        EventLog.getInstance().logEvent(new Event("Rabbit " + j.toUpperCase() + " Created"));
    }

    public ArrayList<Habit> getHabits() {
        return tracker;
    }

    // EFFECTS: adds the habit into the list
    public void addHabit(Habit h) {
        tracker.add(h);
        EventLog.getInstance().logEvent(new Event("New Habit " + h.getTitle() + " Created!"));
    }

    // REQUIRES : selected != null
    // MODIFIES : this
    // EFFECTS : selects a habit
    public void selectHabit(Habit a) {
        selected = a;
    }

    // EFFECTS: returns the selected habit
    public Habit getSelected() {
        return selected;
    }

    // REQUIRES : selected != null
    // MODIFIES : Habit
    // EFFECTS : modifies the habit title
    public void changeTitle(String g) {
        selected.modifyTitle(g);
    }

    // REQUIRES : selected != null
    // MODIFIES : Habit
    // EFFECTS : modifies the habit title
    public void changeDescription(String f) {
        selected.modifyDescription(f);
    }

    // REQUIRES : selected != null
    // MODIFIES : Habit
    // EFFECTS : modifies the habit category
    public void changePerDay(int h) {
        selected.modifyPerDay(h);
    }

    // REQUIRES : selected != null
    // MODIFIES : Habit
    // EFFECTS : modifies the habit category
    public void changeCategory(String p) {
        selected.modifyCategory(p);
    }

    // EFFECTS : returns the number of user's completed habits
    public int completedHabits() {
        int number = 0;
        for (Habit y : tracker) {
            if (y.isFinished()) {
                number++;
            }
        }
        return number;
    }

    // EFFECTS: returns the total number of habits the user has
    public int numberOfHabits() {
        int amount = 0;
        for (Habit z : tracker) {
            amount++;
        }
        return amount;
    }

    // MODIFIES : habit
    // EFFECTS : increments habit's progress by 1
    public void progressHabit(int y) {
        tracker.get(y).addProgress();
    }

    // EFFECTS: returns the goal of lifestyle points of the user
    public int getLifestyleGoal() {
        int lifestyleGoal = 0;

        for (Habit w : tracker) {
            if (w.getCategory().equals("Lifestyle")) {
                lifestyleGoal = lifestyleGoal + w.getPerDay();
            }
        }
        return lifestyleGoal;
    }

    // EFFECTS: returns the amount of completed lifestyle habits
    public int getLifestyleCompleted() {
        int lifestyleCompleted = 0;
        for (Habit u : tracker) {
            if (u.getCategory().equals("Lifestyle")) {
                lifestyleCompleted = lifestyleCompleted + u.getProgress();
            }
        }
        return lifestyleCompleted;
    }

    // EFFECTS: returns the goal of social points of the user
    public int getSocialGoal() {
        int socialGoal = 0;

        for (Habit w : tracker) {
            if (w.getCategory().equals("Social")) {
                socialGoal = socialGoal + w.getPerDay();
            }
        }
        return socialGoal;
    }

    // EFFECTS: returns the amount of completed social habits
    public int getSocialCompleted() {
        int socialCompleted = 0;

        for (Habit u : tracker) {
            if (u.getCategory().equals("Social")) {
                socialCompleted = socialCompleted + u.getProgress();
            }
        }
        return socialCompleted;
    }

    // EFFECTS: returns the goal of diet points of the user
    public int getDietGoal() {
        int dietGoal = 0;

        for (Habit w : tracker) {
            if (w.getCategory().equals("Diet")) {
                dietGoal = dietGoal + w.getPerDay();
            }
        }
        return dietGoal;
    }

    // EFFECTS: returns the amount of completed diet habits
    public int getDietCompleted() {
        int dietCompleted = 0;

        for (Habit u : tracker) {
            if (u.getCategory().equals("Diet")) {
                dietCompleted = dietCompleted + u.getProgress();
            }
        }
        return dietCompleted;
    }

    // EFFECTS: returns the goal of Hobby points of the user
    public int getHobbyGoal() {
        int hobbyGoal = 0;

        for (Habit w : tracker) {
            if (w.getCategory().equals("Hobby")) {
                hobbyGoal = hobbyGoal + w.getPerDay();
            }
        }
        return hobbyGoal;
    }

    // EFFECTS: returns the amount of completed Hobby habits
    public int getHobbyCompleted() {
        int hobbyCompleted = 0;

        for (Habit u : tracker) {
            if (u.getCategory().equals("Hobby")) {
                hobbyCompleted = hobbyCompleted + u.getProgress();
            }
        }
        return hobbyCompleted;
    }

    // EFFECTS: returns the amount of completed Hobby habits
    public float getHabitProgress() {
        float hobbyProgress = 0;

        for (Habit u : tracker) {
            hobbyProgress = hobbyProgress + u.getProgress();
        }
        return hobbyProgress;
    }

    public float getHabitGoalOverall() {
        float habitGoalOverall = 0;

        for (Habit e : tracker) {
            habitGoalOverall = habitGoalOverall + e.getPerDay();
        }
        return habitGoalOverall;
    }

    //RABBIT METHODS

    // MODIFIES : Rabbit
    // EFFECTS : modifies rabbit's name
    public void modifyRabbitName(String x) {
        rabbit.setName(x);
    }


    // MODIFIES : Rabbit
    // EFFECTS : modifies rabbit's fit status
    public void isFit() {
        if (getLifestyleCompleted() >= getLifestyleGoal()) {
            rabbit.setFit(true);
        } else {
            rabbit.setFit(false);
        }
    }

    // MODIFIES : Rabbit
    // EFFECTS : modifies rabbit's diet status
    public void isDietGood() {
        if (getDietCompleted() >= getDietGoal()) {
            rabbit.setDiet(true);
        } else {
            rabbit.setDiet(false);
        }
    }

    // MODIFIES : Rabbit
    // EFFECTS : modifies rabbit's social status
    public void isSociable() {
        if (getSocialCompleted() >= getSocialGoal()) {
            rabbit.setSocial(true);
        } else {
            rabbit.setSocial(false);
        }
    }

    // MODIFIES : Rabbit
    // EFFECTS : modifies rabbit's entertained status
    public void isEntertained() {
        if (getHobbyCompleted() >= getHobbyGoal()) {
            rabbit.setEntertained(true);
        } else {
            rabbit.setEntertained(false);
        }
    }

    public void rabbitSetHappiness() {
        rabbit.setHappiness(getHabitProgress());
    }

    public void rabbitSetMaxHappiness() {
        rabbit.setMaxHappiness(getHabitGoalOverall());
    }

    public void rabbitSetHappinessStatus() {
        boolean isHappy;
        float habitRatio = getHabitProgress() / getHabitGoalOverall();

        if (habitRatio >= 0.75) {
            isHappy = true;
        } else {
            isHappy = false;
        }
        rabbit.setHappinessStatus(isHappy);
    }

    public String getRabbitName() {
        return rabbit.getName();
    }

    public boolean getRabbitDiet() {
        return rabbit.getDietStatus();
    }

    public boolean getRabbitSocial() {
        return rabbit.getSocialStatus();
    }

    public boolean getRabbitEntertained() {
        return rabbit.getEntertainedStatus();
    }

    public boolean getRabbitFit() {
        return rabbit.getFitStatus();
    }

    public float getRabbitHappiness() {
        return rabbit.getHappiness();
    }

    public float getRabbitMaxHappiness() {
        return rabbit.getMaxHappiness();
    }

    public boolean getRabbitHappinessStatus() {
        return rabbit.getHappyStatus();
    }

    public Rabbit getRabbit() {
        return rabbit;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("rabbit", getRabbitName());
        json.put("habit", habitsToJson());
        json.put("dietGood", getRabbitDiet());
        json.put("fit", getRabbitFit());
        json.put("entertained", getRabbitEntertained());
        json.put("notLonely", getRabbitSocial());
        json.put("happiness", getRabbitHappiness());
        json.put("maxHappiness", getRabbitMaxHappiness());
        json.put("isHappy", getRabbitHappinessStatus());
        return json;
    }

    // EFFECTS: returns habits in this tracker as a JSON array
    private JSONArray habitsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Habit h : getHabits()) {
            jsonArray.put(h.toJson());
        }

        return jsonArray;
    }
}
