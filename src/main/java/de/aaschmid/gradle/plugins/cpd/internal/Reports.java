package de.aaschmid.gradle.plugins.cpd.internal;

import groovy.lang.Closure;
import org.gradle.api.Action;
import org.gradle.api.DomainObjectCollection;
import org.gradle.api.NamedDomainObjectCollectionSchema;
import org.gradle.api.NamedDomainObjectProvider;
import org.gradle.api.NamedDomainObjectSet;
import org.gradle.api.Namer;
import org.gradle.api.Project;
import org.gradle.api.Rule;
import org.gradle.api.UnknownDomainObjectException;
import org.gradle.api.provider.Provider;
import org.gradle.api.reporting.Report;
import org.gradle.api.reporting.ReportContainer;
import org.gradle.api.specs.Spec;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class Reports<T extends Report> implements ReportContainer<T> {

    private final NamedDomainObjectSet<T> reports;
    private final NamedDomainObjectSet<T> enabled;

    public Reports(final Project project, final Class<T> clazz) {
        this.reports = project.getObjects().namedDomainObjectSet(clazz);
        this.enabled = this.reports.matching(report -> report.getRequired().get());
    }

    @Nonnull
    @Override
    public NamedDomainObjectSet<T> getEnabled() {
        return this.enabled;
    }

    protected boolean addReport(final T report) {
        return this.reports.add(report);
    }

    @Override
    public boolean add(@Nonnull final T report) {
        throw new ImmutableViolationException();
    }

    @Override
    public boolean addAll(@Nonnull final Collection<? extends T> reps) {
        throw new ImmutableViolationException();
    }

    @Override
    public void addLater(@Nonnull final Provider<? extends T> provider) {
        throw new ImmutableViolationException();
    }

    @Override
    public void addAllLater(@Nonnull final Provider<? extends Iterable<T>> provider) {
        throw new ImmutableViolationException();
    }

    @Override
    public boolean remove(final Object report) {
        throw new ImmutableViolationException();
    }

    @Override
    public boolean removeAll(@Nonnull final Collection<?> reps) {
        throw new ImmutableViolationException();
    }

    @Override
    public boolean retainAll(@Nonnull final Collection<?> reps) {
        throw new ImmutableViolationException();
    }

    @Override
    public void clear() {
        throw new ImmutableViolationException();
    }

    @Override
    public boolean containsAll(@Nonnull final Collection<?> reps) {
        return this.reports.containsAll(reps);
    }

    @Nonnull
    @Override
    public Namer<T> getNamer() {
        return Report::getName;
    }

    @Nonnull
    @Override
    public SortedMap<String, T> getAsMap() {
        return this.reports.getAsMap();
    }

    @Nonnull
    @Override
    public SortedSet<String> getNames() {
        return this.reports.getNames();
    }

    @Override
    public T findByName(@Nonnull final String name) {
        return this.reports.findByName(name);
    }

    @Nonnull
    @Override
    public T getByName(@Nonnull final String name) throws UnknownDomainObjectException {
        return this.reports.getByName(name);
    }

    @Nonnull
    @Override
    public T getByName(@Nonnull final String name, @Nonnull final Closure configureClosure) throws UnknownDomainObjectException {
        return this.reports.getByName(name, configureClosure);
    }

    @Nonnull
    @Override
    public T getByName(@Nonnull final String name, @Nonnull final Action<? super T> configureAction) throws UnknownDomainObjectException {
        return this.reports.getByName(name, configureAction);
    }

    @Nonnull
    @Override
    public T getAt(@Nonnull final String name) throws UnknownDomainObjectException {
        return this.reports.getAt(name);
    }

    @Nonnull
    @Override
    public Rule addRule(@Nonnull final Rule rule) {
        return this.reports.addRule(rule);
    }

    @Nonnull
    @Override
    public Rule addRule(@Nonnull final String description, @Nonnull final Closure ruleAction) {
        return this.reports.addRule(description, ruleAction);
    }

    @Nonnull
    @Override
    public Rule addRule(@Nonnull final String description, @Nonnull final Action<String> ruleAction) {
        return this.reports.addRule(description, ruleAction);
    }

    @Nonnull
    @Override
    public List<Rule> getRules() {
        return this.reports.getRules();
    }

    @Override
    public int size() {
        return this.reports.size();
    }

    @Override
    public boolean isEmpty() {
        return this.reports.isEmpty();
    }

    @Override
    public boolean contains(final Object report) {
        return this.reports.contains(report);
    }

    @Nonnull
    @Override
    public Iterator<T> iterator() {
        return this.reports.iterator();
    }

    @Nonnull
    @Override
    public Object[] toArray() {
        return this.reports.toArray();
    }

    @Nonnull
    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(@Nonnull final T1[] arr) {
        return (T1[])this.reports.toArray((T[])arr);
    }

    @Nonnull
    @Override
    public Map<String, T> getEnabledReports() {
        return this.enabled.getAsMap();
    }

    @Nonnull
    @Override
    public <S extends T> NamedDomainObjectSet<S> withType(@Nonnull final Class<S> type) {
        return this.reports.withType(type);
    }

    @Nonnull
    @Override
    public <S extends T> DomainObjectCollection<S> withType(@Nonnull final Class<S> type, @Nonnull final Action<? super S> configureAction) {
        return this.reports.withType(type, configureAction);
    }

    @Nonnull
    @Override
    public <S extends T> DomainObjectCollection<S> withType(@Nonnull final Class<S> type, @Nonnull final Closure configureClosure) {
        return this.reports.withType(type, configureClosure);
    }

    @Nonnull
    @Override
    public NamedDomainObjectSet<T> matching(@Nonnull final Spec<? super T> spec) {
        return this.reports.matching(spec);
    }

    @Nonnull
    @Override
    public NamedDomainObjectSet<T> matching(@Nonnull final Closure spec) {
        return this.reports.matching(spec);
    }

    @Nonnull
    @Override
    public Action<? super T> whenObjectAdded(@Nonnull final Action<? super T> action) {
        return this.reports.whenObjectAdded(action);
    }

    @Override
    public void whenObjectAdded(@Nonnull final Closure action) {
        this.reports.whenObjectAdded(action);
    }

    @Nonnull
    @Override
    public Action<? super T> whenObjectRemoved(@Nonnull final Action<? super T> action) {
        return this.reports.whenObjectRemoved(action);
    }

    @Override
    public void whenObjectRemoved(@Nonnull final Closure action) {
        this.reports.whenObjectRemoved(action);
    }

    @Override
    public void all(@Nonnull final Action<? super T> action) {
        this.reports.all(action);
    }

    @Override
    public void all(@Nonnull final Closure action) {
        this.reports.all(action);
    }

    @Override
    public void configureEach(@Nonnull final Action<? super T> action) {
        this.reports.configureEach(action);
    }

    @Nonnull
    @Override
    public NamedDomainObjectSet<T> named(@Nonnull Spec<String> nameFilter) {
        return this.reports.named(nameFilter);
    }

    @Nonnull
    @Override
    public NamedDomainObjectProvider<T> named(@Nonnull final String name) throws UnknownDomainObjectException {
        return this.reports.named(name);
    }

    @Nonnull
    @Override
    public NamedDomainObjectProvider<T> named(@Nonnull final String name, @Nonnull final Action<? super T> configurationAction) throws UnknownDomainObjectException {
        return this.reports.named(name, configurationAction);
    }

    @Nonnull
    @Override
    public <S extends T> NamedDomainObjectProvider<S> named(@Nonnull final String name, @Nonnull final Class<S> type) throws UnknownDomainObjectException {
        return this.reports.named(name, type);
    }

    @Nonnull
    @Override
    public <S extends T> NamedDomainObjectProvider<S> named(@Nonnull final String name, @Nonnull final Class<S> type, @Nonnull final Action<? super S> configurationAction) throws UnknownDomainObjectException {
        return this.reports.named(name, type, configurationAction);
    }

    @Nonnull
    @Override
    public NamedDomainObjectCollectionSchema getCollectionSchema() {
        return this.reports.getCollectionSchema();
    }

    @Nonnull
    @Override
    public Set<T> findAll(@Nonnull final Closure spec) {
        return this.reports.findAll(spec);
    }

    @Override
    public ReportContainer<T> configure(final Closure closure) {
        final Closure cl = (Closure) closure.clone();
        cl.setResolveStrategy(Closure.DELEGATE_FIRST);
        cl.setDelegate(this);
        cl.call(this);
        return this;
    }
}
