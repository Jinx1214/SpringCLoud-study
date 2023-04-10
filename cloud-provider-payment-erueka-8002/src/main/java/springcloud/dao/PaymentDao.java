package springcloud.dao;

import com.atguigu.springcloud.commons.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    //新增訂單接口
    int create(Payment payment);

    //查詢接口
    Payment getPaymentById(@Param("id") Long id);
}
