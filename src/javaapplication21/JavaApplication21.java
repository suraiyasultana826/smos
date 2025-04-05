//Suria Sultana
//id: 24549010107
package javaapplication21;
class InvalidPerformanceRatingException extends Exception { 
    public InvalidPerformanceRatingException(String message) {
        super(message);
    }
}

class InvalidContactNumberException extends Exception { 
    public InvalidContactNumberException(String message) {
        super(message);
    }
}

 abstract class Employee{
     
     private long id;
     private String name;
     private String contactNumber;
     private int rating;
     
     
     public long getId(){
         return id;
     }
     
     public void setId(long id){
         this.id=id;
     }
     
     public String getName(){
         return name;
     }
     
     public void setName(String name){
         this.name=name;
     }
     
     public String getContactNumber(){
         return contactNumber;
     }
     
     public void setContactNumber(String contactNumber) throws InvalidContactNumberException { 
         if(contactNumber.length()!=10){
             throw new InvalidContactNumberException("Contact number must contain 10 digits");
         }
         else{
             this.contactNumber=contactNumber;
         }
     }
     
     public int getRating(){
         return rating;
     }
     
     public void setRating(int rating) throws InvalidPerformanceRatingException { 
         if(rating<1||rating>5){
             throw new InvalidPerformanceRatingException(" Enter a rating between 1 to 5.");
         }
         else{
             this.rating=rating;
         }
     }
     
     
     
     abstract void salaryCalculation(int workingHours,int wagesPerHour);
     
     abstract void displayInformation();
}

class Full_Time_Employee extends Employee{
    

    @Override
    void displayInformation(){
        
        System.out.println("Full Time Employee");
        System.out.println("Name: "+getName());
        System.out.println("ID: "+getId());
        System.out.println("Contact Number: "+getContactNumber());
        System.out.println("Rating: "+getRating()); 
                
        
    }
   
    @Override
    void salaryCalculation(int workingHours,int wagesPerHour){
        int transportationFee=2000;
        int lunch=4500;
        int disbursement = transportationFee + lunch;

        System.out.println("Salary of  " +getName()+" : "+workingHours*wagesPerHour);
        System.out.println("Disbursement: "+disbursement);
        System.out.println("Total Withdrawable amount: "+(workingHours*wagesPerHour+disbursement));
        System.out.println();
                
    }
    
    
        }

class Part_Time_Employee extends Employee{
    
     @Override
    void displayInformation(){
        
        System.out.println("Part Time Employee (No disbursement)"); 
        System.out.println("Name: "+getName());
        System.out.println("ID: "+getId());
        System.out.println("Contact Number: "+getContactNumber());
        System.out.println("Rating: "+getRating()); 
                
        
    }
     
     @Override
    void salaryCalculation(int workingHours,int wagesPerHour){
        System.out.println("Salary of Part-Time-Employee: "+workingHours*wagesPerHour);
    }
    
     
    
     
}



public class JavaApplication21 {

    public static void main(String[] args) {
           try{
             Full_Time_Employee fullTimeEmployee=new Full_Time_Employee();
        fullTimeEmployee.setId(907);
        fullTimeEmployee.setName("Tanu");
        fullTimeEmployee.setContactNumber( "0151677570");
        fullTimeEmployee.setRating(90);
        
        
           

        fullTimeEmployee.displayInformation();
        fullTimeEmployee.salaryCalculation(200,50);
        
         Part_Time_Employee partTimeEmployee=new Part_Time_Employee();
        partTimeEmployee.setId(387);
        partTimeEmployee.setName("Suraiya Sultana");
        partTimeEmployee.setContactNumber( "0199394920");
        partTimeEmployee.setRating(4);
        partTimeEmployee.displayInformation();
        partTimeEmployee.salaryCalculation(80,50);
        }
        catch (InvalidPerformanceRatingException  e){
            System.out.println(e.getMessage());
        }
        catch(InvalidContactNumberException e){
            System.out.println(e.getMessage());
        }
       

    }
    
}
