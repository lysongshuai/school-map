/**
 * 文件名：@AfwSimpleJpaRepository.java <br/>
 * 包名：cn.efunbox.afw.data.jpa.spring.support <br/>
 * 项目名：afw-data <br/>
 * @author xtwin <br/>
 */
package com.school.util;

import com.school.util.SnowflakeIdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.Attribute.PersistentAttributeType;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 类名：AfwSimpleJpaRepository  <br />
 *
 * 功能：Jpa仓库基础实现
 *
 * @author xtwin <br />
 * 创建时间：2016年7月26日 下午3:19:42  <br />
 * @version 2016年7月26日
 */
public class ProjectSimpleJpaRepository<E, ID extends Serializable> extends SimpleJpaRepository<E, ID> implements ProjectJpaRepository<E, ID> {
	
	// 日志记录器
	private static final Logger logger = LoggerFactory.getLogger(ProjectSimpleJpaRepository.class);
	
	// jpa管理器对象
	private EntityManager entityManager;
	
	// 实体信息
	private JpaEntityInformation<E, ID> entityInformation;
	
	/**
	 * 构造方法
	 */
	public ProjectSimpleJpaRepository(JpaEntityInformation<E, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		
		// 保留该对象，方便后续使用
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
	}

	/**
	 * 功能: <br/>
	 * 
	 * 重写：xtwin <br/>
	 * 
	 * @version ：2016年7月26日 下午3:23:06<br/>
	 * 
	 * @param sample
	 * @return <br/>
	 * @see ProjectJpaRepository#count(Object)
	 */
	@Override
	public long count(E sample) {
		return count(getSpecification(sample));
	}

	/**
	 * 功能: <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年8月17日 下午12:05:21<br/>
	 *
	 * @param sample
	 * @return <br/>
	 * @see ProjectJpaRepository#exists(Object)
	 */
	@Override
	public boolean exists(E sample) {
		return count(sample) > 0L;
	}

	/**
	 * 功能: <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年7月26日 下午3:23:06<br/>
	 *
	 * @param id
	 * @return <br/>
	 * @see ProjectJpaRepository#find(Serializable)
	 */
	@Override
	public E find(ID id) {
		return findOne(id);
	}
	/**
	 * 功能：根据ids查询 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年3月30日 下午6:28:23 <br/>
	 */
	public List<E> findByIds(List<ID> ids){
		return findAll(ids);
	}


	/**
	 * 功能: <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年7月26日 下午3:23:06<br/>
	 *
	 * @param start
	 * @param offset
	 * @return <br/>
	 * @see ProjectJpaRepository#find(Long, Integer)
	 */
	@Override
	public List<E> find(Long start, Integer offset) {
		return find(start, offset, null);
	}

	/**
	 * 功能: <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年7月29日 上午10:20:21<br/>
	 *
	 * @param start
	 * @param offset
	 * @param sort
	 * @return <br/>
	 * @see ProjectJpaRepository#find(Long, Integer, Sort)
	 */
	@Override
	public List<E> find(Long start, Integer offset, Sort sort) {
		return find(null, start, offset, sort);
	}

	/**
	 * 功能: <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年8月2日 上午11:58:30<br/>
	 *
	 * @param sample
	 * @return <br/>
	 * @see ProjectJpaRepository#findFirst(Object)
	 */
	@Override
	public E findFirst(E sample) {
		return findFirst(sample, null);
	}

	/**
	 * 功能: <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年8月2日 上午11:58:30<br/>
	 *
	 * @param sample
	 * @param sort
	 * @return <br/>
	 * @see ProjectJpaRepository#findFirst(Object, Sort)
	 */
	@Override
	public E findFirst(E sample, Sort sort) {
		List<E> list = find(sample, 0L, 1, sort);

		return null == list || list.isEmpty() ? null : list.get(0);
	}

	/**
	 * 功能: <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年7月26日 下午3:23:06<br/>
	 *
	 * @param sample
	 * @return <br/>
	 * @see ProjectJpaRepository#find(Object)
	 */
	@Override
	public List<E> find(E sample) {
		return find(sample, null);
	}

	/**
	 * 功能: <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年7月29日 上午10:20:21<br/>
	 *
	 * @param sample
	 * @param sort
	 * @return <br/>
	 * @see ProjectJpaRepository#find(Object, Sort)
	 */
	@Override
	public List<E> find(E sample, Sort sort) {
		return find(sample, null, null,sort);
	}

	/**
	 * 功能: <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年7月26日 下午3:23:06<br/>
	 *
	 * @param sample
	 * @param start
	 * @param offset
	 * @return <br/>
	 * @see ProjectJpaRepository#find(Object, Long, Integer)
	 */
	@Override
	public List<E> find(E sample, Long start, Integer offset) {
		return find(sample, start, offset, null);
	}

