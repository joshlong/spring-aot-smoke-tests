/*
 * Copyright 2022-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Josh Long
 */
@SpringBootApplication
@RegisterReflectionForBinding(Joke.class)
public class AiChatClientAotApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiChatClientAotApplication.class, args);
	}

	@Bean
	CommandLineRunner aiChatClientCommandLineRunner(ChatClient ai) {
		return args -> {
			var joke = ai.prompt("tell me a joke!").call().entity(Joke.class);
			System.out.println(joke);
		};
	}

	@Bean
	ChatClient chatClient(ChatClient.Builder builder) {
		return builder.build();
	}

}

record Joke(String joke, String punchline) {
}