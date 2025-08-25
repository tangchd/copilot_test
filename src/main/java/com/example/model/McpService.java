package com.example.model;

public class McpService {
    private String name;
    private String description;
    private String version;
    private String[] capabilities;

    public McpService() {}

    public McpService(String name, String description, String version, String[] capabilities) {
        this.name = name;
        this.description = description;
        this.version = version;
        this.capabilities = capabilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String[] getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String[] capabilities) {
        this.capabilities = capabilities;
    }
}