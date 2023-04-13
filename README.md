# nWebtoonAPI
n사 웹툰 API를 만들어보자

# 개발환경
- Java 11
- Spring Boot
- Spring Data JPA
- MySQL

## 웹툰 목록 조회
1. 전체 및 요일별 정렬
2. 전제 및 요일별 정렬 안에 조회 순, 평점 순 정렬<br>

<img width="846" alt="image" src="https://user-images.githubusercontent.com/125088568/231784123-36e851fa-87f9-48e4-9b87-40fd7c77116e.png"><br>
![image](https://user-images.githubusercontent.com/125088568/231784990-46fcf983-a072-41d2-8594-90c768aed43e.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231787505-293da536-0d03-48db-a000-2549b3db1887.png)<br><br>

## 웹툰 등록 및 이미지 등록
1. 웹툰 id로 하는 대표 이미지 및 서브 이미지 폴더 생성
2. 대표 및 서브 이미지 저장<br>

![image](https://user-images.githubusercontent.com/125088568/231789573-f6a34653-776b-4ba8-bda9-a281a5fc020c.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231790139-3b163323-aa2f-4385-8317-3002d46fd82b.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231790186-1f2e13d6-55f4-496e-9157-ce390faf9aaa.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231793072-48a28b8f-3193-433e-979a-27c775d2751d.png)<br><br>

## 웹툰 수정 및 삭제
1. 수정시 이미지 파일첨부 유/무 확인
2. 수정시 첨부된 파일이 있다면 기존 이미지 파일 삭제
3. 웹툰 삭제 시 이미지 폴더 삭제<br>

![image](https://user-images.githubusercontent.com/125088568/231796972-45031574-afbc-4951-b606-535c6f48e1b2.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231797293-6dafcd3d-1392-4b9f-9be4-1de45dfe2100.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231798438-5a500d9c-a4e0-4edf-9851-7d4710131236.png)<br><br>

## 웹툰 에피소드 목록 조회
![image](https://user-images.githubusercontent.com/125088568/231799480-5c1ce634-5f2c-4dcf-a0ce-f883cf9284eb.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231799676-266ab226-aa44-4957-8ab1-88bcc28f67d8.png)<br><br>

## 에피소드 조회
1. 에피소드 조회시 웹툰 조회수 증가<br>

![image](https://user-images.githubusercontent.com/125088568/231800219-317389a0-dac1-4f78-b646-180e94ded1e4.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231800721-4a80939f-db1c-432a-a469-d9b90334f3f0.png)<br><br>

## 에피소드 등록
1. 웹툰 총 에피소드수 증가
2. 썸네일 폴더 생성 및  파일 저장
3. 컨텐츠 폴더 생성 및 파일 저장<br>

![image](https://user-images.githubusercontent.com/125088568/231801702-6a46372e-85b5-4fd5-ba93-65df081ee27e.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231801997-74f95d4a-df57-4275-b521-9272acd779b0.png)<br><br>

## 에피소드 수정 및 삭제
1. 수정시 썸네일, 컨텐츠 파일첨부 유/무 확인
2. 수정시 첨부된 파일이 있다면 기존 파일 삭제
3. 에피소드 삭제 시 에피소드 파일 및 폴더 삭제
4. 에피소드 삭제 시 해당 웹툰 총 에피소드수 감소<br>

![image](https://user-images.githubusercontent.com/125088568/231803818-f3c5915b-ec7f-4148-b6cd-197e5ece03da.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231803344-004aa6c4-7fdb-4bd6-b1a8-aa5e56773014.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231804162-8d19d5d9-199e-4f20-9f9f-65732d9dca7b.png)<br><br>

## 평점
1. 소수점 2자리까지 표현
2. 평점을 등록한 사람수 평점API 호출시 증가 및 저장 (count변수)
3. 웹툰 평점은 전체 에피소드 평균 평점<br>

![image](https://user-images.githubusercontent.com/125088568/231805935-2ad889c0-be76-45f4-934f-4a9f273cd69f.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231806117-0c58f070-a153-4109-b78b-bcde1d45536c.png)<br><br>

## 댓글 등록<br>

![image](https://user-images.githubusercontent.com/125088568/231806700-6833dbee-47a5-46ed-b030-bd5731e7a966.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231806848-c94a0291-99f3-4ce6-bdc4-e949ccc42678.png)<br><br>

## 댓글 수정 및 삭제<br>

![image](https://user-images.githubusercontent.com/125088568/231807167-2d1ca53a-328b-4485-b30c-9dd400d0255b.png)<br>
![image](https://user-images.githubusercontent.com/125088568/231807327-054992f5-292b-43c6-b38a-ba51612dbeff.png)<br><br>



























