package cn.friday.base.service.global.redis.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

import cn.friday.base.service.global.redis.bo.SimpleTypeTuple;
import cn.friday.base.service.global.redis.bo.ZsetResult;
import cn.friday.base.service.global.redis.loader.RedisLoader;

public interface IBaseZsetRedisDao<T> {

	/**
	 * 元素在列表中不存在
	 */
	public final static int NO_MEMBER = -999999;

	/**
	 * 增加
	 * @param member 
	 * @param score
	 * @param ids
	 * @return
	 */
	public boolean add(T member, double score, int... ids);

	/**
	 * 增加多个成员
	 * @param tuples
	 * @param ids
	 * @return
	 */
	public boolean add(Set<TypedTuple<String>> tuples, int... ids);

	/**
	 * 批量增加成员
	 * @param simpleTypeTuples
	 * @param ids
	 * @return
	 */
	public boolean add(Collection<SimpleTypeTuple<T>> simpleTypeTuples, int... ids);

	/**
	 * 增加指定元素的分值
	 * @param member
	 * @param delta
	 * @param ids
	 * @return 增加后的分值
	 */
	public double incrScore(T member, double delta, int... ids);

	/**
	 *  按照分值的降序排序
	 * @param min
	 * @param max
	 * @param ids
	 * @return
	 */
	public Set<T> findByScoreDesc(double min, double max, int... ids);

	/**
	 * 
	 * 按照分值的降序排序
	 * @param min
	 * @param max
	 * @param loader
	 * @param ids
	 * @return 
	 */
	public Set<T> findByScoreDesc(double min, double max, RedisLoader<List<ZsetResult<T>>> loader, int... ids);

	/**
	 * 按照分值的排序（升序）
	 * @param min
	 * @param max
	 * @param offset 从第几条开始
	 * @param count
	 * @param ids
	 * @return
	 */
	public Set<T> findByScoreAsc(double min, double max, long offset, long count, int... ids);

	/**
	 * 按照分值的升序排序
	 * offset 从第几个开始
	 * count 总共多少条
	 */
	public Set<T> findByScoreAsc(double min, double max, long offset, long count,
			RedisLoader<List<ZsetResult<T>>> loader, int... ids);

	/**
	 * 按照分值的排序（降序）
	 * @param min
	 * @param max
	 * @param offset 从第几条开始
	 * @param count
	 * @param ids
	 * @return
	 */
	public Set<T> findByScoreDesc(double min, double max, long offset, long count, int... ids);

	/**
	 * 
	 * 按照分值的排序（降序）
	 * @param min
	 * @param max
	 * @param offset
	 * @param count
	 * @param loader
	 * @param ids
	 * @return 
	 */
	public Set<T> findByScoreDesc(double min, double max, long offset, long count,
			RedisLoader<List<ZsetResult<T>>> loader, int... ids);

	/**
	 * 按照分值的升序排序
	 * @param min
	 * @param max
	 * @param ids
	 * @return
	 */
	public Set<T> findByScoreAsc(double min, double max, int... ids);

	/**
	 * 
	 * 按照分值的升序排序
	 * @param min
	 * @param max
	 * @param loader(回调类，在redis时查询不存在时调用)
	 * @param ids
	 * @return 上午9:56:46
	 * 2016年5月7日
	 */
	public Set<T> findByScoreAsc(double min, double max, RedisLoader<List<ZsetResult<T>>> loader, int... ids);

	/**
	 * 查询一定区间的值
	 * 按照值的升序排序
	 * @param start
	 * @param end
	 * @param ids
	 * @return
	 */
	public Set<T> findByIdAsc(long start, long end, int... ids);

	/**
	 * 查询一定区间的值
	 * 按照值的升序排序
	 * @param start
	 * @param end
	 * @param loader
	 * @param ids
	 * @return 
	 */
	public Set<T> findByIdAsc(long start, long end, RedisLoader<List<ZsetResult<T>>> loader, int... ids);

	/**
	 * 按照索引查询，
	 * 并返回分值
	 * @param start
	 * @param end
	 * @param ids
	 * @return
	 *@author BravoZu
	 */
	public List<ZsetResult<T>> findByIdWithScoresAsc(long start, long end, int... ids);

	/**
	 * 按照id查询，结果升序返回
	 * @param start
	 * @param end
	 * @param loader
	 * @param ids
	 * @return 
	 */
	public List<ZsetResult<T>> findByIdWithScoresAsc(long start, long end, RedisLoader<List<ZsetResult<T>>> loader,
			int... ids);

	/**
	 * 查询一定区间的值，
	 * 按照值的倒序排序
	 * @param start
	 * @param end
	 * @param ids
	 * @return
	 */
	public Set<T> findByIdDesc(long start, long end, int... ids);

