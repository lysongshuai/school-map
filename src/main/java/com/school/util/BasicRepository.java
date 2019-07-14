/**
 * 文件名：@BasicRepository.java <br/>
 * 包名：tv.acfun.base.repository <br/>
 * 项目名：acfun-base-provider <br/>
 * @author xtwin <br/>
 */
package com.school.util;

import org.springframework.data.repository.NoRepositoryBean;


/**
 * 类名：BaseRepository  <br />
 *
 * 功能：基础持久仓库
 *
 * @author xtwin <br />
 * 创建时间：2016年7月27日 上午10:59:21  <br />
 * @version 2016年7月27日
 */
@NoRepositoryBean
public interface BasicRepository<E> extends ProjectJpaRepository<E,String> {



}
