| No. | Level 1         | 풀이완료 | page | No. | Level 2      | 풀이완료 | page |
| --- | --------------- | ---- | ---- | --- | ------------ | ---- | ---- |
| 08  | [올바른 괄호](https://binaryjourney.tistory.com/296)          | [V](../java/src/stack/Solution08RightParentheses.java)    | 144  | 10  | [괄호 회전하기](https://binaryjourney.tistory.com/298)      | [V](../java/src/stack/Solution10RotateParentheses.java)    | 153  |
| 09  | [10진수를 2진수로 변환하기](https://binaryjourney.tistory.com/297) | [V](../java/src/stack/Solution09DecimalToBinary.java)    | 149  | 11  | [짝지어 제거하기](https://binaryjourney.tistory.com/299)     | [V](../java/src/stack/Solution11RemovePair.java)    | 158  |
|     |                 |      |      | 12  | [주식 가격](https://binaryjourney.tistory.com/300)        | [V](../java/src/stack/Solution12StockPrice.java)    | 161  |
|     |                 |      |      | 13  | [크레인 인형 뽑기 게임](https://binaryjourney.tistory.com/301) | [V](../java/src/stack/Solution13ClawMachine.java)    | 168  |
|     |                 |      |      | 14  | [표 편집](https://binaryjourney.tistory.com/302)         | [V](../java/src/stack/Solution14EditTable.java)    | 177  |

## 개념

### 스택

> Stack 어원은 `쌓는다` 이다.

- 먼저 입력한 데이터를 제일 나중에 꺼낼 수 있는 자료구조이다.
	- `FILO`:  선입선출(First In Last Out), 먼저 들어간 것이 마지막에 나오는 규칙
	- `push`: 스택에 데이터를 삽입하는 연산
	- `pop`: 스택에 데이터를 꺼내는 연산

### 스택의 ADT

> 💡 ADT (Abstract data type)
> 
> 추상 자료형, 인터페이스만 있고 실제로 구현은 되지 않은 자료형

> 💡 deque (덱)
> 
> 양쪽에서 데이터를 삽입하거나 삭제할 수 있는 자료 구조

- 데이터가 아무것도 들어 있지 않으면 `top` 에  `-1`이 들어가 있음

#### 연산

| 정의                       | 설명                              |
| ------------------------ | ------------------------------- |
| boolean isFull()         | 스택에 들어 있는 데이터 개수가 max size인지 확인 |
| boolean isEmpty()        | 스택에 들어 있는 데이터가 하나도 없는지 확인       |
| void push(ItemType item) | 스택에 데이터 삽입                      |
| ItemType pop()           | 스택에서 최근에 푸시한 데이터를 꺼내고 그 데이터를 반환 |

#### 상태

| 정의                     | 설명                                     |
| ---------------------- | -------------------------------------- |
| int top                | 스택에서 최근에 푸시한 데이터의 위치를 기록               |
| ItemType data[maxsize] | 스택의 데이터를 관리하는 배열. 최대 max size의 데이터를 관리 |

### Stack 클래스 사용하기

> 💡 java의 Stack 클래스는 크기를 동적으로 관리하므로 `max_size`나 `isFull()` 메서드가 없다.

> 💡 다만 `size()` 메서드를 제공하여 스택에 들어 있는 데이터의 수를 알 수 있다.

> 💡 가장 최근에 push한 데이터를 꺼내지 않으면서 반환만 하는 `peek()` 메서드를 제공한다.

```java
// 스택 객체 생성
Stakc<Integer> stack = new Stack<>();

// 스택에 데이터 푸시
stack.push(6);
stack.push(5);

// 스택이 비어 있는지 확인
System.out.println(stack.isEmpty()); // false

// 스택에 가장 최근에 푸시한 값
System.out.println(stack.peek()); // 5
System.out.println(stack.pop()); // 5

// 스택에 들어 있는 데이터 개수
System.out.println(stack.size()); // 1
```