package com.dream.service;

import java.util.Set;

public interface ResourceService {

	Set<String> findPermissions(Set<Long> resourceIds);

}
