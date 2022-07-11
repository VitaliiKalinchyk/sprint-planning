package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {

    UserStory userStory;
    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory==null || !userStory.isCompleted())
            return null;
        return new Bug(id, name, estimate, userStory);
        //throw new UnsupportedOperationException("Implement this method");
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory=userStory;
        //throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public String toString() {
        return String.format("[Bug %d] %s: %s",getId(),userStory.getName(),getName());
        //throw new UnsupportedOperationException("Implement this method");
    }
}
