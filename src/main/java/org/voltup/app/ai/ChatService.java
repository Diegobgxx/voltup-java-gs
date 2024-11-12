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
                            Você é um assitente virtual da voltup para buscar os postos de carregamento mais próximos.
                            Você está conversando com pessoas que tem veiculos eletricos.
                            Seja Objetivo.
                            Tente manter o assunto dentro do contexto de postos de carregamento de energia de carros elétricos.
                            Você pode usar chamada de funções para buscar informações dos postos que são compativeis com o veiculo do usuário.
                        """)
                .defaultFunctions("findChargingStation")
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