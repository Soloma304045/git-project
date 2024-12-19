import Planes.Plane;
import java.util.ArrayList;
import java.util.List;

public class Repository<T extends Plane> {
    private final List<T> items;

    public Repository() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public boolean remove(String name) {
        return items.removeIf(item -> item.getName().equals(name));
    }

    public boolean update(String name, T updatedItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.set(i, updatedItem);
                return true;
            }
        }
        return false;
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public T getById(String name) {
        for (T item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
