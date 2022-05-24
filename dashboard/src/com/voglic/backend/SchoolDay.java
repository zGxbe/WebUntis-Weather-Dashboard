package com.voglic.backend;

import java.util.Arrays;
import java.util.Comparator;

public class SchoolDay {
    Subject[] subjects;

    SchoolDay(String timetableFile) {
        int length = 0;
        try {
            while (true){
                new Subject(timetableFile, length);
                length++;
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Succesfully read the length!");
        }
        subjects = new Subject[length];
        for (int i = 0; i < length; i++){
            subjects[i] = new Subject(timetableFile, i);
        }
        Arrays.sort(subjects, new Sortbystart());
    }

    @Override
    public String toString() {
        return "SchoolDay: " + Arrays.toString(subjects);
    }
}

class Sortbystart implements Comparator<Subject> {
    @Override
    public int compare(Subject a, Subject b){
        return a.starttime - b.starttime;
    }
}