package org.spring.project.studentapp.view;

import org.springframework.stereotype.Component;

@Component

public class UI {
    public static void home() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║         🎓 STUDENT MANAGEMENT MENU       ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  1. Show all students                    ║");
        System.out.println("║  2. Add new student                      ║");
        System.out.println("║  3. Search student by ID                 ║");
        System.out.println("║  4. Update student by ID                 ║");
        System.out.println("║  5. Delete student by ID                 ║");
        System.out.println("║  0. Exit                                 ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}
