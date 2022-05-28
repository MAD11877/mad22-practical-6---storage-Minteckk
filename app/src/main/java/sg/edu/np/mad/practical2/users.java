package sg.edu.np.mad.practical2;

public class users {
    String Name;
    String Description;
    int Id;
    boolean Followed;

    public users(String name, String desc, int id, boolean follow)
    {
        this.Name = name;
        this.Description = desc;
        this.Id = id;
        this.Followed = follow;
    }

    public users() {}

    public void SetUserID(int id) {
        this.Id = id;
    }

    public int getUserID() {
        return this.Id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    public void setDesc(String desc)
    {
        this.Description = desc;
    }

    public String getDesc() {
        return this.Description;
    }

    public void setFollowStatus(boolean follow){
        this.Followed = follow;
    }

    public boolean getFollowStatus() {
        return this.Followed;
    }
}

