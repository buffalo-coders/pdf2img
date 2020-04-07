###
# #%L
# org.buffalo-coders:pdf2img
# %%
# Copyright (C) 2019 Buffalo Coders
# %%
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
# 
#      http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# #L%

default: install

.PHONY: display-updates
display-updates:
	mvn -Dmaven.version.rules=https://raw.githubusercontent.com/buffalo-coders/parent/master/src/main/resources/versions-maven-plugin.rules.xml \
		versions:display-dependency-updates \
		versions:display-parent-updates \
		versions:display-plugin-updates \
		versions:display-property-updates

.PHONY: mvn-install
mvn-install:
	mvn install

.PHONY: install
install: mvn-install
