/*
 * Copyright 2015, The Android Open Source Project
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

package andevcba.com.githubmvp.data.repository;

import java.util.List;
import java.util.TreeMap;

import andevcba.com.githubmvp.data.model.Repo;
import andevcba.com.githubmvp.data.model.ReposByUsername;

/**
 * Concrete implementation to load {@link Repo}s from memory.
 *
 * @author lucas.nobile
 */
public class InMemoryRepository implements Repository {

    private ReposCache reposCache;

    public InMemoryRepository(ReposCache reposCache) {
        this.reposCache = reposCache;
    }

    @Override
    public void searchReposByUsername(String username, ReposCallback callback) {
        if (reposCache.isCached(username)) {
            TreeMap<String, List<Repo>> reposByUsername = new TreeMap<>();
            reposByUsername.put(username, reposCache.get(username));
            ReposByUsername repoResponse = new ReposByUsername(reposByUsername, true /* is cached */);
            callback.onResponse(repoResponse);
        }
    }

    @Override
    public void saveReposByUsername(ReposByUsername reposByUsername) {
        String username = reposByUsername.getReposByUsername().firstKey();
        reposCache.put(username, reposByUsername.getReposByUsername().get(username));
    }

    @Override
    public void loadAllRepos(ReposCallback callback) {
        ReposByUsername reposByUsername = new ReposByUsername(reposCache.getAll(), !reposCache.getAll().isEmpty() /* is cached */);
        callback.onResponse(reposByUsername);
    }
}
