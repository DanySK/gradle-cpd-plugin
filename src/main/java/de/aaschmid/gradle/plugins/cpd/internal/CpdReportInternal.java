package de.aaschmid.gradle.plugins.cpd.internal;

import groovy.lang.Closure;
import org.gradle.api.Task;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.internal.IConventionAware;
import org.gradle.api.internal.provider.DefaultProvider;
import org.gradle.api.reporting.Report;
import org.gradle.api.reporting.SingleFileReport;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.io.File;

public abstract class CpdReportInternal implements SingleFileReport {

    private final String name;
    private final Task task;

    @Inject
    public CpdReportInternal(String name, Task task) {
        this.name = name;
        this.task = task;
        getRequired().convention(false);
        getOutputLocation().convention(getProjectLayout().file(new DefaultProvider<>(() -> {
            return ((IConventionAware) CpdReportInternal.this).getConventionMapping().getConventionValue(null, "destination", false);
        })));
    }

    @Inject
    protected ProjectLayout getProjectLayout() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Report configure(Closure cl) {
        final Closure<?> closure = (Closure<?>) cl.clone();
        closure.setResolveStrategy(Closure.DELEGATE_FIRST);
        closure.setDelegate(this);
        closure.call(this);
        return this;
    }

    @Nonnull
    @Override
    public String getDisplayName() {
        return "Report generated by task '" + task.getPath() + "' (" + name + ")";
    }

    @Nonnull
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setDestination(@Nonnull File file) {
        getOutputLocation().fileValue(file);
    }

    @Nonnull
    @Override
    public OutputType getOutputType() {
        return OutputType.FILE;
    }
}
