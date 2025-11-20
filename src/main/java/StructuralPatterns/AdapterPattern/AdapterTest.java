package StructuralPatterns.AdapterPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdapterTest {
    @Test
    public void testAdapter() {
        Logger logger = new LoggerAdapter(new OldLogger());
        logger.log("System started");
        assertTrue(logger instanceof LoggerAdapter);
    }

    // 旧系统的日志类
    class OldLogger {
        public void writeLog(String msg) {
            System.out.println("[OldLog] " + msg);
        }
    }

    // 新接口
    interface Logger {
        void log(String message);
    }

    // 适配器
    class LoggerAdapter implements Logger {
        private OldLogger oldLogger;

        public LoggerAdapter(OldLogger oldLogger) {
            this.oldLogger = oldLogger;
        }

        @Override
        public void log(String message) {
            oldLogger.writeLog(message);
        }
    }

}
