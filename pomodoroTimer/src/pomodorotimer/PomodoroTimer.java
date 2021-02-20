/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomodorotimer;
import java.util.Timer;
import java.util.TimerTask;


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
    public void startTimer(int taskLength){
        timer.scheduleAtFixedRate(task,taskLength*60,1000);
    }
    
    public void startBreakShortBreak(){
        
    }
    
    
    
    
    
}
