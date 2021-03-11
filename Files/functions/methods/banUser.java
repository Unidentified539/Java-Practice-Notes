package methods;

import java.util.ArrayList;

public class banUser {
    public ArrayList<String> bans = new ArrayList<>();


    public void createBan(String userIp) {
        bans.add(userIp);
    }

    public boolean checkBan(String ipAddress) {
        if (bans.contains(ipAddress)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void clearAllBans() {
        bans.clear();
    }

    public void unban(String ipToUnban) {
        bans.remove(ipToUnban);
    }

    public String printAllBans() {
        return bans.toString();
    }
}
