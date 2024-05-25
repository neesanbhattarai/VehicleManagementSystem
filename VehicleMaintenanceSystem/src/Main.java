import java.util.Scanner;
import java.util.Date;
import com.example.maintenance.MaintenanceSystem;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get vehicle details from the user
        System.out.println("Enter vehicle ID:");
        String vehicleId = scanner.nextLine();
        System.out.println("Enter initial mileage:");
        double mileage = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Instantiate MaintenanceSystem with vehicle details
        MaintenanceSystem maintenanceSystem = new MaintenanceSystem(vehicleId, mileage);

        // Record maintenance
        System.out.println("Enter maintenance description:");
        String description = scanner.nextLine();
        System.out.println("Enter cost:");
        double cost = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        maintenanceSystem.recordMaintenance("Oil Change", new Date(), description, cost);

        // Schedule maintenance task
        maintenanceSystem.scheduleMaintenanceTask(vehicleId, new Date());

        // Process repair request
        System.out.println("Enter repair issue description:");
        String issueDescription = scanner.nextLine();
        maintenanceSystem.processRepairRequest(vehicleId, issueDescription);

        // Generate maintenance reminder
        maintenanceSystem.generateMaintenanceReminder(vehicleId);

        // Monitor spare parts availability (assuming this doesn't require input)

        // Track updated mileage
        System.out.println("Enter updated mileage:");
        double updatedMileage = scanner.nextDouble();
        maintenanceSystem.trackVehicleMileage(vehicleId, updatedMileage); // Update mileage

        // Generate maintenance report
        maintenanceSystem.generateMaintenanceReport(vehicleId);

        // Manage maintenance schedule (assuming this doesn't require input)

        // Track warranty information (assuming this doesn't require input)

        // Track repair status
        maintenanceSystem.trackRepairStatus(vehicleId);

        scanner.close();
    }
}
