package com.example.android_project_v3;

public class Lesson {

    private int lessonNumber;
    private String name;
    private int length; // will convert to hr and min later with a converter
    private boolean isCompleted;

    private Lesson() {
    }

    private Lesson(int lessonNumber, String name, int length, boolean isCompleted) {
        this.lessonNumber = lessonNumber;
        this.name = name;
        this.length = length;
        this.isCompleted = isCompleted;
    }

    private static Lesson[] instances = {
            new Lesson(1, "Introduction to the course", 12, false),
            new Lesson(2, "What is Javascript", 30, false),
            new Lesson(3, "Variables and conditionals", 80, false),
            new Lesson(4, "Loops", 38, false)
    };

    public static Lesson[] getInstances() {
        return instances;
    }

    public static Lesson getInstance(int index) {
        return instances[index];
    }

    public String lengthConverter(int length) {
        if (length >= 60) {
            return (length / 60) + "hr " + (length % 60) + " min";
        } else {
            return (length % 60) + " min";
        }

    }

    @Override
    public String toString() {
        return lessonNumber + ". " + name + "\n" + lengthConverter(length);
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public static void setInstances(Lesson[] instances) {
        Lesson.instances = instances;
    }
}
