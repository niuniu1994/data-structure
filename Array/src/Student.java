
public class Student {
	
	private String studentName;
	private int studentScore;
	

	public Student(int studentScore,String studentName) {
		this.studentName = studentName;
		this.studentScore = studentScore;
	}

	public String toString() {
		return String.format("Name:%s,Score%s",studentName,studentScore);
	}
	
	public static void main(String args[]) {
		Array<Student> arr = new Array();
		
		arr.addFirst(new Student(90,"jim"));
		arr.addFirst(new Student(90,"jack"));
		System.out.println(arr);
	}
}
