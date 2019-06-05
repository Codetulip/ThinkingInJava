# Interface Segregation Principle(ISP)
接口隔离原则的包含4层含义：  
1.接口要尽量的小  
2.接口要高内聚  
3.定制服务  
4.接口设计是有限度的
  
根据以下规则衡量：  
1.一个接口只服务于一个子模块或业务逻辑  
2.通过业务逻辑压缩接口中的public方法，接口时常去回顾，尽量让接口达到精简的方法  
3.已经被污染的接口，尽量去修改，若变更的风险较大，则采用适配器模式进行转化处理  
4.了解环境，拒绝盲从。每个项目或产品都有特定的环境因素，接口的拆分标准就不同。考虑接口的粒度。
  
