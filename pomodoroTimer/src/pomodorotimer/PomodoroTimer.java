/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomodorotimer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;


/**
 *
 * @author user
 */
public class PomodoroTimer {

    private int status; 
    private int taskLength;
    private int taskTimer;
    private int taskCount;
    private int shortBreakTime;
    private int longBreakTime;

    public PomodoroTimer() {
        this.setStatus(0);
        this.setTaskLength(8);
        this.setTaskTimer(25);
        this.setShortBreakTime(3);
        this.setLongBreakTime(5);
        this.setTaskCount(0);
    }

    //setter and getter 
    public void setStatus(int status) {
        this.status = status;
    }

    public void setTaskLength(int taskLength) {
        this.taskLength = taskLength;
    }

    public void setTaskTimer(int taskTimer) {
        this.taskTimer = taskTimer;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public void setShortBreakTime(int shortBreakTime) {
        this.shortBreakTime = shortBreakTime;
    }

    public void setLongBreakTime(int longBreakTime) {
        this.longBreakTime = longBreakTime;
    }

    public int getStatus() {
        return status;
    }

    public int getTaskLength() {
        return taskLength;
    }

    public int getTaskTimer() {
        return taskTimer;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public int getShortBreakTime() {
        return shortBreakTime;
    }

    public int getLongBreakTime() {
        return longBreakTime;
    }
    
    //checking status 
    public String checkStatus(int status){
        String hasil = "";
        if(status == 0){
            hasil = "NO_TIMER";
        }else if(status == 1){
            hasil = "TASK_TIMER";
        }else if(status == 2){
            hasil = "SHORT_BREAK_TIMER";
        }else{
            hasil = "LONG_BREAK_TIMER";
        }
        return hasil;
    }
    
    
    //initializing mainTimer
    private  Scanner inputValue = new Scanner(System.in);
    private int minutePassed = 0;
    private int secondPassed = 0;
    private Timer timer = new Timer();
    private TimerTask task = new TimerTask(){
        public void run(){
            if(secondPassed == 60){
                minutePassed += 1;
                secondPassed = 0;
            }
            secondPassed++;
            System.out.println("Session "+minutePassed+" : "+secondPassed);
        }
    };
        
    //start the timer 
    public void startTimer(int taskLength, int status){
        String statusResult = "";
        this.status = 1;
        String statusCheck = checkStatus(status);
        if(statusCheck == "NO_TIMER"){
            statusResult = "POMODORO ";
        }
        System.out.println(statusResult+"  has been started !!");
        timer.scheduleAtFixedRate(task, taskLength*60 , 1000);
        String checkStartBreak = inputValue.nextLine();
        if(checkStartBreak == "Y"){
            this.taskCount += 1;
            if(taskCount == 3){
                this.status = 3;
                startBreakLongBreak(this.longBreakTime, this.status);
            }else{
                this.status = 2;
                startBreakShortBreak(this.shortBreakTime, this.status);
            }
        }else {
            endTimer();
        }       
    }
       
    public void startBreakShortBreak(int shortBreakTime, int status){
        String statusResult = "";
        String statusCheck = checkStatus(status);
        if(statusCheck == "SHORT_BREAK_TIMER"){
            statusResult = "SHORT BREAK ";
        }
        System.out.println(statusResult+"  has been started !!");
        timer.scheduleAtFixedRate(task, shortBreakTime*60 , 1000);
        startTimer(this.taskLength, this.status);
    }
    
    public void startBreakLongBreak(int longBreakTime, int status){
        String statusResult = "";
        String statusCheck = checkStatus(status);
        if(statusCheck == "LONG_BREAK_TIMER"){
            statusResult = "LONG BREAK ";
        }
        System.out.println(statusResult+"  has been started !!");
        timer.scheduleAtFixedRate(task, longBreakTime*60 , 1000);
        startTimer(this.taskLength, this.status);
    }
    
    public String endTimer(){
        return "END OF POMODORO SYSTEM";
    }
    
    
    
}
