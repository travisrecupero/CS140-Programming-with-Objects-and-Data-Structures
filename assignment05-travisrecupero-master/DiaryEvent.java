package assignment05;

import java.time.LocalDateTime;
import java.util.List;

public class DiaryEvent {

	private String description;
	private LocalDateTime start;
	private int duration;

	public DiaryEvent(String des, int year, int month, int day, int hr24, int min, int dur) {
		this.description = des;
		start = LocalDateTime.of(year, month, day, hr24, min);
		this.duration = dur;
	}

	public boolean before(DiaryEvent de) {
		return start.compareTo(de.start) < 0;
	}

	public boolean after(DiaryEvent de) {
		return start.compareTo(de.start) > 0;
	}

	public static int[] monthBreakdown(DiaryEvent[] array) {
		int[] arr = new int[13];
		for (int i = 0; i < array.length; i++) {
			arr[i] = array[i].start.getMonthValue();
		}
		return arr;
	}

	public static DiaryEvent earliest(List<DiaryEvent> list) {
		DiaryEvent earliest = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).before(earliest)) {
				earliest = list.get(i);
				return list.get(i);
			}
		}
		return earliest;
	}

	@Override
	public String toString() {
		return description + " at " + start + ", lasting " + duration + " minutes.";
	}

}
