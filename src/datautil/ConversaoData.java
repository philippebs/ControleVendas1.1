package datautil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConversaoData {

	public Date dataParaJava(String data) {
		
		// {1984, 03, 23}
		String dt[] = data.split("-");
		
		Calendar calendar = new GregorianCalendar();
		
		calendar.set(Integer.parseInt(dt[0]), 
				Integer.parseInt(dt[1]) -1, 
				Integer.parseInt(dt[2]));
		
		return calendar.getTime();
	}
	
}
