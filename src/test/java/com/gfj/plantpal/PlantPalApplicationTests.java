package com.gfj.plantpal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootTest
class PlantPalApplicationTests {

        @MockBean
        private ServerEndpointExporter serverEndpointExporter;
        @Test
        void contextLoads() {
                // 这里可以添加你的测试逻辑
        }
}
