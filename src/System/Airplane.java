package System;

public class Airplane {
    private String code;
    private String planeName;
    private int qntSeats;

    public Airplane(String code, String planeName, int qntSeats) {
        this.code = code;
        this.planeName = planeName;
        this.qntSeats = qntSeats;
    }

    // ========== getters e setters ==========

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public int getQntSeats() {
        return qntSeats;
    }

    public void setQntSeats(int qntSeats) {
        this.qntSeats = qntSeats;
    }

}