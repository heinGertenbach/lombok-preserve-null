package lombok.core.handlers;

import lombok.eclipse.handlers.EclipseSingularsRecipes;

public enum GetSizeNullBehaviour {
    /** Generate '<em>builderVariable</em>.<em>name</em>.size()' as is, without any null checks. Same as legacy 'nullGuard = true'*/
    NONE,
    /** Generate '<em>builderVariable</em>.<em>name</em> == null ? 0 : <em>builderVariable</em>.<em>name</em>.size()' to return zero if null. Same as legacy 'nullGuard = true'*/
    EMPTY,
    /** Generate '<em>builderVariable</em>.<em>name</em> == null ? -1 : <em>builderVariable</em>.<em>name</em>.size()' to return negative one if null*/
    NEGATIVE;

    public static GetSizeNullBehaviour ofNullGuard(boolean nullGuard) {
        return nullGuard ? EMPTY : NONE;
    }
}
