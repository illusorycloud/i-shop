package tk.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/2
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
