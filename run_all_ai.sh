#!/usr/bin/env bash

./gradlew formatMain formatTest
#./gradlew :ai:spring-ai-starter-model-openai:build
#./gradlew :ai:spring-ai-starter-model-openai:appTest

old="spring-ai-starter-model-openai spring-ai-starter-model-ollama"
for project in spring-ai-starter-model-anthropic ; do
  echo "testing... $project "
  ./gradlew   -PfromMavenLocal=org.springframework.ai :ai:${project}:nativeAppTest
#  ./gradlew --scan -PfromMavenLocal=org.springframework.ai :ai:${project}:nativeAppTest
done
