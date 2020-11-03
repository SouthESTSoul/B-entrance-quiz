package com.thoughtworks.capability.gtb.entrancequiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO GTB-知识点: * 使用了lombok
// TODO GTB-知识点: * 需要了解Restful实践
// TODO GTB-知识点: * 需要了解下三层架构
// TODO GTB-完成度: * 完成度太低，其它维度无法正常考察
// TODO GTB-测试: * 有Controller层测试，覆盖了部分功能的Happy Path
@SpringBootApplication
public class GtbEntranceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}

}
