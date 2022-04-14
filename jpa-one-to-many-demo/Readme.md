1. for post call: (Post)
endpoint: http://localhost:8080/posts
body:
{
    "title": "testing",
    "description": "testing jpa",
    "content": "post1"
}

2. to get post with pagination (GET)
endpoint: http://localhost:8080/posts?page=0&size=2&sort=createdAt,desc

3. to comment on post (POST)
endpoint: http://localhost:8080/posts/1/comments
body:
{
	"text":"great post"
}
4. to get the comment on post (GET)
endpoint: http://localhost:8080/posts/1/comments?page=0&size=3&sort=createdAt,desc

5. To get the all post: (GET)
endpoint: http://localhost:8080/posts
ref: https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