	/**
	 * 功能: <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年7月29日 上午9:44:56<br/>
	 *
	 * @param sample
	 * @param start
	 * @param offset
	 * @param sort
	 * @return <br/>
	 * @see ProjectJpaRepository#find(Object, Long, Integer, Sort)
	 */
	@Override
	public List<E> find(E sample, Long start, Integer offset, Sort sort) {
		// 创建qbe
		Specification<E> spec = getSpecification(sample);

		if (null == sort) {
			// 默认按id降序排序
			sort = new Sort(new Order(Direction.DESC, entityInformation.getIdAttribute().getName()));
		}

		// 取得查询对象
		TypedQuery<E> query = getQuery(spec, sort);

		// 起始条数，从零开始
		if (null != start) {
			// TODO 此处只接受整形值
			query.setFirstResult(start.intValue());
		}

		// 查询条数
		if (null != offset) {
			query.setMaxResults(offset);
		}

		// 执行查询
		return query.getResultList();
	}


	/**
	 * 功能: 更新操作，不更新为null的字段 <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年8月1日 上午9:37:15<br/>
	 *
	 * @param entity
	 * @return <br/>
	 * @see ProjectJpaRepository#update(Object)
	 */
	@Transactional
	public E update(E entity) {
		return update(entity, true);
	}

	/**
	 * Saves all given entities.
	 *
	 * @param entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given domain is {@literal null}.
	 */
	@Override
	@Transactional
	public <S extends E> List<S> save(Iterable<S> entities) {

		return insertOrUpdateBatch(entities);
	}
	/**
	 * Saves a given domain. Use the returned instance for further operations as the save operation might have changed the
	 * domain instance completely.
	 *
	 * @param entity
	 * @return the saved domain
	 */
	@Transactional
	public <S extends E> S save(S entity) {

		if (entityInformation.isNew(entity)) {
			setSnowflakeIdId(entity);
			entityManager.persist(entity);
			return entity;
		} else {
			return entityManager.merge(entity);
		}
	}
	/**
	 * 功能: 动态数据更新，可以选择是否需要更新null字段 <br/>
	 *
	 * 重写：xtwin <br/>
	 *
	 * @version ：2016年8月1日 上午9:37:05<br/>
	 *
	 * @param entity
	 * @param ignoreNull
	 * @return <br/>
	 * @see ProjectJpaRepository#update(Object, boolean)
	 */
	@Transactional
	public E update(E entity, boolean ignoreNull) {
		// 取得当前实体的id
		ID id = entityInformation.getId(entity);
		
		// 检查id是否为空Ø
		if (null == id) {
			throw new RuntimeException("The update domain id must be not empty !");
		}
		
		// 查询库中当前对象的信息
		E persist = find(id);
		
		// 检查该id对应的数据是否存在
		if (null == persist) {
			throw new RuntimeException("The update domain id is not exist : " + id);
		}
		
		// 标识是否发生了变化
		boolean isChanged = false;
		
		// 取得所有属性
		for (Attribute<? super E, ?> attr : entityManager.getMetamodel().entity(getDomainClass()).getAttributes()) {
			// 依次处理每个字段
			/*PersistentAttributeType patype = attr.getPersistentAttributeType();

			if (PersistentAttributeType.MANY_TO_ONE.equals(patype) 
					|| PersistentAttributeType.ONE_TO_MANY.equals(patype)) {

				// 忽略
				continue;
			}*/
			
			Member member = attr.getJavaMember();
			
			Field field = null;
			if (member instanceof Field) {
				field = (Field) member;
			} else {
				field = ReflectionUtils.findField(getDomainClass(), attr.getName());
			}
			
			// 取得字段值
			Object value = ReflectionUtils.getField(field, entity);
			if (null != value || ! ignoreNull) {
				// 旧值
				Object oldValue = ReflectionUtils.getField(field, persist);
				
				if ((null == value && null != oldValue) 
						|| (null != value && ! value.equals(oldValue))) {
					
					// 将新值更新到持久化对象中
					ReflectionUtils.setField(field, persist, value);
					
					// 标记为发生了更新
					isChanged = true;
				}
			}
		}
		
		if (isChanged) {
			persist = save(persist);
		} else {
			// 没有发生变更，忽略更新
			logger.debug("has no changed : {}", id);
		}
		
		// 执行保存并返回
		return persist;
	}
	/**
	 * update all given entities.
	 *
	 * @param entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given domain is {@literal null}.
	 */
	@Transactional
	public <S extends E> List<S> update(Iterable<S> entities) {
		return insertOrUpdateBatch(entities);
	}

