import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        
        // 数据库中的密码哈希
        String dbPasswordHash = "$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi";
        
        // 测试密码
        String testPassword = "admin123";
        
        // 验证密码是否匹配
        boolean matches = encoder.matches(testPassword, dbPasswordHash);
        
        System.out.println("密码验证结果: " + matches);
        
        if (matches) {
            System.out.println("密码 'admin123' 与数据库中的哈希匹配！");
        } else {
            System.out.println("密码 'admin123' 与数据库中的哈希不匹配！");
            System.out.println("重新生成密码哈希:");
            System.out.println(encoder.encode(testPassword));
        }
    }
}
