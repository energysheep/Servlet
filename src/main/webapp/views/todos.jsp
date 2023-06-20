<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
  <form action="/todoinsert" method="post">
<!--      get방식은 데이터를 불러올떄(상품의 정확한 주소?등등), post는 데이터를 저장할때 (로그인 회원가입 등등)-->
<!--      get은 속도 빠르고 데이터 확실하게 보안 낮음, post는 속도 느리고 보안 높음-->
    <input type="text" name="content" placeholder="아이디를 입력해주세요">
    <input type="submit">
  </form>
</div>
