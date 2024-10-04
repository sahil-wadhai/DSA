package q1;

import java.util.*;

class CourseProgram{
    static class Course{
        private int courseId;
        private String courseName;
        private String courseAdmin;
        private int quiz;
        private int handson;
        
        public Course(int id, String name, String admin, int quiz,int handson){
            this.courseId = id;
            this.courseName = name;
            this.courseAdmin = admin;
            this.quiz = quiz;
            this.handson = handson;
        }
        public void setCourseId(int id){
            this.courseId = id;
        }
        public int getCourseId(){
            return this.courseId;
        }
        
        public void setCourseName(String name){
            this.courseName = name;
        }
        public String getCourseName(){
            return this.courseName;
        }
        
        public void setCourseAdmin(String admin){
            this.courseAdmin=admin;
        }
        public String getCourseAdmin(){
            return this.courseAdmin;
        }
        
        public void setQuiz(int quiz){
            this.quiz =quiz;
        }
        public int getQuiz(){
            return this.quiz;
        }
        
        public void setHandson(int handson){
            this.handson=handson;
        }
        public int getHandson(){
            return this.handson;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Start....");
        Scanner sc = new Scanner(System.in);
        int n = 4;
        Course [] courses = new Course[n];
        
        for(int i = 0 ; i<n ; i++){
            int a = sc.nextInt();sc.nextLine();
			String b = sc.nextLine();
			String c = sc.nextLine();
			int d = sc.nextInt();sc.nextLine();
			int e = sc.nextInt();sc.nextLine();
            courses[i] = new Course(a,b,c,d,e);
        }
        
        String admin = sc.nextLine();
		int hand = sc.nextInt();
        int res1 = findAvgOfQuizByAdmin(courses,admin);
        Course [] res2 = sortCourseByHandson(courses,hand);
        
        if(res1==0){
            System.out.println("No Course Found");
        }
        else{
            System.out.println(res1);
        }
        if(res2==null){
            System.out.println("No Course found with mentioned attribute");
        }
        else{
            for(Course c : res2){
                System.out.println(c.getCourseName());
            }
            
        }
        sc.close();
    }
    
    public static int findAvgOfQuizByAdmin(Course [] courses, String admin){
        int total = 0;
        int count = 0;
        for(Course c:courses){
            if(c.getCourseAdmin().equalsIgnoreCase(admin)){
                total += c.getQuiz();
                count++;
            }
        }
        if(total==0 || count==0){
            return 0;
        }
        return total/count;
    }
    
    public static Course[] sortCourseByHandson(Course [] courses,int givenHandson){
        List<Course> courseArr = new ArrayList<>();
        
        for(Course c : courses){
            if(c.getHandson()<givenHandson){
                courseArr.add(c);
            }
        }
        Collections.sort(courseArr,(c1,c2)->{
            if(c1.getHandson()>c2.getHandson()) return 1;
            else return -1;
        });
        
        Course [] newCourseArr = new Course[courseArr.size()];
        int i=0;
        for(Course course:courseArr){
            newCourseArr[i] = new Course(course.getCourseId(),course.getCourseName(),course.getCourseAdmin(),course.getQuiz(),course.getHandson());
            i++;
        }
        if(i==0) return null;
        return newCourseArr; 
    }
}
