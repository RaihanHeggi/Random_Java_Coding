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
    private int minutePassed;
    private int secondPassed;
    private int lastTime;
    private Timer timer = new Timer();
    private TimerTask task = new TimerTask(){
        public void run(){
            if(secondPassed == 60){
                minutePassed += 1;
                secondPassed = 0;
                if(lastTime <= 0){
                    System.out.println("Do you want to start break session ! (Y/N)");
                    String selectionInput = inputValue.nextLine();
                    String selection = selectionInput.toLowerCase();
                    if(selection == "y" ){
                        if(taskCount >= 3){
                            status = 2;
                            startBreakShortBreak(shortBreakTime,status);
                        }else{
                            status = 3;
                            startBreakLongBreak(longBreakTime,status);
                        }
                    }else{
                        endTimer();
                    }    
                }else{ 
                    if(status == 1){
                        lastTime = (taskTimer - minutePassed)+1;
                        System.out.println("Remaining Session Time "+lastTime+" Minutes Again");
                    }else if(status == 2){
                        lastTime = (shortBreakTime - minutePassed)+1;
                        System.out.println("Remaining Session Time "+lastTime+" Minutes Again");
                    }else{ 
                        lastTime = (longBreakTime - minutePassed)+1;
                        System.out.println("Remaining Session Time "+lastTime+" Minutes Again");
                    }
                }
            }
            secondPassed++;
        }
    };
        
    //start the timer 
    public void startTimer(int taskLength, int status){
        String statusResult = "";
        this.status = 1;
        this.minutePassed = 0;
        this.secondPassed = 0;
        this.lastTime = 9999;
        String statusCheck = checkStatus(status);
        if(statusCheck == "NO_TIMER"){
            statusResult = "POMODORO ";
        }
        System.out.println(statusResult+"  has been started !!");
        timer.scheduleAtFixedRate(task,25,taskLength*60);
    }
       
    public void startBreakShortBreak(int shortBreakTime, int status){
        String statusResult = "";
        String statusCheck = checkStatus(status);
        this.minutePassed = 0;
        this.secondPassed = 0;
        this.lastTime = 9999;
        if(statusCheck == "SHORT_BREAK_TIMER"){
            statusResult = "SHORT BREAK ";
        }
        System.out.println(statusResult+"  has been started !!");
        timer.scheduleAtFixedRate(task,25,shortBreakTime*60 );
        startTimer(this.taskLength, this.status);
    }
    
    public void startBreakLongBreak(int longBreakTime, int status){
        String statusResult = "";
        String statusCheck = checkStatus(status);
        this.minutePassed = 0;
        this.secondPassed = 0;
        this.lastTime = 9999;
        if(statusCheck == "LONG_BREAK_TIMER"){
            statusResult = "LONG BREAK ";
        }
        System.out.println(statusResult+"  has been started !!");
        timer.scheduleAtFixedRate(task,25,longBreakTime*60);
        startTimer(this.taskLength, this.status);
    }
    
    public String endTimer(){
        return "END OF POMODORO SYSTEM";
    }
    
    
    
}
