package com.loda.refConstructor;

public class Student extends Person {
    public String add;
    protected double enScore;
    Float chiSocre;
    private Double mathScore;

    public Student(){}

    public Student(String add, double enScore, Float chiSocre, Double mathScore) {
        this.add = add;
        this.enScore = enScore;
        this.chiSocre = chiSocre;
        this.mathScore = mathScore;
    }

    protected Student(String add, double enScore, Float chiSocre) {
        this.add = add;
        this.enScore = enScore;
        this.chiSocre = chiSocre;
    }

    Student(String add, double enScore) {
        this.add = add;
        this.enScore = enScore;
    }

    private Student(String name, Integer age, String add, double enScore, Float chiSocre, Double mathScore) {
        super(name, age);
        this.add = add;
        this.enScore = enScore;
        this.chiSocre = chiSocre;
        this.mathScore = mathScore;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public double getEnScore() {
        return enScore;
    }

    public void setEnScore(double enScore) {
        this.enScore = enScore;
    }

    public Float getChiSocre() {
        return chiSocre;
    }

    public void setChiSocre(Float chiSocre) {
        this.chiSocre = chiSocre;
    }

    public Double getMathScore() {
        return mathScore;
    }

    public void setMathScore(Double mathScore) {
        this.mathScore = mathScore;
    }

    @Override
    public String toString() {
//        super.toString();
        return "Student{" +
                "add='" + add + '\'' +
                ", enScore=" + enScore +
                ", chiSocre=" + chiSocre +
                ", mathScore=" + mathScore +
                '}';
    }
}