	private <S extends E> List<S> insertOrUpdateBatch(Iterable<S> entities) {
		List<S> result = new ArrayList<>();
		if (entities == null) {
			return result;
		}
		Iterator<S> iterator = entities.iterator();
		int i = 0;
		int count = 0;
		//遍历循环 每20个 insert 批量插入/更新 一次库
		while (iterator.hasNext()) {
			S entity = iterator.next();
			if (entityInformation.isNew(entity)) {
				setSnowflakeIdId(entity);
				entityManager.persist(entity);
			} else {
				update(entity);
			}
			result.add(entity);
			i++;
			if (i % 20 == 0) {
				entityManager.flush();
				entityManager.clear();

				count=0;
			}else {
				count++;
			}
		}
		//判断 是否有剩余未flush的 最后flush
		if (count>0){
			entityManager.flush();
			entityManager.clear();
		}
		return result;
	}

	/**
	 * 功能：获取qbe <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年7月29日 上午9:43:25 <br/>
	 */
	protected Specification<E> getSpecification(final E sample) {
		return null == sample ? null : new Specification<E>() {
			@Override
			public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				try {
					// 获取qbe
					return ProjectSimpleJpaRepository.this.toPredicate(sample, root, query, cb);
				} catch (Exception e) {
					throw new RuntimeException("toPredicate fail with error : " + String.valueOf(e), e);
				}
			}
		};
	}

	/**
	 * 功能：转为查询样板，可以由子类重写 <br/>
	 *
	 * @author xtwin <br/>
	 * @version 2016年7月29日 上午10:15:27 <br/>
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	protected Predicate toPredicate(E sample, Root<E> root, CriteriaQuery<?> query, CriteriaBuilder cb) throws Exception {
		// 存放查询条件
		List<Predicate> list = new ArrayList<Predicate>();
		
		// 处理实体中的所有字段
		for (Attribute<? super E, ?> attr : entityManager.getMetamodel().entity(getDomainClass()).getAttributes()) {
			// 依次处理每个字段
			PersistentAttributeType patype = attr.getPersistentAttributeType();

			// 打印日志
			logger.debug("the attr type is : {}", patype);

			if (PersistentAttributeType.MANY_TO_ONE.equals(patype) 
					|| PersistentAttributeType.ONE_TO_MANY.equals(patype)) {

				// 忽略
				continue;
			}

			Object value = null;
			
			Member member = attr.getJavaMember();
			if (member instanceof Method) {
				value = ReflectionUtils.invokeMethod((Method) member, sample);
			} else if (member instanceof Field) {
				//((Field) member).setAccessible(true);
				// 确保可以访问
				ReflectionUtils.makeAccessible((Field) member);
				
				// 取得字段的值
				value = ((Field) member).get(sample);
			}
			
			if (null != value) {
				Predicate tmp = null;
				//like 查询放在最前面
				List<Predicate> likePredicate = new ArrayList<Predicate>();
				if (String.class.isAssignableFrom(attr.getJavaType()) ) {
					if(!StringUtils.isEmpty(value)){
						StringBuilder stringBuilder=new StringBuilder(((String) value).trim());
						//如果以 % 开头和结尾 表示 like 查询
						if("%".equals(stringBuilder.substring(0,1)) || stringBuilder.toString().endsWith("%")){
							//tmp = cb.like(root.get(attr.getName()), (String) value);
							likePredicate.add(tmp);
						}else{
							tmp = cb.equal(root.get(attr.getName()), value);
							list.add(tmp);
						}
					}
				} else  {
					tmp = cb.equal(root.get(attr.getName()), value);
					list.add(tmp);
				}
				if(likePredicate.size()>0){
					list.addAll(0,likePredicate);
				}
			}
		}
		
		// where条件
		return list.isEmpty() ? null : cb.and(list.toArray(new Predicate[list.size()]));
	}


	protected void setSnowflakeIdId(E entity){
		try {
			Field field = ReflectionUtils.findField(entity.getClass(),entityInformation.getIdAttribute().getName());
			if(entityInformation.getIdAttribute().getType().getJavaType().getName().equals("java.lang.Long")){
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, entity, SnowflakeIdUtil.getSnowflakeIdUtil().nextId());
			}else if(entityInformation.getIdAttribute().getType().getJavaType().getName().equals("java.lang.String")) {
				logger.debug(" uuid  entityInformation.getIdAttribute().getName() ={}",entityInformation.getIdAttribute().getName());
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, entity, SnowflakeIdUtil.getSnowflakeIdUtil().nextCode());
			}
		}catch (Exception e){
			logger.error("Reflect set id 出错 mag ={}",e.getMessage(),e);
		}
	}
}