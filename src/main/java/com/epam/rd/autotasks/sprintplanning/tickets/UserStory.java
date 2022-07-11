package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {
    private final UserStory[] dependsOn;
    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn=dependsOn;
        //throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public void complete() {
        status = true;
        if (dependsOn.length!=0) {
            for (UserStory i : dependsOn)
                if (!i.isCompleted()) {
                    status = false;
                    break;
                }
        }
        //throw new UnsupportedOperationException("Implement this method");
    }

    public UserStory[] getDependencies() {
        return dependsOn.clone();
        //throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public String toString() {
        return String.format("[US %d] %s",getId(),getName());
        //throw new UnsupportedOperationException("Implement this method");
    }
}
