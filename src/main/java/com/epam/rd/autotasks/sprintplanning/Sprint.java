package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {
    private final int capacity;
    private final int ticketsLimit;
    private int estimatedTime=0, numberOfTickets=0;
    private final Ticket[]  sprintTickets;
    public Sprint(int capacity, int ticketsLimit) {
        this.capacity=capacity;
        this.ticketsLimit=ticketsLimit;
        sprintTickets=new Ticket[ticketsLimit];
        //throw new UnsupportedOperationException("Implement this method");
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory==null ||
                numberOfTickets==ticketsLimit ||
                userStory.getEstimate()+estimatedTime > capacity ||
                userStory.isCompleted())
            return false;
        if (userStory.getDependencies()!=null && userStory.getDependencies().length!=0)
            for (UserStory i: userStory.getDependencies()) {
               if (!ifStoryInSprint(i))
                   return false;
            }
        estimatedTime +=userStory.getEstimate();
        sprintTickets[numberOfTickets++]=userStory;
        return true;
        //throw new UnsupportedOperationException("Implement this method");
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport==null ||
                numberOfTickets==ticketsLimit ||
                bugReport.getEstimate()+estimatedTime > capacity ||
                bugReport.isCompleted())
            return false;
        estimatedTime +=bugReport.getEstimate();
        sprintTickets[numberOfTickets++]=bugReport;
        return true;
        //throw new UnsupportedOperationException("Implement this method");
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(sprintTickets,numberOfTickets);
        //throw new UnsupportedOperationException("Implement this method");
    }

    public int getTotalEstimate() {
        return estimatedTime;
        //throw new UnsupportedOperationException("Implement this method");
    }

    private boolean ifStoryInSprint (UserStory userstory){
        for (Ticket i: sprintTickets) {
            if (userstory.equals(i))
                return true;
        }
        return false;
    }
}
