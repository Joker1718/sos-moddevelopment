package settlement.room.infra.hauler;

import init.resources.RESOURCE;
import settlement.room.main.job.StorageCrate;
import snake2d.util.datatypes.COORDINATE;

final class HaulerSpawnerHelper {

    private HaulerSpawnerHelper() {
    }

    static void spawn(HaulerInstance ins) {
        RESOURCE res = ins.resource();
        if (res == null) {
            return;
        }

        int employed = ins.employees().employed();
        if (employed <= 0) {
            return;
        }

        int free = ins.blueprintI().tally.space.get(ins) - ins.blueprintI().tally.amount.get(ins);
        if (free <= 0) {
            return;
        }

        int spawn = Math.min(free, Math.max(1, employed));
        for (int n = 0; n < spawn; n++) {
            boolean placed = false;
            for (COORDINATE c : ins.body()) {
                StorageCrate crate = ins.blueprintI().crate.get(c.x(), c.y(), ins, ins.sdata);
                if (crate != null && crate.resource() == res && crate.storageReservable() > 0) {
                    crate.storageReserve(1);
                    crate.storageDeposit(1);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                return;
            }
        }
    }
}
