/**
 * 
 */
package io.javabrains.springbootstarter.serviceImpl;

import java.io.Serializable;
import java.util.List;

import io.javabrains.springbootstarter.repository.BaseRepository;

/**
 * @author Kusma
 *
 * 05-Jan-2018
 */
public class BaseServiceImpl<T, ID extends Serializable> {
	private BaseRepository<T, ID> baseRepository;
	
	public void setBaseRepository(BaseRepository<T, ID> baseRepository) {
		this.baseRepository = baseRepository;
	}

	/**
	 * Find one.
	 * 
	 * @param id
	 *            the id
	 * @return the t
	 */

	public T findOne(ID id) {
		return baseRepository.findOne(id);
	}

	/**
	 * Find all.
	 * 
	 * @return the list
	 */
	public List<T> findAll() {
		return baseRepository.findAll();
	}

	/**
	 * Save.
	 * 
	 * @param entity
	 *            the entity
	 */
	public T save(T entity) {
		return baseRepository.saveAndFlush(entity);
	}

	/**
	 * Save all: save a list
	 *
	 * @param aoEntities
	 *            the ao entities
	 */
	public List<T> saveAll(List<T> aoEntities) {
		return baseRepository.save(aoEntities);
	}

	/**
	 * Delete.
	 * 
	 * @param entity
	 *            the entity
	 */
	public void delete(T entity) {
		baseRepository.delete(entity);

	}

	/**
	 * Delete by id.
	 * 
	 * @param entityId
	 *            the entity id
	 */
	public void deleteById(ID entityId) {
		baseRepository.delete(entityId);
	}

}
