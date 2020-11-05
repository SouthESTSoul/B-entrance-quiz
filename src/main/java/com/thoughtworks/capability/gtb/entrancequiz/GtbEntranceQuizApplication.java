package com.thoughtworks.capability.gtb.entrancequiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO GTB-知识点: * 使用了lombok
// TODO GTB-知识点: * 需要了解下三层架构
// TODO GTB-测试: * 有Controller层测试，覆盖了部分功能的Happy Path
// TODO GTB-工程实践: * 注意单一职责，group和student应该有单独的Controller和Service
@SpringBootApplication
public class GtbEntranceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}

}
