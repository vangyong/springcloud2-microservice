package main

import (
	//"context"
	//"log"
	//"net/http"
	//"os"
	//"os/signal"
	//"time"

	"microservice-equity/api"
	//"microservice-equity/handler"

	"github.com/didip/tollbooth"
	"github.com/didip/tollbooth/limiter"

	"github.com/gin-gonic/gin"
)

// 定义全局的CORS中间件
func Cors() gin.HandlerFunc {
	return func(c *gin.Context) {
		c.Writer.Header().Add("Access-Control-Allow-Origin", "*")
		c.Next()
	}
}

func LimitHandler(lmt *limiter.Limiter) gin.HandlerFunc {
	return func(c *gin.Context) {
		httpError := tollbooth.LimitByRequest(lmt, c.Writer, c.Request)
		if httpError != nil {
			c.Data(httpError.StatusCode, lmt.GetMessageContentType(), []byte(httpError.Message))
			c.Abort()
		} else {
			c.Next()
		}
	}
}

//func enableEureka() {
//	eeureka.RegisterAt(
//		beego.AppConfig.DefaultString("eurekaServer", "http://localhost:8761"),
//		beego.AppConfig.DefaultString("appname", "microservice-equity"),
//		beego.AppConfig.DefaultString("httpport", "8060"))
//}

func main() {

	//enableEureka()

	gin.SetMode(gin.ReleaseMode)
	router := gin.Default()
	//// 静态资源加载，本例为css,js以及资源图片
	//router.StaticFS("/public", http.Dir("/Users/wangyong/mygit/springcloud2-microservice/microservice-equity/website/static"))
	//router.StaticFile("/favicon.ico", "./resources/favicon.ico")

	//// 导入所有模板，多级目录结构需要这样写
	//router.LoadHTMLGlob("website/tpl/*/*")
	//// 也可以根据handler，实时导入模板。
	//
	//// website分组
	//v := router.Group("/")
	//{
	//	v.GET("/index.html", handler.IndexHandler)
	//	v.GET("/add.html", handler.AddHandler)
	//	v.POST("/postme.html", handler.PostmeHandler)
	//}

	// 中间件 golang的net/http设计的一大特点就是特别容易构建中间件。
	// gin也提供了类似的中间件。需要注意的是中间件只对注册过的路由函数起作用。
	// 对于分组路由，嵌套使用中间件，可以限定中间件的作用范围。
	// 大致分为全局中间件，单个路由中间件和群组中间件。

	// 使用全局CORS中间件,虽然是全局中间件,在use前的代码不受影响,也可在handler中局部使用
	// router.Use(Cors())

	////rate-limit 中间件
	//lmt := tollbooth.NewLimiter(1, nil)
	//lmt.SetMessage("服务繁忙，请稍后再试...")

	// API分组(RESTFULL)以及版本控制
	v1 := router.Group("/v1")
	{
		// 下面是群组中间的用法
		// v1.Use(Cors())

		// 单个中间件的用法
		v1.GET("/user/:id", Cors(), api.GetUser)

		// rate-limit
		//v1.GET("/user/:id/*action", LimitHandler(lmt), api.GetUser)
		//v1.GET("/user/:id/*action", Cors(), api.GetUser)

		// AJAX OPTIONS ，下面是有关OPTIONS用法的示例
		// v1.OPTIONS("/users", OptionsUser)      // POST
		// v1.OPTIONS("/users/:id", OptionsUser)  // PUT, DELETE
	}

	router.Run(":8060")

}
