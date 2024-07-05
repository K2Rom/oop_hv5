package viewer;

import model.Human;

import java.util.List;

public interface HumanView<T extends Human> {
	public void sendOnConsole(List<T> list);
}
