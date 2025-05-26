package entities;

import java.util.ArrayList;

public class Client implements Comparable<Client> {
    private String name;
    private Integer number;
    private ServiceModality serviceModality;
    private int score;
    private int times = 0;

    public Client(ArrayList<Integer> numbers, ServiceModality serviceModality) {
        setNumber(numbers);
        setName();
        setServiceModality(serviceModality);
        setScore(serviceModality);
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = "Cliente #" + this.number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(ArrayList<Integer> numbers) {
        this.number = numbers.getLast() + 1;
        numbers.add(this.number);
    }

    public ServiceModality getServiceModality() {
        return serviceModality;
    }

    public void setServiceModality(ServiceModality serviceModality) {
        this.serviceModality = serviceModality;
    }

    public int getScore() {
        return score;
    }

    public void setScore(ServiceModality serviceModality) {
        if (serviceModality == ServiceModality.GENERAL) {
            this.score = 1;
        } else {
            this.score = 3;
        }
    }

    public void incrementScore() {
        this.score++;
    }

    public void incrementTime() {
        this.times++;
    }
    public int getTimes() {
        return times;
    }

    @Override
    public int compareTo(Client other) {
        int scoreComparison = Integer.compare(other.getScore(), this.getScore());
        if (scoreComparison != 0) {
            return scoreComparison;
        }
        return Integer.compare(other.getTimes(), this.getTimes());
    }
}