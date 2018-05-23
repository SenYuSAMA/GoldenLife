# 基于MVP模式的黄金报价软件
***
**关键技术   
	①使用后台不死服务定时向网络请求报价数据，并存至数据库。  
	②使用Okhttp3开源框架发送网络请求，返回Json数据。  
	③使用Gson开源框架解析网络返回的Json数据，并且存至数据库。  
	④数据库的构建与操作，使用LitePal开源框架。  
	⑤使用ViewPager+Fragment+Tablayout实现界面滑动切换碎片展示报价。  
	⑥使用RecycleView实现material design，展示新闻信息。  **
![MVP逻辑](https://i.imgur.com/8YXOQ29.png)
***
报价页面：  
![](https://i.imgur.com/nkgYtb2.png)  
新闻展示页面：  
![](https://i.imgur.com/1gyou7j.png)
