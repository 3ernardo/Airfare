package System;

public class Airplane {
// ==================== Airplane ====================
// Esta classe cria conexao dos avioes com o BD e fornece os metodos necessarios
// para que as classes do pacote DAO acessem ao BD.
    private int airplaneKey;
    private String code;
    private String planeName;
    private int qntSeats;

    public Airplane(String code, String planeName, int qntSeats) {
        this.code = code;
        this.planeName = planeName;
        this.qntSeats = qntSeats;
    }

    public Airplane(int aK, String code, String planeName, int qntSeats) {
        this.airplaneKey = aK;
        this.code = code;
        this.planeName = planeName;
        this.qntSeats = qntSeats;
    }

    // ========== getters e setters ==========

    public int getAirplaneKey() {
        return airplaneKey;
    }

    public void setAirplaneKey(int airplaneKey) {
        this.airplaneKey = airplaneKey;
    }

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