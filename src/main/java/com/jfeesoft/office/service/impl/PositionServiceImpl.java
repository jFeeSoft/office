package com.jfeesoft.office.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.office.model.Position;
import com.jfeesoft.office.repository.PositionRepository;
import com.jfeesoft.office.service.PositionService;

@Component
@Transactional
public class PositionServiceImpl extends GenericServiceImpl<Position, Long> implements PositionService {

	@Autowired
	public PositionServiceImpl(PositionRepository positionRepository) {
		super(positionRepository);
	}

	@Override
	public Map<Long, Position> findAllMap() {
		List<Position> positions = (List<Position>) ((PositionRepository) repository).findAll();
		Map<Long, Position> positionMap = new HashMap<>();
		for (Position position : positions) {
			positionMap.put(position.getId(), position);
		}
		return positionMap;
	}

}
