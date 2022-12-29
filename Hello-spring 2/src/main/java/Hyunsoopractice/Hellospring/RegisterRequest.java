package Hyunsoopractice.Hellospring;


//RegisterRequest 클래스는 회원 가입을 처리할 때 필요한 이메일, 암호, 이름 데이터를 담고 있는 클래스.

public class RegisterRequest {

    private String email;
    private String password;
    private String comfirmPassword;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
    public String getComfirmPassword() {
        return comfirmPassword;
    }
    public void setConfirmPassword(String ConfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isPasswordEqualToConfirmPassword() {
        return password.equals(comfirmPassword);
    }
}
