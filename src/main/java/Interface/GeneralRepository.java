
package Interface;

import java.util.List;

/**
 *
 * @author JK
 */
public interface GeneralRepository<T> {
    public int save(T t);
    public int delete(T t);
    public List<T> fetchAll();
    public T fetch(int id);
    public int update(T t);
}
