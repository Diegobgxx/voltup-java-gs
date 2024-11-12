package org.voltup.app.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("""
                            Você é um assitente virtual para dar insights para uma fazenda.
                            Você está conversando com fazendeiros e agronomos.
                            Seja Objetivo e mostre numeros.
                            Tente manter o assunto dentro do contexto de agro.
                            Você pode usar chamada de funções para buscar informações da plantaçao, da fazenda e das strategias utilizadas.
                        """)
                .defaultFunctions("findPlantation", "findFarm")
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }

    public String sendToAi(String message){
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }

}