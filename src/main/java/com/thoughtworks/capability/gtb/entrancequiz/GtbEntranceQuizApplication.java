package com.thoughtworks.capability.gtb.entrancequiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GtbEntranceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}

}

// TODO GTB-完成度: * 新增学生接口没有校验名字不能为空的场景
// TODO GTB-完成度: * 没有实现查询未分组学生的接口
// TODO GTB-完成度: * 没有分离查看分组和分组学员的接口
// TODO GTB-测试: * 包含了对Controller的测试
// TODO GTB-知识点: * Spring MVC相关的知识点掌握的不错
// TODO GTB-知识点: * API设计合理，部分符合Restful API Design
// TODO GTB-知识点: * 合理使用了@CrossOrigin
// TODO GTB-工程实践: * 项目分包合理，使用了分层架构
// TODO GTB-工程实践: * 遵循了小步提交，commit message表意