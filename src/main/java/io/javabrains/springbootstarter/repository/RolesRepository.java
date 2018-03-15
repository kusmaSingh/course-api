/**
 * 
 */
package io.javabrains.springbootstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javabrains.springbootstarter.entity.Roles;

/**
 * @author Kusma
 *
 *         12-Jan-2018
 */
public interface RolesRepository extends JpaRepository<Roles, Long> {

}
