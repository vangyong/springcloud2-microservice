// model 是专门提供RESTful接口的路由请求处理handler
// 可以使用gorm等ORM工具来处理。为了代码简洁，这里使用原生sql处理。
package model

import (
	"database/sql"
	"fmt"
	"log"
)

type User struct {
	UserId       string `json:"userId" form:"userId"`
	NickName     string `json:"nickName" form:"nickName"`
	MobileNumber string `json:"mobileNumber" form:"mobileNumber"`
}

func (u *User) GetUser(id string) (user User, err error) {

	users := User{}

	//redisClient := NewRedis()
	//val, err := redisClient.Get("user:" + string(id)).Result()
	//if err != nil {
	//	log.Println("GetUser from cache error:", val, err)
	//}

	//mysqlClient := NewMysql()
	//
	//defer mysqlClient.Db.Close()

	mysqlClient, err := sql.Open("mysql", "root:root@tcp(localhost:3306)/springcloud2-microservice?charset=utf8")
	if err != nil {
		fmt.Println(err)
	}
	//关闭数据库
	defer mysqlClient.Close()

	var userId string
	var nickName sql.NullString
	var mobileNumber sql.NullString

	fmt.Println(id)
	//单行查询
	row := mysqlClient.QueryRow("select user_id,nick_name,mobile_number from sys_user where user_id = ?", id)

	if err != nil {
		log.Printf("Query data from mysql error: %v\n", err)
		return users, err
	}
	row.Scan(&userId, &nickName, &mobileNumber)
	fmt.Println(userId)
	fmt.Println(nickName)
	fmt.Println(mobileNumber)

	if !nickName.Valid {
		nickName.String = ""
	}
	if !mobileNumber.Valid {
		mobileNumber.String = ""
	}
	fmt.Println("----------")
	fmt.Println(nickName, mobileNumber)
	fmt.Println("----------")

	users = User{UserId: userId, NickName: nickName.String, MobileNumber: mobileNumber.String}

	return users, nil

}
