package com.flow.mo.api.dao;

import com.flow.mo.api.model.account.Account;
import com.flow.mo.api.model.collection.Collection;

public interface AccountRepositoryCustom {
	
	boolean addCollection(Collection collection, String personId);
	
	boolean removeCollection(Collection collection, String personId);
}
