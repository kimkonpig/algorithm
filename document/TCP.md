## TCP
- 일반적으로 TCP와 IP를 함께 사용하는데, IP가 데이터의 배달을 처리한다면 TCP는 패킷을 추적 및 관리한다.
  - 패킷 : 인터넷 내에서 데이터를 보내기 위한 경로 배정(라우팅)을 효율적으로 하기 위해 데이터를 여러 개의 조각으로 나누어 전송을 하는데, 이때 조각을 패킷이라고 한다.
  - 데이터는 패킷 단위로 나누어 같은 목적지(IP 계층)으로 전송된다.
- <b>신뢰성 있는 데이터 전송을 지원하는 연결 지향형 프로토콜</b>이다
- 사전에 <b>3-way handshake</b>라는 과정을 통해 연결을 설정하고 통신을 시작한다.
- 4-way handshake 과정을 통해 연결을 해제(가상 회선 방식)한다.
- <b>흐름 제어, 혼잡 제어, 오류 제어</b>를 통해 신뢰성을 보장한다. 그러나 이 세가지 때문에 UDP보다 전송 속도가 느리다.
- <b>데이터의 전송 순서를 보장</b>하며 수신 여부를 확인할 수 있다.
- TCP 사용 예 : 대부분의 웹 HTTP 통신, 이메일, 파일 전송 등
- TCP가 가상회선 방식을 제공한다는 것은 송신측과 수신측을 연결하여 패킷을 전송하기 위한 논리적 경로를 배정한다는 뜻이다.
- A, B, C라는 데이터(패킷)가 출발지에서 목적지로 간다고 했을 때,
  - 목적지에서는 A, B, C가 모두 필요한 지 모르고 A와 C만 보고 모든 데이터가 왔다고 착각할 수 있다.
  - A, B, C 패킷에 1, 2, 3 번호를 부여하여 패킷 분실 확인을 하고 목적지에서 데이터를 재조립할 수 있다.
