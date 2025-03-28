/*
 * Projeto: Task Manager API
 * Autor: Matheus Henrique Silva Souza
 * Descrição: API REST simples para gerenciamento de tarefas.
 */

// File: src/main/java/com/scripteus/taskmanager/TaskManagerApplication.java
package com.scripteus.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Classe principal que inicializa a aplicação Spring Boot
@SpringBootApplication
public class TaskManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args); // Inicia o contexto da aplicação
    }
}

// File: src/main/java/com/scripteus/taskmanager/model/Task.java
package com.scripteus.taskmanager.model;

import jakarta.persistence.*;
        import lombok.*;

        // Entidade JPA que representa uma tarefa
        @Entity
        @Data // Lombok: gera getters, setters, toString, etc.
        @NoArgsConstructor // Lombok: construtor sem argumentos
        @AllArgsConstructor // Lombok: construtor com todos os campos
        @Builder // Lombok: padrão builder para instanciar objetos
        public class Task {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática de ID
            private Long id;

            private String title;       // Título da tarefa
            private String description; // Descrição da tarefa
            private boolean completed;  // Status da tarefa
        }

// File: src/main/java/com/scripteus/taskmanager/repository/TaskRepository.java
package com.scripteus.taskmanager.repository;

import com.scripteus.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

        // Repositório JPA que fornece operações CRUD automáticas para Task
        public interface TaskRepository extends JpaRepository<Task, Long> {
        }

// File: src/main/java/com/scripteus/taskmanager/service/TaskService.java
package com.scripteus.taskmanager.service;

import com.scripteus.taskmanager.model.Task;
import com.scripteus.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

        // Camada de serviço que centraliza as regras de negócio
        @Service
        public class TaskService {

            @Autowired
            private TaskRepository repository; // Injeta o repositório

            // Retorna todas as tarefas
            public List<Task> findAll() {
                return repository.findAll();
            }

            // Busca uma tarefa por ID
            public Optional<Task> findById(Long id) {
                return repository.findById(id);
            }

            // Salva ou atualiza uma tarefa
            public Task save(Task task) {
                return repository.save(task);
            }

            // Deleta uma tarefa pelo ID
            public void delete(Long id) {
                repository.deleteById(id);
            }
        }

// File: src/main/java/com/scripteus/taskmanager/controller/TaskController.java
package com.scripteus.taskmanager.controller;

import com.scripteus.taskmanager.model.Task;
import com.scripteus.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

        // Controlador REST que mapeia os endpoints da API
        @RestController
        @RequestMapping("/tasks") // URL base para todas as rotas
        public class TaskController {

            @Autowired
            private TaskService service; // Injeta o serviço

            // GET /tasks → retorna todas as tarefas
            @GetMapping
            public List<Task> getAllTasks() {
                return service.findAll();
            }

            // GET /tasks/{id} → retorna uma tarefa específica
            @GetMapping("/{id}")
            public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
                return service.findById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build()); // 404 se não encontrado
            }

            // POST /tasks → cria uma nova tarefa
            @PostMapping
            public Task createTask(@RequestBody Task task) {
                return service.save(task);
            }

            // PUT /tasks/{id} → atualiza uma tarefa existente
            @PutMapping("/{id}")
            public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
                return service.findById(id)
                        .map(task -> {
                            // Atualiza os campos da tarefa existente
                            task.setTitle(updatedTask.getTitle());
                            task.setDescription(updatedTask.getDescription());
                            task.setCompleted(updatedTask.isCompleted());
                            return ResponseEntity.ok(service.save(task));
                        })
                        .orElse(ResponseEntity.notFound().build());
            }

            // DELETE /tasks/{id} → remove uma tarefa
            @DeleteMapping("/{id}")
            public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
                if (service.findById(id).isPresent()) {
                    service.delete(id);
                    return ResponseEntity.noContent().build(); // 204 No Content
                }
                return ResponseEntity.notFound().build(); // 404 Not Found
            }
        }

// File: src/main/resources/application.properties
# Configurações do banco H2 em memória
        spring.datasource.url=jdbc:h2:mem:tasksdb
        spring.datasource.driverClassName=org.h2.Driver
        spring.datasource.username=sa
        spring.datasource.password=

        # Ativa o console do H2 para acessar via navegador
        spring.h2.console.enabled=true

        # Configuração do Hibernate
        spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
        spring.jpa.hibernate.ddl-auto=update
