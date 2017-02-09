package ua.jdbc.domain;

import java.time.LocalDate;

public class Salary extends BaseEntity{

    private LocalDate date;

    private double value;

    private int emplId;

    public Salary(LocalDate date, double value, int emplId) {
        this.date = date;
        this.value = value;
        this.emplId = emplId;
    }

    public Salary(int id, LocalDate date, double value, int emplId) {
        setId(id);
        this.date = date;
        this.value = value;
        this.emplId = emplId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getEmplId() {
        return emplId;
    }

    public void setEmplId(int emplId) {
        this.emplId = emplId;
    }
}
