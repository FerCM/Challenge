package com.fernandacm.challenge.Models;

import java.util.ArrayList;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseRetrofit {
    private int count;
    private String next;
    boolean previous;
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public boolean isPrevious() {
        return previous;
    }

    public void setPrevious(boolean previous) {
        this.previous = previous;
    }


}
