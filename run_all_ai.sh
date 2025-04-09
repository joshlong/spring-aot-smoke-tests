#!/usr/bin/env bash

./gradlew formatMain formatTest
#./gradlew :ai:spring-ai-starter-model-openai:build
#./gradlew :ai:spring-ai-starter-model-openai:appTest

for project in spring-ai-starter-model-openai spring-ai-starter-model-ollama ; do
  echo "testing... $project "
  ./gradlew :ai:${project}:nativeAppTest
done
