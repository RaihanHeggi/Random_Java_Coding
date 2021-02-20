/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomodorotimer;
/**
 *
 * @author user
 */
public class main_class {
    public static void main(String[] args) {
        PomodoroTimer pomodoro = new PomodoroTimer();
        pomodoro.startTimer(pomodoro.getTaskLength());
        
    }
}
