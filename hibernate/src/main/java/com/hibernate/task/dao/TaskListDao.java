package com.hibernate.task.dao;

import com.hibernate.task.TaskList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TaskListDao extends CrudRepository<TaskList, Integer> {
}
