package br.com.giovane.observer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Observer - quando um estado de um objeto muda, todos aqueles objetos que dependem dele tambem mudam

        // Create celebrity
        Celebrity celebrity1 = new Celebrity("Cristiano Ronaldo");

        // Create followers for celebrity and assign them to celebrity
        Follower follower1 = new Follower("Giovane");
        Follower follower2 = new Follower("Maria");
        Follower follower3 = new Follower("Fabio");

        celebrity1.addSubscriber(follower1);
        celebrity1.addSubscriber(follower2);
        celebrity1.addSubscriber(follower3);

        // Celebrity will make a post
        celebrity1.notifySubscribers("Having a good day in Portugal with my family...!");

    }
}

// -----------------------------------------------------------------------------------

interface Observer {
     void notifySubscribers(String message, String name);
}

// -----------------------------------------------------------------------------------

interface Subject {
     void addSubscriber(Observer observer);
     void removeSubscriber(Observer observer);
     void notifySubscribers(String message);
}

// -----------------------------------------------------------------------------------

class Follower implements Observer {

    public String followerName;

    public Follower(String followerName) {
        this.followerName = followerName;
    }

    public String getFollowerName() {
        return followerName;
    }

    public void setFollowerName(String followerName) {
        this.followerName = followerName;
    }

    @Override
    public void notifySubscribers(String message, String name) {
        System.out.println("Hey: " + this.followerName + " -> " + name + ", has made a post: " + message);
    }

}

// -----------------------------------------------------------------------------------

class Celebrity implements Subject {

    public String celebrityName;

    // Observers se registram no Subject para receber atualizacoes do objeto
    public List<Observer> observers = new ArrayList<>();

    public Celebrity(String celebrityName) {
        this.celebrityName = celebrityName;
    }

    @Override
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeSubscriber(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers(String message) {
        observers.forEach(observer -> observer.notifySubscribers(message, this.celebrityName));
    }
}

// -----------------------------------------------------------------------------------
