/**
 * 文件名：@ProjectJpaRepository.java <br/>
 * 包名：cn.efunbox.afw.data.jpa.spring.support <br/>
 * 项目名：afw-data <br/>
 * @author xtwin <br/>
 */
package com.school.util;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * 类名：ProjectJpaRepository  <br />
 *
 * 功能：
 *
 * @author xtwin <br />
 * 创建时间：2016年7月26日 下午3:20:36  <br />
 * @version 2016年7月26日
 */
@NoRepositoryBean
public interface ProjectJpaRepository<E, ID extends Serializable> extends JpaRepository<E, ID> {

	/**
	 * 功能：统计符合样板的数据条数 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年3月31日 下午4:56:01 <br/>
	 */
	long count(E sample);
	
	/**
	 * 功能：检查是否存在 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年8月17日 下午12:04:48 <br/>
	 */
	boolean exists(E sample);

	/**
	 * 功能：根据id查询 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年3月30日 下午6:28:23 <br/>
	 */
	E find(ID id);
	/**
	 * 功能：查询符合条件的第一条 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年8月2日 上午11:55:36 <br/>
	 */
	E findFirst(E sample);

	/**
	 * 功能：根据ids查询 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年3月30日 下午6:28:23 <br/>
	 */
	List<E> findByIds(List<ID> id);

	/**
	 * 功能：查询符合条件的第一条 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年8月2日 上午11:58:10 <br/>
	 */
	E findFirst(E sample, Sort sort);

	/**
	 * 功能：分页查询所有数据，使用id降序排序 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年3月31日 下午4:52:30 <br/>
	 */
	List<E> find(Long start, Integer offset);
	
	/**
	 * 功能：分页查询，使用sort规则排序 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年7月29日 上午10:19:05 <br/>
	 */
	List<E> find(Long start, Integer offset, Sort sort);
	
	/**
	 * 功能：根据样板查询数据，使用id降序排序 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年3月30日 下午6:51:00 <br/>
	 */
	List<E> find(E sample);
	
	/**
	 * 功能：根据样板查询数据，使用sort规则排序 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年7月29日 上午10:19:51 <br/>
	 */
	List<E> find(E sample, Sort sort);
	
	/**
	 * 功能：分页查询，按id降序排序 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年3月31日 上午11:58:31 <br/>
	 */
	List<E> find(E sample, Long start, Integer offset);
	
	/**
	 * 功能：分页查询，且排序 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年7月29日 上午9:44:26 <br/>
	 */
	List<E> find(E sample, Long start, Integer offset, Sort sort);
	
	/**
	 * 功能：更新操作，不更新为null的字段 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年8月1日 上午9:35:47 <br/>
	 */
	E update(E entity);
	/**
	 * 功能：基于原生merge方法的 批量更新操作
	 *
	 * @author  tomas <br/>
	 * @version 2017年8月1日 上午9:35:47 <br/>
	 */
	<S extends E> List<S> update(Iterable<S> entities);

	/**
	 * 功能：基于原生merge方法的 批量save操作
	 *
	 * @author  tomas <br/>
	 * @version 2017年8月1日 上午9:35:47 <br/>
	 */
	<S extends E> List<S> save(Iterable<S> entities);
	
	/**
	 * 功能：更新操作，可以选择是否要忽略更新为null的字段 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年8月1日 上午9:36:20 <br/>
	 */
	E update(E entity, boolean ignoreNull);
}
