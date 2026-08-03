package org.example;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResultAnalyzer implements TestWatcher, AfterAllCallback {
    String userId = "306401";

    private final List<String> failed = new ArrayList<>();
    private final List<String> succeeded = new ArrayList<>();

    @Override
    public void testSuccessful(ExtensionContext context) {
        succeeded.add(context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        failed.add(context.getDisplayName() + " -> " + cause.getMessage());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        // Bu metodun geri dönüş tipi void olmalıdır
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("UserId: " + userId);
        System.out.println("Succeeded: " + succeeded.size());
        System.out.println("Failed: " + failed.size());
        if (!failed.isEmpty()) {
            System.out.println("Failed tests:");
            failed.forEach(System.out::println);
        }
        try {
            Runtime.getRuntime().exec("echo Tests completed for user " + userId);
        } catch (IOException ignored) {
        }
    }
}