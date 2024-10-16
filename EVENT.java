
package event;

import java.util.Scanner;

public class EVENT {

    
    public static void main(String[] args) {
        String resp;

        Scanner sc = new Scanner(System.in);  // Declare scanner outside the loop to avoid creating multiple instances

        do {
            Event test = new Event();

            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    test.addRecord();
                    break;
                case 2:
                    test.viewRecord();
                    break;
                case 3:
                    test.viewRecord();
                    test.updateRecord();
                    break;
                case 4:
                    test.viewRecord();
                    test.deleteRecord();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();  // Close scanner before exiting
                    return;      // Exit the loop and terminate the program
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        
     System.out.print("Do you want to continue (yes/no)? ");
            resp = sc.next();

        } while (resp.equalsIgnoreCase("yes"));

        sc.close();  // Ensure scanner is closed
    }
    public void addRecord() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter Event ID to update: ");
        String sid = sc.next();
        System.out.print("Enter new Event Name: ");
        String courseId = sc.next();
        System.out.print("Enter new Event Date: ");
        String instructorId = sc.next();
        System.out.print("Enter new Event Location: ");
        String dayOfWeek = sc.next();
        System.out.print("Enter new Event Organizer: ");
        String startTime = sc.next();
        System.out.print("Enter End Time: ");
        String endTime = sc.next();
        

 String sql = "INSERT INTO event (event_ID, event_name, event_date, event_location, event_organizer, end_time)"  + "VALUES (?,?,?,?,?,?,?)";
        conf.addEvent(sql, eid, eventName, eventDate, eventLocation, eventOrganizer, endTime); 
    }
public void viewRecord() {
        String qry = "SELECT * FROM Event";
        String[] hdrs = {"Event_ID", "Event Name", "Event Date", "Event Location", "Event Oraganizer","End Time"};
        String[] clmns = {"event_ID", "event_name","event_date", "event_location","event_organizer","end_time"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmns);
    }

    public void updateRecord() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Event ID to update: ");
        String sid = sc.next();
        System.out.print("Enter new Event Name: ");
        String courseId = sc.next();
        System.out.print("Enter new Event Date: ");
        String instructorId = sc.next();
        System.out.print("Enter new Event Location: ");
        String dayOfWeek = sc.next();
        System.out.print("Enter new Event Organizer: ");
        String startTime = sc.next();
        System.out.print("Enter End Time: ");
        String endTime = sc.next();
        
        String sql = "UPDATE event SET event_name = ?, event_date= ?, event_location = ?, event_organizer =?,end_time=? WHERE event_ID = ?;
        config conf = new config();
       conf.Event(sql, eid, eventName, eventDate, eventLocation, eventOrganizer, endTime); 
    }

    public void deleteRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Event ID to delete: ");
        String sid = sc.next();

        String qry = "DELETE FROM Event WHERE Schedule_ID = ?";

        config conf = new config();
        conf.deleteEvent(qry, sid);
    }
}

    

