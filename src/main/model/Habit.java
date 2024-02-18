package model;

import java.util.ArrayList;

public class Habit {
    private String title;
    private String desc;
    private int perDay;
    private int progress;
    private Boolean finished;
    private ArrayList<String> categories;
    private String category;


    // EFFECTS: Creates a new habit that the user wants to keep track of, initializes specifications as follows:
    //          title of the habit
    //          description of the habit
    //          how many times does the user wants to do the habit each day
    //          sets the finished status to false
    public Habit(String title, String desc, int perDay, String category) {
        this.title = title;
        this.desc = desc;
        this.perDay = perDay;
        this.progress = 0;
        this.finished = false;
        categories = new ArrayList<>();
        categories.add("Lifestyle");
        categories.add("Social");
        categories.add("Diet");
        categories.add("Hobby");
        this.category = category;
    }

    // MODIFIES : this
    // EFFECTS : increments the progress of the habit by 1
    public void addProgress() {
        progress++;
    }

    // MODIFIES : this
    // EFFECTS : checks if the habit goal is accomplished
    public boolean isFinished() {
        if (progress >= perDay) {
            finished = true;
            return true;
        }
        return false;
    }

    // MODIFIES : this
    // EFFECTS : modifies the habit title
    public void modifyTitle(String g) {
        title = g;
    }

    // MODIFIES : this
    // EFFECTS : modifies the habit title
    public void modifyCategory(String d) {
        category = d;
    }

    // MODIFIES : this
    // EFFECTS : modifies the habit goal
    public void modifyPerDay(int d) {
        perDay = d;
    }

    // MODIFIES : this
    // EFFECTS : modifies the habit description
    public void modifyDescription(String p) {
        desc = p;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getPerDay() {
        return perDay;
    }

    public int getProgress() {
        return progress;
    }

    public String getCategory() {
        return category;
    }
}