
# 게시판

### 생성 Post "/boards"

###### Body parameter
* title : String -> 게시판 이름

### 조회 Get "/boards"
###### Body parameter
* id : Long -> 게시판 ID
* title : String -> 게시판 이름
* createdTime : LocalDateTime -> 생성시간

### 수정 Put "/boards/{boardId}" 
###### Path Variable_
* id : Long -> 게시판 ID
###### Body parameter_
* title : String -> 게시판 이름

### 삭제 Delete  "/boards/{boardId}"
###### Path Variable_
* id : Long -> 게시판 ID



# 게시글


### 생성 Post "/posts"
###### Body parameter_
* title : String -> 게시글 이름
* content : String -> 게시글 내용
* board : Board -> 게시판 ID ????
* writer: String -> 작성자

### 목록 조회 Get "/posts"
###### Body parameter_
* id : Long -> 게시글 ID
* title : String -> 게시글 이름
* board : Board -> 게시판 ID
* createdTime : LocalDateTime -> 생성시간
* writer: String -> 작성자
* commentCount : int ->댓글갯수

### 상세 조회 Get "/posts/{postId}"
###### Path Variable_
* id : Long -> 게시글 ID
###### Body parameter_
* id : Long -> 게시글 ID
* title : String -> 게시글 이름
* content : String -> 게시글 내용
* board : Board -> 게시판 ID
* createdTime : LocalDateTime -> 생성시간
* writer: String -> 작성자
* commentList : List -> 댓글목록

### 수정 Put "/posts/{postId}" 
###### Path Variable_
* id : Long -> 게시글 ID
###### Body parameter_
* title : String -> 게시글 이름
* content : String -> 게시글 내용
* board : Board -> 게시판 ID
* writer: String -> 작성자

### 삭제 Delete "/posts/{postId}" 
###### Path Variable_
* id : Long -> 게시글 ID
###### Body parameter_
* writer: String -> 작성자



# 댓글 

### 생성 Post "/comments"
###### Body parameter_
* content : String -> 댓글 내용
* postId : Long -> 게시글
* writer : String -> 작성자 이름

### 수정 Put "/comments/{commentId}" 
###### Path Variable_
* id : Long -> 댓글 ID
###### Body parameter_
* content : String -> 댓글 내용
* writer : String -> 작성자

### 삭제 Delete "/comments/{commentId}" 
###### Path Variable_
* id : Long -> 댓글 ID
###### Body parameter_
* writer: String -> 작성자

