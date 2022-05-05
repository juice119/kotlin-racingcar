# kotlin-racingcar

#  2단계 - 문자열 계산기

### 요구사항
- 문자열 값으로 사칙 연산을 수행할 수 있는 계산기를 구현
- 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정
  - 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시
- `"2 + 3 * 4 / 2"`와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 `10`을 출력


### 과제에서 명시한 예외사항
- 입력값이 `null`이거나 빈 공백 문자일 경우 `IllegalArgumentException throw`
- 사칙연산 기호가 아닌 경우 `IllegalArgumentException throw`

### 개인적으로 추가한 예외사항
- 연산을 수행할수 없는 연산자가 연속으로 두번 나온 경우 `IllegalArgumentException throw`
  -  `1++1` 입력시, `IllegalArgumentException throw`
- 숫자, 연산자를 제외한 문자 입력시 `IllegalArgumentException throw`
  - `1AbCDe2` 입력시 , `IllegalArgumentException throw`
- 연산식에서 연산자 없이 숫자만 있는 경우 그 값만 응답
  - `1` 입력시, `1` 출력
- 중간에 공백이 포함된 인자가 입력된 경우 공백을 제거하여 계산 수행
  - `1   0 + 2        0` 입력시, `30` 출력

### TODO LIST
- [ ] 예외처리에서 발생한 에러 메시지 포맷 정하기
- [ ] 연산자 `enum` 형식으로 바꾸기