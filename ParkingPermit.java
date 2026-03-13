package Week7;

import java.math.BigDecimal;
import java.util.Scanner;

public class ParkingPermit {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
	System.out.println("Choose your permit type"
			+ " R(Resident) or C(Commuter):");
	
	String PermitLine = scan.nextLine();
 Permit permit = null;	
	if (PermitLine.equals("R")) {
		permit = new ResidentPermit();
		
	} else if(PermitLine.equals("C")) {
		permit = new CommuterPermit();
	}
	
	System.out.println("What vehicle do you own?: (C,S,or M)");
	
	String TypeLine = scan.nextLine();
VehicleType Type = VehicleType.MOTORCYCLE;
	if (TypeLine.equals("C")) {
		Type = VehicleType.CAR;
	}else if(TypeLine.equals("S")) {
		Type = VehicleType.SUV;
	}
	
	System.out.println("# of Months:");

	
	int Months = scan.nextInt();
	scan.nextLine();
	
	boolean Carpool = false;
	
	System.out.println("Are you carpooling?:");
	
	String CarpoolLine = scan.nextLine();
	
	if (CarpoolLine.equals("T")) {
		Carpool = true;
	}
	
	BigDecimal subtotal = permit.GetCost();
	System.out.println("Permit Cost " + String.format("%.2f", subtotal));
	
	subtotal = subtotal.multiply(BigDecimal.valueOf(1).add(Type.multiplyer));
	
	System.out.println("Vehicle Type Modifier " + String.format("%.2f",BigDecimal.valueOf(1).add(Type.multiplyer).multiply(new BigDecimal(100))));
	
	if (Carpool) {
		subtotal = subtotal.multiply(new BigDecimal(.9));
		System.out.println("Carpooling -10%");
	}
	subtotal = subtotal.multiply(new BigDecimal(Months));
	System.out.println("Subtotal: " + String.format("%.2f", subtotal));
	
	BigDecimal total = subtotal.multiply(new BigDecimal(1.05));
	System.out.println("Total:  " + String.format("%.2f", total));
	}
}
