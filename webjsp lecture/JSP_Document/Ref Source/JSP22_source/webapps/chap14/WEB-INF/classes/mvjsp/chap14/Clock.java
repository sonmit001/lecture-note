package mvjsp.chap14;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {

	public String now() {
        SimpleDateFormat format = new SimpleDateFormat("HH�� mm�� ss��");
        return format.format(new Date());
	}
}