	/**
	 * 按照分值的顺序排序
	 * @param min
	 * @param max
	 * @param ids
	 * @return
	 */
	public List<ZsetResult<T>> findByScoreWithScoresAsc(double min, double max, int... ids);

	/**
	 * 按照分值的升序排序
	 */
	public List<ZsetResult<T>> findByScoreWithScoresAsc(double min, double max, RedisLoader<List<ZsetResult<T>>> loader,
			int... ids);

	/**
	 * 按照分值的倒序排序
	 * @param min
	 * @param max
	 * @param ids
	 * @return
	 */
	public List<ZsetResult<T>> findByScoreWithScoresDesc(double min, double max, int... ids);

	/**
	 * 按照分值的倒序排序
	 * @param min
	 * @param max
	 * @param loader
	 * @param ids
	 * @return 
	 */
	public List<ZsetResult<T>> findByScoreWithScoresDesc(double min, double max,
			RedisLoader<List<ZsetResult<T>>> loader, int... ids);

	/**
	 * 根据分值查询（升序）
	 * @param min
	 * @param max
	 * @param offset 第几个开始
	 * @param count 查询总的数量
	 * @param ids
	 * @return
	 */
	public List<ZsetResult<T>> findByScoreWithScoresAsc(double min, double max, long offset, long count, int... ids);

	/**
	 * 结果升序排序
	 * @param min score 的小值
	 * @param max score的大值
	 * @param offset
	 * @param count
	 * @param loader
	 * @param ids
	 * @return 
	 */
	public List<ZsetResult<T>> findByScoreWithScoresAsc(double min, double max, long offset, long count,
			RedisLoader<List<ZsetResult<T>>> loader, int... ids);

	/**
	 * 根据分值查询（降序）
	 * @param min
	 * @param max
	 * @param offset 第几个开始
	 * @param count 查询总的数量
	 * @param ids
	 * @return
	 */
	public List<ZsetResult<T>> findByScoreWithScoresDesc(double min, double max, long offset, long count, int... ids);

	/**
	 * 结果按照score的降序排列
	 * @param min
	 * @param max
	 * @param offset
	 * @param count
	 * @param loader
	 * @param ids
	 * @return 
	 */
	public List<ZsetResult<T>> findByScoreWithScoresDesc(double min, double max, long offset, long count,
			RedisLoader<List<ZsetResult<T>>> loader, int... ids);

	/**
	 * 查询成员对应的分值
	 * @param member
	 * @param ids
	 * @return
	 */
	public double getScore(T member, int... ids);

	/**
	 * 查询成员对应的分值
	 * @param member
	 * @param ids
	 * @return -999999：表示元素在zset中不存在
	 */
	public double score(T member, int... ids);

	/**
	 * 判断成员是否存在
	 * @param member
	 * @param ids
	 * @return
	 */
	public boolean existMember(T member, int... ids);

	/**
	 * 长度
	 * @param ids
	 * @return
	 */
	public long size(int... ids);

	/**
	 * 区间长度
	 * @param min
	 * @param max
	 * @param ids
	 * @return
	 */
	public long rangeSize(double min, double max, int... ids);

	/**
	 * 删除成员
	 * @param member
	 * @param ids
	 * @return
	 */
	public boolean remove(T member, int... ids);

	/**
	 * 移除区间的成员
	 * @param start
	 * @param end
	 * @param ids
	 * @return
	 */
	public boolean removeRange(long start, long end, int... ids);

	/**
	 * 移除分值区间的成员
	 * @param min
	 * @param max
	 * @param ids
	 * @return
	 */
	public boolean removeRangeByScore(double min, double max, int... ids);

	/**
	 * 删除key
	 * @param ids
	 * @return
	 */
	public boolean deleteById(int... ids);

	/**
	 * 设置过期时间
	 * @param seconds （秒）
	 * @param ids
	 */
	public void expire(final long seconds, int... ids);

	/**
	 * 获取列表中第一个元素
	 * 按照从小到大
	 * @param ids
	 * @return
	 *@author BravoZu
	 */
	public T getLast(int... ids);

	/**
	 * 获取列表中第一个元素
	 * 按照从小到大
	 * @param ids
	 * @return
	 *@author BravoZu
	 */
	public T getFirst(int... ids);

	/**
	 * 获取最后一个元素
	 * 按照从小到大
	 * @param ids
	 * @return
	 *@author BravoZu
	 */
	public ZsetResult<T> getLastWithScore(int... ids);

	/**
	 * 获取第一个元素
	 * 按照从小到大
	 * @param ids
	 * @return
	 *@author BravoZu
	 */
	public ZsetResult<T> getFirstWithScore(int... ids);

}
