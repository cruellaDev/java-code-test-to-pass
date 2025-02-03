| No. | Level 1 | 풀이완료 | page | No. | Level 2 | 풀이완료 | page |
| --- | ------- | ---- | ---- | --- | ------- | ---- | ---- |
| 15  | [요세푸스문제](https://binaryjourney.tistory.com/321)  | [V](../java/src/queue/Solution15JosephusProblem.java)    | 199  | 16  | [기능 개발](https://binaryjourney.tistory.com/322)   | [V](../java/src/queue/Solution16ProgramBeforeDeploy.java)    | 204  |
|     |         |      |      | 17  | [카드 뭉치](https://binaryjourney.tistory.com/324)   | [V](../java/src/queue/Solution17CardStack.java)    | 209  |

## 개념

### 큐

> Queue 어원은 `줄을 서다` 이다.

큐는 먼저 들어간 데이터가 먼저 나오는 자료 구조이다.
- `FIFO`:  선입선출(First In First Out), 먼저 들어간 것이 먼저 나오는 규칙
	- `Enqueue(Add)`: 큐에 데이터를 삽입하는 연산
	- `Dequeue(Poll)`: 큐에 데이터를 꺼내는 연산


프로그래밍 언어에서 큐는 대표적으로 여러 이벤트가 발생했을 때 발생한 순서대로 처리할 때 활용된다.
- 작업 대기열
- 이벤트 처리


### 큐의 ADT

> [!NOTICE] ADT (Abstract data type)
> 
> 추상 자료형, 인터페이스만 있고 실제로 구현은 되지 않은 자료형

#### 연산

| 정의                      | 설명                             |
| ----------------------- | ------------------------------ |
| boolean isFull()        | 큐에 들어 있는 데이터 개수가 max size인지 확인 |
| boolean isEmpty()       | 큐에 들어 있는 데이터가 하나도 없는지 확인       |
| void add(ItemType item) | 큐에 데이터 삽입                      |
| ItemType poll()         | 큐에서 최근에 삽입한 데이터를 꺼내고 그 데이터를 반환 |

#### 상태

| 정의                     | 설명                                    |
| ---------------------- | ------------------------------------- |
| int front              | 큐에서 가장 마지막에 poll한 위치를 기록              |
| int rear               | 큐에서 최근 add한 데이터의  위치를 기록              |
| ItemType data[maxsize] | 큐의 데이터를 관리하는 배열. 최대 max size의 데이터를 관리 |


### Queue 클래스 사용하기


- Java 컬렉션 프레임워크에서 Queue는 인터페이스로 구현되어 있다.
	- Queue의 구현체로 자주 사용하는 클래스는 `ArrayDeque`, `LinkedList`가 있다.
	- 일반적인 코딩테스트에서는 `ArrayDeque`를 더 많이 사용한다.
- Deque는 `Double Ended Queue`의 줄임말이다.
	- 양 끝에서 삽입이나 삭제할 수 있는 큐를 구현한 것이다.
	- `ArrayDeque` 하나면 큐, 스택, 덱을 전부 구현할 수 있다.


```java

Queue<Integer> queue = new ArrayDeque<>();

// 큐에 데이터 추가
queue.add(1);
queue.add(2);
queue.add(3);


// 큐의 맨 앞 데이터 꺼내기
int first = queue.poll();
System.out.println(first); // 1


// 큐에 데이터 추가
queue.addLast(4);
queue.addLast(5);

// 큐의 맨 앞 데이터 꺼내기
first = queue.poll();
System.out.println(first); // 2
```
