import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testcase = Integer.parseInt(br.readLine());
            String[] events = new String[testcase];
            Stack<Task> tasks = new Stack<>();

            for (int i=0; i<testcase; ++i) {
                events[i] = br.readLine();
            }

            Task currentTask = null;
            int totalGrade = 0;
            for (String event : events) {
                StringTokenizer st = new StringTokenizer(event);
                boolean isNewTask = st.nextToken().equals("1") ;

                if (isNewTask) {
                    if (currentTask != null) {
                        tasks.add(currentTask);
                    }
                    int grade = Integer.parseInt(st.nextToken());
                    int time = Integer.parseInt(st.nextToken());
                    currentTask = new Task(grade, time);
                }
                
                if (currentTask == null) {
                    if (tasks.isEmpty()) {
                        continue;
                    }
                    currentTask = tasks.pop();
                }
                

                if (currentTask.doTaskAndCheckDone()) {
                    totalGrade += currentTask.getGrade();
                    currentTask = null;
                }
            }

            System.out.println(totalGrade);
        } catch (IOException ioe) {

        }
    }
}

class Task {
    private int grade;
    private int time;

    public Task(int grade, int time) {
        this.grade = grade;
        this.time = time;
    }

    public boolean doTaskAndCheckDone() {
        if(--time == 0) {
            return true;
        }
        return false;
    }

    public int getGrade() {
        return grade;
    }
    
}
