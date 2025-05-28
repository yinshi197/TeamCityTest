package com.softbridge.visionbyte;

import jetbrains.buildServer.serverSide.SBuildServer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ServerMockTest {

    @Test
    public void testServerUrl() {
        // 模拟 TeamCity 构建服务器接口
        SBuildServer server = Mockito.mock(SBuildServer.class);

        // 模拟行为：返回一个 URL
        Mockito.when(server.getRootUrl()).thenReturn("http://localhost:8111");

        // 测试验证
        assertEquals("http://localhost:8111", server.getRootUrl());
    }
}
