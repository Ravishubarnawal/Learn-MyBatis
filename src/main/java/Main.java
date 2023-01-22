import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
    SqlSession session = factory.openSession();

    // create student object
    StudentInfo studentInfo = new StudentInfo();
    Scanner info = new Scanner(System.in);
    Scanner choice = new Scanner(System.in);
    System.out.println("Please Enter the input");
    int input = info.nextInt();

    switch (input) {
        // Insert studentInfo data in db:
      case 1:
        while (true) {
          System.out.println("Enter data");
          System.out.println("Name");
          Scanner infoString = new Scanner(System.in);
          String name = infoString.nextLine();
          System.out.println("Fee");
          int fee = info.nextInt();
          studentInfo.setName(name);
          studentInfo.setFee(fee);
          System.out.println("Do you want to insert more record (Yes/No)");
          String option = info.next();
          if (option.equalsIgnoreCase("No")) {
            session.insert("StudentInfo.insert", studentInfo);
            System.out.println("record inserted successfully");
            session.commit();
            session.close();
            break;
          }
        }
      case 2:
        // Reading all records from db:
        List<StudentInfo> studentInfo1 = session.selectList("StudentInfo.getAll");
        System.out.println(studentInfo1);
        //                Iterator it= studentInfo1.iterator();
        //                while (it.hasNext()){
        //                    StudentInfo value= (StudentInfo) it.next();
        //                    System.out.println(value);
        //                }
        for (StudentInfo students : studentInfo1) {
          System.out.println(students);
        }
        System.out.println("No of record are " + studentInfo1.stream().count());
        break;
      case 3:
        // updating records in db:
        do {
          System.out.println("Enter student_id to Update");
          int id = info.nextInt();
          StudentInfo s2 = (StudentInfo) session.selectOne("StudentInfo.getById", id);
          System.out.println(s2.toString());
          System.out.println("Update Student data begins.......");
          System.out.println("Enter name to be updated......");
          Scanner infoString = new Scanner(System.in);
          String name = infoString.nextLine();
          System.out.println("Enter updated fee.....");
          int fee = info.nextInt();
          s2.setName(name);
          s2.setFee(fee);
          session.update("StudentInfo.update", s2);
          session.commit();
          System.out.println("record updated successfully");
          System.out.println("Y to continue");
          session.commit();
          session.close();
        } while (Character.toUpperCase(choice.next().charAt(0)) == 'Y');
        break;
      case 4:
        //delete record from db:
        System.out.println("Enter student_id to delete record");
        int id = info.nextInt();
        session.delete("StudentInfo.deleteById", id);
        session.commit();
        session.close();
        System.out.println("Record deleted successfully");
        break;
      case 5:
        //store procedure
        System.out.println("Enter student_id to get results from store procedure created in mysqldb");
        int student_id = info.nextInt();
        StudentInfo storecall= (StudentInfo) session.selectOne("StudentInfo.callById",student_id);
        System.out.println(storecall);
        session.commit();
        session.close();

      case 6:
        //dynamic sql queries with if with WHERE // GetRecordByName
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the name for which you want to get records");
        String name=sc.nextLine();
        List<StudentInfo> s1= session.selectList("StudentInfo.getRecByName",name);
        for(StudentInfo studentDetail :s1){
          System.out.println(studentDetail);
        }
    }
  }
}
