package org.albensumya.hackathon.datealgo;

public class Algo {
    private static String[][] questions;
    private static String[] responses;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            update();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Algo() {
        questions = new String[5][6];
        responses = new String[5];
    }

    public static String[][] update() {
        return questions;
    }

}