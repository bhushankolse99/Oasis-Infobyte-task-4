import java.util.*;
public class OnlineExam
{
	Scanner sc = new Scanner(System.in);
	HashMap<String,Integer> info = new HashMap<String,Integer>();
	public void login()
	{
		info.put("user1",1234);
		info.put("user2",3214);
		info.put("user3",7894);
		info.put("user4",6547);
		info.put("user5",7896);
		String id;
		int pwd;
		System.out.println("Login to your account!");
		System.out.println("Enter your user ID:");
		id = sc.next();
		System.out.println("Enter your password:");
		pwd = sc.nextInt();
		if(info.containsKey(id) && info.get(id)==pwd)
		{
			System.out.println("\nLogin successful!");
			menu();
		}
		else
		{
			System.out.println("\nIncorrest user ID or password!\nTry again!\n");
			login();
		}
	}
	public void menu()
	{
		int ch;
		System.out.println("\nEnter your choice:");
		System.out.println("1.Update profile \n2.Start exam \n3.Logout");
		ch = sc.nextInt();
		switch(ch)
		{
			case 1:
				info = update();
				menu();
				break;
			case 2:
				startExam();
				menu();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Choose a valid operation!");
		}
	}
	public HashMap<String,Integer> update()
	{
		String update_id;
		int update_pwd;
		System.out.println("Enter your username:");
		update_id = sc.next();
		System.out.println("Enter your old password:");
		update_pwd = sc.nextInt();
		if(info.containsKey(update_id) && info.get(update_id)==update_pwd)
		{
			System.out.println("Enter new password:");
			update_pwd = sc.nextInt();
			info.replace(update_id,update_pwd);
			System.out.println("Password reset successfully!");
		}
		else
		{
			System.out.println("User record not found!\n");
		}
		return info;
	}
	public void startExam()
	{
		long startTime = System.currentTimeMillis();
		long endTime = startTime + 30;
		int score = 0,ans;
		
		System.out.println("Instructions:");
		System.out.println("1. There are 5 questions in this exam");
		System.out.println("2. All questions are compulsory");
		System.out.println("3. For each correct answer you will get 5 marks");
		System.out.println("4. For each wrong answer 1 mark will be reduced from your obtained marks");
		System.out.println("5. Time limit to complete the exam is 5 minutes");
		System.out.println("\n All The Best!\n");
		System.out.println("**********************Exam has started**********************");
		while(System.currentTimeMillis()<endTime)
		{
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q1.Number of primitive data types in Java are?");
			System.out.println("1.6 \t2.7 \t3.8\t4.9");
			System.out.print("Answer:");
			ans = sc.nextInt();
			if(ans == 3)
				score+=5;
			else
				score--;
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q2.What is the size of float and double in java?");
			System.out.println("1.32 and 64 \t2.32 and 32 \t3.64 and 64\t4.64 and 32");
			System.out.print("Answer:");
			ans = sc.nextInt();
			if(ans == 1)
				score+=5;
			else
				score--;
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q3.Automatic type conversion is possible in which of the possible cases?");
			System.out.println("1.Byte to int \t2.int to long \t3.Long to int \t4.short to int");
			System.out.print("Answer:");
			ans = sc.nextInt();
			if(ans == 2)
				score+=5;
			else
				score--;
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q4.Find the output of the following code.\n int Integer = 24;\n char String  = I;\n System.out.print(Integer);\n System.out.print(String);");
			System.out.println("1.compile error \t2.Throws exception \t3.I\t4.24 I");
			System.out.print("Answer:");
			ans = sc.nextInt();
			if(ans == 4)
				score+=5;
			else
				score--;
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q5.Select the valid statement.");
			System.out.println("1.char[] ch = new char[5]\t2.char[] ch = new char[]\t3.char[] ch = new char()\t4.char[] ch = new char(5)");
			System.out.print("Answer:");
			ans = sc.nextInt();
			if(ans == 1)
				score+=5;
			else
				score--;
			System.out.println("-------------------------------------------------------------");
			break;
		}
		System.out.println("Your exam has ended.");
		System.out.println();
		System.out.println("Your score is "+score);
		if(score>10)
			System.out.println("Congratulations!");
		else
			System.out.println("Better Luck Next Time!");
	}
	public static void main(String args[])
	{
		OnlineExam obj = new OnlineExam();
		obj.login();
	}
}