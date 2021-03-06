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

import andevcba.com.githubmvp.data.model.Repo;
import andevcba.com.githubmvp.data.model.ReposByUsername;

/**
 * Repository for accessing {@link Repo} data from a data source.
 *
 * @author lucas.nobile
 */
public interface Repository {

    void searchReposByUsername(String username, ReposCallback callback);

    void saveReposByUsername(ReposByUsername reposByUsername);

    void loadAllRepos(ReposCallback callback);
}
