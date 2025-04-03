
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
     
     
     
     abstract void salaryCalculation(int workingHours,int hourlyWages);
     
     abstract void displayInformation();
}

class Full_Time_Employee extends Employee{
    

    @Override
    void displayInformation(){
        
        System.out.println("Status: Full Time Employee");
        System.out.println("Name: "+getName());
        System.out.println("ID: "+getId());
        System.out.println("Contact Number: "+getContactNumber());
        System.out.println("Rating: "+getRating()); // Added missing ":"
                
        
    }
   
    @Override
    void salaryCalculation(int workingHours,int hourlyWages){
        int transportationFee=2000;
        int lunch=4500;
        int disbursement = transportationFee + lunch;

        System.out.println("Salary of  " +getName()+" : "+workingHours*hourlyWages);
        System.out.println("Disbursement: "+disbursement);
        System.out.println("Total Withdrawable amount: "+(workingHours*hourlyWages+disbursement));
        System.out.println();
                
    }
    
    
        }

class Part_Time_Employee extends Employee{
    
     @Override
    void displayInformation(){
        
        System.out.println("Status: Part Time Employee (No disbursement)"); // Corrected status
        System.out.println("Name: "+getName());
        System.out.println("ID: "+getId());
        System.out.println("Contact Number: "+getContactNumber());
        System.out.println("Rating: "+getRating()); // Added missing ":"
                
        
    }
     
     @Override
    void salaryCalculation(int workingHours,int hourlyWages){
        System.out.println("Salary of Part-Time-Employee: "+workingHours*hourlyWages);
    }
    
     
    
     
}



public class JavaApplication21 {

    public static void main(String[] args) {
           try{
             Full_Time_Employee f=new Full_Time_Employee();
        f.setId(5678);
        f.setName("Tanu");
        f.setContactNumber( "0151677570");
        f.setRating(1);
        
        
           

        f.displayInformation();
        f.salaryCalculation(450,30);
        
         Part_Time_Employee p=new Part_Time_Employee();
        p.setId(5679);
        p.setName("Suraiya Sultana");
        p.setContactNumber( "0199394920");
        p.setRating(5);
        p.displayInformation();
        p.salaryCalculation(120,20);
        }
        catch (InvalidPerformanceRatingException  e){
            System.out.println(e.getMessage());
        }
        catch(InvalidContactNumberException e){
            System.out.println(e.getMessage());
        }
       

    }
    
}
