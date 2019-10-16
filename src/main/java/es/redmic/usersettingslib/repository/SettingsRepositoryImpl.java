package es.redmic.usersettingslib.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Value;

/*-
 * #%L
 * user-settings-lib
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
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
 * #L%
 */

import es.redmic.elasticsearchlib.data.repository.RWDataESRepository;
import es.redmic.models.es.common.dto.EventApplicationResult;
import es.redmic.models.es.common.query.dto.SimpleQueryDTO;
import es.redmic.usersettingslib.model.Settings;

public abstract class SettingsRepositoryImpl<TModel extends Settings, TQueryDTO extends SimpleQueryDTO>
		extends RWDataESRepository<TModel, TQueryDTO> {

	@Value("${microservice.commands.path}")
	String microServiceCommandsPath;

	@Value("${controller.mapping.SETTINGS}")
	String controllerPath;

	private static QueryBuilder INTERNAL_QUERY = null;

	private static String[] INDEX = { "settings" };
	private static String TYPE = "_doc";

	public SettingsRepositoryImpl() {
		super(INDEX, TYPE);
	}

	@PostConstruct
	public void postConstructSettingsRepositoryImpl() {
		INTERNAL_QUERY = QueryBuilders.boolQuery()
				.must(QueryBuilders.termQuery("service", microServiceCommandsPath + controllerPath));
	}

	@Override
	public QueryBuilder getInternalQuery() {
		return INTERNAL_QUERY;
	}

	/**
	 * Sobrescribe a la función base. Función que dado un conjunto de términos, nos
	 * devuelve una query de elasticsearch. Debe estar implementado en cada
	 * repositorio para darle una funcionalidad específica y en la base estarán las
	 * funcionalidades que comparten todos los repositorios.
	 * 
	 * @param terms
	 *            Map de términos pasados por la query.
	 * @param query
	 *            QueryBuilder con la query de los términos acumulados en los
	 *            repositorios específicos.
	 * @return query de tipo terms de elasticsearch.
	 */
	@Override
	public QueryBuilder getTermQuery(Map<String, Object> terms, BoolQueryBuilder query) {

		if (terms.containsKey("id")) {
			query.must(QueryBuilders.termQuery("id", terms.get("id")));
		}

		if (terms.containsKey("userId")) {
			query.must(QueryBuilders.termQuery("userId", terms.get("userId")));
		}

		if (terms.containsKey("name")) {
			query.must(QueryBuilders.existsQuery("name"));
		}
		return super.getTermQuery(terms, query);
	}

	@Override
	protected EventApplicationResult checkInsertConstraintsFulfilled(Settings modelToIndex) {
		return new EventApplicationResult(true);
	}

	@Override
	protected EventApplicationResult checkUpdateConstraintsFulfilled(Settings modelToIndex) {
		return new EventApplicationResult(true);
	}

	@Override
	protected EventApplicationResult checkDeleteConstraintsFulfilled(String modelToIndex) {
		return new EventApplicationResult(true);
	}
}
