package com.example.controller;

import com.example.model.McpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello, Spring Boot Web Application!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is running!";
    }

    @GetMapping("/mcp/services")
    public List<McpService> getMcpServices() {
        return Arrays.asList(
            new McpService("filesystem", "文件系统访问服务", "1.0.0", 
                new String[]{"read_file", "write_file", "list_directory", "create_directory"}),
            new McpService("database", "数据库操作服务", "1.0.0", 
                new String[]{"query", "insert", "update", "delete", "schema_info"}),
            new McpService("web-search", "网络搜索服务", "1.0.0", 
                new String[]{"search", "fetch_url", "extract_content"}),
            new McpService("code-analysis", "代码分析服务", "1.0.0", 
                new String[]{"analyze_code", "format_code", "lint", "test_generation"}),
            new McpService("memory", "上下文记忆服务", "1.0.0", 
                new String[]{"store_context", "retrieve_context", "search_memory", "clear_memory"})
        );
    }
}