package com.mahesh.spring5web.repositories;

import com.mahesh.spring5web.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long > {
}
