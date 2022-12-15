package javaRMI;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Data implements Serializable {

    private String clientName;
    private String fuelPrice;
    private String fuelType;
    private String date;

    public Data(String clientName, String fuelPrice, String fuelType, String date) {
        this.clientName = clientName;
        this.fuelPrice = fuelPrice;
        this.fuelType = fuelType;
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String name) {
        this.clientName = name;
    }

    public String getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(String fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    
    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
    public String toString() {
        return "Cliente: " + clientName + "\nValor abastecido: " + fuelPrice + "\nTipo do combustível: " + fuelType + "\nData: " + date + "\n";
    }
}
