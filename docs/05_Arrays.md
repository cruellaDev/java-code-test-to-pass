
| No. | Level 1 | 풀이완료 | page | No. | Level 2     | 풀이완료 | page |
| --- | ------- | ---- | ---- | --- | ----------- | ---- | ---- |
| 01  | [배열 정렬하기](https://binaryjourney.tistory.com/288) | [V](../java/src/arrays/Solution01SortArray.java)    | 105  | 03  | [두 개 뽑아서 더하기](https://binaryjourney.tistory.com/290) | [V](../java/src/arrays/Solution02ControlArray.java)    | 113  |
| 02  | [배열 제어하기](https://binaryjourney.tistory.com/289) | [V](../java/src/arrays/Solution03AddTwoRandomNumbersFromArray.java)    | 109  | 04  | [모의고사](https://binaryjourney.tistory.com/291)        | [V](../java/src/arrays/Solution04Exam.java)    | 116  |
|     |         |      |      | 05  | [행렬의 곱셈](https://binaryjourney.tistory.com/292)      | [V](../java/src/arrays/Solution05MultiplyMatrix.java)    | 120  |
|     |         |      |      | 06  | [실패율](https://binaryjourney.tistory.com/293)         | [V](../java/src/arrays/Solution06FailRates.java)    | 123  |
|     |         |      |      | 07  | [방문 길이](https://binaryjourney.tistory.com/294)       | [V](../java/src/arrays/Solution07TrackingVisiting.java)    | 128  |

## 개념

### 배열

- 배열은 선형구조, 인덱스와 값을 일대일 대응해 관리하는 자료구조로 어떤 위치에 있는 데이터든 한 번에 접근할 수 있다.
- 배열은 차원과는 무관하게 메모리에 연속 할당된다.
- 컴퓨터 메모리 구조는 1차원이기에 2차원, 3차원 배열도 실제로는 1차원 공간에 저장된다.
	- 자바에서는 1차원 배열 역시 하나의 객체로, 2차원 배열을 1차원 배열 객체의 배열로 표현한다.
	- 2차원 배열은 메모리에 데이터가 반드시 연속으로 저장되지 않을 수도 있다.

#### 배열 연산의 시간복잡도

배열은 임의 접근이라는 방법으로 배열의 모든 위치에 있는 데이터에 단번에 접근할 수 있다.

데이터에 접근하기 위한 시간 복잡도는 O(1)이다.

배열 맨 뒤에 데이터를 삽입할 경우 다른 데이터 위치에 영향을 주지 않으므로 시간 복잡도는 O(1)이다.

배열 맨 앞에 데이터를 삽입할 경우 다른 데이터의 위치를 뒤로 한 칸씩 밀어야 하므로 시간 복잡도는 O(N)이다.

배열 중간에 데이터를 삽입할 경우 현재 삽입한 데이터 위에 있는 데이터 개수만큼 미는 연산을 해야 하여 시간 복잡도는 O(N)이다.

> 💡 배열은 임의 접근이라는 특징이 있어 데이터에 인덱스로 바로 접근할 수 있어 데이터에 빈벊게 접근하는 경우 효율적이지만 메모리 낭비가 발생할 수 있다.

> 💡 할당할 수 있는 메모리 크기를 확인하자.

> 💡 중간에 데이터 삽입이 많은지 확인하자.

### ArrayList

- 자바에서 크기가 동적으로 변경되는 배열이 필요할 때 사용한다.