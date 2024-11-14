class Student {
    int studentID;                    
    String studentName;               
    int subjectMarks[];               // Array to store marks for each subject
    int Count = 0;               // Count o
  
    static final int A = 85; 
    static final int B = 70; 
    // Constructor 
   public  Student(int id, String name) {
        studentID = id;          
        studentName = name;            
        subjectMarks = new int[3]; // array size
    }
    // Method to add marks for a subject
   public void addMarks(int x) {
        subjectMarks[Count] = x; // Add marks to the array
        Count++;                      
    }
    // Method to calculate the overall grade
   public void gradeEvaluation() {
        int sum = 0;                       // to store the sum of marks
        for (int i = 0; i < Count; i++) { // Loop 
            sum += subjectMarks[i];      
        }
        double average = (double) sum / Count; // Calculate average marks
        // print grade  using if-else
        if (average >= A) {
            System.out.println(" Grade: A");
        } else if (average >= B) {
            System.out.println(" Grade: B");
        } else {
            System.out.println(" Grade: C");
        }
    }
    // Method to display student information and evaluate grade
    void result() {
        System.out.println("");
        System.out.println("ID: " + studentID + "   Name: " + studentName); 
        gradeEvaluation(); // Call method to evaluate grade
        System.out.println("");
    }
}
// Main class to run the program
public class GradingSystem {
    public static void main(String[] args) {
        Student s = new Student(2706, "VN"); // Create a new student object and constructor calling
        // Add marks for three subjects
        s.addMarks(85); // Add first subject marks
        s.addMarks(92); //
        s.addMarks(98); //

        s.result(); 
    }
}