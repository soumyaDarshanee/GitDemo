

import java.io.IOException;
import java.util.ArrayList;

public class testSample {
	public static void main(String[] args) throws IOException {
	
	DataDriven d = new DataDriven();
	ArrayList aData = d.getData("Add Profile");
	System.out.println(aData.get(0));
	System.out.println(aData.get(1));
	System.out.println(aData.get(2));
	System.out.println(aData.get(3));
	}
}
 