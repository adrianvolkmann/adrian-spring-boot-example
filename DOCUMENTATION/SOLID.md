## O que é SOLID?

SOLID é um conjunto de cinco princípios de design de software que, quando aplicados em conjunto, facilitam a criação de sistemas mais robustos e escaláveis. Esses princípios foram popularizados por Robert C. Martin (também conhecido como Uncle Bob) e são amplamente utilizados na engenharia de software moderna.

### Os Princípios SOLID

1. **S** - **Single Responsibility Principle (Princípio da Responsabilidade Única)**
2. **O** - **Open/Closed Principle (Princípio Aberto/Fechado)**
3. **L** - **Liskov Substitution Principle (Princípio da Substituição de Liskov)**
4. **I** - **Interface Segregation Principle (Princípio da Segregação de Interfaces)**
5. **D** - **Dependency Inversion Principle (Princípio da Inversão de Dependência)**

Vamos detalhar cada um desses princípios com exemplos em Java, utilizando o Spring Boot quando aplicável.

---

### 1. Single Responsibility Principle (SRP)

**Princípio da Responsabilidade Única** afirma que uma classe deve ter apenas uma razão para mudar, ou seja, deve ter uma única responsabilidade.

**Exemplo que viola SRP:**

```java
public class UserService {
    public void createUser(User user) {
        // Lógica para criar usuário
    }

    public void sendEmail(User user, String message) {
        // Lógica para enviar e-mail
    }
}
```

Neste exemplo, a classe `UserService` está lidando tanto com a criação de usuários quanto com o envio de e-mails, o que viola o SRP.

**Aplicando SRP:**

```java
@Service
public class UserService {
    public void createUser(User user) {
        // Lógica para criar usuário
    }
}

@Service
public class EmailService {
    public void sendEmail(User user, String message) {
        // Lógica para enviar e-mail
    }
}
```

Agora, cada classe tem uma única responsabilidade: `UserService` para gerenciamento de usuários e `EmailService` para envio de e-mails.

---

### 2. Open/Closed Principle (OCP)

**Princípio Aberto/Fechado** diz que as entidades de software (classes, módulos, funções) devem estar abertas para extensão, mas fechadas para modificação.

**Exemplo que viola OCP:**

```java
public class PaymentProcessor {
    public void processPayment(String type) {
        if (type.equals("credit")) {
            // Processa pagamento com cartão de crédito
        } else if (type.equals("paypal")) {
            // Processa pagamento com PayPal
        }
        // Adicionar novos tipos de pagamento requer modificar esta classe
    }
}
```

Cada novo método de pagamento exige a modificação da classe existente.

**Aplicando OCP com Abstração:**

```java
public interface PaymentMethod {
    void processPayment();
}

@Service
public class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment() {
        // Processa pagamento com cartão de crédito
    }
}

@Service
public class PayPalPayment implements PaymentMethod {
    @Override
    public void processPayment() {
        // Processa pagamento com PayPal
    }
}

@Service
public class PaymentProcessor {
    private final List<PaymentMethod> paymentMethods;

    @Autowired
    public PaymentProcessor(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public void processAllPayments() {
        for (PaymentMethod method : paymentMethods) {
            method.processPayment();
        }
    }
}
```

Agora, para adicionar um novo método de pagamento, basta criar uma nova implementação de `PaymentMethod` sem modificar a classe `PaymentProcessor`.

---

### 3. Liskov Substitution Principle (LSP)

**Princípio da Substituição de Liskov** estabelece que objetos de uma classe derivada devem poder substituir objetos da classe base sem alterar a corretude do programa.

**Exemplo que viola LSP:**

```java
public class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) { this.width = width; }

    public void setHeight(int height) { this.height = height; }

    public int getArea() { return width * height; }
}

public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }
}
```

Aqui, `Square` altera o comportamento de `Rectangle`, o que pode levar a resultados inesperados.

**Aplicando LSP com Composição:**

```java
public interface Shape {
    int getArea();
}

public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() { return width * height; }
}

public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int getArea() { return side * side; }
}
```

Agora, `Square` e `Rectangle` implementam a interface `Shape` sem violar o LSP, permitindo substituições seguras.

---

### 4. Interface Segregation Principle (ISP)

**Princípio da Segregação de Interfaces** sugere que uma classe não deve ser forçada a implementar interfaces que não utiliza. É melhor ter várias interfaces específicas do que uma interface geral.

**Exemplo que viola ISP:**

```java
public interface Worker {
    void work();
    void eat();
}

public class HumanWorker implements Worker {
    @Override
    public void work() {
        // Trabalha
    }

    @Override
    public void eat() {
        // Come
    }
}

public class RobotWorker implements Worker {
    @Override
    public void work() {
        // Trabalha
    }

    @Override
    public void eat() {
        // Robots não comem, mas precisam implementar o método
    }
}
```

Neste caso, `RobotWorker` é forçado a implementar o método `eat()`, que não faz sentido para robôs.

**Aplicando ISP com Interfaces Específicas:**

```java
public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}

public class HumanWorker implements Workable, Eatable {
    @Override
    public void work() {
        // Trabalha
    }

    @Override
    public void eat() {
        // Come
    }
}

public class RobotWorker implements Workable {
    @Override
    public void work() {
        // Trabalha
    }
}
```

Agora, `RobotWorker` implementa apenas `Workable`, evitando a necessidade de métodos irrelevantes.

---

### 5. Dependency Inversion Principle (DIP)

**Princípio da Inversão de Dependência** afirma que módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações. Além disso, abstrações não devem depender de detalhes, mas os detalhes devem depender das abstrações.

**Exemplo que viola DIP:**

```java
public class MySQLConnection {
    public void connect() {
        // Conecta ao MySQL
    }
}

public class UserRepository {
    private MySQLConnection connection = new MySQLConnection();

    public void save(User user) {
        connection.connect();
        // Salva usuário no banco de dados
    }
}
```

Aqui, `UserRepository` depende diretamente da implementação concreta `MySQLConnection`.

**Aplicando DIP com Injeção de Dependência:**

```java
public interface DatabaseConnection {
    void connect();
}

@Service
public class MySQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        // Conecta ao MySQL
    }
}

@Service
public class PostgreSQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        // Conecta ao PostgreSQL
    }
}

@Repository
public class UserRepository {
    private final DatabaseConnection connection;

    @Autowired
    public UserRepository(DatabaseConnection connection) {
        this.connection = connection;
    }

    public void save(User user) {
        connection.connect();
        // Salva usuário no banco de dados
    }
}
```

Com a inversão de dependência, `UserRepository` depende da abstração `DatabaseConnection`, permitindo trocar facilmente a implementação sem modificar a classe `UserRepository`.

