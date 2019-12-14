package shared;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String accessLevel;
    private String buildingNo;
    private String userNo;

    public User(String username, String password, String accessLevel, String buildingNo, String userNo) {
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
        this.buildingNo = buildingNo;
        this.userNo = userNo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public String getUserNo() {
        return userNo;
    }
}
