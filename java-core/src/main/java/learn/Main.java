package learn;

class Course {

	public double average = 0;

	public Course(double... vars) {
		if (vars.length > 0) {
			double sum = 0;
			for (double d : vars) {
				sum += d;
			}
			this.average = sum / vars.length;
		}
	}
}

public class Main {

	public static void main(String[] args) {

		Course course = new Course(60, 10, 80);
		System.out.println(course.average);

		Course course1 = new Course(50, 40, 30);
		System.out.println(course1.average);
	}

}
