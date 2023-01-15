package Lecture;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Lecture {
private DayOfWeek dayOfWeek;
private LocalTime localTime;
private Duration duration;
public DayOfWeek getDayOfWeek() {
	return dayOfWeek;
}
public void setDayOfWeek(DayOfWeek dayOfWeek) {
	this.dayOfWeek = dayOfWeek;
}
public LocalTime getLocalTime() {
	return localTime;
}
public void setLocalTime(LocalTime localTime) {
	this.localTime = localTime;
}
public Duration getDuration() {
	return duration;
}
public void setDuration(Duration duration) {
	this.duration = duration;
}
public Lecture(DayOfWeek dayOfWeek, LocalTime localTime, Duration duration) {
	super();
	this.dayOfWeek = dayOfWeek;
	this.localTime = localTime;
	this.duration = duration;
}
public Lecture() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return   dayOfWeek +" "+  localTime + " " + duration.toMinutes() + " minutes" ;
}

}
