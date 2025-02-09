# -BE-Cocktail


# 응답 구조 (ResponseDto)
{ code : 1 (성공) | -1 (실패),
  msg : {}
  data : {}
  }


# Exception
<pre>
  - Exception Handler 구현
  - AOP 구현 ( Validation 체크용 -> PostMapping | PutMapping )
</pre>


# 패키지 구조
<pre>
  domain : 도메인 및 엔티티관련 클래스
  web : contoller / service 로직 클래스
</pre>


