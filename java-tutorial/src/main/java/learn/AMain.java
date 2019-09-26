package learn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class Supervisor {

	String id;
	String name;
	List<String> interest;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}
}

public class AMain {

	public static void main(String[] args) {
		String id, name, line;
		String[] arr;
		List<String> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("file/supervisor.txt"))) {
			while ((line = br.readLine()) != null) {
				arr = line.trim().split(",");
				list.addAll(Arrays.asList(arr));
				if (list.size() > 2) {
					id = list.get(0);
					list.remove(0);
					name = list.get(0);
					list.remove(0);
					System.out.println(new Supervisor(id, name, list));
				}
				list.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
