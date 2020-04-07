package Repos;

import Domain.Device;
import Interface.GeneralRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JK
 */
@Repository
public class DeviceRepo implements GeneralRepository<Device> {

    @Override
    public int save(Device t) {
        int flag = 0;
        return flag;
    }

    @Override
    public int delete(Device t) {
        int flag = 0;
        return flag;
    }

    @Override
    public Device fetch(int id) {
        return null;
    }

    @Override
    public int update(Device t) {
        int flag = 0;
        return flag;
    }

    @Override
    public List<Device> fetchAll() {
        return null;
    }
}
