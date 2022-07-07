package org.albensumya.hackathon.datealgo;

public class Place {
    private int[] preferencesArr;

    public Place(int[] preferencesArr) {
        this.preferencesArr = preferencesArr;
    }

    public int compareTo(Place p2, int category) {
        return preferencesArr[category] - p2.getPreferencesArr()[category];
    }

    public int[] getPreferencesArr() {
        return preferencesArr;
    }
}
