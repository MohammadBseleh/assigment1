package Lecture;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConflictCheck {
	public static Map<DayOfWeek, ArrayList<Lecture>> mapLectures = new HashMap<DayOfWeek, ArrayList<Lecture>>();
    public static boolean conflict = false;
	public static void main(String[] args) {
		try {
			File myObj = new File("/Users/nabilbasila/Desktop/java stuff/Java8Fea/lecture.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				Lecture lecture = new Lecture();
				lecture.setDayOfWeek(determineTheDay(myReader.next()));
                lecture.setLocalTime(LocalTime.parse(myReader.next()));
                lecture.setDuration(Duration.ofMinutes(myReader.nextInt()));
                if(mapLectures.containsKey(lecture.getDayOfWeek()))
						{
					        mapLectures.get(lecture.getDayOfWeek()).add(lecture);
						}
                else {
                mapLectures.put(lecture.getDayOfWeek(), new ArrayList<Lecture>());
                mapLectures.get(lecture.getDayOfWeek()).add(lecture);
                }
                
			}
			for (DayOfWeek day : DayOfWeek.values()) {
				List<ArrayList<Lecture>> lectureSameDay = mapLectures.entrySet().stream().filter(e -> day.equals(e.getKey()))
					.map(Map.Entry::getValue)
					.collect(Collectors.toList());
				     
				if(mapLectures.containsKey(day)) {
					if( lectureSameDay.get(0).size()>=2)
					{
						for (int j = 0; j < lectureSameDay.get(0).size()-1; j++) {
							if(lectureSameDay.get(0).get(j).getLocalTime()
							.plusMinutes(lectureSameDay.get(0).get(j).getDuration().toMinutes()).isBefore(lectureSameDay.get(0).get(j+1).getLocalTime())) {
								continue;
							}
							else
							{   conflict = true;
								System.out.println("Conflict between " + lectureSameDay.get(0).get(j).toString() + " and " + lectureSameDay.get(0).get(j+1).toString() );
							} 
							}
					}
					else
						continue;
				}}
			if(!conflict)
				System.out.println("No Conflict");
			
			
		   
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static DayOfWeek determineTheDay(String day) {
		switch (day) {
		case "Mon":
			return DayOfWeek.MONDAY;
		case "Tue":
			return DayOfWeek.TUESDAY;
		case "Wed":
			return DayOfWeek.WEDNESDAY;
		case "Thu":
			return DayOfWeek.THURSDAY;
		case "Fri":
			return DayOfWeek.FRIDAY;
		case "Sat":
			return DayOfWeek.SATURDAY;
		case "Sun":
			return DayOfWeek.SUNDAY;
		default:
			return null;

		}
	}
    
}
