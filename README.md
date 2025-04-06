# Insynium PLM

**Insynium PLM** is a collaborative Product Lifecycle Management (PLM) software solution that supports the design and management of complex products across multiple industries, including satellites, aircraft, automobiles, clothing, robotics, and more.

---

## 🚀 Project Context

As a PLM software editor, the goal of Insynium PLM is to facilitate collaborative product design, ensuring efficiency, data integrity, scalability, and ease of integration with other systems.

---

## 🛠️ Technologies Used

- **Java 8 LTS**
- **Spring Framework**


---

## 🧩 Services Offered

### 🔐 Reservation
In a collaborative context, modifying an entity requires **reserving** it first. This prevents **concurrent updates** and ensures data integrity when multiple users are working simultaneously.

### 🔄 Life Cycle Management
All entities evolve over time through various **life cycle states**. Each entity follows a specific **life cycle template** that defines its transition stages.

**Example**:
- A newly created design Part starts in the `"In progress"` state.
- Once the designer completes the task, it transitions to `"Under validation"`.
- After validation, the Part enters its final state: `"Release"`.

### 🔁 Versioning
Entities in their final life cycle state can **start a new version** when modifications are required.
- Previous versions remain **intact and accessible**.
- Ensures **traceability and historical reference**.

---

## ✨ Improvements & Clean Code Practices

### ✅ Code Quality Enhancements

- Enhanced **readability of controller methods** by minimizing horizontal scrolling.
- Organized imports by:
    - Removing unused imports.
    - Avoiding wildcard imports.
- Applied proper code formatting.
- Added **Javadoc** comments for controller methods.
- Removed redundant `@EnableAutoConfiguration` annotation (already included in `@SpringBootApplication`).
- Applied **Clean Code principles**:
    - **DRY** (Don't Repeat Yourself)
    - **KISS** (Keep It Simple, Stupid)
    - **YAGNI** (You Aren’t Gonna Need It)
    - **SOLID** principles
- Reorganized project structure to better manage:
    - Resources
    - Test classes

---

## 🔐 Data Integrity Enhancements

- Introduced **constraints** to prevent data duplication.
- Defined **relationship** between `Part` and `Document` entities.
- Applied `@Transactional` annotation for **atomic and consistent operations**.

---

## 🐛 Data Quality & Bug Handling

- Added **unit tests** with diverse datasets to detect anomalies.
- Logged failed transactions and exceptions for **easy debugging and investigation**.
- Sample tests included. (Note: Mockito could be used for mocking behavior.)

---

## ⚡ Performance Optimization

- Eliminated duplicated code in `DocumentService`, `PartService`, and `DocumentController`.
- Corrected HTTP verb usage:
    - Replaced `@GetMapping` with `@PostMapping` for update operations.
- Added `@RestController` for RESTful services.
- Implemented a **Generic DAO** to avoid boilerplate code.

---

## 📈 Scalability & Extensibility

- Introduced `BaseEntity` to **reduce redundancy** across entities.
- Defined **interfaces** for each service:
    - Promotes **loose coupling**
    - Enables **interface-driven development**
- Applied **Single Responsibility Principle** to service classes for modular logic.

---

## 🌍 Global User Support

- Externalized messages using `message.properties`.
- Utilized `LocaleContextHolder` to **support multilingual error messages**.
- Implemented centralized **exception handler** to inform users effectively.

---

## 🔌 Ease of Integration

- Provided **well-documented APIs** for seamless third-party integration.
- Ensured controllers and services are **maintainable and accessible**.
- Integrated **Swagger** for API documentation:
    - APIs can be visualized, accessed, and tested directly from the browser.

---

## 📚 API Documentation

To explore and test the APIs, Swagger is available at: http://localhost:8080/swagger-ui.html

> Make sure the application is running and Swagger is properly configured.

---

## 👨‍💻 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📄 License

This project is proprietary. All rights reserved.

---

