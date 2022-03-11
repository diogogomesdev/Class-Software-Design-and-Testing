package pt.up.fe.ldts.example4;

public class Client extends Worker {

    private String name, phone;

    public Client(String name, String phone) {
        super(name, phone, null, null);
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
