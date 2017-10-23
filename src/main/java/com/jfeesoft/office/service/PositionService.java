package com.jfeesoft.office.service;

import java.util.Map;

import com.jfeesoft.office.model.Position;

public interface PositionService extends GenericService<Position, Long> {

	Map<Long, Position> findAllMap();
}
