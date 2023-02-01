package com.java.repositoriesobjectquery;

import com.java.entities.CarDetail;

public interface CarRepositoriesHQL {
	CarDetail findByCarID(long cadid);

}
