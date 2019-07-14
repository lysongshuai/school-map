import com.school.util.SnowflakeIdUtil;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i< 28 ;i++){
            System.out.println(SnowflakeIdUtil.getSnowflakeIdUtil().nextId());
        }
    }
}
