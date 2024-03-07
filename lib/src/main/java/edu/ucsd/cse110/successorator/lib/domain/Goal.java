package edu.ucsd.cse110.successorator.lib.domain;

import androidx.annotation.NonNull;

import java.util.Objects;

/**
 *
 */
public class Goal {
    private final @NonNull Integer id;
    private final @NonNull String description;
    private boolean completed;
    private String date;
    private String repType;

    private String contextType;

    public Goal(
            @NonNull Integer id,
            @NonNull String description,
            boolean completed,
            String date,
            String repType, String contextType) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.date = date;
        this.repType = repType;
        this.contextType = contextType;
    }

    public Integer id() {
        return id;
    }

    public @NonNull String description() {
        return description;
    }

    public boolean completed() { return completed; }

    public String date() {return date;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal = (Goal) o;
        return Objects.equals(id, goal.id)
                && Objects.equals(description, goal.description)
                && Objects.equals(completed, goal.completed)
                && Objects.equals(date, goal.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, completed, date);
    }

    public String repType() {
        return repType;
    }

    public String contextType() {
        return contextType;
    }
}




