package com.freepalesting313.boycottproducts.dataservices;

import com.freepalesting313.boycottproducts.dto.GitHubContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;

@Component
public class GitHubDataFetcher {

    private final String githubApiBaseUrl;
    private final String repositoryOwner;
    private final String repositoryName;
    private final String filePath;

    @Autowired
    private WebClient webClient;

    public GitHubDataFetcher() {
        this.githubApiBaseUrl = "https://api.github.com/repos/";
        this.repositoryOwner = "freePalestine313";
        this.repositoryName = "boycottproducts";
        this.filePath = "boycott.json";
    }

    public String fetchDataFromGitHub() {
        String apiUrl = githubApiBaseUrl + repositoryOwner + "/" + repositoryName + "/contents/" + filePath;
        GitHubContent response = webClient.get().uri(apiUrl).retrieve().bodyToMono(GitHubContent.class).block();
        if (response != null) {
            // Decode the content (usually base64-encoded)
            String base64String = response.getContent().replaceAll("\\n", "");
            byte[] contentBytes = Base64.getDecoder().decode(base64String);
            return new String(contentBytes);
        }
        return null;
    }
}
