import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExcelWriter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name : ");
        String name = scanner.nextLine();

        System.out.println("Enter the email : ");
        String email = scanner.nextLine();

        System.out.println("Enter the salary : ");
        int salary = scanner.nextInt();
        File file = new File("sheet.csv");

        try{
            PrintWriter pw = new PrintWriter(new FileWriter("sheet.csv",true));

            if(file.length() == 0){
                pw.println("Name,Email,Salary");
            }

            pw.println(name+","+email+","+salary);
            pw.close();
            System.out.print("data updated!");

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        scanner.close();
    }
}
