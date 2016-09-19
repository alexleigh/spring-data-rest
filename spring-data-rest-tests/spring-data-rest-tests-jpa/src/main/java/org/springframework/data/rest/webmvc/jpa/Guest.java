/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.rest.webmvc.jpa;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Alex Leigh
 * @see DATAREST-872
 */
@Data
@Entity
public class Guest {

	@Id @GeneratedValue //
	private Long id;

	@OneToOne(cascade = CascadeType.ALL) //
	private Room room;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //
	private List<Meal> meals = new ArrayList<Meal>();

	@OneToOne(cascade = CascadeType.ALL) //
	private RatePlan mainRatePlan;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //
	private List<RatePlan> additionalRatePlans = new ArrayList<RatePlan>();

	@OneToOne(cascade = CascadeType.ALL) //
	private Folio mainFolio;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //
	private List<Folio> additionalFolios = new ArrayList<Folio>();

	public void addMeal(Meal meal) {
		this.meals.add(meal);
	}

	public void addAdditionalRatePlan(RatePlan ratePlan) {
		this.additionalRatePlans.add(ratePlan);
	}

	public void addAdditionalFolio(Folio folio) {
		this.additionalFolios.add(folio);
	}
}
