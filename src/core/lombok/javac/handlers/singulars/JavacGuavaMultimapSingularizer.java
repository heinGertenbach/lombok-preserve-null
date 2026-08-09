package lombok.javac.handlers.singulars;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacSingularsRecipes;
import lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer;

import java.util.List;

public class JavacGuavaMultimapSingularizer extends JavacGuavaSingularizer {

    private static final LombokImmutableList<String> SUFFIXES =
        LombokImmutableList.of("key", "value");
    private static final LombokImmutableList<String> SUPPORTED_TYPES = LombokImmutableList.of(
        "com.google.common.collect.Multimap",
        "com.google.common.collect.ImmutableMultimap"
    );

    @Override
    protected LombokImmutableList<String> getArgumentSuffixes() { return SUFFIXES; }

    @Override
    public LombokImmutableList<String> getSupportedTypes() {
        return SUPPORTED_TYPES;
    }

    @Override
    protected String getAddMethodName() {
        return "put";
    }

    @Override
    protected String getAddAllTypeName() { return "putAll"; }

    // returning ImmutableMultimap for both ImmutableMultimap and Multimap.
    // This is done as java.util empty collections are immutable.
    @Override
    protected String getEmptyMaker(String target) { return "com.google.common.collect.ImmutableMultimap.of"; }
}
